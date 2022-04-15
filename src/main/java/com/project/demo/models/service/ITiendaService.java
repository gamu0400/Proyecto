package com.project.demo.models.service;

import java.util.List;

import com.project.demo.entity.Tienda;

public interface ITiendaService {
	
	public void save(Tienda tienda);
	public List<Tienda> findAll();
	public Boolean verificarExisteTienda(String nombre);
}
