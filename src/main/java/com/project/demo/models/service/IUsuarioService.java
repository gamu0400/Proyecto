package com.project.demo.models.service;



import java.util.List;

import com.project.demo.entity.Usuario;

public interface IUsuarioService {
	public void save(Usuario usuario);
	public List<Usuario> findAll();
}
