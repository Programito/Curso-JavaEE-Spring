package com.progra.practica1.entities;

public class CorporateCustomer extends Customer{
	
	private String contact;
	//private char creditRating;
	private int creditLimit;


	public CorporateCustomer(Long idCustomer, String name, String deliveryAdress, String phone, String contact, char creditRating, int creditLimit) {
		super(idCustomer, name, deliveryAdress, phone,creditRating);
		this.contact=contact;
		//this.creditRating=creditRating;
		this.creditLimit=creditLimit;
	}


	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	
	@Override
	public String toString() {
		return "CorporateCustomer " + super.toString() + "contact=" + contact + ", creditLimit=" + creditLimit + "]";
	}


	// toString
	public void remind() {
		
	}

}
