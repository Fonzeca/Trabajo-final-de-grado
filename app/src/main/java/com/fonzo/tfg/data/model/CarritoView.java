package com.fonzo.tfg.data.model;

import com.fonzo.tfg.rest.pojo.CarritoRs;

public class CarritoView {

	public int id;
	public String direccion;
	public double total;

	public CarritoView() {
	}

	public CarritoView(CarritoRs response) {
		direccion = response.getPedidoDomicilio();
		total = response.getTotal();
		id = response.getId();
	}
}
