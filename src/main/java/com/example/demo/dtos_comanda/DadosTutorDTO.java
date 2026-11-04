package com.example.demo.dtos_comanda;

public class DadosTutorDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;

	public DadosTutorDTO() {
	}

	public DadosTutorDTO(Long id, String nome, String cpf, String telefone, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}
}
