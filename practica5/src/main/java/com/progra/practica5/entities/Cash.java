package com.progra.practica5.entities;

public class Cash extends Payment {
	
	private String cashTendered;

	

	public Cash( double amount, String cashTendered) {
		//super(saldo, amount);
		super(amount);
		this.cashTendered = cashTendered;

	}


	@Override
	public String toString() {
		return  super.toString() + "Cash [cashTendered=" + cashTendered + "]";
	}
}
