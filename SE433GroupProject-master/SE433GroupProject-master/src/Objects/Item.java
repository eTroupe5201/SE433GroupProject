package Objects;

public class Item {
    private double price;
    private String name;
    //Copy constructor
    public Item(Item other){
        setPrice(other.getPrice());
        setName(other.getName());
    }
    public Item(){
      
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
}
