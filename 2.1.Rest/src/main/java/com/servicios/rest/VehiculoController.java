package com.servicios.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoVehiculo;
import com.entidades.all.TipoVehiculo;
import com.entidades.all.Vehiculo;

@Controller
public class VehiculoController {
	
	@RequestMapping(value = "/Vehiculo/CrearVehiculo", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean CrearVehiculo(String numeroPlaca, int idTipoVehiculo,float capacidadKilos) {
		Boolean inserto = false;
		try {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setNumeroPlaca(numeroPlaca);
			
			TipoVehiculo tipoVehiculo = new TipoVehiculo();
			tipoVehiculo.setIdTipoVehiculo(idTipoVehiculo);
			
			vehiculo.setTipoVehiculo(tipoVehiculo);
			
			vehiculo.setCapacidadKilos(capacidadKilos);
			
			inserto = daoVehiculo.Instancia().CrearVehiculo(vehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
	
	@RequestMapping(value = "/Vehiculo/ListarVehiculo", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Vehiculo> ListarVehiculo(int idTipoVehiculo, String cadena) {
		ArrayList<Vehiculo> v = null;
		try {
			v= daoVehiculo.Instancia().ListarVehiculo(idTipoVehiculo, cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	@RequestMapping(value = "/Vehiculo/EliminarVehiculo", method = RequestMethod.GET, 
			produces ="application/json")
	public @ResponseBody Boolean DesactivarVehiculo(String idVehiculo) {
			Boolean elimino = false;
			try {
				elimino = daoVehiculo.Instancia().EliminarVehiculo(idVehiculo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return elimino;
	}
}
