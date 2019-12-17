package com.example.demo.infraestructura.repository.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.models.Factura;
import com.example.demo.dominio.service.FacturaService;
import com.example.demo.infraestructura.mapper.FacturaMapper;
import com.example.demo.infraestructura.repository.database.FacturaRepository;
import com.example.demo.shared.dominio.Codigo;

@Service
public class FacturaAdapter implements FacturaService {
	
	@Autowired
	public FacturaRepository facturaRepository;
	
	@Autowired
	public FacturaMapper facturaMapper;

	@Override
	public void crearFactura(Factura factura) {
		facturaRepository.save(facturaMapper.dominioToDto(factura));
	}

	@Override
	public Factura buscarFacturaXId(Codigo codigo) {
		return facturaMapper.dtoToDominio(facturaRepository.findById(codigo.getValue()).get());
	}

	@Override
	public List<Factura> mostrarFacturas() {
		return facturaMapper.listDtoToDominio(facturaRepository.findAll());
	}

	@Override
	public void eliminar(Codigo codigo) {
		facturaRepository.deleteById(codigo.getValue());
		
	}

}
