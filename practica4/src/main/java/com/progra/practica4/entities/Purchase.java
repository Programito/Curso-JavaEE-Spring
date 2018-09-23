package com.progra.practica4.entities;

import java.util.HashMap;

public class Purchase {
	
	String nom;
	int cantitat,preuUnitari;
	
	
	public Purchase() {
		
	}
	
	public Purchase(String nom, int cantitat, int preuUnitari) {
		this.nom=nom;
		this.cantitat=cantitat;
		this.preuUnitari=preuUnitari;
	}
	
	public int getPreuUnitari() {
		return preuUnitari;
	}
	
	public int getCantitat(String nom) {
		return cantitat;
	}
	
	public void increaseAmount() {
		cantitat++;
	}
	
	public int price() {
		return preuUnitari * cantitat;
	}

	@Override
	public String toString() {
		return nom + ": " + cantitat;
	}
	
	
}
