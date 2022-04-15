package com.project.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria", uniqueConstraints = {@UniqueConstraint(columnNames = {"categoria_nombre"})})
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoria")
	private Long id;
	
	@NotEmpty
	@Size(min = 4, max = 20)
	@Column(name = "categoria_nombre")
	private String categorianombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategorianombre() {
		return categorianombre;
	}

	public void setCategorianombre(String categorianombre) {
		this.categorianombre = categorianombre;
	}

	




	
}