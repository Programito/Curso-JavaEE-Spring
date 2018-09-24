package com.progra.practica4.entities;

import java.util.HashMap;
import java.util.Scanner;

public class Shop_v2 {

	private Storehouse store;
	private Scanner reader;
	// clau es el nom del client
	private HashMap<String, Customer> hMCustomer;

	public Shop_v2(Storehouse store, Scanner reader) {
		this.store = store;
		this.reader = reader;
		hMCustomer = new HashMap<String, Customer>();
	}

	public void manage(String customer) {

		System.out.println("welcome to our shop " + customer);

		Customer cust;
		ShoppingBasket basket;
		while (true) {
			System.out.println("--------------------------------------------------------------------------------------");
			if (!hMCustomer.containsKey(customer)) {
				cust = new Customer(customer);
				hMCustomer.put(customer, cust);
				System.out.println("Enter new Shopping card code");
			} else {
				cust = hMCustomer.get(customer);
				mostrarOpciones(customer, cust);
			}
			String id = reader.nextLine();
			System.out.println("Customer: " + customer);
			System.out.println("Code: " + id);

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
					cust.add(id, product,store.price(product));
					// basket.add(product, store.price(product));
				} else if ((store.stock(product) == 0)) {
					System.out.println("We have 0 of " + product + " in stock");
				} else {
					System.out.println("We don't have this " + product + " in stock");
				}
			}

			System.out.println("your purchase are:");
			System.out.println("Current:");
			cust.print(id);
			System.out.println("basket price: " + cust.price(id));
			System.out.println("Global:");
			cust.printAll();
			System.out.println("basket price: " + cust.priceAll());
		}

	}

	public void mostrarOpciones(String nom, Customer cust) {
		System.out.println("You can choose a previous store or put the name of a new one");
		for (String ids : cust.idShoppingBasket()) {
			System.out.println(ids);
		}
	}

}
