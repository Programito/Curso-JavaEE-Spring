package com.progra.practica1.entities;

import java.util.ArrayList;

public class OrderLine {

	private Long idOrderLine;
	private ProductoCantidad productoCantidad;
	
	

	public OrderLine(Long idOrderLine, Producto product, int cantidad) {
		this.idOrderLine = idOrderLine;
		productoCantidad= new ProductoCantidad(product, cantidad);
	}

	public Long getIdOrderLine() {
		return idOrderLine;
	}

	public void setIdOrderLine(Long idOrderLine) {
		this.idOrderLine = idOrderLine;
	}

	public ProductoCantidad getProductoCantidad() {
		return productoCantidad;
	}

	public void setProductoCantidad(ProductoCantidad productoCantidad) {
		this.productoCantidad = productoCantidad;
	}

	
	public void incrementarCantidad() {
		productoCantidad.incrementar();
	}

	@Override
	public String toString() {
		return "OrderLine [idOrderLine=" + idOrderLine + "," + productoCantidad.toString() +  "]";
	}
	
	
	

}
