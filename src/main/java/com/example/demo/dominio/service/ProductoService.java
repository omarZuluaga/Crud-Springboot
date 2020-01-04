package com.example.demo.dominio.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.demo.dominio.models.Producto;
import com.example.demo.shared.dominio.Codigo;

import net.sf.jasperreports.engine.JRException;

public interface ProductoService {
	public List<Producto> buscarPorIds(List<Codigo> codigos);
	public void guardar (Producto producto);
	public Producto buscarXId(Codigo codigo);
	public List<Producto> buscarTodo();
	public void eliminar (Codigo codigo);
	public void actualizar (Producto producto);
	public String exportReport() throws FileNotFoundException, JRException;
	public String exportReportsByIds(List<String> codigos)throws FileNotFoundException, JRException ;
}
