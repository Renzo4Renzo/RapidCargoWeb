package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.entidades.all.Cliente;
import com.entidades.all.Persona;



public class daoCliente {
	
	public static daoCliente _Instancia;
	private daoCliente() {}
	public static daoCliente Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoCliente();
		}
		return _Instancia;
	}
	
	public Boolean CrearCliente(Cliente cliente) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = 
					cn.prepareCall("{call spCrearCliente(?,?,?,?,?,?,?)}");
			cst.setString(1, cliente.getDniCliente());
			cst.setString(2, cliente.getPersona().getNombres());
			cst.setString(3, cliente.getPersona().getApellidos());
			cst.setString(4, cliente.getPersona().getDireccion());
			cst.setString(5, cliente.getPersona().getTelefono());
			cst.setString(6, cliente.getCorreoElectronico());
			cst.setString(7, cliente.getPersona().getGenero());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public Cliente DevolverCliente (String dni) throws Exception {
		Connection cn = Conexion.conectar();
		Cliente c = null;
		
		try {
			CallableStatement cst = cn.prepareCall("{call spDevolverCliente(?)}");
			cst.setString(1, dni);
			ResultSet rs = cst.executeQuery();
			
			if(rs.next()) {
				c= new Cliente();			
				Persona p = new Persona();
				p.setNombres(rs.getString("NOMBRES"));
				p.setApellidos(rs.getString("APELLIDOS"));
				p.setDireccion(rs.getString("DIRECCION"));
				p.setTelefono(rs.getString("TELEFONO"));
				p.setGenero(rs.getString("GENERO"));
				c.setCorreoElectronico(rs.getString("CORREOELECTRONICO"));
				c.setDniCliente(rs.getString("DNI"));
				p.setDNI(rs.getString("DNI"));
				c.setPersona(p);
			}
		} catch (Exception e) {
			throw e;
		}
		finally {
			cn.close();
		}
		return c;
	}
	
	public Boolean ValidarDniCliente (String dni) throws Exception {
		Connection cn = Conexion.conectar();
		Cliente c = null;
		try {
			CallableStatement cst = cn.prepareCall("{call spValidarDniCliente(?)}");
			cst.setString(1, dni);
			ResultSet rs = cst.executeQuery();
			
			if(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setDniCliente(rs.getString("DNI"));
				c = cliente;
			}
			
		} catch (Exception e) {
			throw e;
		}
		finally {
			cn.close();
		}
		if(c == null)
			return false;
		else
			return true;
	}

	
	
}
