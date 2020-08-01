package com.fonzo.tfg.data.model;

public class LoggedInUser {
    public String usuario;
    public String token;

    public LoggedInUser(String usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }
}