package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.all.Tmp;

public class daoTmp {
	public static daoTmp  _Instancia;
	private daoTmp() {}
	public static daoTmp Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoTmp();
		}
		return _Instancia;
	}
	
	public ArrayList<Tmp> ListarRutasPorEncomienda() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Tmp> lista = new ArrayList<Tmp>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarRutasPorEncomienda()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Tmp t = new Tmp();
				t.setNombreRuta(rs.getString("NOMBRERUTA"));
				t.setCantidad(rs.getInt("CANTIDAD"));
				lista.add(t);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
}
