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
        //Removes all items who are equivalent to ref
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

    public void EditQuantity(int quantity, Item ref) throws Exception {
        //Validate input
        if(quantity < Common.MIN_QUANTITY){
            throw new Exception("Invalid quantity");
        }

        ArrayList<Item> markedDeletion = new ArrayList<>();

        int total=0;
        for (Item item : cart) {
            //Case if cart item is equivalent to ref parameter
            if(item.equals(ref)){
                total++;
                //Case if too many equivalent items exist in the cart
                if(total > quantity){
                    markedDeletion.add(item);
                    count--;
                }

            }
        }
        cart.removeAll(markedDeletion);

        //Case if not enough equivalent items exist in the cart
        while(total < quantity){
            AddItem(ref);
            total++;
        }


    }

    public void NotifyCustomer(){

        System.out.println("Total Items in cart: " + count);
    }
}
