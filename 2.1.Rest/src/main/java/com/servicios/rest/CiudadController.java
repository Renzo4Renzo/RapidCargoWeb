package com.servicios.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoCiudad;
import com.entidades.all.Ciudad;


@Controller
public class CiudadController {
	
	@RequestMapping(value = "/Ciudad/ListarCiudad", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Ciudad> ListarCiudad() {
		ArrayList<Ciudad> c = null;
		try {
			c= daoCiudad.Instancia().ListarCiudad();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
