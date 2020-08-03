package com.fonzo.tfg.ui.login.viewmodel;

import androidx.annotation.Nullable;

/**
 * Clase que contiene el estado del formulario del login
 */
public class LoginEstadoCampos {
    @Nullable
    private Integer usuarioError;
    @Nullable
    private Integer claveError;

    private boolean isValido;
    LoginEstadoCampos(@Nullable Integer usuarioError, @Nullable Integer claveError) {
        this.usuarioError = usuarioError;
        this.claveError = claveError;
        this.isValido = false;
    }
    LoginEstadoCampos(boolean isValido) {
        this.usuarioError = null;
        this.claveError = null;
        this.isValido = isValido;
    }

    @Nullable
    public Integer getUsuarioError() {
        return usuarioError;
    }

    @Nullable
    public Integer getClaveError() {
        return claveError;
    }

    public boolean isValido() {
        return isValido;
    }
}