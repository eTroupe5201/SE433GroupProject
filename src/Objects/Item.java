package Objects;

public class Item {
    int price;
    String name;
    //Copy constructor
    public Item(Item other){
        price = other.price;
        name = other.name;
    }
}
