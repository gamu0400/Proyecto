package com.project.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

}
