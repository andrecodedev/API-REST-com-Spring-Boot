package com.example.demo.dtos_comanda;

import java.time.LocalDate;

public class DadosAnimalDTO {

	private Long id;
	private String nome;
	private String especie;
	private String raca;
	private LocalDate dataNascimento;
	private Long tutorId;
	private String tutorNome;

	public DadosAnimalDTO() {
	}

	public DadosAnimalDTO(Long id, String nome, String especie, String raca, LocalDate dataNascimento, Long tutorId,
			String tutorNome) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.dataNascimento = dataNascimento;
		this.tutorId = tutorId;
		this.tutorNome = tutorNome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecie() {
		return especie;
	}

	public String getRaca() {
		return raca;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Long getTutorId() {
		return tutorId;
	}

	public String getTutorNome() {
		return tutorNome;
	}
}
