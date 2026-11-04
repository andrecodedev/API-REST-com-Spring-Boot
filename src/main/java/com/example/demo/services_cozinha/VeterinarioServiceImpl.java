package com.example.demo.services_cozinha;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configs_gerente.RegraNegocioException;
import com.example.demo.domains_pratos.Veterinario;
import com.example.demo.dtos_comanda.DadosVeterinarioDTO;
import com.example.demo.dtos_comanda.VeterinarioDTO;
import com.example.demo.repositories_estoque.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService_cardapio {

	private final VeterinarioRepository veterinarioRepository;

	public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository) {
		this.veterinarioRepository = veterinarioRepository;
	}

	@Override
	@Transactional
	public DadosVeterinarioDTO adicionar(VeterinarioDTO dto) {
		validar(dto);
		Set<String> especies = dto.getEspeciesAtendidas().stream()
				.map(String::trim)
				.filter(s -> !s.isBlank())
				.collect(Collectors.toCollection(HashSet::new));
		Veterinario veterinario = new Veterinario(dto.getNome().trim(), dto.getCrmv().trim(), especies);
		veterinario = veterinarioRepository.save(veterinario);
		return toDados(veterinario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DadosVeterinarioDTO> listar() {
		return veterinarioRepository.findAll().stream().map(this::toDados).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public DadosVeterinarioDTO buscarPorId(Long id) {
		Veterinario veterinario = veterinarioRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado com o ID " + id));
		return toDados(veterinario);
	}

	private void validar(VeterinarioDTO dto) {
		if (dto.getNome() == null || dto.getNome().isBlank()) {
			throw new RegraNegocioException("O nome do veterinário é obrigatório.");
		}
		if (dto.getCrmv() == null || dto.getCrmv().isBlank()) {
			throw new RegraNegocioException("O CRMV do veterinário é obrigatório.");
		}
		if (dto.getEspeciesAtendidas() == null || dto.getEspeciesAtendidas().isEmpty()) {
			throw new RegraNegocioException("Informe ao menos uma espécie que o veterinário pode atender.");
		}
	}

	private DadosVeterinarioDTO toDados(Veterinario veterinario) {
		return new DadosVeterinarioDTO(veterinario.getId(), veterinario.getNome(), veterinario.getCrmv(),
				veterinario.getEspeciesAtendidas());
	}
}
