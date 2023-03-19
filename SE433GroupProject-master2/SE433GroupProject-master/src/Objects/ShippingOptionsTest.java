package Objects;




import static org.junit.Assert.*;

import org.junit.Test;

public class ShippingOptionsTest {

	@Test
	public void shippingOptionsNextDay() {
		assertEquals(ShippingOptions.NEXTDAY.toString(), "NEXTDAY");

	}
	@Test
	public void shippingOptionsStandard() {
		assertEquals(ShippingOptions.STANDARD.toString(), "STANDARD");
	}
}
