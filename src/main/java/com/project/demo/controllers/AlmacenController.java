package com.project.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.demo.entity.Almacen;
import com.project.demo.models.service.IAlmacenService;
import com.project.demo.models.service.ITiendaService;

@Controller
@RequestMapping("/almacen")
public class AlmacenController {
	
	@Autowired
	private IAlmacenService almacenService;
	
	@Autowired
	private ITiendaService tiendaService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Almacen almacen = new Almacen();
		model.addAttribute("almacen", almacen);
		model.addAttribute("listaTienda", tiendaService.findAll());
		model.addAttribute("listaAlmacen", almacenService.listarAlmacen());
		return "almacen/index";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Almacen almacen,BindingResult resultado, Model model,RedirectAttributes flash) {
		if(resultado.hasErrors()) {			
			model.addAttribute("listaAlmacen", almacenService.listarAlmacen());
			  return "almacen/index";
		  }
		if(almacenService.verificarExisteCategoria(almacen.getNombrealmacen())) {
			almacenService.save(almacen);
		}else {
			  flash.addFlashAttribute("error", "El nombre del almacen no puede ser duplicado");
		  }
		return "redirect:/almacen/";
		
	}
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable Long id) {
		List<Almacen> listaAlmacensel = new ArrayList<>();
		listaAlmacensel = almacenService.listarAlmacen();
		for(Almacen alma: listaAlmacensel) {
			if(alma.getId()==id) {
				almacenService.delete(alma);				
			}
		}
		return "redirect:/almacen/";
	}
	

}
