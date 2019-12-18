//package com.example.demo.aplication;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.example.demo.dominio.models.Producto;
//import com.example.demo.dominio.service.FacturaService;
//import com.example.demo.dominio.service.ProductoService;
//import com.example.demo.exceptions.RegistroNoEncontradoException;
//import com.example.demo.infraestructura.dto.FacturaDto;
//import com.example.demo.infraestructura.dto.FacturaRest;
//import com.example.demo.infraestructura.dto.ItemDto;
//import com.example.demo.infraestructura.dto.ItemRest;
//import com.example.demo.infraestructura.dto.ProductoDto;
//import com.example.demo.infraestructura.dto.ProductoRest;
//import com.example.demo.infraestructura.mapper.FacturaMapper;
//import com.example.demo.infraestructura.mapper.ProductoMapper;
//import com.example.demo.infraestructura.repository.database.FacturaRepository;
//import com.example.demo.infraestructura.repository.database.ProductoRepository;
//
//@Component
//public class FacturaAplication {
//	@Autowired
//	public FacturaService facturaService;
//	@Autowired
//	public FacturaRepository facturaRepository;
//	@Autowired
//	private ProductoRepository productoRepository;
//	@Autowired
//	private ProductoMapper productoMapper;
//	@Autowired
//	private ProductoService productoService;
//	@Autowired
//	private FacturaMapper facturaMapper;
//	
//	public void crearFactura(FacturaRest factura) {
//		FacturaRest f = factura;
//		f.setCodigo(UUID.randomUUID().toString());
//		f.setItems(this.cargarItems(f.getItems()));
//		f.setValorTotal(this.calcularFactura(f.getItems()));
//		
//		facturaService.crearFactura(facturaMapper.restToDominio(f));
//	}
//	
//	public List<ItemRest> cargarItems(List<ItemRest> items){
//		for(ItemRest i : items) {
//			i.setCodigo(UUID.randomUUID().toString());
//			i.setProducto(this.cargarProducto(i.getProducto()));
//			i.setValorTotal(i.getCantidad()*i.getProducto().getValor());
//			items.add(i);
//		}
//		return items;
//	}
//	
//	public Double calcularFactura(List<ItemRest> items) {
//		Double total = 0.0;
//		for(ItemRest i : items) {
//			total = total + (i.getCantidad()*i.getProducto().getValor());
//		}
//		return total;
//	}
//	
//	public ProductoRest cargarProducto(ProductoRest producto) {
//		Producto p = productoMapper.restToDominio(producto);
//		return productoMapper.dominioToRest(productoService.buscarXId(p.getCodigo()));
//	}
//
//	public List<FacturaDto>consultar(){
//			return facturaRepository.findAll();
//	}
//	
//	void eliminar(String codigo) {
//		facturaRepository.findById(codigo).orElseThrow(()-> new RegistroNoEncontradoException());
//		facturaRepository.deleteById(codigo);
//	}
//}
