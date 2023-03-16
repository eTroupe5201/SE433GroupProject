package Objects;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTests {
	Item item;
	Item item2;
	double delta;
	@Before
	public void setup() {
		delta = 1e-15; 
		item = new Item();
		item.setName("book");
		item.setPrice(10);
		item2 = new Item(item);
	}

	@Test
	public void itemNameTest() {
		
		assertEquals(item.getName(), "book");
	}
	@Test
	public void itemNameTestMutation() {
		
		assertNotEquals(item.getName(), "");
	}
	
	@Test
	public void itemPriceTest() {
		
		assertEquals(item.getPrice(), 10, delta);
	}
	@Test
	public void itemNameTest2() {
		
		assertEquals(item2.getName(), "book");
		
	}
	
	@Test
	public void itemPriceTest2() {
		
		assertEquals(item2.getPrice(), 10, delta);
	}
	@Test
	public void itemPriceTestMutation() {
		
		assertNotEquals(item2.getPrice(), 0);
	}
	@Test
	public void itemNameMutationTest() {
		
		assertNotEquals(item2.getName(),"");
	}
}
