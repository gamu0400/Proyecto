package com.project.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Tienda;

public interface ITiendaDAO extends CrudRepository<Tienda, Long> {
	public List<Tienda> findBynombre(String nombre);
	
}
