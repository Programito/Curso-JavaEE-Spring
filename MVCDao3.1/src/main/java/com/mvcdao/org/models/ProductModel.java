package com.mvcdao.org.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

	private List<Product> products;

	public ProductModel() {
		this.products = new ArrayList<Product>();
		this.products.add(new Product("P001-HJ", "Laptop ASUS 15 8GB", 256, 2, true));
		this.products.add(new Product("P002-OP", "RJ45 Categoria6 12m", 32.3, 5, true));
		this.products.add(new Product("P003-QE", "Tablet Samsung Android", 50.8, 8, false));
	}

	public List<Product> findAll() {
		return this.products;
	}

	public Product find(String id) {
		for (Product product : this.products) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}
	

}