package com.fonzo.tfg.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TesisRetrofit {
    private static ServidorTesis endPoints;

    public static ServidorTesis obtenerConexion(){
        if(endPoints == null){
            String baseUrl = "http://vps-1791261-x.dattaweb.com:5599/";

            Retrofit retrofit = new Retrofit.Builder().
                                    baseUrl(baseUrl).
                                    addConverterFactory(GsonConverterFactory.create()).
                                    build();

            endPoints = retrofit.create(ServidorTesis.class);
        }
        return endPoints;
    }
}
