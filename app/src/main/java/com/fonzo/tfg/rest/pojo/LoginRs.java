package com.tesis.principal.api.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "usuario", "token" })
public class LoginRs {

	@JsonProperty("usuario")
	private String usuario;
	@JsonProperty("token")
	private String token;

	@JsonProperty("usuario")
	public String getUsuario() {
		return usuario;
	}

	@JsonProperty("usuario")
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@JsonProperty("token")
	public String getToken() {
		return token;
	}

	@JsonProperty("token")
	public void setToken(String token) {
		this.token = token;
	}

}