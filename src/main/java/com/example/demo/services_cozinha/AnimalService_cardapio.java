package com.example.demo.services_cozinha;

import java.util.List;

import com.example.demo.dtos_comanda.AnimalDTO;
import com.example.demo.dtos_comanda.DadosAnimalDTO;

public interface AnimalService_cardapio {

	DadosAnimalDTO adicionar(AnimalDTO dto);

	List<DadosAnimalDTO> listar();

	DadosAnimalDTO buscarPorId(Long id);

	List<DadosAnimalDTO> listarPorTutor(Long tutorId);
}
