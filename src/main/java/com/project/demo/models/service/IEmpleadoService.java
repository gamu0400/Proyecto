package com.project.demo.models.service;

import java.util.List;

import com.project.demo.entity.Empleado;

public interface IEmpleadoService {
	public void save(Empleado empleado);
	public List<Empleado> findAll();
	public Boolean verificarExisteEmpleado (String nombre);
}
