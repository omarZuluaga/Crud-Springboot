package com.example.demo.dominio.models;

import java.util.List;

import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.ValorTotal;

public class Factura {
	private final Codigo codigo;
	private final Nombre cliente;
	private final ValorTotal valorTotal;
	private final Cantidad numero;
	private final List<Item> items;

	public static Factura of(Codigo codigo, Nombre cliente, ValorTotal valorTotal, Cantidad numero, List<Item> items) {
		return new Factura(codigo, cliente, valorTotal, numero, items);
	}

	public Factura(Codigo codigo, Nombre cliente, ValorTotal valorTotal, Cantidad numero, List<Item> items) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.numero = numero;
		this.items = items;
	}

	public Nombre getCliente() {
		return cliente;
	}

	public ValorTotal getValorTotal() {
		return valorTotal;
	}

	public Cantidad getNumero() {
		return numero;
	}

	public List<Item> getItems() {
		return items;
	}

	public Codigo getCodigo() {
		return codigo;
	}
}
