package Objects;



import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CustomerMutationTest {
	Item item;
	Customer customer;
	Customer customer2;

	double delta;

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();

	private final PrintStream originalOut = System.out;



	@Before
	public void setup() throws Exception {
		delta = 1e-15; 
		delta = 1e-15; 
		item = new Item("Insanely Expensive Book", 99999.99);
		customer = new Customer("Erica Troupe", "IL - Illinois", item, 1, ShippingOptions.STANDARD);
		customer2 = new Customer("Erica Brown", "IL - Illinois", item, 1, ShippingOptions.NEXTDAY);
		customer.AddItem();
		customer2.AddItem();
		System.setOut(new PrintStream(out));
	}	
	@After
	public void teardown() {
	    System.setOut(originalOut);
	 
	}
	@Test 
	public void customerCheckOutTotalMinPurchase() throws Exception {

		customer.GetTotal();

			  assertEquals("Subtotal + Tax & Shipping: $105999.99\n", out.toString());
		
		
	} 
	@Test
	public void customerNotificationFlagMutation() {
		customer2.CheckOut(); 
	    assertEquals("Good Day Erica Brown. Your Total is: 99999.99 transaction completed!\n", out.toString());
		assertEquals(true, customer2.notified);
	}
	@Test
	public void customerShippingStandard() {
		assertEquals(customer.getShipping(), ShippingOptions.STANDARD.toString());
	}
	@Test
	public void customerShippingNextDay() {
		assertEquals(customer2.getShipping(), ShippingOptions.NEXTDAY.toString());
	}
	@Test
	public void customerCalculateExtrasMutation() {
		assertNotEquals(customer.GetTotal(), Common.maxPurchase);
	}
	@Test
	public void customergetExtraMutation() {
		assertNotEquals(customer.getExtra(), 0);
	}
	@Test
	public void customerCalculateExtrasMutation3() {
		assertNotEquals(customer.GetTotal(), 0.0f);
	}
	@Test
	public void itemNameMutation() {
		assertNotEquals(item.getName(), "");
		

	} 
	@Test
	public void itemNameMutation2() {
		assertEquals(item.getName(), "Insanely Expensive Book");
	}
	@Test
	public void itemPriceMutation() {
		assertNotEquals(item.getPrice(), null);
	}
	@Test
	public void itemPriceMutation2() {
		assertEquals(item.getPrice(), 99999.99, delta);
	}
	@Test
	public void addItemMutation() {
		assertNotEquals(customer.SeeContents(), null);
	}
	@Test
	public void addItemMutation2() {
		assertNotEquals(customer2.SeeContents(), null);
	}
	@Test
	public void extraMutation() {
		customer.GetTotal();
		assertNotEquals(customer.getExtra(), null);
	}

	@Test
	public void extraMutationZero() {
		customer.GetTotal();
		assertNotEquals(customer.getExtra(), 0);
	}
	@Test
	public void customerQuantityGreaterThanMinTest() throws Exception {
		
		assertThrows(Exception.class, ()-> customer.EditQuantity(-1));
		assertTrue(customer.quantityChecked);
		assertNotEquals(false,customer.quantityChecked);
	}




}
