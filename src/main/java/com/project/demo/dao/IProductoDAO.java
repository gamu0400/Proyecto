package com.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Productos;

public interface IProductoDAO extends CrudRepository<Productos, Long>{
	public List<Productos> findBynombre	(String nombre);
	
	@Query (value = "SELECT * FROM productos WHERE nombre like %?1%" , nativeQuery=true)
	public List<Productos> findByNombre (String term);
}

