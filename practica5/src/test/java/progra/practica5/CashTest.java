package progra.practica5;

import org.junit.Assert;
import org.junit.Test;

import com.progra.practica5.entities.Cash;
import com.progra.practica5.entities.Payment;

public class CashTest {
	
	@Test
	public void getType() {
		Payment cash= new Cash(20.0, "ewrwe");
		Assert.assertTrue(cash instanceof Cash);
	}
	
	@Test
	public void getAndSetCash() {
		Payment cash= new Cash(20.0, "ewrwe");
		Assert.assertEquals(20.0, cash.getAmount(),0.01);
		cash.setAmount(30.0);
		Assert.assertEquals(30.0, cash.getAmount(),0.01);
	}
}
