package com.project.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.demo.entity.Usuario;
import com.project.demo.models.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	@RequestMapping("/")
	public String inicio(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaUsuario", usuarioService.findAll());		
		return "usuario/index";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/usuario/";
	}
}
