package progra.practica5;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.progra.practica5.entities.Authorized;
import com.progra.practica5.entities.Check;
import com.progra.practica5.entities.Credit;
import com.progra.practica5.entities.Payment;

public class CreditTest {
	@Test
	public void getTypeTest() {
	 	Calendar calendar= Calendar.getInstance();
    	Date date= calendar.getTime();
		Credit credit= new Credit(20.0,30.0,231,"adasa",date);
		Assert.assertTrue(credit instanceof Credit);
		Authorized credit2= new Credit(20.0,30.0,231,"adasa",date);
		Assert.assertTrue(credit2 instanceof Credit);
	}
	
	@Test
	public void getAndSetTest() {
	 	Calendar calendar= Calendar.getInstance();
    	Date date= calendar.getTime();
		Credit credit= new Credit(20.0,30.0,231,"adasa",date);
		Assert.assertEquals(20.0, credit.getAmount(),0.01);
		credit.setAmount(30.0);
		Assert.assertEquals(30.0, credit.getAmount(),0.01);
		 if (Credit.class.isInstance(credit)) {
		        Credit credit2 = Credit.class.cast(credit);
		        Assert.assertEquals(30.0, credit2.getSaldo(),0.01);
		        credit2.setSaldo(25.0);
		        Assert.assertEquals(25.0, credit2.getSaldo(),0.01);
		        Assert.assertEquals(date,credit2.getExpDate());
		 } 
	}
	
	@Test
	public void operationStatusTest() {
	 	Calendar calendar= Calendar.getInstance();
    	Date date= calendar.getTime();
		Credit credit= new Credit(20.0,30.0,231,"adasa",date);
		Assert.assertTrue(credit.operationStatus());
		credit.setSaldo(15.0);
		Assert.assertTrue(!credit.operationStatus());
	}
	
	@Test
	public void changeTest() {
	 	Calendar calendar= Calendar.getInstance();
    	Date date= calendar.getTime();
		Credit credit= new Credit(20.0,30.0,231,"adasa",date);
		credit.change();
		Assert.assertEquals(10.0, credit.getSaldo(),0.01);
	}
	
	@Test
	public void validate() {
		Calendar calendar= Calendar.getInstance();
    	Date date= calendar.getTime();
		Credit credit= new Credit(20.0,30.0,231,"adasa",date);
		Assert.assertTrue(!credit.getAuthorized());
		credit.authorized();
		Assert.assertTrue(credit.getAuthorized());
	}
}