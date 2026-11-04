package com.example.demo.controllers_garcom;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos_comanda.ConsultaDTO;
import com.example.demo.dtos_comanda.DadosConsultaDTO;
import com.example.demo.services_cozinha.ConsultaService_cardapio;

@RestController
@RequestMapping
public class ConsultaController {

	private final ConsultaService_cardapio consultaService;

	public ConsultaController(ConsultaService_cardapio consultaService) {
		this.consultaService = consultaService;
	}

	@PostMapping("/consultas")
	@ResponseStatus(HttpStatus.CREATED)
	public DadosConsultaDTO agendar(@RequestBody ConsultaDTO dto) {
		return consultaService.agendar(dto);
	}

	@GetMapping("/consultas")
	public List<DadosConsultaDTO> listar() {
		return consultaService.listar();
	}

	@GetMapping("/consultas/{id}")
	public DadosConsultaDTO buscarPorId(@PathVariable Long id) {
		return consultaService.buscarPorId(id);
	}

	@GetMapping("/animais/{id}/consultas")
	public List<DadosConsultaDTO> listarPorAnimal(@PathVariable Long id) {
		return consultaService.listarPorAnimal(id);
	}

	@GetMapping("/veterinarios/{id}/consultas")
	public List<DadosConsultaDTO> listarPorVeterinario(@PathVariable Long id) {
		return consultaService.listarPorVeterinario(id);
	}

	@PutMapping("/consultas/{id}/cancelar")
	public DadosConsultaDTO cancelar(@PathVariable Long id) {
		return consultaService.cancelar(id);
	}
}
