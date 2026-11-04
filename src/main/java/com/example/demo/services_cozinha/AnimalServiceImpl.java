package com.example.demo.services_cozinha;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configs_gerente.RegraNegocioException;
import com.example.demo.domains_pratos.Animal;
import com.example.demo.domains_pratos.Tutor;
import com.example.demo.dtos_comanda.AnimalDTO;
import com.example.demo.dtos_comanda.DadosAnimalDTO;
import com.example.demo.repositories_estoque.AnimalRepository;
import com.example.demo.repositories_estoque.TutorRepository;

@Service
public class AnimalServiceImpl implements AnimalService_cardapio {

	private final AnimalRepository animalRepository;
	private final TutorRepository tutorRepository;

	public AnimalServiceImpl(AnimalRepository animalRepository, TutorRepository tutorRepository) {
		this.animalRepository = animalRepository;
		this.tutorRepository = tutorRepository;
	}

	@Override
	@Transactional
	public DadosAnimalDTO adicionar(AnimalDTO dto) {
		validar(dto);
		Tutor tutor = tutorRepository.findById(dto.getTutorId())
				.orElseThrow(() -> new RegraNegocioException("Tutor não encontrado com o ID " + dto.getTutorId()));
		Animal animal = new Animal(dto.getNome().trim(), dto.getEspecie().trim(), dto.getRaca().trim(),
				dto.getDataNascimento(), tutor);
		animal = animalRepository.save(animal);
		return toDados(animal);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosAnimalDTO> listar() {
		return animalRepository.findAll().stream().map(this::toDados).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public DadosAnimalDTO buscarPorId(Long id) {
		Animal animal = animalRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Animal não encontrado com o ID " + id));
		return toDados(animal);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosAnimalDTO> listarPorTutor(Long tutorId) {
		if (!tutorRepository.existsById(tutorId)) {
			throw new RegraNegocioException("Tutor não encontrado com o ID " + tutorId);
		}
		return animalRepository.buscarPorTutorId(tutorId).stream().map(this::toDados).collect(Collectors.toList());
	}

	private void validar(AnimalDTO dto) {
		if (dto.getNome() == null || dto.getNome().isBlank()) {
			throw new RegraNegocioException("O nome do animal é obrigatório.");
		}
		if (dto.getEspecie() == null || dto.getEspecie().isBlank()) {
			throw new RegraNegocioException("A espécie do animal é obrigatória.");
		}
		if (dto.getRaca() == null || dto.getRaca().isBlank()) {
			throw new RegraNegocioException("A raça do animal é obrigatória.");
		}
		if (dto.getDataNascimento() == null) {
			throw new RegraNegocioException("A data de nascimento do animal é obrigatória.");
		}
		if (dto.getTutorId() == null) {
			throw new RegraNegocioException("O tutorId é obrigatório.");
		}
	}

	private DadosAnimalDTO toDados(Animal animal) {
		Tutor tutor = animal.getTutor();
		return new DadosAnimalDTO(animal.getId(), animal.getNome(), animal.getEspecie(), animal.getRaca(),
				animal.getDataNascimento(), tutor != null ? tutor.getId() : null,
				tutor != null ? tutor.getNome() : null);
	}
}
