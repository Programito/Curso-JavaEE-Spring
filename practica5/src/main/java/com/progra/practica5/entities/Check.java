package com.progra.practica5.entities;

public class Check extends Payment implements Authorized{
	
	private String name;
	private String bankID;
	private boolean authorized;
	private double saldo;
	
	public Check(double amount, double saldo, String name, String bankID) {
		//super(saldo, amount);
		super(amount);
		this.name = name;
		this.bankID = bankID;
		this.saldo=saldo;
		authorized=false;
	}


	public void authorized() {
		authorized=true;
	}

	

	@Override
	public String toString() {
		return super.toString() + "Check [name=" + name + ", bankID=" + bankID + ", authorized=" + authorized + ", saldo=" + saldo + "]";
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
	

}

