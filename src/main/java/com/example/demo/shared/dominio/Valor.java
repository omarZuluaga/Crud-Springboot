package com.example.demo.shared.dominio;

import com.example.demo.exceptions.ValorNoPermitidoException;

public class Valor {
	private final Double value;
	public Valor (Double valor){
		if(valor<1) {
			throw new ValorNoPermitidoException();
		}
		this.value = valor;
	}
	public Double getValue() {
		return value;
	}
}
