
package com.fonzo.tfg.rest.pojo;

import java.util.List;

public class CarritoRs {

    private int id;
    private int usuarioId;
    private String fechaCompra;
    private String fechaExpiracion;
    private String pedidoDomicilio;
    private double total;
    private int comercioId;
    private List<ItemProductosxCarrito> productosxCarrito = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getPedidoDomicilio() {
        return pedidoDomicilio;
    }

    public void setPedidoDomicilio(String pedidoDomicilio) {
        this.pedidoDomicilio = pedidoDomicilio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getComercioId() {
        return comercioId;
    }

    public void setComercioId(int comercioId) {
        this.comercioId = comercioId;
    }

    public List<ItemProductosxCarrito> getProductosxCarrito() {
        return productosxCarrito;
    }

    public void setProductosxCarrito(List<ItemProductosxCarrito> productosxCarrito) {
        this.productosxCarrito = productosxCarrito;
    }

}
