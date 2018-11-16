package com.servicios.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoSucursal;
import com.entidades.all.Sucursal;


@Controller
public class SucursalController {
	@RequestMapping(value = "/Sucursal/ListarSucursalGerente", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Sucursal> ListarSucursalGerente() {
		ArrayList<Sucursal> v = null;
		try {
			v= daoSucursal.Instancia().ListarSucursales();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	@RequestMapping(value = "/Sucursal/ListarSucursalCajero", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Sucursal> ListarSucursalCajero(String idRuta) {
		ArrayList<Sucursal> v = null;
		try {
			v= daoSucursal.Instancia().ListarSucursalesCajero(idRuta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
}
