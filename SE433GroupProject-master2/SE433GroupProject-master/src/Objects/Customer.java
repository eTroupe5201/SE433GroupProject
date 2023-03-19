package Objects;



import java.text.DecimalFormat;
import java.util.ArrayList;

public class Customer {
	
	private String name;
    private String state;
    private Item item;
    private ShippingOptions shipping;
    int quantity;
    private ShoppingCart shoppingCart;
    public boolean checkedOut;
	private double extraGlobal;
	public boolean quantityChecked;
    public boolean notified;
    public double cartTotalOnly;
    public Customer(String nm, String st, Item it, int q,ShippingOptions sOpt) throws Exception  {
        this.name = nm;
        this.state = st;
        this.item = it;
        this.shipping = sOpt;
        //Safety Check
        this.quantity = q;
        this.checkedOut = false;
        this.quantityChecked = false;
        checkQuantity(quantity);
        this.notified = false;
        this.cartTotalOnly = 0.0;
         shoppingCart = new ShoppingCart();
    }
  
    

    public void AddItem(){
        for(int i= 0; i<quantity;i++){
            shoppingCart.AddItem(item);
        }
        shoppingCart.NotifyCustomer();
        updateNotification();
    }
    public int getCount() {
    	return shoppingCart.cartSize();
    }
    
    public float GetTotal(){
        float result = shoppingCart.getTotal();
        double extras = CalculateExtras();
        float finalTotal = (float) (result + extras); //random glitch, double dot
        System.out.print("Subtotal + Tax & Shipping: $" + finalTotal +"\n");
        
        return finalTotal;
    }

    public ArrayList<Item> SeeContents(){
    	return shoppingCart.cart;
    }
   
    public void RemoveItem(){
        shoppingCart.RemoveItem(item);
    }
     
    public void CheckOut(){
       
    	cartTotalOnly = shoppingCart.getTotal();
      
        if(cartTotalOnly > Common.maxPurchase){ //changed this as well. Please let me know what you think.
            System.out.print("PURCHASE-LIMIT: $" +Common.maxPurchase+ "\nCHECKOUT-INCOMPLETE\n");//print used with \n character for testing
            checkedOut = false;
        }
        else if(cartTotalOnly < Common.minPurchase){ //this seems better, let me know what you think
        	
            System.out.print("PURCHASE-MINIMUM: $" +Common.minPurchase+ "\nCHECKOUT-INCOMPLETE\n");
            checkedOut = false;
        }
        else{
        	 System.out.print("Good Day " +name+ ". Your Total is: " + shoppingCart.getTotal() + " transaction completed!\n");
            checkedOut = true;
        }

    }
    
    public void EditQuantity(int q) throws Exception{
    	if(q < 0) {throw new Exception("Value is negative!");}
    	else {
    	quantityChecked = false;
    	checkQuantity(q);
        quantity = q;}
        
    	
    }
//    public void EditQuantity(int q) throws Exception {
//        if(q < Common.minQuantity){
//            throw new Exception("Invalid quantity");
//        }
//        shoppingCart.EditQuantity(q, item);
//        quantity = q;
//    }
//    
    public void updateNotification() {
    	
    	this.notified = shoppingCart.notified;
    }
    
    private double CalculateExtras(){
       double extra = 0;
        if(state.equals("IL - Illinois")||state.equals("CA - California")||state.equals("NY - New York")){
            extra += (Common.tax * (item.getPrice() * quantity)); //fix 6% of the total
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
    public void setExtra(double extra) {
    	
    	extraGlobal = extra;
    }

	public double getExtra() {
		DecimalFormat df = new DecimalFormat("0.##");
    	return Double.parseDouble(df.format(extraGlobal));
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
		this.quantityChecked = true;
        if(quantity < Common.minQuantity){
            throw new Exception("Exception message");
        }
	}

}
