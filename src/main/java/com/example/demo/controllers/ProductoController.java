package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.aplication.ProductoAplication;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;

@RequestMapping("/producto")
@RestController
public class ProductoController {
//	@Autowired
//	ProductoAplication productoAplication;
	@Autowired
	ProductoMapper productoMapper;
	@Autowired
	ProductoService productoService;

	@RequestMapping(method = RequestMethod.POST)
	public void agregar(@RequestBody ProductoRest producto) {
		producto.setCodigo(UUID.randomUUID().toString());
		productoService.guardar(productoMapper.restToDominio(producto));
	}

	@GetMapping
	public List<ProductoRest> consultarTodo() {
		return productoMapper.listDominioToListRest(productoService.buscarTodo());
	}

	@GetMapping("/{codigo}")
	public ProductoRest cosultarXId(@PathVariable String codigo) {
		return productoMapper.dominioToRest(productoService.buscarXId(new Codigo(codigo)));
	}

	@DeleteMapping("/{codigo}")
	public void eliminar(@PathVariable String codigo) {
		productoService.eliminar(new Codigo(codigo));
	}

	@PutMapping
	public void actualizar(@RequestBody ProductoRest producto) {
		productoMapper.dominioToRest(productoService.buscarXId(new Codigo(producto.getCodigo())));
		productoService.actualizar(productoMapper.restToDominio(producto));
	}
}
