package com.project.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.demo.entity.Categoria;
import com.project.demo.models.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
    private ICategoriaService categoriaService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		model.addAttribute("listaCategorias", categoriaService.findAll());
		return "categoria/index";
	}
	
	  @RequestMapping(value= "/form", method= RequestMethod.POST)
	    public String guardar(@Valid  Categoria categoria, BindingResult resultado,Model model, RedirectAttributes flash) {
		  if(resultado.hasErrors()) {			
			model.addAttribute("listaCategorias", categoriaService.findAll());
			  return "categoria/index";
		  }		 
		  if(categoriaService.verificarExisteCategoria(categoria.getCategorianombre())) {
			  
			  categoriaService.save(categoria);		  
		  }else {
			  flash.addFlashAttribute("error", "El nombre de la categoría no puede ser duplicado");
		  }
			  
		   
	       
	        return "redirect:/categoria/";
	    }
}
