package utiles;

import org.springframework.web.servlet.ModelAndView;

public class Desconexion {
	
	/*INICIO PRINCIPIO DE REFACTORIZACI�N: Principio DRY */
	public static ModelAndView VerificarDesconexion() {	
		ModelAndView modelAndView =  new ModelAndView("redirect:/login");
		return modelAndView;
	}
	/*FIN PRINCIPIO DE REFACTORIZACI�N: Principio DRY */
}
