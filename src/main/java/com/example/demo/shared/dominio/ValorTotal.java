package com.example.demo.shared.dominio;

import com.example.demo.exceptions.ValorNoPermitidoException;

public class ValorTotal {
	private final Double valorT;
	public ValorTotal (Double valorTotal){
		if(valorTotal<1) {
			throw new ValorNoPermitidoException();
		}
		this.valorT = valorTotal;
	}
	public Double getValue() {
		return valorT;
	}

}
