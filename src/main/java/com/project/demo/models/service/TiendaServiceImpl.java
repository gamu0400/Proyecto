package com.project.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.ITiendaDAO;
import com.project.demo.entity.Tienda;

@Service
public class TiendaServiceImpl implements ITiendaService {

	@Autowired
	private ITiendaDAO tiendaDAO;
	@Override
	public void save(Tienda tienda) {
		tiendaDAO.save(tienda);
	}
	@Override
	public List<Tienda> findAll() {
		
		return (List<Tienda>)tiendaDAO.findAll();
	}
	@Override
	public Boolean verificarExisteTienda(String nombre) {
		List<Tienda> lista = tiendaDAO.findBynombre(nombre);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}

	

	
}
