package com.tesis.principal.api.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "usuario", "clave" })
public class LoginRq {

	@JsonProperty("usuario")
	private String usuario;
	@JsonProperty("clave")
	private String clave;

	@JsonProperty("usuario")
	public String getUsuario() {
		return usuario;
	}

	@JsonProperty("usuario")
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@JsonProperty("clave")
	public String getClave() {
		return clave;
	}

	@JsonProperty("clave")
	public void setClave(String clave) {
		this.clave = clave;
	}

}