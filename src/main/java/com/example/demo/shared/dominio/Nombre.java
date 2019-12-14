package com.example.demo.shared.dominio;

import com.example.demo.exceptions.BadFormatoException;

public class Nombre {
	private final String value;
	public Nombre(String nombre) {
		if((!nombre.matches("[A-Z].*"))) {
			throw new BadFormatoException();
		}
		this.value = nombre;
	}
	public String getValue() {
		return value;
	}
}
