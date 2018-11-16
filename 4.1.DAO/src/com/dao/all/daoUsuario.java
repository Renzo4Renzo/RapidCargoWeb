package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.entidades.all.Ciudad;
import com.entidades.all.Personal;
import com.entidades.all.Sucursal;
import com.entidades.all.TipoUsuario;
import com.entidades.all.Usuario;

public class daoUsuario {
	
	public static daoUsuario  _Instancia;
	private daoUsuario() {}
	public static daoUsuario Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoUsuario();
		}
		return _Instancia;
	}
	
	public Usuario VerificarAcceso (String nombreUsuario,String contrasena) throws Exception {
		Connection cn = Conexion.conectar();
		Usuario u = null;
		
		try {
			CallableStatement cst = cn.prepareCall("{call spVerificarAcceso(?,?)}");
			cst.setString(1, nombreUsuario);
			cst.setString(2, contrasena);
			ResultSet rs = cst.executeQuery();
			
			if(rs.next()) {
				u= new Usuario();			
				u.setNombreUsuario(rs.getString("NOMBREUSUARIO"));
				u.setContrasena(rs.getString("CONTRASENA"));
				TipoUsuario tu = new TipoUsuario();
				  tu.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				u.setTipoUsuario(tu);
				
				Personal p = new Personal();
				  p.setIdPersonal(rs.getInt("idPersonal"));
				u.setPersonal(p);
				
				Sucursal s = new Sucursal();
				  s.setIdSucursal(rs.getInt("idSucursal"));
				  s.setNombreAgencia(rs.getString("nombreAgencia"));
				  
				Ciudad c = new Ciudad();
				c.setIdCiudad(rs.getInt("idCiudad"));
				
				s.setCiudadSucursal(c);
				
				u.setSucursal(s);
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		finally {
			cn.close();
		}
		return u;
	}

	
	
}
