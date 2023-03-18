package Objects;




import java.util.ArrayList;



public class ShoppingCart {
    //Constructor
	public Boolean notified;
	
    public ShoppingCart(){
        cart = new ArrayList<>();
        notified = false;
    }
    
     ArrayList<Item> cart;
   
    public int cartSize() {
    	return cart.size(); 
    }
    
    public void AddItem(Item t){
        //t = new Item(t);
        cart.add(t);
    }
 
    public void RemoveItem(Item t){
    
        cart.remove(t);
    }


    public float getTotal(){
        float total = 0;
        for (Item t : cart) {
            total+=t.getPrice();
        }
        return total;
    }

    public void NotifyCustomer(){
    	notified = true;
        System.out.print("Total Items: " + cart.size() + "\n");
    }
}
