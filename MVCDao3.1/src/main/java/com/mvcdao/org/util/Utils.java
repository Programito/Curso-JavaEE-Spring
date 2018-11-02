package com.mvcdao.org.util;

import java.util.List;

import com.mvcdao.org.models.Item;
import com.mvcdao.org.models.Product;

public class Utils {
	
	public static String hola() {
		return "hola";
	}
	public static double sum(List<Item> items) {
		double total=0;
		if(items!=null) {
			for(Item item:items) {
				total+=item.getQuantity() * item.getProduct().getPrice();
			}
		}
		return total;
	}
}
