package com.fonzo.tfg.rest.pojo;

public class UsuarioRs {

	private String usuario;
	private String mail;
	private Integer comercioId;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getComercioId() {
		return comercioId;
	}

	public void setComercioId(Integer comercioId) {
		this.comercioId = comercioId;
	}
}
