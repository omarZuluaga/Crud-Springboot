package com.example.demo.aplication;


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

import com.example.demo.dominio.service.ProductoService;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.adapters.ProductoAdapter;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;


public class ProductoAplication {
	@Autowired //inyecta la dependencia
	private ProductoService productoService;
	private ProductoMapper productoMapper = new ProductoMapper();
	
	public void crear( ProductoDto producto) {
		producto.setCodigo( UUID.randomUUID().toString());
		productoService.guardar(productoMapper.apiRecibir(producto));
	}
	
	
	public ProductoDto buscar( String codigo){ 
		return productoMapper.apiConvertir(productoService.buscarXId(new Codigo(codigo)));
	}
	
	public List<ProductoDto>consultar(){
		return productoMapper.apiConvertir(productoService.buscarTodo());
	}
	
	void eliminar( String codigo) {
		productoService.eliminar(new Codigo(codigo));
	}
	
	public void actualizar (ProductoDto producto) {
		productoMapper.apiConvertir(productoService.buscarXId(new Codigo(producto.getCodigo())));
		productoService.actualizar(productoMapper.apiRecibir(producto));
	}
	
	private List<ProductoDto> repositorio = new ArrayList<>();
}
