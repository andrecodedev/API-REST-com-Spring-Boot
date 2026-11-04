package com.example.demo.services_cozinha;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configs_gerente.RegraNegocioException;
import com.example.demo.domains_pratos.Tutor;
import com.example.demo.dtos_comanda.DadosTutorDTO;
import com.example.demo.dtos_comanda.TutorDTO;
import com.example.demo.repositories_estoque.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService_cardapio {

	private final TutorRepository tutorRepository;

	public TutorServiceImpl(TutorRepository tutorRepository) {
		this.tutorRepository = tutorRepository;
	}

	@Override
	@Transactional
	public DadosTutorDTO adicionar(TutorDTO dto) {
		validar(dto);
		Tutor tutor = new Tutor(dto.getNome().trim(), dto.getCpf().trim(), dto.getTelefone().trim(),
				dto.getEndereco().trim());
		tutor = tutorRepository.save(tutor);
		return toDados(tutor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosTutorDTO> listar() {
		return tutorRepository.findAll().stream().map(this::toDados).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public DadosTutorDTO buscarPorId(Long id) {
		Tutor tutor = tutorRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Tutor não encontrado com o ID " + id));
		return toDados(tutor);
	}

	private void validar(TutorDTO dto) {
		if (dto.getNome() == null || dto.getNome().isBlank()) {
			throw new RegraNegocioException("O nome do tutor é obrigatório.");
		}
		if (dto.getCpf() == null || dto.getCpf().isBlank()) {
			throw new RegraNegocioException("O CPF do tutor é obrigatório.");
		}
		if (dto.getTelefone() == null || dto.getTelefone().isBlank()) {
			throw new RegraNegocioException("O telefone do tutor é obrigatório.");
		}
		if (dto.getEndereco() == null || dto.getEndereco().isBlank()) {
			throw new RegraNegocioException("O endereço do tutor é obrigatório.");
		}
	}

	private DadosTutorDTO toDados(Tutor tutor) {
		return new DadosTutorDTO(tutor.getId(), tutor.getNome(), tutor.getCpf(), tutor.getTelefone(),
				tutor.getEndereco());
	}
}
