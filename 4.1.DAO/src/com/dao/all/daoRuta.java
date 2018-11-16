package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.all.Ciudad;
import com.entidades.all.Ruta;

public class daoRuta {

	public static daoRuta  _Instancia;
	private daoRuta() {}
	public static daoRuta Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoRuta();
		}
		return _Instancia;
	}
	
	public Boolean CrearRuta(Ruta ruta) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = 
					cn.prepareCall("{call spCrearRuta(?,?,?,?)}");
			cst.setString(1, ruta.getNombreRuta());
			cst.setInt(2, ruta.getCiudadOrigen().getIdCiudad());
			cst.setInt(3, ruta.getCiudadDestino().getIdCiudad());
			cst.setString(4, ruta.getDescripcionRuta());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public ArrayList<Ruta> ListarRutasGerente(String cadena) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Ruta> lista = new ArrayList<Ruta>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarRutasGerente(?)}");
			cst.setString(1,cadena);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Ruta r = new Ruta();
				r.setIdRuta(rs.getInt("idRuta"));
				r.setNombreRuta(rs.getString("nombreRuta"));
				
				Ciudad ciudadOrigen = new Ciudad();
				ciudadOrigen.setIdCiudad(rs.getInt("IDCIUDADORIGEN"));
				ciudadOrigen.setNombreCiudad(rs.getString("NOMBRECIUDADORIGEN"));
				r.setCiudadOrigen(ciudadOrigen);
				
				Ciudad ciudadDestino = new Ciudad();
				ciudadDestino.setIdCiudad(rs.getInt("IDCIUDADDESTINO"));
				ciudadDestino.setNombreCiudad(rs.getString("NOMBRECIUDADDESTINO"));
				r.setCiudadDestino(ciudadDestino);
				
				r.setDescripcionRuta(rs.getString("DESCRIPCIONRUTA"));
				
				lista.add(r);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Ruta> ListarRutasCajero(String idCiudad) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Ruta> lista = new ArrayList<Ruta>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarRutasCajero(?)}");
			cst.setString(1,idCiudad);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Ruta r = new Ruta();
				r.setIdRuta(rs.getInt("idRuta"));
				r.setNombreRuta(rs.getString("nombreRuta"));
				lista.add(r);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public Boolean EliminarRuta(String idRuta) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean elimino = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spEliminarRuta(?)}");
			cst.setString(1, idRuta);
			int i = cst.executeUpdate();
			if(i>0) {elimino=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return elimino;
	}
}
