package com.progra.practica4.entities;

import java.util.HashMap;
import java.util.Iterator;

public class ShoppingBasket {
	private HashMap<String, Purchase> hMPurchase;

	public ShoppingBasket() {
		hMPurchase = new HashMap<String, Purchase>();
	}

	public void add(String nom, int preu) {
		if (hMPurchase.containsKey(nom)) {
			hMPurchase.get(nom).increaseAmount();
		} else {
			Purchase purchase = new Purchase(nom, 1, preu);
			hMPurchase.put(nom, purchase);
		}
	}

	public int price() {
		int total = 0;
		Iterator<String> compras = hMPurchase.keySet().iterator();
		while (compras.hasNext()) {
			total += hMPurchase.get(compras.next()).price();
		}
		return total;
	}

	public void print() {
		String texto="";
		Iterator<String> compras = hMPurchase.keySet().iterator();
		while (compras.hasNext()) {
			texto += hMPurchase.get(compras.next()).toString();
			if(compras.hasNext()) {
				texto+="\n";
			}
		}
		System.out.println(texto);
	}
	
	public int getPreuUnitari(String nom) {
		return hMPurchase.get(nom).getPreuUnitari();
	}
}
