package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.all.TipoVehiculo;
import com.entidades.all.Vehiculo;

public class daoVehiculo {
	
	public static daoVehiculo  _Instancia;
	private daoVehiculo() {}
	public static daoVehiculo Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoVehiculo();
		}
		return _Instancia;
	}
	
	public Boolean CrearVehiculo(Vehiculo vehiculo) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = 
					cn.prepareCall("{call spCrearVehiculo(?,?,?)}");
			cst.setString(1, vehiculo.getNumeroPlaca());
			cst.setInt(2, vehiculo.getTipoVehiculo().getIdTipoVehiculo());
			cst.setFloat(3, vehiculo.getCapacidadKilos());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public ArrayList<Vehiculo> ListarVehiculo(int idTipoVehiculo, String cadena) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarVehiculos(?,?)}");
			cst.setInt(1,idTipoVehiculo);
			cst.setString(2,cadena);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Vehiculo v = new Vehiculo();
				v.setIdVehiculo(rs.getInt("idVehiculo"));
				v.setNumeroPlaca(rs.getString("numeroPlaca"));
				
				TipoVehiculo t = new TipoVehiculo();
				//t.setIdTipoVehiculo(rs.getInt("idTipoVehiculo"));
				t.setDescripcion(rs.getString("descripcionTipoVehiculo"));
				v.setTipoVehiculo(t);
				
				
				v.setCapacidadKilos(rs.getFloat("capacidadKilos"));
				
				lista.add(v);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public Boolean EliminarVehiculo(String idVehiculo) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean elimino = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spEliminarVehiculo(?)}");
			cst.setString(1, idVehiculo);
			int i = cst.executeUpdate();
			if(i>0) {elimino=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return elimino;
	}
	
	public Boolean ModificarVehiculo(Vehiculo vehiculo) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean edito = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spModificarVehiculo(?, ?, ?, ?)}");
			cst.setInt(1, vehiculo.getIdVehiculo());
			cst.setString(2, vehiculo.getNumeroPlaca());
			cst.setInt(3, vehiculo.getTipoVehiculo().getIdTipoVehiculo());
			cst.setFloat(4, vehiculo.getCapacidadKilos());
			int i = cst.executeUpdate();
			if(i>0) {edito=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return edito;
	}
	
}
