package com.example.demo.shared.dominio;

import com.example.demo.exceptions.ExtendetCodeException;

public class Codigo {
	private final String value;
	public Codigo (String codigo) {
		if(codigo.length()>=64 || codigo.length()<=32) {
			throw new ExtendetCodeException();
		}
		this.value = codigo;
	}
	public String getValue() {
		return value;
	}
}
