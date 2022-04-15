package com.project.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.IEmpleadoDAO;
import com.project.demo.entity.Empleado;

@Service
public class EmpleadoServiceimpl implements IEmpleadoService{
	
	@Autowired
	private IEmpleadoDAO empleadoDAO;

	@Override
	public void save(Empleado empleado) {
		empleadoDAO.save(empleado);
		
	}

	@Override
	public List<Empleado> findAll() {
		return (List<Empleado>)empleadoDAO.findAll();
	}

	@Override
	public Boolean verificarExisteEmpleado(String nombre) {
		List<Empleado> lista = empleadoDAO.findBynombre(nombre);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}
	
}
