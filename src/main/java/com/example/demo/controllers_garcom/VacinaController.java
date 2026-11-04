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

import com.example.demo.dtos_comanda.DadosVacinaDTO;
import com.example.demo.dtos_comanda.VacinaDTO;
import com.example.demo.services_cozinha.VacinaService_cardapio;

@RestController
@RequestMapping
public class VacinaController {

	private final VacinaService_cardapio vacinaService;

	public VacinaController(VacinaService_cardapio vacinaService) {
		this.vacinaService = vacinaService;
	}

	@PostMapping("/vacinas")
	@ResponseStatus(HttpStatus.CREATED)
	public DadosVacinaDTO registrar(@RequestBody VacinaDTO dto) {
		return vacinaService.registrar(dto);
	}

	@GetMapping("/animais/{id}/vacinas")
	public List<DadosVacinaDTO> listarPorAnimal(@PathVariable Long id) {
		return vacinaService.listarPorAnimal(id);
	}
}
