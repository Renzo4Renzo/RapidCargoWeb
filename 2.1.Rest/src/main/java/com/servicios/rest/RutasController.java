package com.servicios.rest;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoRuta;
import com.entidades.all.Ciudad;
import com.entidades.all.Ruta;

@Controller
public class RutasController {
	
	@RequestMapping(value = "/Ruta/CrearRuta", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean CrearRuta(String nombreRuta, int idCiudadOrigen,int idCiudadDestino,String descripcionRuta) {
		Boolean inserto = false;
		try {
			Ruta ruta = new Ruta();
			ruta.setNombreRuta(nombreRuta);
			
			Ciudad ciudadOrigen = new Ciudad();
			ciudadOrigen.setIdCiudad(idCiudadOrigen);
			
			Ciudad ciudadDestino = new Ciudad();
			ciudadDestino.setIdCiudad(idCiudadDestino);
			
			ruta.setCiudadOrigen(ciudadOrigen);
			ruta.setCiudadDestino(ciudadDestino);
			
			ruta.setDescripcionRuta(descripcionRuta);
			
			inserto = daoRuta.Instancia().CrearRuta(ruta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
	
	@RequestMapping(value = "/Ruta/ListarRutasGerente", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Ruta> ListarRutasGerente(String cadena) {
		ArrayList<Ruta> r = null;
		try {
			
			r= daoRuta.Instancia().ListarRutasGerente(cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	@RequestMapping(value = "/Ruta/ListarRutasCajero", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Ruta> ListarRutasCajero(String idCiudad ) {
		ArrayList<Ruta> r = null;
		try {
			
			r= daoRuta.Instancia().ListarRutasCajero(idCiudad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	@RequestMapping(value = "/Ruta/EliminarRuta", method = RequestMethod.GET, 
			produces ="application/json")
	public @ResponseBody Boolean DesactivarRuta(String idRuta) {
			Boolean elimino = false;
			try {
				elimino = daoRuta.Instancia().EliminarRuta(idRuta);
			} catch (Exception e) {
			e.printStackTrace();
			}
			return elimino;
	}
}
