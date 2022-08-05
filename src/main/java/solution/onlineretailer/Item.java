package solution.onlineretailer;

public class Item {

	private int id;
	private String description;
	private double price;
	
	public Item(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
		
	@Override
	public String toString() {
		return String.format("[%02d], %s, £%.2f", id, description, price);
	}
}
