package com.project.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "facturas")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fac_id")
	private Long id;
	
	@Column(name = "fac_descripcion")
	private String descripcion;
	
	@Column(name = "fac_observacion")
	private String observacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fac_fecha_creacion")
	private Date fecha_creacion;
	
	@ManyToOne
	@JoinColumn(name = "cliente_idcliente")
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "facturas_fac_id", nullable = false)
	private List<DetalleFactura> listaDetalles;
	
	@PrePersist
	@PreUpdate
	public void prePersistencia() {
		fecha_creacion = new Date();
	}
	
	
	public Factura() {
		this.listaDetalles = new ArrayList<>();
	}
	
	public void addDetalleFactura(DetalleFactura detalle) {
		this.listaDetalles.add(detalle);
	}
	
	
	public List<DetalleFactura> getListaDetalles() {
		return listaDetalles;
	}


	public void setListaDetalles(List<DetalleFactura> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
