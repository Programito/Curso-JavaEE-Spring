package com.progra.practica4.entities;

public class PrecioCantidad {
	private int precio;
	private int cantidad;
	
	public PrecioCantidad(int precio, int cantidad) {
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public boolean take() {
		boolean agafar=false;
		if(cantidad>0) {
			cantidad--;
			agafar=true;
		}
		return agafar;
	}
	
}
