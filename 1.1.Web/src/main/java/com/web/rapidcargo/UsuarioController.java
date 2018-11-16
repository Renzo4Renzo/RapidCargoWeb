package com.web.rapidcargo;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import pojo.Usuario;
import utiles.Constantes;

@Controller
public class UsuarioController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView Login() {		
		return new ModelAndView("loginIntranet", "command", new Usuario());	
	}
	
	/*INICIO REFACTORIZACIÓN 1: Temporal en Línea*/
	@RequestMapping(value = "/VerificarAcceso", method = RequestMethod.POST)
	public String VerificarAcceso(@ModelAttribute("SpringWeb")Usuario u, 
						HttpServletRequest req, ModelMap model) {		
		try {
			//Verficamos acceso desde la API REST
			RestTemplate rest = new RestTemplate();
			String URI = Constantes.urlAPI+"/Usuario/VerificarAcceso" + 
						"?nombreUsuario="+u.getNombreUsuario()+"&contrasena="+u.getContrasena();
			Usuario result = rest.getForObject(URI, u.getClass());
			if(result!=null) {
				//agregamos el usuario logueado a la sesion 
				if(result.getTipoUsuario().getIdTipoUsuario() == 2)
					{	
						req.getSession().setAttribute("usuario", result);
						Constantes.conectado = true;
						return "redirect:/principalCajero";	
					}
				else if (result.getTipoUsuario().getIdTipoUsuario() == 3)
					{
						req.getSession().setAttribute("usuario", result);
						Constantes.conectado = true;
						return "redirect:/principalAlmacen";	
					}
				else
					return "redirect:/login?msg=Tipo de Usuario Incorrecto";
			}else {
				return "redirect:/login?msg=Usuario o password no valido";
			}			
		} catch (Exception e) {
			return "error";
		}	
	}
	/*FIN REFACTORIZACIÓN 1: Temporal en Línea*/

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView Logout(HttpServletRequest req) {
		req.getSession().removeAttribute("usuario");
		Constantes.conectado = false;
		return new ModelAndView("logout", "command", new Usuario());	
	}
	
}
