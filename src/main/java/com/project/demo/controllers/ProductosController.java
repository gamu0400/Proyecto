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

import com.project.demo.entity.Productos;
import com.project.demo.models.service.ICategoriaService;
import com.project.demo.models.service.IProductoService;



@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private IProductoService productosService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Productos productos = new Productos();
		model.addAttribute("productos", productos);
		model.addAttribute("listaCategorias", categoriaService.findAll());
		model.addAttribute("listaProductos", productosService.listarProductos());	
		return "productos/index";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Productos producto,BindingResult resultado,Model model,RedirectAttributes flash) {
		if(resultado.hasErrors()) {
			model.addAttribute("listaProductos", productosService.listarProductos());
			  return "productos/index";
		}
		if(productosService.verificarExisteProducto(producto.getNombre())) {
			productosService.save(producto);
		}else {
			  flash.addFlashAttribute("error", "El nombre de la categoría no puede ser duplicado");
		  }
		
		return "redirect:/productos/";
	}
	
	  @RequestMapping(value =  "/eliminar/{id}", method = RequestMethod.GET)
	    public String eliminar(@PathVariable Long id) {
	    	productosService.delete(id);
	        return "redirect:/productos/";
	    }
	
}
