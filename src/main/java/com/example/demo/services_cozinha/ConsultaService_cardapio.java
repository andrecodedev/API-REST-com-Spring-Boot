package com.example.demo.services_cozinha;

import java.util.List;

import com.example.demo.dtos_comanda.ConsultaDTO;
import com.example.demo.dtos_comanda.DadosConsultaDTO;

public interface ConsultaService_cardapio {

	DadosConsultaDTO agendar(ConsultaDTO dto);

	List<DadosConsultaDTO> listar();

	DadosConsultaDTO buscarPorId(Long id);

	List<DadosConsultaDTO> listarPorAnimal(Long animalId);

	List<DadosConsultaDTO> listarPorVeterinario(Long veterinarioId);

	DadosConsultaDTO cancelar(Long id);
}
