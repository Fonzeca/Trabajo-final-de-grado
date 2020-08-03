package com.fonzo.tfg.data.model;

import com.fonzo.tfg.rest.pojo.ComercioRs;

import java.io.Serializable;

public class ComercioView implements Serializable {
    public final int id;
    public final String nombre;
    public final String direccion;

    public ComercioView(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public ComercioView(ComercioRs response) {
        this.id = response.id;
        this.nombre = response.nombre;
        this.direccion = response.direccion;
    }

}
