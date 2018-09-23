package com.progra.practica4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.progra.practica4.entities.Purchase;
import com.progra.practica4.entities.Storehouse;

public class PurchaseTest {
	Purchase purchase;
	
	@Before
	public void before(){
		purchase= new Purchase("milk",4,2);
	}
	
	@Test
	public void priceTest() {
		Assert.assertEquals(8 ,purchase.price());
	}
	
	@Test
	public void toStringTest() {
		Assert.assertEquals("milk: 4" ,purchase.toString());
	}
	
	@Test
	public void increaseAmountTest() {
		Assert.assertEquals("milk: 4" ,purchase.toString());
		purchase.increaseAmount();
		Assert.assertEquals("milk: 5" ,purchase.toString());
	}
}
