package com.example.demo.shared.dominio;

import com.example.demo.exceptions.ValorNoPermitidoException;

public class Valor {
	Valor (Integer valor){
		if(valor<1) {
			throw new ValorNoPermitidoException();
		}
	}
}
