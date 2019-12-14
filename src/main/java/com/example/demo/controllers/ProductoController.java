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
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.adapters.ProductoAdapter;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.dominio.ProductoService;
import com.example.demo.dto.ProductoDto;

@RestController
@RequestMapping("/producto")

public class ProductoController {
	@Autowired //inyecta la dependencia
	private ProductoService productoService;
	private ProductoMapper productoMapper = new ProductoMapper();
	private ProductoAdapter productoAdapter = new ProductoAdapter();
	
	@PostMapping
	void crear(@RequestBody ProductoDto producto) {
		productoService.guardar(productoMapper.recibir(producto));
	}
	
	
	@GetMapping("/{codigo}")
	ProductoDto buscar(@PathVariable String codigo){ 
		return productoMapper.convertir(productoService.buscarXId(new Codigo(codigo)));
	}
	
	@GetMapping()
	public List<ProductoDto>consultar(){
		return productoMapper.convertir(productoService.buscarTodo());
	}
	
//	@DeleteMapping("/{codigo}")
//	void eliminar(@PathVariable String codigo) {
//		productoService.findById(codigo).orElseThrow(()-> new RegistroNoEncontradoException());
//		productoService.deleteById(codigo);
//	}
//	
//	@PutMapping
//	void actualizar(@RequestBody ProductoDto producto) {
//		productoService.findById(producto.getCodigo()).orElseThrow(()-> new RegistroNoEncontradoException());
//		productoService.save(producto);
//	}
	
	private List<ProductoDto> repositorio = new ArrayList<>();
}
