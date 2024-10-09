package main;

import java.util.ArrayList;

public class Order {
	String orderId, orderDate, Status;
	ArrayList<Product> products = new ArrayList<>();
	
	public Order(String orderId, String orderDate, String status, ArrayList<Product> products) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		Status = status;
		this.products = products;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public void displayOrderInfo() {
		System.out.printf("%-10s | %-16s | $%.2f\n", getOrderId(), getOrderDate(), calculateTotalPrice());
	}
	
	public double calculateTotalPrice() {
		double totalPrice = 0.0;
		
		for (Product product : products) {
			totalPrice += product.price;
		}
		
		return totalPrice;
		
	}
	
	public void processOrder() {
		System.out.println("Your order has been placed!");
	}
}
