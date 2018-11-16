package com.servicios.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoEntregaUnica;

@Controller
public class EntregaUnicaController {
	
	@RequestMapping(value = "/Entrega/EntregarEnSucursal", 
			method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Boolean AsignarCargaMinivan(String idEncomienda, String nombreUsuario) {
		Boolean inserto = false;
		try {			
			inserto = daoEntregaUnica.Instancia().EntregarEnSucursal(idEncomienda,nombreUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}	
	
	@RequestMapping(value = "/Entrega/EntregarEnDomicilio", 
			method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Boolean EntregarEnDomicilio(String idEncomienda, String nombreUsuario) {
		Boolean inserto = false;
		try {			
			inserto = daoEntregaUnica.Instancia().EntregarEnDomicilio(idEncomienda, nombreUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
}
