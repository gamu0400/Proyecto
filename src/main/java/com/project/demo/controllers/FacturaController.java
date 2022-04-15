package com.project.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.demo.entity.Cliente;
import com.project.demo.entity.DetalleFactura;
import com.project.demo.entity.Factura;
import com.project.demo.entity.Productos;
import com.project.demo.models.service.IClienteService;
import com.project.demo.models.service.IFacturaService;
import com.project.demo.models.service.IProductoService;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IFacturaService facturaService;
	
	@RequestMapping("/")
	public String inicio() {
		return "factura/index";
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscar(String dni, Model model, RedirectAttributes flash) {
		Cliente cliente = clienteService.buscarCliente(dni);
		if(cliente == null) {
			flash.addFlashAttribute("error", "CLIENTE NO EXISTE");
			return "redirect:/factura/";
		}
		Factura factura = new Factura();
		factura.setCliente(cliente);
		model.addAttribute("factura", factura);
		return "factura/vender";
	}
	@RequestMapping(value = "/cargar_productos/{term}" , produces = {"application/json"})
	public @ResponseBody List<Productos> cargarProductos(@PathVariable String term){
		return clienteService.buscarProductos(term);
	}
	
	@RequestMapping("/form")
	public String guardar(Factura factura, 
			@RequestParam(name = "item_id[]" , required = true) Integer[] itemId,
			@RequestParam(name = "cantidad[]" , required = true) Integer[] cantidad,
			RedirectAttributes flash, 
			SessionStatus status) {
		
		for(int i=0; i<itemId.length; i++) {
			Productos productos = productoService.buscarProductos(itemId[i]);
			
			DetalleFactura linea = new DetalleFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProductos(productos);
			factura.addDetalleFactura(linea);
		}
		
		facturaService.guardarFactura(factura);
		status.setComplete();
		
		flash.addFlashAttribute("success", "Factura registrada con éxito");
		
		return "redirect:/factura/";
	}
}
