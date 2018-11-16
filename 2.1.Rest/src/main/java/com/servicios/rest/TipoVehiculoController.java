package com.servicios.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.all.daoTipoVehiculo;
import com.entidades.all.TipoVehiculo;
@Controller
public class TipoVehiculoController {

	@RequestMapping(value = "/TipoVehiculo/ListarTipoVehiculo", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<TipoVehiculo> ListarTipoVehiculo() {
		ArrayList<TipoVehiculo> v = null;
		try {
			v= daoTipoVehiculo.Instancia().ListarTipoVehiculo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
}
