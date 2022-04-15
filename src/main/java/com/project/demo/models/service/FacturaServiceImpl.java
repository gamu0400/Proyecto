package com.project.demo.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.IFacturaDAO;
import com.project.demo.entity.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaDAO facturaDAO;
	
	@Override
	public void guardarFactura(Factura factura) {
		facturaDAO.save(factura);
	}
	
}
