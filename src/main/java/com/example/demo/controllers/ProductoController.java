package com.example.demo.controllers;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.dto.ProductoDto;

@RestController
@RequestMapping("/producto")

public class ProductoController {
	@Autowired //inyecta la dependencia
	private ProductoRepository productoRepository;
	
	
	@PostMapping
	void crear(@RequestBody ProductoDto producto) {
		productoRepository.save(producto);
	}
	
	
	@GetMapping("/{codigo}")
	ProductoDto buscar(@PathVariable String codigo){ 
		return productoRepository.findById(codigo).orElseThrow(()-> new RegistroNoEncontradoException());
	}
	
	@GetMapping()
	public List<ProductoDto>consultar(){
		return productoRepository.findAll();
	}
	
	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		productoRepository.findById(codigo).orElseThrow(()-> new RegistroNoEncontradoException());
		productoRepository.deleteById(codigo);
	}
	
	@PutMapping
	void actualizar(@RequestBody ProductoDto producto) {
		productoRepository.findById(producto.getCodigo()).orElseThrow(()-> new RegistroNoEncontradoException());
		productoRepository.save(producto);
	}
	
	private List<ProductoDto> repositorio = new ArrayList<>();
}
