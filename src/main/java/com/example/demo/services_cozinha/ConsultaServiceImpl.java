package com.example.demo.services_cozinha;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configs_gerente.RegraNegocioException;
import com.example.demo.domains_pratos.Animal;
import com.example.demo.domains_pratos.Consulta;
import com.example.demo.domains_pratos.StatusConsulta;
import com.example.demo.domains_pratos.Veterinario;
import com.example.demo.dtos_comanda.ConsultaDTO;
import com.example.demo.dtos_comanda.DadosConsultaDTO;
import com.example.demo.repositories_estoque.AnimalRepository;
import com.example.demo.repositories_estoque.ConsultaRepository;
import com.example.demo.repositories_estoque.VeterinarioRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService_cardapio {

	private final ConsultaRepository consultaRepository;
	private final AnimalRepository animalRepository;
	private final VeterinarioRepository veterinarioRepository;

	public ConsultaServiceImpl(ConsultaRepository consultaRepository, AnimalRepository animalRepository,
			VeterinarioRepository veterinarioRepository) {
		this.consultaRepository = consultaRepository;
		this.animalRepository = animalRepository;
		this.veterinarioRepository = veterinarioRepository;
	}

	@Override
	@Transactional
	public DadosConsultaDTO agendar(ConsultaDTO dto) {
		validar(dto);

		Animal animal = animalRepository.findById(dto.getAnimalId())
				.orElseThrow(() -> new RegraNegocioException("Animal não encontrado com o ID " + dto.getAnimalId()));
		Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId()).orElseThrow(
				() -> new RegraNegocioException("Veterinário não encontrado com o ID " + dto.getVeterinarioId()));

		boolean habilitado = veterinario.getEspeciesAtendidas().stream()
				.anyMatch(especie -> especie.equalsIgnoreCase(animal.getEspecie()));
		if (!habilitado) {
			throw new RegraNegocioException(
					"Veterinário não habilitado para a espécie " + animal.getEspecie() + ".");
		}

		boolean conflito = consultaRepository.existeAgendamentoNoHorario(veterinario.getId(), dto.getDataHora(),
				StatusConsulta.AGENDADA);
		if (conflito) {
			throw new RegraNegocioException("Veterinário já possui consulta agendada neste horário.");
		}

		Consulta consulta = new Consulta(animal, veterinario, dto.getLocal().trim(), dto.getDataHora());
		consulta = consultaRepository.save(consulta);
		return toDados(consulta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosConsultaDTO> listar() {
		return consultaRepository.findAll().stream().map(this::toDados).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public DadosConsultaDTO buscarPorId(Long id) {
		Consulta consulta = consultaRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Consulta não encontrada com o ID " + id));
		return toDados(consulta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosConsultaDTO> listarPorAnimal(Long animalId) {
		if (!animalRepository.existsById(animalId)) {
			throw new RegraNegocioException("Animal não encontrado com o ID " + animalId);
		}
		return consultaRepository.buscarPorAnimalId(animalId).stream().map(this::toDados).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosConsultaDTO> listarPorVeterinario(Long veterinarioId) {
		if (!veterinarioRepository.existsById(veterinarioId)) {
			throw new RegraNegocioException("Veterinário não encontrado com o ID " + veterinarioId);
		}
		return consultaRepository.buscarPorVeterinarioId(veterinarioId).stream().map(this::toDados)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public DadosConsultaDTO cancelar(Long id) {
		Consulta consulta = consultaRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Consulta não encontrada com o ID " + id));
		if (consulta.getStatus() == StatusConsulta.CANCELADA) {
			throw new RegraNegocioException("Consulta já está cancelada.");
		}
		consulta.setStatus(StatusConsulta.CANCELADA);
		consulta = consultaRepository.save(consulta);
		return toDados(consulta);
	}

	private void validar(ConsultaDTO dto) {
		if (dto.getAnimalId() == null) {
			throw new RegraNegocioException("O animalId é obrigatório.");
		}
		if (dto.getVeterinarioId() == null) {
			throw new RegraNegocioException("O veterinarioId é obrigatório.");
		}
		if (dto.getLocal() == null || dto.getLocal().isBlank()) {
			throw new RegraNegocioException("O local da consulta é obrigatório.");
		}
		if (dto.getDataHora() == null) {
			throw new RegraNegocioException("A data e horário da consulta são obrigatórios.");
		}
	}

	private DadosConsultaDTO toDados(Consulta consulta) {
		Animal animal = consulta.getAnimal();
		Veterinario veterinario = consulta.getVeterinario();
		return new DadosConsultaDTO(consulta.getId(), animal.getId(), animal.getNome(), animal.getEspecie(),
				veterinario.getId(), veterinario.getNome(), consulta.getLocal(), consulta.getDataHora(),
				consulta.getStatus());
	}
}
