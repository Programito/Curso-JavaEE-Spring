package com.progra.practica4.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Storehouse {

	// utilizo solo un hasmash para facilitar futuras versiones
	private HashMap<String, PrecioCantidad> hMProduct;

	public Storehouse() {
		hMProduct = new HashMap<String, PrecioCantidad>();
	}

	public void addProduct(String nom, int preu, int cantidad) {
		hMProduct.put(nom, new PrecioCantidad(preu, cantidad));
	}

	public int price(String nom) {
		int preu = -99;
		if (hMProduct.containsKey(nom)) {
			preu = hMProduct.get(nom).getPrecio();
		}
		return preu;
	}

	public int stock(String nom) {
		int quantitat = 0;
		if (hMProduct.containsKey(nom)) {
			quantitat = hMProduct.get(nom).getCantidad();
		}
		return quantitat;
	}
	
	public ArrayList<String> products() {
		ArrayList<String> claves=new ArrayList<String>();
	    Iterator<String> productos = hMProduct.keySet().iterator();
	    while(productos.hasNext()){
	        claves.add(productos.next());
	    }
	    Collections.sort(claves);
	    return claves;
	}

	public boolean take(String nom) {
		boolean agafar = false;
		if (hMProduct.containsKey(nom)) {
			agafar = hMProduct.get(nom).take();
		}
		return agafar;
	}
}
