package com.example.demo.shared.dominio;

import com.example.demo.exceptions.ValorNoPermitidoException;

public class Cantidad {
	private final int value;
	public Cantidad (int cantidad){
		if(cantidad<1) {
			throw new ValorNoPermitidoException();
		}
		this.value = cantidad;
	}
	public int getValue() {
		return value;
	}
}
