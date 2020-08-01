package com.fonzo.tfg.ui.login;

import androidx.annotation.Nullable;
import com.fonzo.tfg.data.model.LoggedInUser;

public class LoginResult {
    @Nullable
    private LoggedInUser success;
    @Nullable
    private Exception error;

    LoginResult(@Nullable Exception error) {
        this.error = error;
    }

    LoginResult(@Nullable LoggedInUser success) {
        this.success = success;
    }

    @Nullable
    LoggedInUser getSuccess() {
        return success;
    }

    @Nullable
    Exception getError() {
        return error;
    }
}