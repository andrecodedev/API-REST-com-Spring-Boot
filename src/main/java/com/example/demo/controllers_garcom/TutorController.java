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

import com.example.demo.dtos_comanda.DadosTutorDTO;
import com.example.demo.dtos_comanda.TutorDTO;
import com.example.demo.services_cozinha.TutorService_cardapio;

@RestController
@RequestMapping("/tutores")
public class TutorController {

	private final TutorService_cardapio tutorService;

	public TutorController(TutorService_cardapio tutorService) {
		this.tutorService = tutorService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DadosTutorDTO adicionar(@RequestBody TutorDTO dto) {
		return tutorService.adicionar(dto);
	}

	@GetMapping
	public List<DadosTutorDTO> listar() {
		return tutorService.listar();
	}

	@GetMapping("/{id}")
	public DadosTutorDTO buscarPorId(@PathVariable Long id) {
		return tutorService.buscarPorId(id);
	}
}
