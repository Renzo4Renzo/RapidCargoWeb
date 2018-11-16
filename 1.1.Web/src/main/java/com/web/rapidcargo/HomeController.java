package com.web.rapidcargo;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utiles.Constantes;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "principalExtranet";
	}
	
	
	@RequestMapping(value = "/principalCajero", method = RequestMethod.GET)
	public String principalCajero(Model model, HttpServletRequest req) {
		if (Constantes.conectado == false) {
			return "redirect:/login";
		}
		return "cajero/principalCajero";
	}
	
	
	@RequestMapping(value = "/principalAlmacen", method = RequestMethod.GET)
	public String principalAlmacen(Model model) {
		if (Constantes.conectado == false) {
			return "redirect:/login";
		}
		return "almacen/principalAlmacen";
	}
	
}
