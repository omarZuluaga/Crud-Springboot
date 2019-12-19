package com.example.demo.dominio.models;

import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.ValorTotal;

public class Item{
	private final Codigo codigo;
	private final Cantidad cantidad;
	private final ValorTotal valorTotal;
	private final Producto producto;
	
	private Item(Codigo codigo, Cantidad cantidad, ValorTotal valorTotal, Producto producto) {
		this.codigo = codigo;
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
	
	public static Item of(Codigo codigo, Cantidad cantidad, ValorTotal valorTotal, Producto producto) {
		return new Item(codigo, cantidad, valorTotal, producto);
	}
	public Codigo getCodigo() {
		return codigo;
	}
}
