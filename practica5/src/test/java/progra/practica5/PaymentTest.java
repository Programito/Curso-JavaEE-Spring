package progra.practica5;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.progra.practica5.entities.Cash;
import com.progra.practica5.entities.Check;
import com.progra.practica5.entities.Credit;
import com.progra.practica5.entities.Payment;

public class PaymentTest {
	
	@Test
	public void paymentTest() {
		ArrayList<Payment> payment=new ArrayList<Payment>();
		Payment cash= new Cash(20.0, "ewrwe");
		payment.add(cash);
		Assert.assertEquals(1,payment.size());
		Payment check= new Check(20.0,30.0,"adasa","asdasdas");
		payment.add(check);
		Assert.assertEquals(2,payment.size());
		Credit credit= new Credit(20.0,30.0,231,"adasa",null);
		payment.add(credit);
		Assert.assertEquals(3,payment.size());
	}
}
