package com.example.demo.dtos_comanda;

import java.util.Set;

public class VeterinarioDTO {

	private String nome;
	private String crmv;
	private Set<String> especiesAtendidas;

	public VeterinarioDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public Set<String> getEspeciesAtendidas() {
		return especiesAtendidas;
	}

	public void setEspeciesAtendidas(Set<String> especiesAtendidas) {
		this.especiesAtendidas = especiesAtendidas;
	}
}
