package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aplication.ProductoAplication;
//import com.example.demo.aplication.ProductoAplication;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;


@RequestMapping("/producto")
@RestController
public class ProductoController {
//	@Autowired
//	ProductoAplication productoAplication;
	@Autowired
	ProductoMapper productoMapper;
	@Autowired
	ProductoService productoService;
	private ProductoAplication productoAplication;
	
	public ProductoController(@Autowired ProductoMapper productoMapper, @Autowired ProductoService productoService) {
		this.productoAplication = new ProductoAplication(productoService, productoMapper);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void agregar(@RequestBody ProductoRest producto) {
		productoAplication.agregar(producto);
	}

	@GetMapping
	public List<ProductoRest> consultarTodo() {
		return productoAplication.consultarTodo();
	}

	@GetMapping("/{codigo}")
	public ProductoRest cosultarXId(@PathVariable String codigo) {
		return productoAplication.cosultarXId(codigo);
	}

	@DeleteMapping("/{codigo}")
	public void eliminar(@PathVariable String codigo) {
		productoAplication.eliminar(codigo);
	}

	@PutMapping
	public void actualizar(@RequestBody ProductoRest producto) {
		productoAplication.actualizar(producto);
	}
}
