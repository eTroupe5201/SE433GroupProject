package Objects;


import java.util.ArrayList;

public class ShoppingCart {
    //Constructor
	
    public ShoppingCart(){
        cart=new ArrayList<>();
    }
    
    ArrayList<Item> cart;
    int count=0;
    public void AddItem(Item t){
        t = new Item(t);
        cart.add(t);
        count++;
   

    }
 
    public void RemoveItem(Item t){
        cart.remove(t);
        count--;
    }

    public float getTotal(){
        int total = 0;
        for (Item t :
                cart) {
            total+=t.getPrice();
        }
        return total;
    }

    public void NotifyCustomer(){

        System.out.println("Total Items: " + count);
    }
}
