package com.example.demo.infraestructura.repository.adapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.dominio.models.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

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
	
	public String exportReport() throws FileNotFoundException, JRException {
		String path = "src\\main\\resources\\reports";
		List<ProductoDto> productos = productoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
		File file= ResourceUtils.getFile("classpath:productos.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Created by", "Omar");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\productos.pdf" );
		
		return "ready";
	}
	
	public String exportReportsByIds(List<String> codigos) throws FileNotFoundException, JRException{
		String path = "src\\\\main\\\\resources\\\\reports";
		List <ProductoDto> productos = productoRepository.findAllById(codigos);
		File file= ResourceUtils.getFile("classpath:productos.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Created by", "Omar");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\productos.pdf" );
		
		return "ready";
	}
}
