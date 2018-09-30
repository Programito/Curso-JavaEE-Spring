package progra.practica5;

import org.junit.Assert;
import org.junit.Test;

import com.progra.practica5.entities.Authorized;
import com.progra.practica5.entities.Check;
import com.progra.practica5.entities.Payment;

public class CheckTest {
	@Test
	public void getTypeTest() {
		Payment check= new Check(20.0,30.0,"adasa","asdasdas");
		Assert.assertTrue(check instanceof Check);
		Authorized check2=new Check(20.0,30.0,"adasa","asdasdas");
		Assert.assertTrue(check2 instanceof Check);
	}
	
	@Test
	public void getAndSetCheckTest() {
		Payment check= new Check(20.0,30.0,"adasa","asdasdas");
		Assert.assertEquals(20.0, check.getAmount(),0.01);
		check.setAmount(30.0);
		Assert.assertEquals(30.0, check.getAmount(),0.01);
		 if (Check.class.isInstance(check)) {
		        Check check2 = Check.class.cast(check);
		        Assert.assertEquals(30.0, check2.getSaldo(),0.01);
		        check2.setSaldo(25.0);
		        Assert.assertEquals(25.0, check2.getSaldo(),0.01);
		 } 
	}
	
	@Test
	public void operationStatusTest() {
		Check check= new Check(20.0,30.0,"adasa","asdasdas");
		Assert.assertTrue(check.operationStatus());
		check.setSaldo(15.0);
		Assert.assertTrue(!check.operationStatus());
	}
	
	@Test
	public void changeTest() {
		Check check= new Check(20.0,30.0,"adasa","asdasdas");
		check.change();
		Assert.assertEquals(10.0, check.getSaldo(),0.01);
	}
	
	@Test
	public void validate() {
		Check check= new Check(20.0,30.0,"adasa","asdasdas");
		Assert.assertTrue(!check.getAuthorized());
		check.authorized();
		Assert.assertTrue(check.getAuthorized());
	}
	
}

