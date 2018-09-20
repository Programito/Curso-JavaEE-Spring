package com.progra.practica1.entities;

public class PersonalCustomer extends Customer{
	
	private String creditCard;

	public PersonalCustomer(Long idCustomer, String name, String deliveryAdress, String phone,char creditRating, String creditCard) {
		super(idCustomer, name, deliveryAdress, phone,creditRating);
		this.creditCard=creditCard;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	@Override
	public String toString() {
		return "PersonalCustomer " + super.toString() + "creditCard:" + creditCard +"]";
	}


}
