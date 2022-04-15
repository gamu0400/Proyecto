package com.project.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.IAlmacenDAO;
import com.project.demo.entity.Almacen;

@Service
public class AlmacenServiceimpl implements IAlmacenService{
	
	@Autowired
	private IAlmacenDAO almacenDAO;

	@Override
	public void save(Almacen almacen) {
		almacenDAO.save(almacen);
		
	}

	@Override
	public List<Almacen> listarAlmacen() {
		
		return (List<Almacen>)almacenDAO.findAll();
	}

	@Override
	public void delete(Almacen almacen) {
		almacenDAO.delete(almacen);
		
	}

	@Override
	public Boolean verificarExisteCategoria(String nombre) {
		List<Almacen> lista = almacenDAO.findBynombrealmacen(nombre);
		Boolean rpta;
		if(lista.size()==0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}

}
