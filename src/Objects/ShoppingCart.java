package Objects;


import java.util.ArrayList;

public class ShoppingCart {
    //Constructor
    public ShoppingCart(){
        cart=new ArrayList<>();
    }
    ArrayList<Item> cart;
    private int count=0;
    public void AddItem(Item t){
        t = new Item(t);
        cart.add(t);
        count++;

    }
    public void RemoveItem(Item ref){
        //Removes all items who share name and price as the passed in ref
        ArrayList<Item> markedDeletion = new ArrayList<>();

        for (Item item : cart) {
            if(item.equals(ref)){
                markedDeletion.add(item);
                count--;
            }
        }
        cart.removeAll(markedDeletion);
    }
    public float getTotal(){
        float total = 0;
        for (Item t :
                cart) {
            total += t.getPrice();
        }
        return total;
    }

    public void NotifyCustomer(){

        System.out.println("Total Items added: " + count);
    }
}
