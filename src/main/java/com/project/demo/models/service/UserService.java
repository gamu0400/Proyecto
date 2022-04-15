package com.project.demo.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.dao.IUsuariosDAO;
import com.project.demo.entity.Rol;
import com.project.demo.entity.Usuarios;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private IUsuariosDAO usuariosDAO;
	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuarios = usuariosDAO.findByUsername(username);
		
		List<GrantedAuthority> listaRoles = new ArrayList<>();
		
		if(usuarios==null) {
			log.error("Error login: no existe el usuario");
			throw new UsernameNotFoundException("Usuario No Existe");
		}
		
		for(Rol item: usuarios.getRoles()) {
			listaRoles.add(new SimpleGrantedAuthority(item.getAuthority()));
		}
		if(listaRoles.isEmpty()) {
			log.error("Error login: Usuario no tiene roles asignados");
			throw new UsernameNotFoundException("Usuario no tiene roles asignados");
			
		}
		return new User(usuarios.getUsername(), usuarios.getPassword(), usuarios.getEnabled(),true,true,true,listaRoles);
		
	}
	
	
}
