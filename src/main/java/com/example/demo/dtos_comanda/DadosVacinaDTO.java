package com.example.demo.dtos_comanda;

import java.time.LocalDate;

public class DadosVacinaDTO {

	private Long id;
	private Long animalId;
	private String animalNome;
	private String nome;
	private LocalDate dataAplicacao;
	private String lote;

	public DadosVacinaDTO() {
	}

	public DadosVacinaDTO(Long id, Long animalId, String animalNome, String nome, LocalDate dataAplicacao,
			String lote) {
		this.id = id;
		this.animalId = animalId;
		this.animalNome = animalNome;
		this.nome = nome;
		this.dataAplicacao = dataAplicacao;
		this.lote = lote;
	}

	public Long getId() {
		return id;
	}

	public Long getAnimalId() {
		return animalId;
	}

	public String getAnimalNome() {
		return animalNome;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public String getLote() {
		return lote;
	}
}
