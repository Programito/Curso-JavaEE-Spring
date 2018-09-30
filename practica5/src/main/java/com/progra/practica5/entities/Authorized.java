package com.progra.practica5.entities;

public interface Authorized {
	boolean getAuthorized();
	void setAuthorized(boolean auth);
	double getSaldo();
	void setSaldo(double saldo);
	boolean operationStatus();
	void change();
	void authorized(); 
}
