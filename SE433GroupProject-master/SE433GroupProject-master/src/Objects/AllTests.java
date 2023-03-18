package Objects;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//import ProjectTests.CustomerMutationTests;
//import ProjectTests.CustomerTests;
//import ProjectTests.ItemTests;

@RunWith(Suite.class)
@SuiteClasses({  ItemTest.class, CustomerMutationTest.class,ItemTest.class,CustomerTest.class, ShoppingCartTest.class,  ShippingOptionsTest.class
		 })
public class AllTests {

}
