package com.project.demo.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Tienda")
public class Tienda implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tienda")
	private long id;
	
	@NotEmpty
	@Size(min = 4, max = 20)
	@Column(name="nombre_tienda")
	private String nombre;
	
	@NotEmpty
	@Size(min = 4, max = 20)
	@Column(name="direccion_tienda")
	private String direccion;
	
	@NotEmpty
	@Size(min = 4, max = 9)
	@Column(name="telefono_tienda")
	private String telefono;
	
	@NotEmpty
	@Size(min = 4, max = 20)
	@Column(name="descripcion_tienda")
	private String descripcion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
