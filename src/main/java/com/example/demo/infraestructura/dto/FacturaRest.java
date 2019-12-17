package com.example.demo.infraestructura.dto;

import java.util.List;


public class FacturaRest {
	private String codigo;
	private String cliente;
	private Double valorTotal;
	private int numero;
	private List<ItemRest> items;
	
	public FacturaRest() {
	}
	
	public FacturaRest(String codigo, String cliente, Double valorTotal, int numero, List<ItemRest> items) {
		super();
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setValorTotal(valorTotal);
		this.setNumero(numero);
		this.setItems(items);
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<ItemRest> getItems() {
		return items;
	}
	public void setItems(List<ItemRest> items) {
		this.items = items;
	}
	
}
