package com.example.demo.infraestructura.repository.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.models.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;

@Service
public class ProductoAdapter implements ProductoService{
	
	@Autowired
	public ProductoRepository productoRepository;
	
	@Autowired
	public ProductoMapper productoMapper;

	@Override
	public List<Producto> buscarPorIds(List<Codigo> codigos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Producto> buscarTodo(){
		return productoMapper.apiRecibir(productoRepository.findAll());
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(productoMapper.apiConvertir(producto));
	}

	@Override
	public Producto buscarXId(Codigo codigo) {
		// TODO Auto-generated method stub
		return productoMapper.apiRecibir(productoRepository.findById(codigo.getValue()).get());
	}
	
	public void eliminar (Codigo codigo) {
		productoRepository.deleteById(codigo.getValue());
	}
	
	public void actualizar(Producto producto) {
		productoRepository.save(productoMapper.apiConvertir(producto));
	}
}
