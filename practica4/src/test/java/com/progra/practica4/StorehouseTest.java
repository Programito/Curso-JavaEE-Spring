package com.progra.practica4;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.progra.practica4.entities.Storehouse;

public class StorehouseTest {
	
	Storehouse store;
	
	@Before
	public void before(){
		store = new Storehouse();
	}
	
	@Test
	public void priceTest() {
		store.addProduct("milk", 3, 10);
		store.addProduct("coffee", 5, 7);
		Assert.assertEquals(3 ,store.price("milk"));
		Assert.assertEquals(5 ,store.price("coffee")); 
		Assert.assertEquals(-99 ,store.price("sugar")); 
	}
	
	@Test
	public void stockTest() {
//		Storehouse store;
//		store = new Storehouse();
		store.addProduct("coffee", 5, 1);
		Assert.assertEquals(1 ,store.stock("coffee"));
		Assert.assertEquals(0 ,store.stock("sugar"));
	}
	
	@Test
	public void takeTest() {
//		Storehouse store;
//		store = new Storehouse();
		store.addProduct("coffee", 5, 1);
		Assert.assertTrue(store.take("coffee"));
		Assert.assertTrue(!store.take("coffee"));
		Assert.assertTrue(!store.take("sugar"));
		Assert.assertEquals(0 ,store.stock("coffee"));
		Assert.assertEquals(0 ,store.stock("sugar"));	
	}
    
	@Test
	public void productsTest() {
		store.addProduct("milk", 3, 10);
		store.addProduct("coffee", 5, 6);
		store.addProduct("buttermilk", 2, 20);
		store.addProduct("jogurt", 2, 20);
		
		ArrayList<String> productos=new ArrayList<String>();
		productos.add("milk");
		productos.add("coffee");
		productos.add("buttermilk");
		productos.add("jogurt");

		Collections.sort(productos);
	
		Assert.assertArrayEquals(productos.toArray(), store.products().toArray());
	}
	
	
}
