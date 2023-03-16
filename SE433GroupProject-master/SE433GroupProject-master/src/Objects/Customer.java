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
        checkedOut = false;
        checkQuantity(quantity);
        
        shoppingCart = new ShoppingCart();
    }
    
    private String name;
    private String state;
    private Item item;
    private ShippingOptions shipping;
    private int quantity;
    private ShoppingCart shoppingCart;
    public boolean checkedOut;
	private int extraGlobal;
    
    
    public void AddItem(){
        for(int i= 0; i<quantity;i++){
            shoppingCart.AddItem(item);
        }
        shoppingCart.NotifyCustomer();
    }
    public int getCount() {
    	return shoppingCart.count;
    }
    public float GetTotal(){
        float result = shoppingCart.getTotal();
        int extras = CalculateExtras();
        System.out.println("Subtotal + Tax & Shipping: $" + result + extras);
        return shoppingCart.getTotal();
    }

    public ArrayList<Item> SeeContents(){
    	return shoppingCart.cart;
    }
   
    public void RemoveItem(){
        shoppingCart.RemoveItem(item);
    }
    
    public void CheckOut(){
        System.out.println("Good Day " +name+ ". Your Total is:");
        float total = GetTotal();
        if(total > Common.maxPurchase){
            System.out.println("PURCHASE-LIMIT: $" +Common.maxPurchase+ "\nCHECKOUT-INCOMPLETE");
        }
        else if(total < Common.minPurchase){
            System.out.println("PURCHASE-MINIMUM: $" +Common.minPurchase+ "\nCHECKOUT-INCOMPLETE");
        }
        else{
            System.out.println("transaction completed");
            checkedOut = true;
        }

    }
    
    public void EditQuantity(int q) throws Exception{
    	checkQuantity(q);
        quantity = q;
    }
    
    private int CalculateExtras(){
       int extra = 0;
        if(state.equals("IL - Illinois")||state.equals("CA - California")||state.equals("NY - New York")){
            extra += Common.tax;
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
        setExtra(extra);
        return extra;
    }
    public void setExtra(int extra) {
    	extraGlobal = extra;
    }
    public int getExtra() {
    	return extraGlobal;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getShipping() {
		return shipping.toString();
	}
	public void checkQuantity(int quantity) throws Exception {
        if(quantity < Common.minQuantity){
            throw new Exception("Exception message");
        }
	}

}
