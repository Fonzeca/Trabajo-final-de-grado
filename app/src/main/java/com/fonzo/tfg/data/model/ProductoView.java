package com.fonzo.tfg.data.model;

import com.fonzo.tfg.rest.pojo.ItemListaProductoRs;

public class ProductoView {
    public int id;
    public String nombre;
    public double precio;
    public int stock;

    public ProductoView(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoView(ItemListaProductoRs item) {
        this.id = item.getId();
        this.nombre = item.getNombre();
        this.precio = item.getPrecio();
        this.stock = item.getStock();
    }
}
