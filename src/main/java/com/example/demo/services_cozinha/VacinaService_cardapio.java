package com.example.demo.services_cozinha;

import java.util.List;

import com.example.demo.dtos_comanda.DadosVacinaDTO;
import com.example.demo.dtos_comanda.VacinaDTO;

public interface VacinaService_cardapio {

	DadosVacinaDTO registrar(VacinaDTO dto);

	List<DadosVacinaDTO> listarPorAnimal(Long animalId);
}
