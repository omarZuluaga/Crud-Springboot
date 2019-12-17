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
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infraestructura.dto.FacturaDto;
import com.example.demo.infraestructura.dto.FacturaRest;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.repository.database.FacturaRepository;
import com.example.demo.infraestructura.repository.database.ProductoRepository;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private FacturaAplication facturaAplication;

	@PostMapping()
	void crearFactura(@RequestBody FacturaRest factura) {
		factura.setCodigo(UUID.randomUUID().toString());
		facturaAplication.crearFactura(factura);
	}

	@GetMapping()
	public List<FacturaDto>consultar(){
		return facturaRepository.findAll();
	}
	
	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		facturaRepository.findById(codigo).orElseThrow(()-> new RegistroNoEncontradoException());
		facturaRepository.deleteById(codigo);
	}
	
	
}
