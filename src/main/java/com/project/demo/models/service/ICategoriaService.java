package com.project.demo.models.service;

import java.util.List;

import com.project.demo.entity.Categoria;

public interface ICategoriaService {
	public void save(Categoria categoria);
	public List<Categoria> findAll();
	public Boolean verificarExisteCategoria(String nombre);
	
}
