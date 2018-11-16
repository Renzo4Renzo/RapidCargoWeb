package com.servicios.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoEncomienda;
import com.entidades.all.Cliente;
import com.entidades.all.Encomienda;
import com.entidades.all.Ruta;
import com.entidades.all.Sucursal;
import com.entidades.all.Usuario;


@Controller
public class EncomiendaController {
	
	@RequestMapping(value = "/Encomienda/RegistrarEncomienda", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean RegistrarEncomienda(String dniCliente,int idRuta,String fechaLlegada,String nombreDestinatario,String direccionDestinatario
				,int idSucursalOrigen,int idSucursalDestino,String usuarioCajero,float peso, float montoPago, String descripcionEncomienda, Boolean aDomicilio) {
		Boolean inserto = false;
		try {
			Encomienda encomienda = new Encomienda();
			Cliente cliente = new Cliente();
			cliente.setDniCliente(dniCliente);
			encomienda.setCliente(cliente);
			Ruta ruta = new Ruta();
			ruta.setIdRuta(idRuta);
			encomienda.setRuta(ruta);
			encomienda.setFechaLlegada(fechaLlegada);
			encomienda.setDireccionDestinatario(direccionDestinatario);
			encomienda.setNombreDestinatario(nombreDestinatario);
			
			Sucursal sucursalOrigen = new Sucursal();
			sucursalOrigen.setIdSucursal(idSucursalOrigen);
			
			Sucursal sucursalDestino = new Sucursal();
			sucursalDestino.setIdSucursal(idSucursalDestino);
			
			encomienda.setSucursalOrigen(sucursalOrigen);
			encomienda.setSucursalDestino(sucursalDestino);
			
			Usuario uCajero = new Usuario();
			uCajero.setNombreUsuario(usuarioCajero);
			
			encomienda.setUsuarioCajero(uCajero);
			
			encomienda.setPeso(peso);
			encomienda.setMontoPago(montoPago);
			encomienda.setDescripcionEncomienda(descripcionEncomienda);
			encomienda.setaDomicilio(aDomicilio);
			
			inserto = daoEncomienda.Instancia().RegistrarEncomienda(encomienda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
	
	
	@RequestMapping(value = "Encomienda/DevolverEncomienda", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Encomienda DevolverEncomienda(String codigoEncomienda) {
		Encomienda u = null;
		try {
			u = daoEncomienda.Instancia().DevolverEncomienda(codigoEncomienda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@RequestMapping(value = "/Encomienda/ListarEncomiendaGerente", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Encomienda> ListarEncomiendaGerente(String fechaInicio, String fechaFin) {
		ArrayList<Encomienda> en = null;
		try {
			en= daoEncomienda.Instancia().ListarEncomiendaGerente(fechaInicio, fechaFin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}
	
	/*INICIO REFACTORIZACI�N 2: Reemplazar Par�metro con M�todos Expl�citos*/
	@RequestMapping(value = "/Encomienda/calcularMonto", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody float calcularMontoPago(float peso) {
		Encomienda encomienda = new Encomienda();
		
		return encomienda.calcularPago(peso);
	}
	
	@RequestMapping(value = "/Encomienda/validarPeso", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean validarPeso(float peso) {
		Encomienda encomienda = new Encomienda();
		
		return encomienda.validarPesoLimite(peso);
	}
	/*FIN REFACTORIZACI�N 2: Reemplazar Par�metro con M�todos Expl�citos*/
	
	@RequestMapping(value = "/Encomienda/ListarEncomiendasSalir", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Encomienda> ListarEncomiendasSalir(int idSucursalOrigen) {
		ArrayList<Encomienda> en = null;
		try {
			en= daoEncomienda.Instancia().ListarEncomiendasSalir(idSucursalOrigen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}
	
	@RequestMapping(value = "/Encomienda/ListarEncomiendasEntregaSucursal", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Encomienda> ListarEncomiendasEntregaSucursal(int idSucursalOrigen) {
		ArrayList<Encomienda> en = null;
		try {
			en= daoEncomienda.Instancia().ListarEncomiendasEntregaSucursal(idSucursalOrigen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}
	
	@RequestMapping(value = "/Encomienda/ListarEncomiendasEntregaDomicilio", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Encomienda> ListarEncomiendasEntregaDomicilio(int idSucursalOrigen) {
		ArrayList<Encomienda> en = null;
		try {
			en= daoEncomienda.Instancia().ListarEncomiendasEntregaDomicilio(idSucursalOrigen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}
	
	@RequestMapping(value = "/Encomienda/ListarEncomiendasTrasladoBus", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Encomienda> ListarEncomiendasTrasladoBus(String nombreConductor) {
		ArrayList<Encomienda> en = null;
		try {
			en= daoEncomienda.Instancia().ListarEncomiendasTrasladoBus(nombreConductor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}
	
	@RequestMapping(value = "/Encomienda/ListarEncomiendasEntregaMinivan", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Encomienda> ListarEncomiendasEntregaMinivan(String nombreConductor) {
		ArrayList<Encomienda> en = null;
		try {
			en= daoEncomienda.Instancia().ListarEncomiendasEntregaMinivan(nombreConductor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}
	
	@RequestMapping(value = "/Encomienda/TrasladarEncomienda", 
			method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody Boolean TrasladarEncomienda(int idEncomienda) {
		Boolean edito = false;
		try {
			Encomienda encomienda = new Encomienda();
			encomienda.setIdEncomienda(idEncomienda);		
			edito = daoEncomienda.Instancia().TrasladarEncomienda(encomienda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return edito;
	}
	
}