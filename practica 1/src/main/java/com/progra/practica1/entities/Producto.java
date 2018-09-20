package com.progra.practica1.entities;



public class Producto {

	private Long idProduct;

	private String name;

	private Float price;

	private String remarks;
	
	
	
	public Producto(Long idProduct, String name, Float price, String remarks) {
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.remarks = remarks;
	}
	
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Producto [idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", remarks=" + remarks
				+ "]";
	}
	
	
	
}
