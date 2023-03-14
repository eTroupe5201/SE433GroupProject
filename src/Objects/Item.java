package Objects;

public class Item {
    //Fields
    private float price;
    private String name;

    //Private constructor
    private Item() {}

    //Copy constructor
    public Item(Item other) {
        price = other.price;
        name = other.name;
    }

    //Parameter constructor
    public Item(String nm, float cost) {
        price = cost;
        name = nm;
    }


    //Methods
    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Item other) {
        return (this.name.equals(other.name)  && this.price == other.price);
    }
}
