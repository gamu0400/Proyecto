package com.project.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.IProductoDAO;
import com.project.demo.entity.Productos;

@Service
public class ProductosServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDAO productoDAO;

	@Override
	public void save(Productos producto) {
		productoDAO.save(producto);
	}

	@Override
	public List<Productos> listarProductos() {
		
		return (List<Productos>)productoDAO.findAll();
	}

	@Override
	public void delete(Long id) {
		productoDAO.deleteById(id);;	
	}

	@Override
	public Boolean verificarExisteProducto(String nombre) {
		List<Productos> lista = productoDAO.findBynombre(nombre);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}

	@Override
	public Productos buscarProductos(long id) {	
		return productoDAO.findById(id).orElse(null);
	}

	

}
