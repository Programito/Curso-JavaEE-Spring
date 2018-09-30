package com.progra.practica5.entities;

public abstract class Payment {
	
	private double amount;
	//private double saldo;
	
	
	public Payment(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount=amount;
	}
	
	@Override
	public String toString() {
		return "Payment [amount=" + amount + "]";
	}
	
//	public Payment(double saldo,double amount) {
//	this.saldo=saldo;
//	this.amount=amount;
//}

	
//	public double getSaldo() {
//		return saldo;
//	}
//
//	public void setSaldo(double saldo) {
//		this.saldo = saldo;
//	}
//
	
//	public boolean operationStatus(){
//		return saldo >= amount;
//	}
//	
//	public double change() {
//		return saldo - amount;
//	}
	
}
