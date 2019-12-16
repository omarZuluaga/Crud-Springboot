package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aplication.ProductoAplication;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;

@RequestMapping
@RestController("/producto")
public class ProductoController {
	@Autowired
	ProductoAplication productoAplication;
	@Autowired
	ProductoMapper productoMapper;
	
	@PostMapping
	public void agregar(@RequestBody ProductoRest producto) {
		productoAplication.crear(productoMapper.recibir(producto));
	}
}
