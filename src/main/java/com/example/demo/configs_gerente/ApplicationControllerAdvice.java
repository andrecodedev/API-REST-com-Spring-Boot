package com.example.demo.configs_gerente;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dtos_comanda.ApiErrorDTO;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(RegraNegocioException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO handleRegraNegocioException(RegraNegocioException ex) {
		return new ApiErrorDTO(ex.getMessage());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO handleJsonInvalido(HttpMessageNotReadableException ex) {
		return new ApiErrorDTO(
				"JSON inválido. Confira datas (AAAA-MM-DD ou AAAA-MM-DDTHH:mm:ss) e os campos obrigatórios.");
	}
}
