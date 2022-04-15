package com.project.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.IClienteDAO;
import com.project.demo.dao.IProductoDAO;
import com.project.demo.entity.Cliente;
import com.project.demo.entity.Productos;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDAO clienteDAO;
	
	@Autowired
	private IProductoDAO productoDAO;
	
	@Override
	public Cliente buscarCliente(String dni) {
		return clienteDAO.findByDni(dni);
	}

	@Override
	public List<Productos> buscarProductos(String term) {
		return productoDAO.findByNombre(term);
	}
}
