package main;

public class Electronics extends Product implements Orderable {

	String brand;
	int warrantyPeriod;
	
	public Electronics(String productId, String productName, double price, String brand, int warrantyPeriod) {
		super(productId, productName, price);
		this.brand = brand;
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
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
			System.out.printf("%-4s | %-22s | $%-6.2f | %-11s | %s\n", this.productId, this.productName, getPrice(), getWarrantyPeriod(), "In Stock");
		}
		
	}

	@Override
	public boolean isAvailable() {
		
		if (getWarrantyPeriod() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
