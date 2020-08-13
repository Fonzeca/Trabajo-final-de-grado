package com.fonzo.tfg.data;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;

import com.fonzo.tfg.data.model.UsuarioView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.rest.pojo.LoginRq;
import com.fonzo.tfg.rest.pojo.LoginRs;
import com.fonzo.tfg.rest.pojo.UsuarioRs;
import com.fonzo.tfg.ui.login.viewmodel.LoginResult;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private static volatile LoginRepository instance;

    private UsuarioView user = null;
    private Context context;

    // Contructor privado para el singleton
    private LoginRepository(Context context) {
        this.context = context;
    }

    public static LoginRepository getInstance(Context context) {
        if (instance == null) {
            instance = new LoginRepository(context);
        }
        return instance;
    }

    public String obtenerToken() {
        SharedPreferences preferences = context.getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String token = preferences.getString("token", null);
        return token;
    }

    public void logout() {
        SharedPreferences preferences = context.getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        preferences.edit().putString("token", null).apply();
        user = null;
    }

    /**
     * Loguea el usuario y guarda su token en Shared.
     * @param username
     * @param password
     * @return Un Result Success o Error, si es Success tiene un UsuarioView
     */
    public void login(String username, String password, MutableLiveData<LoginResult> resultMutableLiveData) {
        //TODO: documentar
        ServidorTesis servidor = TesisRetrofit.obtenerConexion();
        Call<LoginRs> loginCall = servidor.login(new LoginRq(username, password));

        loginCall.enqueue(new Callback<LoginRs>() {
            public void onResponse(Call<LoginRs> call, Response<LoginRs> response) {
                if(response.isSuccessful()){
                    LoginRs bodyResponse = response.body();
                    user = new UsuarioView(bodyResponse);

                    //Guarda token
                    {
                        SharedPreferences preferences = context.getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                        preferences.edit().putString("token", bodyResponse.token).apply();
                    }
                }else{
                    resultMutableLiveData.postValue(new LoginResult(false, "Usuario y/o clave invalidos."));
                }
            }
            public void onFailure(Call<LoginRs> call, Throwable t) {
                resultMutableLiveData.postValue(new LoginResult(false, t.getMessage()));
            }
        });
    }

    public void validarToken(MutableLiveData<LoginResult> resultMutableLiveData){
        String token = obtenerToken();

        if(token != null && !token.isEmpty()){
            ServidorTesis servidor = TesisRetrofit.obtenerConexion();
            Call<UsuarioRs> call = servidor.validarToken(token);
            call.enqueue(new Callback<UsuarioRs>() {
                public void onResponse(Call<UsuarioRs> call, Response<UsuarioRs> response) {
                    if(response.isSuccessful()){
                        user = new UsuarioView(response.body());
                        resultMutableLiveData.postValue(new LoginResult(true, "Login exitoso."));
                    }else {
                        logout();
                        resultMutableLiveData.postValue(new LoginResult(false, "Login fallido."));
                    }

                }
                public void onFailure(Call<UsuarioRs> call, Throwable t) {
                    resultMutableLiveData.postValue(new LoginResult(false, "Error de conexion."));
                }
            });
        }

        //No token
        resultMutableLiveData.postValue(new LoginResult(false, ""));
    }

    public UsuarioView getUser() {
        return user;
    }
}