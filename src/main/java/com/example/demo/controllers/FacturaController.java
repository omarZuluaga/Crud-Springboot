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

import com.example.demo.dto.Factura;
import com.example.demo.dto.Item;
import com.example.demo.dto.Producto;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ProductoRepository;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ProductoRepository productoRepository;

	@PostMapping()
	void crearFactura(@RequestBody Factura factura) {
		List<String> codigos = new ArrayList();
		for (Item item : factura.getItems()) {
			codigos.add(item.getProducto().getCodigo());
		}
		List<Item> guardarEnFactura = new ArrayList();
		List<Producto> productos = productoRepository.findAllById(codigos);
		Double vT = 0.0;
		for (Item item : factura.getItems()) {
			for (Producto pro : productos) {
				if (pro.getCodigo().equals(item.getProducto().getCodigo())) {
					item.setProducto(pro); 
					item.setValorTotal(item.getCantidad()*pro.getValor());
					vT = vT + (item.getCantidad() * pro.getValor());
					guardarEnFactura.add(item);
				}
			}
		}
		factura.setValorTotal(vT);
		factura.setItems(guardarEnFactura);
		facturaRepository.save(factura);

	}

	@GetMapping()
	public List<Factura>consultar(){
		return facturaRepository.findAll();
	}
	
	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		facturaRepository.findById(codigo).orElseThrow(()-> new RegistroNoEncontradoException());
		facturaRepository.deleteById(codigo);
	}
	
	
}
