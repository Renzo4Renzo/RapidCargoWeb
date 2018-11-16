package com.dao.all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import com.entidades.all.Cliente;
import com.entidades.all.Encomienda;
import com.entidades.all.EntregaUnica;
import com.entidades.all.EstadoEncomienda;
import com.entidades.all.Persona;
import com.entidades.all.Personal;
import com.entidades.all.Ruta;
import com.entidades.all.Sucursal;
import com.entidades.all.Usuario;


public class daoEncomienda {
	
	public static daoEncomienda _Instancia;
	private daoEncomienda() {}
	public static daoEncomienda Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoEncomienda();
		}
		return _Instancia;
	}
	
	public Boolean RegistrarEncomienda(Encomienda encomienda) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaLlegada = myFormat.format(fromUser.parse(encomienda.getFechaLlegada()));
		try {
			CallableStatement cst = 
					cn.prepareCall("{call spRegistrarEncomienda(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, encomienda.getCliente().getDniCliente());
			cst.setInt(2, encomienda.getRuta().getIdRuta());
			cst.setString(3, fechaLlegada);
			cst.setString(4, encomienda.getNombreDestinatario());
			cst.setString(5, encomienda.getDireccionDestinatario());
			cst.setInt(6,encomienda.getSucursalOrigen().getIdSucursal());
			cst.setInt(7,encomienda.getSucursalDestino().getIdSucursal());
			cst.setString(8,encomienda.getUsuarioCajero().getNombreUsuario());
			cst.setFloat(9,encomienda.getPeso());
			cst.setFloat(10,encomienda.getMontoPago());
			cst.setString(11,encomienda.getDescripcionEncomienda());
			cst.setBoolean(12,encomienda.getaDomicilio());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public Encomienda DevolverEncomienda (String codigoEncomienda) throws Exception {
		Connection cn = Conexion.conectar();
		Encomienda encomienda = null;
		
		try {
			CallableStatement cst = cn.prepareCall("{call spDevolverEncomienda(?)}");
			cst.setString(1, codigoEncomienda);
			ResultSet rs = cst.executeQuery();
			
			if(rs.next()) 
			{
				encomienda= new Encomienda();			
				encomienda.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				encomienda.setCodigoEncomienda(rs.getString("CODIGOENCOMIENDA"));
					
				Cliente c = new Cliente();
					c.setDniCliente(rs.getString("DNI"));
					Persona p = new Persona();
						p.setNombres(rs.getString("NOMBRESCLIENTE"));
						p.setApellidos(rs.getString("APELLIDOSCLIENTE"));
					c.setPersona(p);
				encomienda.setCliente(c);
				
				Ruta ruta = new Ruta();
					ruta.setNombreRuta(rs.getString("NOMBRERUTA"));
				encomienda.setRuta(ruta);
				
				encomienda.setFechaRegistro(rs.getString("FECHAREGISTRO"));
				
				Sucursal sucursalOrigen = new Sucursal();
					sucursalOrigen.setNombreAgencia(rs.getString("AGENCIAORIGEN"));
				encomienda.setSucursalOrigen(sucursalOrigen);
				
				Sucursal sucursalDestino = new Sucursal();
					sucursalDestino.setNombreAgencia(rs.getString("AGENCIADESTINO"));
				encomienda.setSucursalDestino(sucursalDestino);
				
				encomienda.setNombreDestinatario(rs.getString("NOMBREDESTINATARIO"));
				
				EstadoEncomienda estadoEncomienda = new EstadoEncomienda();
					estadoEncomienda.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				encomienda.setEstadoEncomienda(estadoEncomienda);
				
				EntregaUnica entregaUnica = new EntregaUnica();
					entregaUnica.setFechaEntrega(rs.getDate("FECHAENTREGA"));
					Usuario u = new Usuario();
						Personal pe = new Personal();
							Persona pp = new Persona();
								pp.setNombres(rs.getString("NOMBRES"));
								pp.setApellidos(rs.getString("APELLIDOS"));
							pe.setPersona(pp);
						u.setPersonal(pe);
					entregaUnica.setUsuario(u);	  
				encomienda.setEntregaUnica(entregaUnica);
				
			}
		} catch (Exception e) {
			throw e;
		}
		finally {
			cn.close();
		}
		return encomienda;
	}
	
	public ArrayList<Encomienda> ListarEncomiendaGerente(String fechaInicio, String fechaFin) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasGerente (?,?)}");
			cst.setString(1,fechaInicio);
			cst.setString(2,fechaFin);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setCodigoEncomienda(rs.getString("CODIGOENCOMIENDA"));
					Cliente c = new Cliente();
					    Persona p = new Persona();
						p.setDNI(rs.getString("DNI"));
						p.setNombres(rs.getString("NOMBRES"));
						p.setApellidos(rs.getString("APELLIDOS"));
					c.setPersona(p);
				e.setCliente(c);
				
				Ruta r = new Ruta();
				  r.setNombreRuta(rs.getString("NOMBRERUTA"));
				e.setRuta(r);
				
				e.setNombreDestinatario(rs.getString("NOMBREDESTINATARIO"));
				e.setFechaRegistro(rs.getString("FECHAREGISTRO"));
				
			    EntregaUnica eu = new EntregaUnica();
					eu.setFechaEntrega(rs.getDate("FECHAENTREGA"));
				e.setEntregaUnica(eu);

				e.setMontoPago(rs.getFloat("MONTOPAGO"));
				
				EstadoEncomienda ee = new EstadoEncomienda();
					ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Encomienda> ListarEncomiendasSalir(int idSucursalOrigen) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasSalida (?)}");
			cst.setInt(1,idSucursalOrigen);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setPeso(rs.getFloat("PESO"));
				e.setFechaLlegada(rs.getString("FECHALLEGADA"));
				
				Sucursal s = new Sucursal();
				s.setNombreAgencia(rs.getString("NOMBREAGENCIA"));
				e.setSucursalOrigen(s);
					
				EstadoEncomienda ee = new EstadoEncomienda();
				ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Encomienda> ListarEncomiendasEntregaSucursal(int idSucursalOrigen) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasEntregaSucursal (?)}");
			cst.setInt(1,idSucursalOrigen);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setCodigoEncomienda(rs.getString("CODIGOENCOMIENDA"));
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setNombreDestinatario(rs.getString("NOMBREDESTINATARIO"));
				e.setDireccionDestinatario(rs.getString("DIRECCIONDESTINATARIO"));
				e.setFechaLlegada(rs.getString("FECHALLEGADA"));
				
				EstadoEncomienda ee = new EstadoEncomienda();
				ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				Cliente c = new Cliente();
				Persona p = new Persona();
				p.setNombres(rs.getString("NOMBRES"));
				p.setApellidos(rs.getString("APELLIDOS"));
				c.setPersona(p);
				e.setCliente(c);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	
	public ArrayList<Encomienda> ListarEncomiendasEntregaDomicilio(int idSucursalOrigen) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasEntregaDomicilio (?)}");
			cst.setInt(1,idSucursalOrigen);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setNombreDestinatario(rs.getString("NOMBREDESTINATARIO"));
				e.setDireccionDestinatario(rs.getString("DIRECCIONDESTINATARIO"));
				e.setFechaLlegada(rs.getString("FECHALLEGADA"));
				
				EstadoEncomienda ee = new EstadoEncomienda();
				ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Encomienda> ListarEncomiendasTrasladoBus(String nombreConductor) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasTrasladoBus (?)}");
			cst.setString(1,nombreConductor);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setFechaLlegada(rs.getString("FECHALLEGADA"));
				e.setDescripcionEncomienda(rs.getString("DESCRIPCIONENCOMIENDA"));
				
				Ruta r = new Ruta();
					r.setNombreRuta(rs.getString("NOMBRERUTA"));
				e.setRuta(r);
				
				EstadoEncomienda ee = new EstadoEncomienda();
					ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Encomienda> ListarEncomiendasEntregaMinivan(String nombreConductor) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasEntregaMinivan (?)}");
			cst.setString(1,nombreConductor);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setDescripcionEncomienda(rs.getString("DESCRIPCIONENCOMIENDA"));
				e.setNombreDestinatario(rs.getString("NOMBREDESTINATARIO"));
				e.setCodigoEncomienda(rs.getString("CODIGOENCOMIENDA"));
				
				EstadoEncomienda ee = new EstadoEncomienda();
					ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public Boolean TrasladarEncomienda(Encomienda encomienda) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean edito = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spTrasladarEncomienda(?)}");
			cst.setInt(1, encomienda.getIdEncomienda());
			int i = cst.executeUpdate();
			if(i>0) {edito=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return edito;
	}
}
