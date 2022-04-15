package com.project.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempleado")
	private Long id;
	
	@NotEmpty
	@Size(min = 4, max = 20)
	@Column(name = "nombre_empleado")
	private String nombre;
	
	@NotEmpty
	@Size(min = 4, max = 100)
	@Column(name = "direccion")
	private String direccion;
	
	@NotEmpty
	@Size(min = 9, max = 9)
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_ingreso;
	
	@PrePersist
	@PreUpdate
	public void  fecha() {
		fecha_ingreso = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	
	
}
