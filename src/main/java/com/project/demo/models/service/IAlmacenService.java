package com.project.demo.models.service;

import java.util.List;

import com.project.demo.entity.Almacen;

public interface IAlmacenService {
	public void save(Almacen almacen);
	public List<Almacen> listarAlmacen();
	public void delete(Almacen almacen);
	public Boolean verificarExisteCategoria(String nombre);
}
