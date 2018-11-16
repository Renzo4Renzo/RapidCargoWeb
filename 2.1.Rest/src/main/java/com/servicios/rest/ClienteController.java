package com.servicios.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoCliente;
import com.entidades.all.Cliente;
import com.entidades.all.Persona;



@Controller
public class ClienteController {
	@RequestMapping(value = "/Cliente/CrearCliente", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean CrearCliente(String dniCliente, String nombresCliente,String apellidosCliente,String direccionCliente,String telefonoCliente,
				String correoElectronico,String generoCliente) {
		Boolean inserto = false;
		try {
			Cliente cliente = new Cliente();
			cliente.setDniCliente(dniCliente);
			
			Persona persona = new Persona();
			
			persona.setNombres(nombresCliente);
			persona.setApellidos(apellidosCliente);
			persona.setDireccion(direccionCliente);
			persona.setTelefono(telefonoCliente);
			persona.setGenero(generoCliente);
			
			cliente.setCorreoElectronico(correoElectronico);
			
			cliente.setPersona(persona);
			
			
			inserto = daoCliente.Instancia().CrearCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
	
	
	@RequestMapping(value = "/Cliente/DevolverCliente", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Cliente VerificarAcceso(String dni) {
		Cliente c = null;
		try {
			c = daoCliente.Instancia().DevolverCliente(dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@RequestMapping(value = "/Cliente/ValidarDNI", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Boolean ValidarDNI(String dni) {
		Boolean valido = false;
		try {
			valido = daoCliente.Instancia().ValidarDniCliente(dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valido;
	}
	
}
