package com.project.demo.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long>{
	public List<Categoria> findBycategorianombre (String categoria_nombre);
	
}
