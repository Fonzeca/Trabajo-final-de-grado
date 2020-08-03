package com.fonzo.tfg.rest;

import com.fonzo.tfg.rest.pojo.ListaComerciosRs;
import com.fonzo.tfg.rest.pojo.ListaProductoRs;
import com.fonzo.tfg.rest.pojo.LoginRq;
import com.fonzo.tfg.rest.pojo.LoginRs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServidorTesis {
    @POST("login")
    Call<LoginRs> login(@Body LoginRq loginRq);

    @GET("validate")
    Call<Boolean> validarToken(@Query("token") String token);

    @GET("comercio")
    Call<ListaComerciosRs> obtenerComercios(@Query("token") String token,
                                            @Query("ciudadId") int ciudadId);

    @GET("producto")
    Call<ListaProductoRs> obtenerProductos(@Query("token") String token,
                                           @Query("comercioId") int comercioId);

}
