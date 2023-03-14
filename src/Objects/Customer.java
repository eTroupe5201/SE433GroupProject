package Objects;

import java.util.ArrayList;

public class Customer {
    private Customer(){}
    public Customer(String nm, String st, Item it, int q,ShippingOptions sOpt) throws Exception {
        name = nm;
        state = st;
        item = it;
        shipping = sOpt;
        //Safety Check
        quantity = q;
        if(quantity < Common.minQuantity){
            throw new Exception("Invalid quantity");
        }
        shoppingCart = new ShoppingCart();
    }
    private String name;
    private String state;
    private Item item;
    private ShippingOptions shipping;
    private int quantity;
    private ShoppingCart shoppingCart;


    public void AddItem(){
        for(int i= 0; i<quantity;i++){
            shoppingCart.AddItem(item);
        }
        shoppingCart.NotifyCustomer();
    }
    public float GetTotal(){
        float subtotal = shoppingCart.getTotal();
        float extras = CalculateExtras(subtotal);

        System.out.println("Subtotal= " + subtotal);
        System.out.println("Taxes & Shipping= " + extras);
        System.out.println("Total= " + (subtotal + extras));

        return subtotal + extras;
    }

    public ArrayList<Item> SeeContents(){
        System.out.println(shoppingCart.cart);
        return shoppingCart.cart;

    }
    public void RemoveItem(){
        shoppingCart.RemoveItem(item);
    }
    public float CheckOut(){
        System.out.println("Good Day " +name.toUpperCase()+ ". Your checkout total is:");
        System.out.println("-------------------------------");
        float total = GetTotal();
        System.out.println("-------------------------------");

        if(shoppingCart.getTotal() > Common.maxPurchase){
            System.out.println("PURCHASE-LIMIT: $" +Common.maxPurchase+ "\nCHECKOUT-INCOMPLETE\n");
        }
        else if(shoppingCart.getTotal() < Common.minPurchase){
            System.out.println("PURCHASE-MINIMUM: $" +Common.minPurchase+ "\nCHECKOUT-INCOMPLETE\n");
        }
        else{
            System.out.println("transaction completed\n");
        }
        return total;
    }
    public void EditQuantity(int q){
        quantity=q;
    }
    private float CalculateExtras(float subtotal){
        float extra = 0;
        if(state.equals("IL - Illinois")||state.equals("CA - California")||state.equals("NY - New York")){

            extra += subtotal * (Common.tax*0.01);
        }


        if(shipping == ShippingOptions.STANDARD){
            extra += Common.stdCost;
            if(shoppingCart.getTotal()>Common.stdDiscount){
                extra -= Common.stdCost;
            }
        }
        else if(shipping == ShippingOptions.NEXTDAY){
            extra += Common.nextDay;
        }
        return extra;
    }

}
