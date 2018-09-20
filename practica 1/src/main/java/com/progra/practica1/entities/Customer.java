package com.progra.practica1.entities;

import java.util.ArrayList;

public abstract class Customer {
	
	
	private Long idCustomer;
	private String name;
	private String deliveryAdress;
	private String phone;
	private char creditRating;
	
	private ArrayList<Order> arrOrder;
	


	
	public Customer(Long idCustomer, String name, String deliveryAdress, String phone, char creditRating) {
		this.idCustomer = idCustomer;
		this.name = name;
		this.deliveryAdress = deliveryAdress;
		this.phone = phone;
		this.creditRating=creditRating;
		this.arrOrder=new ArrayList<Order>();
	}
	
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeliveryAdress() {
		return deliveryAdress;
	}
	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(char creditRating) {
		this.creditRating = creditRating;
	}
	

	public ArrayList<Order> getArrOrder() {
		return arrOrder;
	}

	public void setArrOrder(ArrayList<Order> arrOrder) {
		this.arrOrder = arrOrder;
	}

	@Override
	public String toString() {
		
		String arrOrderText= "";
		for(int i=0; i<arrOrder.size();i++) {
			arrOrderText +="\n{pos Order " + i + ": " + arrOrder.get(i).toString() + "}";
		}
		
		
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", deliveryAdress=" + deliveryAdress
				+ ", phone=" + phone + ", creditRating=" + creditRating + " Order:" + arrOrderText  + "]";
	}
	
	
	// Afegir Order
	public void addOrder(Order order) {
		arrOrder.add(order);
	}
	

	
}