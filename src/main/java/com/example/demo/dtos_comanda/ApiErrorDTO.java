package com.example.demo.dtos_comanda;

import java.util.Arrays;
import java.util.List;

public class ApiErrorDTO {

	private List<String> errors;

	public ApiErrorDTO(String mensagem) {
		this.errors = Arrays.asList(mensagem);
	}

	public ApiErrorDTO(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}
}
