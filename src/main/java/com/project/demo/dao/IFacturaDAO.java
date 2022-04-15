package com.project.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Factura;

public interface IFacturaDAO extends CrudRepository<Factura, Long>{

}
