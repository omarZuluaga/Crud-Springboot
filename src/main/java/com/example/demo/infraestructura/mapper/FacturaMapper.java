package com.example.demo.infraestructura.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dominio.models.Factura;
import com.example.demo.dominio.models.Item;
import com.example.demo.infraestructura.dto.FacturaDto;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.ValorTotal;
import com.example.demo.shared.infrastructure.mapper.MapperApiRest;

public class FacturaMapper implements MapperApiRest<Factura, FacturaDto> {

	@Autowired
	ItemMapper itemMapper;

	@Override
	public Factura apiRecibir(FacturaDto o) {

		return Factura.of(new Codigo(o.getCodigo()), new Nombre(o.getCliente()), new ValorTotal(o.getValorTotal()),
				new Cantidad(o.getNumero()), itemMapper.apiRecibir(o.getItems()));

	}

	@Override
	public FacturaDto apiConvertir(Factura i) {

		FacturaDto factura = new FacturaDto();

		factura.setItems(itemMapper.apiConvertir(i.getItems()));
		factura.setCodigo(i.getCodigo().getValue());
		factura.setCliente(i.getCliente().getValue());
		factura.setNumero(i.getNumero().getValue());
		factura.setValorTotal(i.getValorTotal().getValue());

		return factura;
	}

}
