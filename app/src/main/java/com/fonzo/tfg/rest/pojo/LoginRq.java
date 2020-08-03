package com.fonzo.tfg.rest.pojo;

public class LoginRq {
	public String usuario;
	public String clave;

	public LoginRq(String usuario, String clave) {
		this.usuario = usuario;
		this.clave = clave;
	}
}