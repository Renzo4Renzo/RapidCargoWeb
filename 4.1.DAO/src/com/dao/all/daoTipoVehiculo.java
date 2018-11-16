package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.entidades.all.TipoVehiculo;


public class daoTipoVehiculo {
	
	public static daoTipoVehiculo  _Instancia;
	private daoTipoVehiculo() {}
	public static daoTipoVehiculo Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoTipoVehiculo();
		}
		return _Instancia;
	}
	
	public ArrayList<TipoVehiculo> ListarTipoVehiculo() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<TipoVehiculo> lista = new ArrayList<TipoVehiculo>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarTipoVehiculo()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				TipoVehiculo tv = new TipoVehiculo();
				tv.setIdTipoVehiculo(rs.getInt("IDTIPOVEHICULO"));
				tv.setDescripcion(rs.getString("DESCRIPCIONTIPOVEHICULO"));
				
				
				lista.add(tv);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
}
