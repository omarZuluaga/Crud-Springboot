package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Factura extends BaseEntity{

	private Double ValorTotal;
	private String cliente;
	private int numero;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Item.class)
	private List<Item> items;
	
	public Double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.ValorTotal = valorTotal;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setItems(List<Item> item) {
		this.items = item;
	}
	public List<Item> getItems(){
		return items;
	}
}
