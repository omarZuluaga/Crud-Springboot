package com.example.demo.dominio.service;

import java.util.List;

import com.example.demo.dominio.models.Factura;
import com.example.demo.shared.dominio.Codigo;

public interface FacturaService {
	public void crearFactura(Factura factura);
	public Factura buscarFacturaXId(Codigo codigo);
	public List<Factura> mostrarFacturas();
	public void eliminar(Codigo codigo);
}
