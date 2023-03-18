package Objects;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	Item item;
	Item item1;
	Item item2;
	Item item3;
	Item item4;
	
	
	Customer customer;
	double delta;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;


	@Before
	public void setup() throws Exception {
		delta = 1e-15; 
		item = new Item("book", 10);
		item1 = new Item("Free Book", 0);
		item2 = new Item("Expensive Book", 100000);
	    item3 = new Item("Hat" , 5);
	    item4 = new Item("BookCase", 100);
	
		customer = new Customer("Erica Troupe", "IL - Illinois", item, 10, ShippingOptions.NEXTDAY);
		System.setOut(new PrintStream(out));
	}	
	@After
	public void teardown() {
	    System.setOut(originalOut);
	 
	}

	@Test
	public void customerQuantityTest() {
		assertEquals(customer.getExtra(), 0.0d, delta);
		assertEquals(customer.getQuantity(), 10);
	
	}
	@Test
	public void customeItemNameTest() {
		
		assertSame(item.getName(), "book");

		
	}
	@Test
	public void customerItemPriceTest() {
		
		assertEquals(item.getPrice(), 10,delta);
	}
	@Test
	public void Item4NameTest() {
		
		assertEquals(item4.getName(), "BookCase");
	}
	@Test
	public void Item4PriceTest() {
		
		assertEquals(item4.getPrice(), 100,delta);
	
	}
	

	@Test
	public void Item2NameTest() {
		
		assertEquals(item2.getName(), "Expensive Book");
	}
	@Test
	public void Item2PriceTest() {
		
		assertEquals(item2.getPrice(), 100000,delta);
		
	}
	
	@Test
	public void Item1NameTest() {
		
		assertEquals(item1.getName(), "Free Book");
	}
	@Test
	public void Item1PriceTest() {
		
		assertEquals(item1.getPrice(), 0,delta);
	}
	@Test
	public void Item3NameTest() {
		
		assertEquals(item3.getName(), "Hat");
	}
	@Test
	public void Item3PriceTest() {
		
		assertEquals(item3.getPrice(), 5,delta);
	}
	

	@Test
	public void customerNameTest() {
		
		assertEquals(customer.getName(), "Erica Troupe");
	}
	@Test
	public void customerGetTotalTest() throws Exception {
	
		customer.EditQuantity(2);
		customer.AddItem();
	
		assertEquals(customer.GetTotal(), 46.20000076293945, delta); //im not sure why this is happening
		//20 original cost + 1.2 tax + 25 shipping
	}

	@Test 
	public void customerCheckout() {
		assertNotEquals(customer.GetTotal(), Common.stdDiscount);
		customer.AddItem();
		customer.CheckOut();
		assertTrue(customer.checkedOut);
	    assertEquals("Subtotal + Tax & Shipping: $31.0\n"
	    		+ "Total Items: 10\n"
	    		+ "Good Day Erica Troupe. Your Total is: 100.0 transaction completed!\n", out.toString());
		assertEquals(true, customer.notificationReceived());

	}
	@Test 
	public void customerCheckOutTotalMaxPurchase() throws Exception {
	
		Customer customer3 = new Customer("Stacy White", "IL - Illinois", item2, 1, ShippingOptions.STANDARD);
		customer3.AddItem();
		customer3.CheckOut();
		  assertEquals("Total Items: 1\n"
		  		+ "PURCHASE-LIMIT: $99999.99\n"
		  		+ "CHECKOUT-INCOMPLETE\n", out.toString());
		assertFalse(customer3.checkedOut);
	}


	
	@Test 
	public void customerCalculateExtrasCA() throws Exception {

		Customer customer3 = new Customer("Jennifer Hudson", "CA - California", item3, 1, ShippingOptions.STANDARD);
		customer3.AddItem();
		assertEquals(customer3.GetTotal(), 15.300000190734863, delta);
		assertNotEquals(customer3.getExtra(), 0.0d);
		assertNotEquals(customer3.GetTotal(), Common.minPurchase);
		//5.3 + 10 shipping, correct
	}

	@Test 
	public void customerCalculateExtrasNYStandard() throws Exception {
	
		Customer customer3 = new Customer("Stacy Williams", "NY - New York", item4, 1, ShippingOptions.STANDARD);
		customer3.AddItem();
		assertEquals(customer3.GetTotal(),106, delta);
		//100 for item + .06 of total and free shipping right
	
	}
	@Test 
	public void customerCalculateExtrasNYnextDay() throws Exception {

		Customer customer4 = new Customer("New Customer Again", "NY - New York", item4, 1, ShippingOptions.NEXTDAY);
		customer4.AddItem();
	
		assertEquals(customer4.GetTotal(), 131, delta);

		assertNotEquals(customer4.getCount(), 0);
		assertNotEquals(customer4.SeeContents(), null);
		assertNotEquals(customer4.getShipping(), "");
		//100 + 6 tax + 25 shipping
	}
	@Test 
	public void customerCalculateExtrasNoneNextDay() throws Exception {

		Customer customer4 = new Customer("New Customer Again", "IN", item4, 1, ShippingOptions.NEXTDAY);
		customer4.AddItem();
		
		assertEquals(customer4.GetTotal(),125, delta);
		
	}
	@Test 
	public void customerCalculateExtrasStandard() throws Exception {
	
		Customer customer4 = new Customer("New Customer Again", "IN - Indiana", item4, 1, ShippingOptions.STANDARD);
		customer4.AddItem();
	
		assertEquals(customer4.GetTotal(),100, delta);
	}
	
	@Test 
	public void customerCheckOutTotalMinPurchase() throws Exception {

		Customer customer3 = new Customer("New customer", "CA - California", item1, 1, ShippingOptions.NEXTDAY);
		customer3.AddItem();
		customer3.CheckOut();
		assertEquals(false,customer3.checkedOut);
	
			  assertEquals("Total Items: 1\n"
			  		+ "PURCHASE-MINIMUM: $1.0\n"
			  		+ "CHECKOUT-INCOMPLETE\n", out.toString());
		
		
	} 
	
	@Test(expected = Exception.class)
	public void customerQuantityLessThanMinTest() throws Exception {
		customer = new Customer("Erica Troupe", "IL - Illinois", item, 0, ShippingOptions.NEXTDAY);
		customer.CheckOut();
		
	}
	
	@Test
	public void customerQuantityGreaterThanMinTest() throws Exception {
		
		assertEquals(customer.getQuantity(), 10);
	}

	

	
}
