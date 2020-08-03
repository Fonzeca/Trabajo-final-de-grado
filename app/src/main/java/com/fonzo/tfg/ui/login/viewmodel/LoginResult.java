package com.fonzo.tfg.ui.login.viewmodel;

import androidx.annotation.Nullable;
import com.fonzo.tfg.data.model.UsuarioView;

public class LoginResult {
    @Nullable
    private UsuarioView success;
    @Nullable
    private Exception error;

    public LoginResult(@Nullable Exception error) {
        this.error = error;
    }

    public LoginResult(@Nullable UsuarioView success) {
        this.success = success;
    }

    @Nullable
    public UsuarioView getSuccess() {
        return success;
    }

    @Nullable
    public Exception getError() {
        return error;
    }
}