package com.example.demo.aplication;

import java.util.*;



import com.example.demo.dominio.service.ProductoService;

import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;

public class ProductoAplication {
	
	private ProductoService productoService;
	private ProductoMapper productoMapper;
	
	public ProductoAplication(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	public void agregar(ProductoRest producto) {
		producto.setCodigo(UUID.randomUUID().toString());
		productoService.guardar(productoMapper.restToDominio(producto));
	}

	public List<ProductoRest> consultarTodo() {
		return productoMapper.listDominioToListRest(productoService.buscarTodo());
	}


	public ProductoRest cosultarXId(String codigo) {
		return productoMapper.dominioToRest(productoService.buscarXId(new Codigo(codigo)));
	}

	
	public void eliminar(String codigo) {
		productoService.eliminar(new Codigo(codigo));
	}

	public void actualizar(ProductoRest producto) {
		productoMapper.dominioToRest(productoService.buscarXId(new Codigo(producto.getCodigo())));
		productoService.actualizar(productoMapper.restToDominio(producto));
	}

}
