package com.example.demo.infraestructura.repository.adapters;

import java.util.List;
import java.util.stream.Collectors;

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
		return productoMapper.listDtoToDominio(productoRepository.findAllById(codigos.stream().map(codigo -> codigo.getValue()).collect(Collectors.toList())));
	}
	
	@Override
	public List<Producto> buscarTodo(){
		return productoMapper.listDtoToDominio(productoRepository.findAll());
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(productoMapper.dominioToDto(producto));
	}

	@Override
	public Producto buscarXId(Codigo codigo) {
		// TODO Auto-generated method stub
		return productoMapper.dtoToDominio(productoRepository.findById(codigo.getValue()).get());
	}
	
	public void eliminar (Codigo codigo) {
		productoRepository.deleteById(codigo.getValue());
	}
	
	public void actualizar(Producto producto) {
		productoRepository.save(productoMapper.dominioToDto(producto));
	}
}
