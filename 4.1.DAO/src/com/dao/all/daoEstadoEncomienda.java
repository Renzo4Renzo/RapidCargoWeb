package com.dao.all;

public class daoEstadoEncomienda {
	
	public static daoEstadoEncomienda _Instancia;
	private daoEstadoEncomienda() {}
	public static daoEstadoEncomienda Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoEstadoEncomienda();
		}
		return _Instancia;
	}
}
