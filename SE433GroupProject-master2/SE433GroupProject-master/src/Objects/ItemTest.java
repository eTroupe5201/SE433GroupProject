package Objects;




import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	Item item;
	Item item2;
	double delta;
	@Before
	public void setup() {
		delta = 1e-15; 
		item = new Item("book", 10);
		
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
	public void itemNameTestMutationNul() {
		
		assertNotEquals(item.getName(), null);
	}
	
	@Test
	public void itemPriceTest() {
		
		assertEquals(item.getPrice(), 10, delta);
	}
	
	@Test
	public void itemPriceTestMutation() {
		
		assertNotEquals(item.getPrice(), null);
	}

}
