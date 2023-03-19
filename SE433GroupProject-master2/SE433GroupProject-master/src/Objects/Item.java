package Objects;



public class Item {
    private double price;
    private String name;
    //Copy constructor
    
//    public Item(Item other){
//    	this.name = other.name;
//    	this.price = other.price;
//    }
    public Item(String name, double price) {
    	this.name = name;
    	this.price = price;
    }
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}

