package Objects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerMutationTests {
	Item item;
	Customer customer;
	Customer customer2;

	double delta;
	
	
	@Before
	public void setup() throws Exception {
		delta = 1e-15; 
		item = new Item();
		item.setName("Insanely Expensive Book");
		item.setPrice(99999.99);
		customer = new Customer("Erica Troupe", "IL - Illinois", item, 1, ShippingOptions.STANDARD);
		customer2 = new Customer("Erica Brown", "IL - Illinois", item, 1, ShippingOptions.NEXTDAY);
		customer.AddItem();
		customer2.AddItem();
	
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
	public void extraMutation2() {
		customer.GetTotal();
		assertEquals(customer.getExtra(), 6);
	}
	@Test
	public void extraMutationZero() {
		customer.GetTotal();
		assertNotEquals(customer.getExtra(), 0);
	}

//	@Test
//	public void addItemMutation2() {
//		assertNotEquals(customer.SeeContents(), null);
//	}

}
