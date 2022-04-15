package com.project.demo.models.service;

import java.util.List;

import com.project.demo.entity.Cliente;
import com.project.demo.entity.Productos;

public interface IClienteService {
	public Cliente buscarCliente(String dni);
	
	public List<Productos> buscarProductos(String term);
}
