package com.project.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.Cliente;

@Repository
public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	public Cliente findByDni(String dni);
}
