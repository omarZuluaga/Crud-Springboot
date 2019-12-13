package com.example.demo.exceptions;

public class ValorNoPermitidoException extends RuntimeException {
	public ValorNoPermitidoException() {
		super("Valor inferior a 1");
	}
}
