package com.progra.practica4.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Customer {
	private HashMap<String, ShoppingBasket> hMShoppingBasket;
	private String nom;

	public Customer(String nom) {
		this.hMShoppingBasket = new HashMap<String, ShoppingBasket>();
		this.nom = nom;
	}

	public void add(String idStoreHouse, String product, int preu) {
		if(hMShoppingBasket.containsKey(idStoreHouse)) {
			hMShoppingBasket.get(idStoreHouse).add(product, preu);
		}
		else {
			ShoppingBasket basket= new ShoppingBasket();
			hMShoppingBasket.put(idStoreHouse, basket);
			hMShoppingBasket.get(idStoreHouse).add(product, preu);
		}
		
		
	}

	public int price(String idShoppingBasket) {
		System.out.println("-Price of the Code " + idShoppingBasket + ": " + hMShoppingBasket.get(idShoppingBasket).price());
		return hMShoppingBasket.get(idShoppingBasket).price();
	}

	public String getNom() {
		return nom;
	}

	public ArrayList<String> idShoppingBasket() {
		ArrayList<String> claves = new ArrayList<String>();
		Iterator<String> ids = hMShoppingBasket.keySet().iterator();
		while (ids.hasNext()) {
			claves.add(ids.next());
		}
		Collections.sort(claves);
		return claves;
	}

	public HashMap<String, ShoppingBasket> getBasket() {
		return hMShoppingBasket;
	}

	public void print(String idShoppingBasket) {
		System.out.println("-List of the Code " + idShoppingBasket + ":");
		hMShoppingBasket.get(idShoppingBasket).print();
	}

	public void printAll() {
		Iterator<String> ids = hMShoppingBasket.keySet().iterator();
		while (ids.hasNext()) {
			print(ids.next());
		}
	}

	public int priceAll() {
		int total=0;
		Iterator<String> ids = hMShoppingBasket.keySet().iterator();
		while (ids.hasNext()) {
			total+= price(ids.next());
		}
		return total;
	}

}
