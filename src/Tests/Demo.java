package Tests;

import Objects.Customer;
import Objects.Item;
import Objects.ShippingOptions;

public class Demo {
    public static void Execute() throws Exception {
        //Declare items that customer can add
        Item Banana = new Item("Banana",0.50f);
        Item Chicken = new Item("Chicken", 10f);
        Item Eggs = new Item("Eggs", 1000f);
        Item Milk = new Item("Milk", 1f);

        Customer A = new Customer("Annie", "NY - New York", Banana,100, ShippingOptions.NEXTDAY);
        //Add item functionality by adding 100 bananas
        A.AddItem();
        A.CheckOut();

        Customer B = new Customer("Barbara", "IL - Illinois", Eggs,100, ShippingOptions.STANDARD);
        //Checks maximum barrier by items costing more than $10,000.00
        B.AddItem();
        B.CheckOut();

        //Checks minimum barrier by deleting all items from cart
        B.RemoveItem();
        B.CheckOut();

        Customer C = new Customer("Chris", "CA - California", Chicken,3, ShippingOptions.STANDARD);
        //Edit quantity and check total before checking out
        C.AddItem();
        C.EditQuantity(7);
        C.AddItem();
        C.GetTotal();
        C.CheckOut();

        Customer D =  new Customer("Daniel", "DE - Delaware", Milk,3, ShippingOptions.STANDARD);
        //Add items, see cart contents, edit item quantity, remove items, re-add new quantity of items, re-check cart contents, checkout.
        D.AddItem();
        D.SeeContents();
        D.EditQuantity(1);
        D.RemoveItem();
        D.AddItem();
        D.SeeContents();
        D.CheckOut();
    }
}
