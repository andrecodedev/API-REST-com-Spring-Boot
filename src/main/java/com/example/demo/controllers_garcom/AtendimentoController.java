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

import com.example.demo.dtos_comanda.AtendimentoDTO;
import com.example.demo.dtos_comanda.DadosAtendimentoDTO;
import com.example.demo.services_cozinha.AtendimentoService_cardapio;

@RestController
@RequestMapping
public class AtendimentoController {

	private final AtendimentoService_cardapio atendimentoService;

	public AtendimentoController(AtendimentoService_cardapio atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

	@PostMapping("/atendimentos")
	@ResponseStatus(HttpStatus.CREATED)
	public DadosAtendimentoDTO registrar(@RequestBody AtendimentoDTO dto) {
		return atendimentoService.registrar(dto);
	}

	@GetMapping("/atendimentos/{id}")
	public DadosAtendimentoDTO buscarPorId(@PathVariable Long id) {
		return atendimentoService.buscarPorId(id);
	}

	@GetMapping("/animais/{id}/atendimentos")
	public List<DadosAtendimentoDTO> historicoPorAnimal(@PathVariable Long id) {
		return atendimentoService.historicoPorAnimal(id);
	}
}
