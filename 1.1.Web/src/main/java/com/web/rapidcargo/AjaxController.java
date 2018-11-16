package com.web.rapidcargo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import pojo.Cliente;
import pojo.Sucursal;
import utiles.Constantes;

@Controller
public class AjaxController {
	@RequestMapping(value = "cargarSucursales")
	public ModelAndView cargarSucursales(String idRuta) {
		ModelAndView mv = new ModelAndView("ajax/sucursalesDestino");
		RestTemplate rest = new RestTemplate();
		String URI2 = Constantes.urlAPI + "/Sucursal/ListarSucursalCajero?idRuta="+idRuta;
		ArrayList<Sucursal> lista2 = new ArrayList<Sucursal>();
		ArrayList<Sucursal> result2 = rest.getForObject(URI2, lista2.getClass());
		mv.addObject("sucursales", result2);
		return mv;
	}
	
	@RequestMapping(value = "listarCliente")
	public ModelAndView listarCliente(String dni) {
		ModelAndView mv = new ModelAndView("ajax/datosCliente");
		RestTemplate rest = new RestTemplate();
		String URI2 = Constantes.urlAPI + "/Cliente/DevolverCliente?dni="+dni;
		Cliente lista2 = new Cliente();
		Cliente result2 = rest.getForObject(URI2, lista2.getClass());
		mv.addObject("cliente", result2);
		return mv;
	}
	
	@RequestMapping(value = "validarDNI")
	public @ResponseBody String validarDNI(String dni) {
		RestTemplate rest = new RestTemplate();
		String URI = Constantes.urlAPI + "/Cliente/ValidarDNI?dni="+dni;
		Boolean resultado = false;
		Boolean resulta2 = rest.getForObject(URI, resultado.getClass());
		String respuesta;
		if(resulta2)
			respuesta = "DNI Valido <a onclick='listarCliente()'>Ver Datos</a>";
		else
			respuesta = "DNI no encontrado <a href='/web/NuevoCliente'>Crear</a>";
				
		return respuesta;
	}
	
	@RequestMapping(value = "calcularMonto")
	public @ResponseBody Float calcularMonto(float peso) throws Exception {
		Float resultado = 0.0f;
		try {
			RestTemplate rest = new RestTemplate();
			
			String URI2 = Constantes.urlAPI + "/Encomienda/validarPeso?peso="+peso;
			Boolean valido = false;
			valido = rest.getForObject(URI2, valido.getClass());
			if(valido)
			{	String URI = Constantes.urlAPI + "/Encomienda/calcularMonto?peso="+peso;			
				resultado = rest.getForObject(URI, resultado.getClass());
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return resultado;
	}
	
}
