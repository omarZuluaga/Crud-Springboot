package com.example.demo.dominio;

import java.util.List;

import com.example.demo.shared.dominio.Codigo;

public interface ProductoService {
	public List<Producto> buscarPorIds(List<Codigo> codigos);
	public void guardar (Producto producto);
	public Producto buscarXId(Codigo codigo);
	public List<Producto> buscarTodo();
	public void eliminar (Codigo codigo);
	public void actualizar (Producto producto);
}
