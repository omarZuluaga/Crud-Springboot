package com.example.demo.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dominio.models.Item;
import com.example.demo.dominio.models.Producto;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ItemRest;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.dominio.ValorTotal;
import com.example.demo.shared.infrastructure.mapper.MapperApiRest;
import com.example.demo.shared.infrastructure.mapper.MapperRest;

@Component
public class ItemMapper implements MapperApiRest<Item, ItemDto>, MapperRest<Item, ItemRest> {

	public Item dtoToDominio(ItemDto o) {
		return Item.of(new Codigo(o.getCodigo()),new Cantidad(o.getCantidad()), new ValorTotal(o.getValorTotal()),
				Producto.of(new Codigo(o.getProducto().getCodigo()), new Nombre(o.getProducto().getNombre()), new Valor(o.getProducto().getValor())));
	}

	@Override
	public ItemDto dominioToDto(Item i) {
		ProductoDto pd = new ProductoDto();
		pd.setCodigo(i.getProducto().getCodigo().getValue());
		pd.setNombre(i.getProducto().getNombre().getValue());
		pd.setValor(i.getProducto().getValor().getValue());

		ItemDto it = new ItemDto();
		it.setCodigo(i.getCodigo().getValue());
		it.setCantidad(i.getCantidad().getValue());
		it.setValorTotal(i.getValorTotal().getValue());
		it.setProducto(pd);
		return it;
	}

	public Item restToDominio(ItemRest b) {
		return Item.of(new Codigo(b.getCodigo()) , new Cantidad(b.getCantidad()), new ValorTotal(b.getValorTotal()),
				Producto.of(new Codigo(b.getProducto().getCodigo()), new Nombre(b.getProducto().getNombre()),
						new Valor(b.getProducto().getValor())));
	}
	
	public ItemRest dominioToRest(Item a) {
		ProductoRest pr = new ProductoRest();
		pr.setCodigo(a.getProducto().getCodigo().getValue());
		pr.setNombre(a.getProducto().getNombre().getValue());
		pr.setValor(a.getProducto().getValor().getValue());

		ItemRest ir = new ItemRest();
		ir.setCodigo(a.getCodigo().getValue());
		ir.setCantidad(a.getCantidad().getValue());
		ir.setValorTotal(a.getValorTotal().getValue());
		ir.setProducto(pr); 
		return ir;
	}
}
