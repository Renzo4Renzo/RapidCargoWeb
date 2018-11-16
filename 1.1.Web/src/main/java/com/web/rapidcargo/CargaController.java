package com.web.rapidcargo;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import pojo.CargaUnica;
import pojo.Cliente;
import pojo.Encomienda;
import pojo.Usuario;
import pojo.Vehiculo;
import utiles.Constantes;
import utiles.Desconexion;

@Controller
public class CargaController {

	@RequestMapping(value = "/ListarEncomiendasSalida", method = RequestMethod.GET)
	public ModelAndView ListarEncomiendasSalida(HttpServletRequest req) {		
		try {
			if (Constantes.conectado == false) {
				return Desconexion.VerificarDesconexion(); //Principio DRY
			}
			Usuario u = (Usuario)req.getSession().getAttribute("usuario");
			RestTemplate rest = new RestTemplate();
			String URI = Constantes.urlAPI + "/Encomienda/ListarEncomiendasSalir?idSucursalOrigen="+u.getSucursal().getIdSucursal();
			ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
			
			ArrayList<Encomienda> result = rest.getForObject(URI, lista.getClass());
			
			ModelAndView m = new ModelAndView("almacen/encomiendasSalida");
			m.addObject("listita", result);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
		}	
	}
	
	

	@RequestMapping(value = "/AsignarEncomiendasSalida", method = RequestMethod.GET)
	public ModelAndView AsignarEncomiendasSalida(HttpServletRequest req,String idEncomienda) {		
		try {
			if (Constantes.conectado == false) {
				return Desconexion.VerificarDesconexion(); //Principio DRY
			}
			RestTemplate rest = new RestTemplate();
			//Choferes
			String URI = Constantes.urlAPI + "/Carga/ListarChoferes";
			ArrayList<Usuario> listaChoferes = new ArrayList<Usuario>();
			ArrayList<Usuario> choferes = rest.getForObject(URI, listaChoferes.getClass());
			
			//Buses
			
			String URI2 = Constantes.urlAPI + "/Carga/ListarBuses";
			ArrayList<Vehiculo> listaBuses = new ArrayList<Vehiculo>();
			ArrayList<Vehiculo> buses = rest.getForObject(URI2, listaBuses.getClass());
			
			
			ModelAndView m = new ModelAndView("almacen/encomiendaSalidaSeleccion","command",new CargaUnica());
			m.addObject("choferes", choferes);
			m.addObject("buses", buses);
			m.addObject("idEncomienda",idEncomienda);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
		}	
	}
	
	@RequestMapping(value = "/AsignarCargaBus", method = RequestMethod.POST)
	public String AsignarCargaBus(@ModelAttribute("SpringWeb")CargaUnica carga, 
						HttpServletRequest req, ModelMap model) {		
		try {
			Usuario u = (Usuario)req.getSession().getAttribute("usuario");
			carga.setUsuarioAlmacenero(u);
			
			RestTemplate rest = new RestTemplate();
		
			rest.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
			rest.getMessageConverters().add(new StringHttpMessageConverter());
			String uri = Constantes.urlAPI + "/Carga/AsignarCargaBus";			
			ResponseEntity<String> result = rest.postForEntity(uri, carga, String.class);
			
			if(result.getBody().toString().equals("true"))
				return "redirect:/ListarEncomiendasSalida?msg=Encomienda Asignada Correctamente";
			else
				return "redirect:/ListarEncomiendasSalida?msg=No se pudo Asignar la Encomienda";
		
		} catch (Exception e) {
			return "error";
		}	
	}
	
	
	@RequestMapping(value = "/ListarEncomiendasDomicilio", method = RequestMethod.GET)
	public ModelAndView ListarEncomiendasDomicilio(HttpServletRequest req) {		
		try {
			if (Constantes.conectado == false) {
				return Desconexion.VerificarDesconexion(); //Principio DRY
			}
			Usuario u = (Usuario)req.getSession().getAttribute("usuario");
			RestTemplate rest = new RestTemplate();
			String URI = Constantes.urlAPI + "/Encomienda/ListarEncomiendasEntregaDomicilio?idSucursalOrigen="+u.getSucursal().getIdSucursal();
			ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
			
			ArrayList<Encomienda> result = rest.getForObject(URI, lista.getClass());
			
			ModelAndView m = new ModelAndView("almacen/encomiendasDomicilio");
			m.addObject("listita", result);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
		}	
	}
	
	
	@RequestMapping(value = "/AsignarEncomiendasDomicilio", method = RequestMethod.GET)
	public ModelAndView AsignarEncomiendasDomicilio(HttpServletRequest req,String idEncomienda) {		
		try {
			if (Constantes.conectado == false) {
				return Desconexion.VerificarDesconexion(); //Principio DRY
			}
			RestTemplate rest = new RestTemplate();
			//Choferes
			String URI = Constantes.urlAPI + "/Carga/ListarChoferes";
			ArrayList<Usuario> listaChoferes = new ArrayList<Usuario>();
			ArrayList<Usuario> choferes = rest.getForObject(URI, listaChoferes.getClass());
			
			//Buses
			
			String URI2 = Constantes.urlAPI + "/Carga/ListarMinivan";
			ArrayList<Vehiculo> listaBuses = new ArrayList<Vehiculo>();
			ArrayList<Vehiculo> buses = rest.getForObject(URI2, listaBuses.getClass());
			
			
			ModelAndView m = new ModelAndView("almacen/encomiendasDomicilioSeleccion","command",new CargaUnica());
			m.addObject("choferes", choferes);
			m.addObject("buses", buses);
			m.addObject("idEncomienda",idEncomienda);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
		}	
	}
	
	@RequestMapping(value = "/AsignarCargaMinivan", method = RequestMethod.POST)
	public String AsignarCargaMinivan(@ModelAttribute("SpringWeb")CargaUnica carga, 
						HttpServletRequest req, ModelMap model) {		
		try {
			Usuario u = (Usuario)req.getSession().getAttribute("usuario");
			carga.setUsuarioAlmacenero(u);
			
			RestTemplate rest = new RestTemplate();
		
			rest.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
			rest.getMessageConverters().add(new StringHttpMessageConverter());
			String uri = Constantes.urlAPI + "/Carga/AsignarCargaMinivan";			
			ResponseEntity<String> result = rest.postForEntity(uri, carga, String.class);
			
			if(result.getBody().toString().equals("true"))
				return "redirect:/ListarEncomiendasDomicilio?msg=Encomienda Asignada Correctamente";
			else
				return "redirect:/ListarEncomiendasDomicilio?msg=No se pudo Asignar la Encomienda";
		
		} catch (Exception e) {
			return "error";
		}	
	}
	
	
}
