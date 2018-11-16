package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;

public class daoEntregaUnica {
	
	public static daoEntregaUnica _Instancia;
	private daoEntregaUnica() {}
	public static daoEntregaUnica Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoEntregaUnica();
		}
		return _Instancia;
	}
	
	public Boolean EntregarEnSucursal(String idEncomienda, String nombreUsuario) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spEntregarEnSucursal(?,?)}");
			cst.setString(1, nombreUsuario);
			cst.setString(2, idEncomienda);
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public Boolean EntregarEnDomicilio(String idEncomienda, String nombreUsuario) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spEntregarEnDomicilio(?,?)}");
			cst.setString(1, nombreUsuario);
			cst.setString(2, idEncomienda);
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
}
