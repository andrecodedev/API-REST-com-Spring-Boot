package com.example.demo.services_cozinha;

import java.util.List;

import com.example.demo.dtos_comanda.DadosVeterinarioDTO;
import com.example.demo.dtos_comanda.VeterinarioDTO;

public interface VeterinarioService_cardapio {

	DadosVeterinarioDTO adicionar(VeterinarioDTO dto);

	List<DadosVeterinarioDTO> listar();

	DadosVeterinarioDTO buscarPorId(Long id);
}
