package com.progra.practica4.entities;

import java.util.Scanner;

public class Shop {
	private Storehouse store;
	private Scanner reader;

	public Shop(Storehouse store, Scanner reader) {
		this.store = store;
		this.reader = reader;
	}

	public void manage(String customer) {
		ShoppingBasket basket = new ShoppingBasket();
		System.out.println("welcome to our shop " + customer);
		System.out.println("below is our sale offer:");
		for (String product : store.products()) {
			System.out.println(product);
		}

		while (true) {
			System.out.println("what do you want to buy (press enter to pay):");
			String product = reader.nextLine();
			if (product.isEmpty()) {
				break;
			}
			if (store.stock(product) > 0) {
				store.take(product);
				basket.add(product, store.price(product));
			} else if ((store.stock(product) == 0)) {
				System.out.println("We have 0 of " + product + " in stock");
			} else {
				System.out.println("We don't have this " + product + " in stock");
			}
		}

		System.out.println("your purchase are:");
		basket.print();
		System.out.println("basket price: " + basket.price());

	}
}
