package com.fonzo.tfg.ui.login.viewmodel;

import androidx.annotation.Nullable;
import com.fonzo.tfg.data.model.UsuarioView;

public class LoginResult {
    @Nullable
    private boolean success;
    @Nullable
    private String mensaje;

    public LoginResult(boolean success, String mensaje) {
        this.mensaje = mensaje;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    @Nullable
    public String getMensaje() {
        return mensaje;
    }
}