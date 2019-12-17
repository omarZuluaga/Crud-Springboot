package com.example.demo.infraestructura.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.models.Factura;
import com.example.demo.infraestructura.dto.FacturaDto;
import com.example.demo.infraestructura.dto.FacturaRest;
import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.ValorTotal;
import com.example.demo.shared.infrastructure.mapper.MapperApiRest;
import com.example.demo.shared.infrastructure.mapper.MapperRest;
@Component
public class FacturaMapper implements MapperApiRest<Factura, FacturaDto>, MapperRest<Factura, FacturaRest> {

	@Autowired
	ItemMapper itemMapper;

	@Override
	public Factura dtoToDominio(FacturaDto o) {

		return Factura.of(new Codigo(o.getCodigo()), new Nombre(o.getCliente()), new ValorTotal(o.getValorTotal()),
				new Cantidad(o.getNumero()), itemMapper.listDtoToDominio(o.getItems()));

	}

	@Override
	public FacturaDto dominioToDto(Factura i) {

		FacturaDto factura = new FacturaDto();

		factura.setItems(itemMapper.listDominioToDto(i.getItems()));
		factura.setCodigo(i.getCodigo().getValue());
		factura.setCliente(i.getCliente().getValue());
		factura.setNumero(i.getNumero().getValue());
		factura.setValorTotal(i.getValorTotal().getValue());
		return factura;
	}
	
	public Factura restToDominio(FacturaRest b) {
		return Factura.of(new Codigo(b.getCodigo()), new Nombre(b.getCliente()), new ValorTotal(b.getValorTotal()),
				new Cantidad(b.getNumero()), itemMapper.listRestToListDominio(b.getItems()));
	}
	
	public FacturaRest dominioToRest(Factura a) {
		FacturaRest factura = new FacturaRest();

		factura.setItems(itemMapper.listDominioToListRest(a.getItems()));
		factura.setCodigo(a.getCodigo().getValue());
		factura.setCliente(a.getCliente().getValue());
		factura.setNumero(a.getNumero().getValue());
		factura.setValorTotal(a.getValorTotal().getValue());
		return factura;
	}

}
