package com.example.demo.controllers;


import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.dto.Producto;

@RestController
@RequestMapping("/producto")

public class ProductoController {
	@PostMapping
	void crear(@RequestBody Producto producto) {
		repositorio.add(producto);
	}
	
	
	@GetMapping("/{codigo}")
	Producto buscar(@PathVariable String codigo){ 
		return
		repositorio.stream()
		.filter(producto -> producto.getCodigo().matches(codigo))
		.findAny().orElseThrow(
				()-> new RegistroNoEncontradoException()
				);
	}
	
	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		Producto productoEliminado = repositorio.stream()
				.filter(producto -> producto.getCodigo().matches(codigo))
				.findAny().orElseThrow(
						()-> new RegistroNoEncontradoException()
						);
		
		repositorio.remove(productoEliminado);
	}
	
	@PutMapping
	void actualizar(@RequestBody Producto producto) {
		Producto productoActualizado = repositorio.stream()
				.filter(product -> producto.getCodigo().matches(producto.getCodigo()))
				.findAny().orElseThrow(
						()-> new RegistroNoEncontradoException()
						);
		int repositorioIndexOf= repositorio.indexOf(productoActualizado);
		repositorio.set(repositorioIndexOf,producto);

	}
	
	private List<Producto> repositorio = new ArrayList<>();
}
