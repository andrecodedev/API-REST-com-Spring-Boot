package com.example.demo.services_cozinha;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configs_gerente.RegraNegocioException;
import com.example.demo.domains_pratos.Animal;
import com.example.demo.domains_pratos.Vacina;
import com.example.demo.dtos_comanda.DadosVacinaDTO;
import com.example.demo.dtos_comanda.VacinaDTO;
import com.example.demo.repositories_estoque.AnimalRepository;
import com.example.demo.repositories_estoque.VacinaRepository;

@Service
public class VacinaServiceImpl implements VacinaService_cardapio {

	private final VacinaRepository vacinaRepository;
	private final AnimalRepository animalRepository;

	public VacinaServiceImpl(VacinaRepository vacinaRepository, AnimalRepository animalRepository) {
		this.vacinaRepository = vacinaRepository;
		this.animalRepository = animalRepository;
	}

	@Override
	@Transactional
	public DadosVacinaDTO registrar(VacinaDTO dto) {
		validar(dto);
		Animal animal = animalRepository.findById(dto.getAnimalId())
				.orElseThrow(() -> new RegraNegocioException("Animal não encontrado com o ID " + dto.getAnimalId()));
		Vacina vacina = new Vacina(animal, dto.getNome().trim(), dto.getDataAplicacao(), dto.getLote().trim());
		vacina = vacinaRepository.save(vacina);
		return toDados(vacina);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosVacinaDTO> listarPorAnimal(Long animalId) {
		if (!animalRepository.existsById(animalId)) {
			throw new RegraNegocioException("Animal não encontrado com o ID " + animalId);
		}
		return vacinaRepository.buscarPorAnimalId(animalId).stream().map(this::toDados).collect(Collectors.toList());
	}

	private void validar(VacinaDTO dto) {
		if (dto.getAnimalId() == null) {
			throw new RegraNegocioException("O animalId é obrigatório.");
		}
		if (dto.getNome() == null || dto.getNome().isBlank()) {
			throw new RegraNegocioException("O nome da vacina é obrigatório.");
		}
		if (dto.getDataAplicacao() == null) {
			throw new RegraNegocioException("A data de aplicação é obrigatória.");
		}
		if (dto.getLote() == null || dto.getLote().isBlank()) {
			throw new RegraNegocioException("O lote da vacina é obrigatório.");
		}
	}

	private DadosVacinaDTO toDados(Vacina vacina) {
		Animal animal = vacina.getAnimal();
		return new DadosVacinaDTO(vacina.getId(), animal.getId(), animal.getNome(), vacina.getNome(),
				vacina.getDataAplicacao(), vacina.getLote());
	}
}
