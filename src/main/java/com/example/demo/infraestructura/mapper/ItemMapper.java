package com.example.demo.infraestructura.mapper;

import com.example.demo.dominio.models.Item;
import com.example.demo.dominio.models.Producto;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.dominio.ValorTotal;
import com.example.demo.shared.infrastructure.mapper.MapperApiRest;

public class ItemMapper implements MapperApiRest<Item, ItemDto> {
	
	public Item apiRecibir(ItemDto o) {
		return Item.of(new Cantidad(o.getCantidad()), new ValorTotal(o.getValorTotal()),
				Producto.of(new Nombre(o.getProducto().getNombre()), new Valor(o.getProducto().getValor()),
						new Codigo(o.getProducto().getCodigo())));
	}

	@Override
	public ItemDto apiConvertir(Item i) {
		ProductoDto pd = new ProductoDto();
		pd.setCodigo(i.getProducto().getCodigo().getValue());
		pd.setNombre(i.getProducto().getNombre().getValue());
		pd.setValor(i.getProducto().getValor().getValue());
		
		ItemDto it = new ItemDto();
		it.setCantidad(i.getCantidad().getValue());
		it.setValorTotal(i.getValorTotal().getValue());
		it.setProducto(pd);
		return it;
	}
}
