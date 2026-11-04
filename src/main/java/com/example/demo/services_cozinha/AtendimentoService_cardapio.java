package com.example.demo.services_cozinha;

import java.util.List;

import com.example.demo.dtos_comanda.AtendimentoDTO;
import com.example.demo.dtos_comanda.DadosAtendimentoDTO;

public interface AtendimentoService_cardapio {

	DadosAtendimentoDTO registrar(AtendimentoDTO dto);

	DadosAtendimentoDTO buscarPorId(Long id);

	List<DadosAtendimentoDTO> historicoPorAnimal(Long animalId);
}
