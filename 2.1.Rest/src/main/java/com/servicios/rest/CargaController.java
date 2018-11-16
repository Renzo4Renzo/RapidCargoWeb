package com.servicios.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoCargaUnica;
import com.entidades.all.CargaUnica;
import com.entidades.all.Usuario;
import com.entidades.all.Vehiculo;

@Controller
public class CargaController {
	@RequestMapping(value = "/Carga/ListarChoferes", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Usuario> ListarChoferes() {
		ArrayList<Usuario> c = null;
		try {
			c= daoCargaUnica.Instancia().ListarChoferes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@RequestMapping(value = "/Carga/ListarBuses", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Vehiculo> ListarBuses() {
		ArrayList<Vehiculo> v = null;
		try {
			v= daoCargaUnica.Instancia().ListarBuses();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	@RequestMapping(value = "/Carga/AsignarCargaBus", 
			method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Boolean AsignarCargaBus(@RequestBody CargaUnica carga) {
		Boolean inserto = false;
		try {			
			inserto = daoCargaUnica.Instancia().AsignarCargaBus(carga);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}	
	
	@RequestMapping(value = "/Carga/ListarMinivan", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Vehiculo> ListarMinivan() {
		ArrayList<Vehiculo> v = null;
		try {
			v= daoCargaUnica.Instancia().ListarMinivan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	@RequestMapping(value = "/Carga/AsignarCargaMinivan", 
			method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Boolean AsignarCargaMinivan(@RequestBody CargaUnica carga) {
		Boolean inserto = false;
		try {			
			inserto = daoCargaUnica.Instancia().AsignarCargaMinivan(carga);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}

}
