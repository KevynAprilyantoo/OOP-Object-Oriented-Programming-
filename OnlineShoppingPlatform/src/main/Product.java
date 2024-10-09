package main;

public abstract class Product {
	String productId, productName;
	double price;
	
	public Product(String productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public abstract double getPrice();

	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract void displayProductInfo();
	
	public abstract boolean isAvailable();
}
