package com.example.demo.dtos_comanda;

import java.time.LocalDateTime;

public class DadosAtendimentoDTO {

	private Long id;
	private Long animalId;
	private String animalNome;
	private String diagnostico;
	private String observacoes;
	private String orientacoes;
	private LocalDateTime dataRegistro;

	public DadosAtendimentoDTO() {
	}

	public DadosAtendimentoDTO(Long id, Long animalId, String animalNome, String diagnostico, String observacoes,
			String orientacoes, LocalDateTime dataRegistro) {
		this.id = id;
		this.animalId = animalId;
		this.animalNome = animalNome;
		this.diagnostico = diagnostico;
		this.observacoes = observacoes;
		this.orientacoes = orientacoes;
		this.dataRegistro = dataRegistro;
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

	public String getDiagnostico() {
		return diagnostico;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public String getOrientacoes() {
		return orientacoes;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
}
