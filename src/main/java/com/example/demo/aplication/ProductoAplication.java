package com.example.demo.aplication;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.models.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.adapters.ProductoAdapter;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;

@Component
public class ProductoAplication {
	@Autowired // inyecta la dependencia
	private ProductoService productoService;
	@Autowired
	private ProductoMapper productoMapper;

	public void crear(ProductoRest producto) {
		productoService.guardar(productoMapper.restToDominio(producto));
	}

	public ProductoRest consultarXId(String codigo) {
		return productoMapper.dominioToRest(productoService.buscarXId(new Codigo(codigo)));
	}

	public List<ProductoRest> consultar() {
		return productoMapper.listDominioToListRest(productoService.buscarTodo());
	}

	public void eliminar(String codigo) {
		productoService.eliminar(new Codigo(codigo));
	}

	public void actualizar(ProductoRest producto) {
		productoMapper.dominioToRest(productoService.buscarXId(new Codigo(producto.getCodigo())));
		productoService.actualizar(productoMapper.restToDominio(producto));
	}

	private List<ProductoDto> repositorio = new ArrayList<>();
}
