package Objects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTests {

	Item item;
	Customer customer;
	double delta;
	ShoppingCart cart;
	@Before
	public void setup() throws Exception {
		delta = 1e-15; 
		item = new Item();
		item.setName("book");
		item.setPrice(10);
		customer = new Customer("Erica Troupe", "MI", item, 10, ShippingOptions.STANDARD);
		customer.AddItem();
		
	}
	@Test
	public void ItemNameNameMutationBlank(){
		assertNotEquals(item.getName(), "");
	}
	@Test
	public void ItemPriceMutationk(){
		assertNotEquals(item.getPrice(), 0);
	}
	@Test
	public void ItemPriceMutationNull(){
		assertNotEquals(item.getPrice(), null);
	}
	@Test
	public void ItemNameMutationNull(){
		assertNotEquals(item.getName(), null);
	}
	@Test
	public void ShoppingCartMutationSubtraction(){
		assertEquals(customer.getCount(), 10);
	}
	@Test
	public void ShoppingCartRemoveMutationn(){
		customer.RemoveItem();
		assertEquals(customer.getCount(), 9);
	}

}
