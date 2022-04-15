package com.project.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Almacen;
import com.project.demo.entity.Categoria;

public interface IAlmacenDAO extends CrudRepository<Almacen, Long>{
	
	public List<Almacen> findBynombrealmacen (String nombrealmacen);
}
