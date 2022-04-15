package com.project.demo.models.service;

import java.util.List;

import com.project.demo.entity.Productos;

public interface IProductoService {
	public void save(Productos producto);
	public List<Productos> listarProductos();
	public void delete(Long id);
	public Boolean verificarExisteProducto(String nombre);
	public Productos buscarProductos(long id);
}
