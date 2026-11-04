package com.example.demo.dtos_comanda;

import java.util.Set;

public class DadosVeterinarioDTO {

	private Long id;
	private String nome;
	private String crmv;
	private Set<String> especiesAtendidas;

	public DadosVeterinarioDTO() {
	}

	public DadosVeterinarioDTO(Long id, String nome, String crmv, Set<String> especiesAtendidas) {
		this.id = id;
		this.nome = nome;
		this.crmv = crmv;
		this.especiesAtendidas = especiesAtendidas;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCrmv() {
		return crmv;
	}

	public Set<String> getEspeciesAtendidas() {
		return especiesAtendidas;
	}
}
