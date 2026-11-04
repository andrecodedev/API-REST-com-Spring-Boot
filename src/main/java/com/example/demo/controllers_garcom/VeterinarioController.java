package com.example.demo.controllers_garcom;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos_comanda.DadosVeterinarioDTO;
import com.example.demo.dtos_comanda.VeterinarioDTO;
import com.example.demo.services_cozinha.VeterinarioService_cardapio;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

	private final VeterinarioService_cardapio veterinarioService;

	public VeterinarioController(VeterinarioService_cardapio veterinarioService) {
		this.veterinarioService = veterinarioService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DadosVeterinarioDTO adicionar(@RequestBody VeterinarioDTO dto) {
		return veterinarioService.adicionar(dto);
	}

	@GetMapping
	public List<DadosVeterinarioDTO> listar() {
		return veterinarioService.listar();
	}

	@GetMapping("/{id}")
	public DadosVeterinarioDTO buscarPorId(@PathVariable Long id) {
		return veterinarioService.buscarPorId(id);
	}
}
