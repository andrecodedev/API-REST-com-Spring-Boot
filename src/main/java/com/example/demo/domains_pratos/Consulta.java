package com.example.demo.domains_pratos;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultas")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "animal_id")
	private Animal animal;

	@ManyToOne(optional = false)
	@JoinColumn(name = "veterinario_id")
	private Veterinario veterinario;

	private String local;
	private LocalDateTime dataHora;

	@Enumerated(EnumType.STRING)
	private StatusConsulta status = StatusConsulta.AGENDADA;

	public Consulta() {
	}

	public Consulta(Animal animal, Veterinario veterinario, String local, LocalDateTime dataHora) {
		this.animal = animal;
		this.veterinario = veterinario;
		this.local = local;
		this.dataHora = dataHora;
		this.status = StatusConsulta.AGENDADA;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
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

	public StatusConsulta getStatus() {
		return status;
	}

	public void setStatus(StatusConsulta status) {
		this.status = status;
	}
}
