package com.example.demo.infraestructura.dto;

import com.example.demo.dominio.models.Producto;


public class ItemRest {
	private String codigo;
	private int cantidad;
	private Double valorTotal;
	private ProductoRest producto;
	
	public ItemRest() {
	}
	public ItemRest(String codigo,int cantidad, Double valorTotal, ProductoRest producto) {
		this.setCodigo(codigo);
		this.setCantidad(cantidad);
		this.setValorTotal(valorTotal);
		this.setProducto(producto);
		
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public ProductoRest getProducto() {
		return producto;
	}
	public void setProducto(ProductoRest producto) {
		this.producto = producto;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
