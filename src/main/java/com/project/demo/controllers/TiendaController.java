package com.project.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.demo.entity.Tienda;
import com.project.demo.models.service.ITiendaService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
	
	//instancia para que funcione el RequestMethod.POST(GUARDAR)
	@Autowired
	private ITiendaService tiendaService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Tienda tienda= new Tienda();
		model.addAttribute("listaTiendas",tiendaService.findAll());
		model.addAttribute("tienda",tienda);
		return "tienda/index";
	}
	
	//esto es el guardar
	@RequestMapping(value= "/form", method= RequestMethod.POST)
	public String guardar(@Valid Tienda tienda, BindingResult resultado,Model model,RedirectAttributes flash) {
		if(resultado.hasErrors()) {			
			model.addAttribute("listaTiendas",tiendaService.findAll());
			  return "tienda/index";
		  }	
		if(tiendaService.verificarExisteTienda(tienda.getNombre())) {
			tiendaService.save(tienda);
		}else {
			flash.addFlashAttribute("error", "El nombre de la tienda no puede ser duplicado");
		}
		
		return "redirect:/tienda/";
	}
}