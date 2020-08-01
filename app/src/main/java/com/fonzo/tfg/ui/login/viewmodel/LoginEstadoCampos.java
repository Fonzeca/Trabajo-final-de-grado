package com.fonzo.tfg.ui.login;

import androidx.annotation.Nullable;

/**
 * Clase que contiene el estado del formulario del login
 */
class LoginEstadoCampos {
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
    Integer getUsuarioError() {
        return usuarioError;
    }

    @Nullable
    Integer getClaveError() {
        return claveError;
    }

    boolean isValido() {
        return isValido;
    }
}