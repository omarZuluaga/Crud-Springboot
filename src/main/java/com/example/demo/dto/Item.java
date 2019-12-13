package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item extends BaseEntity{
	
	@OneToOne(targetEntity = Producto.class)
	private Producto producto;
	private int cantidad;
	private Double ValorTotal;

	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.ValorTotal = valorTotal;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
