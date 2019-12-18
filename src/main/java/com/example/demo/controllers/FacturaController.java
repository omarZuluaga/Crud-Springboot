package com.example.demo.controllers;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.aplication.FacturaAplication;
import com.example.demo.dominio.models.Producto;
import com.example.demo.dominio.service.FacturaService;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infraestructura.dto.FacturaDto;
import com.example.demo.infraestructura.dto.FacturaRest;
//import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ItemRest;
//import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.FacturaMapper;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.database.FacturaRepository;
import com.example.demo.shared.dominio.Codigo;
//import com.example.demo.infraestructura.repository.database.ProductoRepository;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	@Autowired
	private FacturaRepository facturaRepository;
//  @Autowired
//	private ProductoRepository productoRepository;
//	@Autowired
//	private FacturaAplication facturaAplication;
	@Autowired
	private ProductoService productoService;
	@Autowired
	public FacturaService facturaService;
	@Autowired
	public FacturaMapper facturaMapper;
	@Autowired
	public ProductoMapper productoMapper;

	@PostMapping()
	void crearFactura(@RequestBody FacturaRest factura) {
		FacturaRest f = factura;
		f.setCodigo(UUID.randomUUID().toString());
		f.setItems(this.cargarItems(f.getItems()));
		f.setValorTotal(this.calcularFactura(f.getItems()));

		facturaService.crearFactura(facturaMapper.restToDominio(f));
	}

	public List<ItemRest> cargarItems(List<ItemRest> items){
		List<ProductoRest> productos= cargarProductos(obtenerCodigos(items));
		
		items.stream().forEach(

				item ->{ item.setProducto(cargarProducto(productos, item.getCodigo()));
				item.setValorTotal(item.getCantidad()*item.getProducto().getValor());
				}
				
				
				);
		
	
		return items;
	}

	public List<String> obtenerCodigos(List<ItemRest> items) {

		return items.stream().map(item -> item.getProducto().getCodigo()).collect(Collectors.toList());
	}

	public Double calcularFactura(List<ItemRest> items) {
		Double total = 0.0;
		for (ItemRest i : items) {
			total = total + (i.getCantidad() * i.getProducto().getValor());
		}
		return total;
	}

	public ProductoRest cargarProducto(List<ProductoRest> productos, String codigoProducto) {
		ProductoRest producto = new ProductoRest();
		for (ProductoRest pro : productos) {
			producto.setCodigo(pro.getCodigo());
			producto.setNombre(pro.getNombre());
			producto.setValor(pro.getValor());
		}
		return producto;
	}

	public List<ProductoRest> cargarProductos(List<String> codigos) {
		ArrayList<Codigo> consulta = new ArrayList<>();
		for (String llega : codigos) {
			consulta.add(new Codigo(llega));
		}

		return productoMapper.listDominioToListRest(productoService.buscarPorIds(consulta));
	}

	@GetMapping()
	public List<FacturaRest> consultar() {
		return facturaMapper.listDominioToListRest(facturaService.mostrarFacturas());
	}

	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		facturaRepository.findById(codigo).orElseThrow(() -> new RegistroNoEncontradoException());
		facturaRepository.deleteById(codigo);
	}

}
