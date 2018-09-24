package com.progra.practica4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.progra.practica4.entities.ShoppingBasket;

public class ShoppingBasketTest {
	ShoppingBasket basket;

	@Before
	public void before() {
		basket = new ShoppingBasket();
	}

	@Test
	public void priceTest() {
		basket.add("milk", 3);
		basket.add("buttermilk", 2);
		basket.add("cheese", 5);
		Assert.assertEquals(10 ,basket.price());
		basket.add("computer",899);
		Assert.assertEquals(909 ,basket.price());
	}
	
	@Test
	public void priceTestIncreaseAmount() {
		basket = new ShoppingBasket();
		basket.add("milk", 3);
		Assert.assertEquals(3 ,basket.price());
		basket.add("buttermilk", 2);
		Assert.assertEquals(5 ,basket.price());
		basket.add("milk", 3);
		Assert.assertEquals(8 ,basket.price());
		basket.add("milk", 3);
		Assert.assertEquals(11 ,basket.price());
	}
}
