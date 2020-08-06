package com.fonzo.tfg.data.model;

import com.fonzo.tfg.rest.pojo.ItemListaProductoRs;
import com.fonzo.tfg.rest.pojo.ItemProductosxCarrito;

public class ProductoView {
    public int idProducto;
    public String nombre;
    public double precio;
    public int stock;

    public ProductoView(int id, String nombre, double precio, int stock) {
        this.idProducto = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoView(ItemListaProductoRs item) {
        this.idProducto = item.getId();
        this.nombre = item.getNombre();
        this.precio = item.getPrecio();
        this.stock = item.getStock();
    }

    protected ProductoView(ItemProductosxCarrito responseItemCarrito) {
        idProducto = responseItemCarrito.getIdProducto();
        nombre = responseItemCarrito.getNombre();
        precio = responseItemCarrito.getPrecioUnitario();
        stock = -1;
    }
}
