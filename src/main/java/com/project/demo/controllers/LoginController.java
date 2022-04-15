package com.project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autenticacion")
public class LoginController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="error", required = false) String error, 
			Model model) {
		
		if(error!=null) {
			model.addAttribute("error","Error usuario/contraseña incorrecta");
		}
		return "autenticacion/index";
	}
}
