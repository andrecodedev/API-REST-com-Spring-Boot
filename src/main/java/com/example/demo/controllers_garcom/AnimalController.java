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

import com.example.demo.dtos_comanda.AnimalDTO;
import com.example.demo.dtos_comanda.DadosAnimalDTO;
import com.example.demo.services_cozinha.AnimalService_cardapio;

@RestController
@RequestMapping
public class AnimalController {

	private final AnimalService_cardapio animalService;

	public AnimalController(AnimalService_cardapio animalService) {
		this.animalService = animalService;
	}

	@PostMapping("/animais")
	@ResponseStatus(HttpStatus.CREATED)
	public DadosAnimalDTO adicionar(@RequestBody AnimalDTO dto) {
		return animalService.adicionar(dto);
	}

	@GetMapping("/animais")
	public List<DadosAnimalDTO> listar() {
		return animalService.listar();
	}

	@GetMapping("/animais/{id}")
	public DadosAnimalDTO buscarPorId(@PathVariable Long id) {
		return animalService.buscarPorId(id);
	}

	@GetMapping("/tutores/{id}/animais")
	public List<DadosAnimalDTO> listarPorTutor(@PathVariable Long id) {
		return animalService.listarPorTutor(id);
	}
}
