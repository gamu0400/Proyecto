package com.project.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "almacen")
public class Almacen implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idalmacen")
	private Long id;
	
	@NotEmpty
	@Size(min = 4,max = 20)
	@Column(name = "nombrealmacen")
	private String nombrealmacen;
	
	@NotEmpty
	@Size(min = 4,max = 100)
	@Column(name = "direccionalmacen")
	private String direccionalmacen;
	
	@NotEmpty
	@Size(min = 9,max = 9)
	@Column(name = "telefono")
	private String telefono;
	
	@NotEmpty
	@Size(min = 4,max = 20)
	@Column(name = "tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "idtienda")
	private Tienda tienda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrealmacen() {
		return nombrealmacen;
	}

	public void setNombrealmacen(String nombrealmacen) {
		this.nombrealmacen = nombrealmacen;
	}

	public String getDireccionalmacen() {
		return direccionalmacen;
	}

	public void setDireccionalmacen(String direccionalmacen) {
		this.direccionalmacen = direccionalmacen;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
