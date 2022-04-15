package com.project.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Usuarios;

public interface IUsuariosDAO extends CrudRepository<Usuarios, Long>{
	
	public Usuarios findByUsername(String username);
}
