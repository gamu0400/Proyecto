package com.project.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.ICategoriaDAO;
import com.project.demo.entity.Categoria;

@Service
public class CategoriaServiceimpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDAO categoriaDAO;
	
	@Override
	public void save(Categoria categoria) {
		
		categoriaDAO.save(categoria);
		
	}

	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaDAO.findAll();
	}

	@Override
	public Boolean verificarExisteCategoria(String nombre) {
		List<Categoria> lista = categoriaDAO.findBycategorianombre(nombre);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}

	
	
	
	
}
