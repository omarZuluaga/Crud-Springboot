package com.example.demo.aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import com.example.demo.dominio.service.FacturaService;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.FacturaRest;
import com.example.demo.infraestructura.dto.ItemRest;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.FacturaMapper;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;



public class FacturaAplication {
	
	public FacturaService facturaService;
	
	private ProductoMapper productoMapper;
	
	private ProductoService productoService;
	
	private FacturaMapper facturaMapper;
	
	
	public FacturaAplication(FacturaService facturaService,
			ProductoMapper productoMapper, ProductoService productoService, FacturaMapper facturaMapper) {
		this.facturaService = facturaService;
		this.productoMapper = productoMapper;
		this.productoService = productoService;
		this.facturaMapper = facturaMapper;
	}

	public void crearFactura(FacturaRest factura) {
		FacturaRest f = factura;
		f.setCodigo(UUID.randomUUID().toString());
		f.setItems(this.cargarItems(f.getItems()));
		f.setValorTotal(this.calcularFactura(f.getItems()));

		facturaService.crearFactura(facturaMapper.restToDominio(f));
	}

	public List<ItemRest> cargarItems(List<ItemRest> items) {
		List<ProductoRest> productos = cargarProductos(obtenerCodigos(items));

		items.stream().forEach(

				item -> {
					item.setCodigo(UUID.randomUUID().toString());
					item.setProducto(cargarProducto(productos, item.getCodigo()));
					item.setValorTotal(item.getCantidad() * item.getProducto().getValor());

					
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

	public List<FacturaRest>consultar(){
			return facturaMapper.listDominioToListRest(facturaService.mostrarFacturas());
	}
	
	public void eliminar(String codigo) {
		facturaService.eliminar(new Codigo(codigo));
	}
}
