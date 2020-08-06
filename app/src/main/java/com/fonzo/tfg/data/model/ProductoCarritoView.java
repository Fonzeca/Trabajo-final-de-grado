package com.fonzo.tfg.data.model;

import com.fonzo.tfg.rest.pojo.ItemProductosxCarrito;

public class ProductoCarritoView extends ProductoView{
	public int id;
	public int cantidad;

	public ProductoCarritoView(ItemProductosxCarrito resposneItem) {
		super(resposneItem);
		id = resposneItem.getId();
		cantidad = resposneItem.getCantidad();
	}
}
