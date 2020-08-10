package com.fonzo.tfg.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.fonzo.tfg.data.model.UsuarioView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.rest.pojo.LoginRq;
import com.fonzo.tfg.rest.pojo.LoginRs;

import java.io.IOException;

import retrofit2.Call;
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
    public Result<UsuarioView> login(String username, String password) {
        try {
            ServidorTesis servidor = TesisRetrofit.obtenerConexion();
            Call<LoginRs> loginCall = servidor.login(new LoginRq(username, password));

            Response<LoginRs> response = loginCall.execute();

            if(response.isSuccessful()){
                LoginRs bodyResponse = response.body();
                user = new UsuarioView(bodyResponse);

                //Guarda token
                {
                    SharedPreferences preferences = context.getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                    preferences.edit().putString("token", bodyResponse.token).apply();
                }
            }else{
                return new Result.Error(new IOException("Usuario y/o clave incorrectas."));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
        return new Result.Success<UsuarioView>(user);
    }

    public UsuarioView getUser() {
        return user;
    }
}