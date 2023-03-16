package Objects;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerTests.class, ItemTests.class, ShoppingCartTests.class, CustomerMutationTests.class
		 })
public class AllTests {

}
