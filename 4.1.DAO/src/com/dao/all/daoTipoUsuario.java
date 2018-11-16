package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.all.TipoUsuario;


public class daoTipoUsuario {
	
	public static daoTipoUsuario  _Instancia;
	private daoTipoUsuario() {}
	public static daoTipoUsuario Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoTipoUsuario();
		}
		return _Instancia;
	}
	
	public ArrayList<TipoUsuario> ListarTipoUsuario() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarTipoUsuario()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				TipoUsuario tu = new TipoUsuario();
				tu.setIdTipoUsuario(rs.getInt("IDTIPOUSUARIO"));
				tu.setDescripcion(rs.getString("DESCRIPCION"));
				
				lista.add(tu);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
}
