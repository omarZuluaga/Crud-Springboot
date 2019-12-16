package com.example.demo.dominio.models;

import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;

public class Producto {
	private final Nombre nombre;
	private final Valor valor;
	private final Codigo codigo;
	
	private Producto(Nombre nombre, Valor valor, Codigo codigo) {
		this.nombre = nombre;
		this.valor = valor;
		this.codigo = codigo;
	}
	
	public Nombre getNombre() {
		return nombre;
	}
	
	public Valor getValor() {
		return valor;
	}
	
	public Codigo getCodigo() {
		return codigo;
	}
	
	public static Producto of(Nombre nombre, Valor valor, Codigo codigo) {
		return new Producto(nombre, valor, codigo);
	}
}	
