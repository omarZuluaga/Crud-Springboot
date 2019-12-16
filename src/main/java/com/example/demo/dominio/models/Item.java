package com.example.demo.dominio.models;

import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.ValorTotal;

public class Item {
	private final Cantidad cantidad;
	private final ValorTotal valorTotal;
	private final Producto producto;
	
	private Item(Cantidad cantidad, ValorTotal valorTotal, Producto producto) {
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
		this.producto = producto;
	}
	public Cantidad getCantidad() {
		return cantidad;
	}
	public ValorTotal getValorTotal() {
		return valorTotal;
	}
	public Producto getProducto() {
		return producto;
	}
	
	public static Item of(Cantidad cantidad, ValorTotal valorTotal, Producto producto) {
		return new Item(cantidad, valorTotal, producto);
	}
}
