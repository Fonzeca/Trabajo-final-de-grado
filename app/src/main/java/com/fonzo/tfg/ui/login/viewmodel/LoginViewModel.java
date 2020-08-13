package com.fonzo.tfg.ui.login.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.data.Result;
import com.fonzo.tfg.data.model.UsuarioView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.rest.pojo.UsuarioRs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginEstadoCampos> loginEstadoCampos = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void login(String nombreUsuario, String clave) {
        loginRepository.login(nombreUsuario, clave, loginResult);
    }

    public void verificarToken(){
        loginRepository.validarToken(loginResult);
    }

    /**
     * Se llama cuando los campos de texto cambian
     * @param username
     * @param password
     */
    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginEstadoCampos.setValue(new LoginEstadoCampos(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginEstadoCampos.setValue(new LoginEstadoCampos(null, R.string.invalid_password));
        } else {
            loginEstadoCampos.setValue(new LoginEstadoCampos(true));
        }
    }

    // Logica de nombre de usaurio
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if(username.length() > 15){
            return false;
        }
        return !username.trim().isEmpty();
    }

    // Logica de clave
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() <= 8;
    }

    public LiveData<LoginEstadoCampos> getLoginEstadoCampos() {
        return loginEstadoCampos;
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }
}

