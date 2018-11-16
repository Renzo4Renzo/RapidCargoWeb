package pojo;

import java.sql.Date;

public class EntregaUnica {
	private Encomienda encomienda;
	private Usuario usuario;
	private Date fechaEntrega;
	public Encomienda getEncomienda() {
		return encomienda;
	}
	public void setEncomienda(Encomienda encomienda) {
		this.encomienda = encomienda;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
}
