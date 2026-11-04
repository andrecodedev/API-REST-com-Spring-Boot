package com.example.demo.dtos_comanda;

import java.time.LocalDateTime;

import com.example.demo.domains_pratos.StatusConsulta;

public class DadosConsultaDTO {

	private Long id;
	private Long animalId;
	private String animalNome;
	private String animalEspecie;
	private Long veterinarioId;
	private String veterinarioNome;
	private String local;
	private LocalDateTime dataHora;
	private StatusConsulta status;

	public DadosConsultaDTO() {
	}

	public DadosConsultaDTO(Long id, Long animalId, String animalNome, String animalEspecie, Long veterinarioId,
			String veterinarioNome, String local, LocalDateTime dataHora, StatusConsulta status) {
		this.id = id;
		this.animalId = animalId;
		this.animalNome = animalNome;
		this.animalEspecie = animalEspecie;
		this.veterinarioId = veterinarioId;
		this.veterinarioNome = veterinarioNome;
		this.local = local;
		this.dataHora = dataHora;
		this.status = status;
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

	public String getAnimalEspecie() {
		return animalEspecie;
	}

	public Long getVeterinarioId() {
		return veterinarioId;
	}

	public String getVeterinarioNome() {
		return veterinarioNome;
	}

	public String getLocal() {
		return local;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public StatusConsulta getStatus() {
		return status;
	}
}
