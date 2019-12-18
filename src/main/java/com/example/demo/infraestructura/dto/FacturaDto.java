package com.example.demo.infraestructura.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class FacturaDto extends BaseEntity{

	private Double ValorTotal;
	private String cliente;
	private int numero;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = ItemDto.class)
	private List<ItemDto> items;
	
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
	public void setItems(List<ItemDto> item) {
		this.items = item;
	}
	public List<ItemDto> getItems(){
		return items;
	}
}
