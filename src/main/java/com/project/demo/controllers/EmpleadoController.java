package com.project.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.demo.entity.Empleado;
import com.project.demo.models.service.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	@RequestMapping("/")
	public String inicio(Model model) {
		Empleado empleado = new Empleado();
		model.addAttribute("empleado", empleado);
		model.addAttribute("listaEmpleado", empleadoService.findAll());
		return "empleado/index";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Empleado empleado,BindingResult resultado,Model model,RedirectAttributes flash) {
		 if(resultado.hasErrors()) {			
				model.addAttribute("listaEmpleado", empleadoService.findAll());
				  return "empleado/index";
			  }	
		 if(empleadoService.verificarExisteEmpleado(empleado.getNombre())) {
			  
				empleadoService.save(empleado);		  
		  }else {
			  flash.addFlashAttribute("error", "El nombre del empleado no puede ser duplicado");
		  }
	
		return "redirect:/empleado/";
	}
	
	
}
