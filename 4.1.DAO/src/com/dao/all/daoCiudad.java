package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.all.Ciudad;

public class daoCiudad {
	
	public static daoCiudad _Instancia;
	private daoCiudad() {}
	public static daoCiudad Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoCiudad();
		}
		return _Instancia;
	}
	
	public ArrayList<Ciudad> ListarCiudad() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Ciudad> lista = new ArrayList<Ciudad>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarCiudad()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Ciudad c = new Ciudad();
				c.setIdCiudad(rs.getInt("IDCIUDAD"));
				c.setNombreCiudad(rs.getString("NOMBRECIUDAD"));
				
				lista.add(c);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
}
