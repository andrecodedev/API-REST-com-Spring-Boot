package com.example.demo.services_cozinha;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configs_gerente.RegraNegocioException;
import com.example.demo.domains_pratos.Animal;
import com.example.demo.domains_pratos.Atendimento;
import com.example.demo.dtos_comanda.AtendimentoDTO;
import com.example.demo.dtos_comanda.DadosAtendimentoDTO;
import com.example.demo.repositories_estoque.AnimalRepository;
import com.example.demo.repositories_estoque.AtendimentoRepository;

@Service
public class AtendimentoServiceImpl implements AtendimentoService_cardapio {

	private final AtendimentoRepository atendimentoRepository;
	private final AnimalRepository animalRepository;

	public AtendimentoServiceImpl(AtendimentoRepository atendimentoRepository, AnimalRepository animalRepository) {
		this.atendimentoRepository = atendimentoRepository;
		this.animalRepository = animalRepository;
	}

	@Override
	@Transactional
	public DadosAtendimentoDTO registrar(AtendimentoDTO dto) {
		validar(dto);
		Animal animal = animalRepository.findById(dto.getAnimalId())
				.orElseThrow(() -> new RegraNegocioException("Animal não encontrado com o ID " + dto.getAnimalId()));
		Atendimento atendimento = new Atendimento(animal, dto.getDiagnostico().trim(),
				dto.getObservacoes() != null ? dto.getObservacoes().trim() : null,
				dto.getOrientacoes() != null ? dto.getOrientacoes().trim() : null, LocalDateTime.now());
		atendimento = atendimentoRepository.save(atendimento);
		return toDados(atendimento);
	}

	@Override
	@Transactional(readOnly = true)
	public DadosAtendimentoDTO buscarPorId(Long id) {
		Atendimento atendimento = atendimentoRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Atendimento não encontrado com o ID " + id));
		return toDados(atendimento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosAtendimentoDTO> historicoPorAnimal(Long animalId) {
		if (!animalRepository.existsById(animalId)) {
			throw new RegraNegocioException("Animal não encontrado com o ID " + animalId);
		}
		return atendimentoRepository.buscarHistoricoPorAnimalId(animalId).stream().map(this::toDados)
				.collect(Collectors.toList());
	}

	private void validar(AtendimentoDTO dto) {
		if (dto.getAnimalId() == null) {
			throw new RegraNegocioException("O animalId é obrigatório.");
		}
		if (dto.getDiagnostico() == null || dto.getDiagnostico().isBlank()) {
			throw new RegraNegocioException("O diagnóstico é obrigatório.");
		}
	}

	private DadosAtendimentoDTO toDados(Atendimento atendimento) {
		Animal animal = atendimento.getAnimal();
		return new DadosAtendimentoDTO(atendimento.getId(), animal.getId(), animal.getNome(),
				atendimento.getDiagnostico(), atendimento.getObservacoes(), atendimento.getOrientacoes(),
				atendimento.getDataRegistro());
	}
}
