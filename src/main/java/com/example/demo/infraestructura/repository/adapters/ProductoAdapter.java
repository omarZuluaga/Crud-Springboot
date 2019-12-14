package com.example.demo.infraestructura.repository.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Producto;
import com.example.demo.dominio.ProductoService;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;

@Service
public class ProductoAdapter implements ProductoService{
	
	@Autowired
	public ProductoRepository productoRepository;

	@Override
	public List<Producto> buscarPorIds(List<Codigo> codigos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto buscarXId(Codigo codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
