package com.fonzo.tfg.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.data.Result;
import com.fonzo.tfg.data.model.LoggedInUser;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginEstadoCampos> loginEstadoCampos = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void login(String nombreUsuario, String clave) {
        new Runnable(){
            public void run() {
                //Se logea
                Result<LoggedInUser> result = loginRepository.login(nombreUsuario, clave);

                LoginResult resultLogin = null;

                //En caso de ser exitoso
                if(result instanceof Result.Success){
                    Result.Success<LoggedInUser> resultSucces = (Result.Success<LoggedInUser>) result;

                    //Se crea el LoginResult para la vista
                    resultLogin = new LoginResult(resultSucces.getData());
                }else{
                    Result.Error resultError = (Result.Error) result;

                    //Se crea el LoginResult para la vista
                    resultLogin = new LoginResult(resultError.getError());
                }

                //Se setea el valor del LoginResult
                loginResult.setValue(resultLogin);
            }
        }.run();
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginEstadoCampos.setValue(new LoginEstadoCampos(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginEstadoCampos.setValue(new LoginEstadoCampos(null, R.string.invalid_password));
        } else {
            loginEstadoCampos.setValue(new LoginEstadoCampos(true));
        }
    }

    LiveData<LoginEstadoCampos> getLoginEstadoCampos() {
        return loginEstadoCampos;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    // Logica de nombre de usaurio
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // Logica de clave
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() < 8;
    }
}
