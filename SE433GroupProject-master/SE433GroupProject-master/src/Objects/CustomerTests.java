package Objects;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTests {

	Item item;
	Customer customer;
	double delta;
	
	@Before
	public void setup() throws Exception {
		delta = 1e-15; 
		item = new Item();
		item.setName("book");
		item.setPrice(10);
		customer = new Customer("Erica Troupe", "IL - Illinois", item, 10, ShippingOptions.NEXTDAY);
	}
	@Test
	public void customerQuantityTest() {
		
		assertEquals(customer.getQuantity(), 10);
	}
	@Test
	public void customeItemrNameTest() {
		
		assertEquals(item.getName(), "book");
	}
	@Test
	public void customerItemPriceTest() {
		
		assertEquals(item.getPrice(), 10,delta);
	}
	@Test(expected = Exception.class)
	public void customerQuantityLessThanMinTest() throws Exception {
		customer = new Customer("Erica Troupe", "IL - Illinois", item, 0, ShippingOptions.NEXTDAY);
		assertEquals(customer.getQuantity(), 0);
	}
	
	@Test
	public void customerQuantityGreaterThanMinTest() throws Exception {
		
		assertEquals(customer.getQuantity(), 10);
	}
	@Test
	public void customerNameTest() {
		
		assertEquals(customer.getName(), "Erica Troupe");
	}
	@Test
	public void customerGetTotalTest() throws Exception {
	
		customer.EditQuantity(2);
		customer.AddItem();
		assertEquals(customer.GetTotal(), 20.0, delta);
	}

	@Test 
	public void customerCheckout() {
		customer.AddItem();
		customer.CheckOut();
		assertTrue(customer.checkedOut);
	}
	@Test 
	public void customerCheckOutTotalMaxPurchase() throws Exception {
		Item item2 = new Item();
		item2.setName("Expensive Book");
		item2.setPrice(100000);
		Customer customer3 = new Customer("New customer", "IL - Illinois", item2, 1, ShippingOptions.STANDARD);
		customer3.AddItem();
		customer3.CheckOut();
		assertFalse(customer3.checkedOut);
	}

	
	@Test 
	public void customerCheckOutTotalMinPurchase() throws Exception {
		Item item2 = new Item();
		item2.setName("Free Book");
		item2.setPrice(0);
		Customer customer3 = new Customer("New customer", "CA - California", item2, 1, ShippingOptions.NEXTDAY);
		customer3.AddItem();
		customer3.CheckOut();
		assertFalse(customer3.checkedOut);
	}
	
	@Test 
	public void customerCalculateExtrasCA() throws Exception {
		Item item2 = new Item();
		item2.setName("Hat");
		item2.setPrice(5);
		Customer customer3 = new Customer("Jennifer Hudson", "CA - California", item2, 1, ShippingOptions.STANDARD);
		customer3.AddItem();
		assertEquals(customer3.GetTotal(),5, delta);
	}

	@Test 
	public void customerCalculateExtrasNYStandard() throws Exception {
		Item item2 = new Item();
		item2.setName("BookCase");
		item2.setPrice(100);
		Customer customer3 = new Customer("Stacy Williams", "NY - New York", item2, 1, ShippingOptions.STANDARD);
		customer3.AddItem();
		assertEquals(customer3.GetTotal(),100, delta);
	}
	@Test 
	public void customerCalculateExtrasNYnextDay() throws Exception {
		Item item3 = new Item();
		item3.setName("BookCase");
		item3.setPrice(100);
		Customer customer4 = new Customer("New Customer Again", "NY - New York", item3, 1, ShippingOptions.NEXTDAY);
		customer4.AddItem();
	
		assertEquals(customer4.GetTotal(),100, delta);
	}
	@Test 
	public void customerCalculateExtrasNoneNextDay() throws Exception {
		Item item3 = new Item();
		item3.setName("BookCase");
		item3.setPrice(100);
		Customer customer4 = new Customer("New Customer Again", "IN", item3, 1, ShippingOptions.NEXTDAY);
		customer4.AddItem();
		
		assertEquals(customer4.GetTotal(),100, delta);
	}
	@Test 
	public void customerCalculateExtrasStandard() throws Exception {
		Item item3 = new Item();
		item3.setName("BookCase");
		item3.setPrice(100);
		Customer customer4 = new Customer("New Customer Again", "IN - Indiana", item3, 1, ShippingOptions.STANDARD);
		customer4.AddItem();
	
		assertEquals(customer4.GetTotal(),100, delta);
	}

	

	
}
