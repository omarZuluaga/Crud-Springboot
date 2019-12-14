package com.example.demo.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dominio.Producto;
import com.example.demo.dto.ProductoDto;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.infrastructure.mapper.MapperApiRest;

@Component
public class ProductoMapper implements MapperApiRest<Producto, ProductoDto>{
	@Override
	public Producto recibir(ProductoDto o) { 
		return Producto.of(new Nombre(o.getNombre()), new Valor(o.getValor()), new Codigo(o.getCodigo()));
	
	}

	@Override
	public ProductoDto convertir(Producto i) {
		ProductoDto pd = new ProductoDto();
		pd.setCodigo(i.getCodigo().getValue());
		pd.setNombre(i.getNombre().getValue());
		pd.setValor(i.getValor().getValue());
		return pd;
	}
}
