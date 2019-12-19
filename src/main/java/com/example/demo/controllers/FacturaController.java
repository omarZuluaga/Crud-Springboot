package com.example.demo.controllers;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aplication.FacturaAplication;

//import com.example.demo.aplication.FacturaAplication;

import com.example.demo.dominio.service.FacturaService;
import com.example.demo.dominio.service.ProductoService;


import com.example.demo.infraestructura.dto.FacturaRest;
//import com.example.demo.infraestructura.dto.ItemDto;

//import com.example.demo.infraestructura.dto.ProductoDto;

import com.example.demo.infraestructura.mapper.FacturaMapper;
import com.example.demo.infraestructura.mapper.ProductoMapper;


//import com.example.demo.infraestructura.repository.database.ProductoRepository;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	
	private FacturaAplication facturaAplication;
	
	public FacturaController( @Autowired ProductoService productoService, @Autowired FacturaService facturaService,
			@Autowired FacturaMapper facturaMapper, @Autowired ProductoMapper productoMapper ) {
		this.facturaAplication = new FacturaAplication(facturaService, productoMapper, productoService, facturaMapper);
	}

	@PostMapping()
	void crearFactura(@RequestBody FacturaRest factura) {
		facturaAplication.crearFactura(factura);
	}

	@GetMapping()
	public List<FacturaRest> consultar() {
		return facturaAplication.consultar(); 
	}

	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		facturaAplication.eliminar(codigo);
	}

}
