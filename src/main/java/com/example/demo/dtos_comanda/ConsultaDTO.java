package com.example.demo.dtos_comanda;

import java.time.LocalDateTime;

public class ConsultaDTO {

	private Long animalId;
	private Long veterinarioId;
	private String local;
	private LocalDateTime dataHora;

	public ConsultaDTO() {
	}

	public Long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}

	public Long getVeterinarioId() {
		return veterinarioId;
	}

	public void setVeterinarioId(Long veterinarioId) {
		this.veterinarioId = veterinarioId;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
}
