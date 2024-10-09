package main;

public class Clothing extends Product implements Orderable {

	String size;
	int quantityInStock;
	
	public Clothing(String productId, String productName, double price, String size, int quantityInStock) {
		super(productId, productName, price);
		this.size = size;
		this.quantityInStock = quantityInStock;
	}

	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public int getQuantityInStock() {
		return quantityInStock;
	}



	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}



	@Override
	public void addToOrder(Order order) {
		
		
	}

	@Override
	public void displayOrderDetails() {
		
		
	}

	@Override
	public double getPrice() {
		
		return this.price;
	}

	@Override
	public void displayProductInfo() {
		if (isAvailable()) {
			System.out.printf("%-4s | %-22s | $%-6.2f | %-6s | %s\n", this.productId, this.productName, getPrice(), getSize(), "In Stock");
		}
		
	}

	@Override
	public boolean isAvailable() {
		
		if (getQuantityInStock() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
