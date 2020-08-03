package com.fonzo.tfg.data.model;

import com.fonzo.tfg.rest.pojo.LoginRs;

public class UsuarioView {
    public String usuario;

    public UsuarioView(String usuario) {
        this.usuario = usuario;
    }
    public UsuarioView(LoginRs loginRs){
        this.usuario = loginRs.usuario;
    }
}