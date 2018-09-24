package com.progra.practica4;

import java.util.Scanner;

import com.progra.practica4.entities.Shop;
import com.progra.practica4.entities.Shop_v2;
import com.progra.practica4.entities.Storehouse;

public class Main {

	public static void main(String[] args) {
		Storehouse store = new Storehouse();
		store.addProduct("coffee", 5, 10);
		store.addProduct("milk", 3, 20);
		store.addProduct("milkbutter", 2, 55);
		store.addProduct("bread",7, 8);
		
		Shop_v2 shop= new Shop_v2(store,new Scanner(System.in));
		shop.manage("Pekka");

	}

}
