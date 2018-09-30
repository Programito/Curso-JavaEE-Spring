package com.progra.practica5.entities;

import java.util.Date;

public class Credit extends Payment implements Authorized {
	
	private int number;
	private String type;
	private Date expDate;
	private boolean authorized;
	private double saldo;
	
	
	public Credit(double amount,double saldo, int number,String type,Date expDate) {
		super(amount);
		this.number=number;
		this.type=type;
		this.expDate=expDate;
		this.saldo=saldo;
		this.authorized=false;
	}

	
	public void authorized() {
		this.authorized=true;
	}


	@Override
	public String toString() {
		return super.toString() + "Credit [number=" + number + ", type=" + type + ", expDate=" + expDate + "]";
	}
	
	public boolean getAuthorized() {
		return authorized;
	}
	
	public void setAuthorized(boolean auth) {
		this.authorized=auth;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}


	public boolean operationStatus() {
		boolean status=false;
		if(super.getAmount()<=saldo) {
			status=true;
		}
		return status;
	}


	public void change() {
		saldo=saldo-super.getAmount();
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getExpDate() {
		return expDate;
	}


	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	
	

}
