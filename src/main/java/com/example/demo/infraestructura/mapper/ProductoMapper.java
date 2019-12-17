package com.example.demo.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dominio.models.Producto;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.infrastructure.mapper.MapperApiRest;
import com.example.demo.shared.infrastructure.mapper.MapperRest;

@Component
public class ProductoMapper implements MapperApiRest<Producto, ProductoDto>, MapperRest<Producto, ProductoRest>{
	@Override
	public Producto dtoToDominio(ProductoDto o) { 
		return Producto.of(new Nombre(o.getNombre()), new Valor(o.getValor()), new Codigo(o.getCodigo()));
	
	}

	@Override
	public ProductoDto dominioToDto(Producto i) {
		ProductoDto pd = new ProductoDto();
		pd.setCodigo(i.getCodigo().getValue());
		pd.setNombre(i.getNombre().getValue());
		pd.setValor(i.getValor().getValue());
		return pd;
	}

	@Override
	public Producto restToDominio(ProductoRest b) {
		
		return Producto.of(new Nombre(b.getNombre()), new Valor(b.getValor()), new Codigo(b.getCodigo()));
	}

	@Override
	public ProductoRest dominioToRest(Producto a) {
		ProductoRest pr = new ProductoRest();
		pr.setCodigo(a.getCodigo().getValue());
		pr.setNombre(a.getNombre().getValue());
		pr.setValor(a.getValor().getValue());
		return pr;
	}
}
