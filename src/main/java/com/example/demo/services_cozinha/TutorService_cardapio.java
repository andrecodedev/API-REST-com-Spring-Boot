package com.example.demo.services_cozinha;

import java.util.List;

import com.example.demo.dtos_comanda.DadosTutorDTO;
import com.example.demo.dtos_comanda.TutorDTO;

public interface TutorService_cardapio {

	DadosTutorDTO adicionar(TutorDTO dto);

	List<DadosTutorDTO> listar();

	DadosTutorDTO buscarPorId(Long id);
}
