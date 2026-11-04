package com.example.demo.domains_pratos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinarios")
public class Veterinario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String crmv;

	@ElementCollection
	@CollectionTable(name = "veterinario_especies", joinColumns = @JoinColumn(name = "veterinario_id"))
	@Column(name = "especie")
	private Set<String> especiesAtendidas = new HashSet<>();

	public Veterinario() {
	}

	public Veterinario(String nome, String crmv, Set<String> especiesAtendidas) {
		this.nome = nome;
		this.crmv = crmv;
		if (especiesAtendidas != null) {
			this.especiesAtendidas = especiesAtendidas;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
