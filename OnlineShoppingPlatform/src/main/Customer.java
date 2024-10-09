package main;

import java.util.ArrayList;

public class Customer extends User {

	String address;
	ArrayList<Order> orders = new ArrayList<>();
	ArrayList<Product> cart = new ArrayList<>();
	
	public Customer(String userId, String username, String email, String address) {
		super(userId, username, email);
		this.address = address;
	}
	
	public Customer(String userId, String username, String email, String address, ArrayList<Order> orders,
			ArrayList<Product> cart) {
		super(userId, username, email);
		this.address = address;
		this.orders = orders;
		this.cart = cart;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Product> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}
	
	@Override
	public String getUserId() {
		
		return super.getUserId();
	}

	@Override
	public void setUserId(String userId) {
		
		super.setUserId(userId);
	}

	@Override
	public String getUsername() {
		
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		
		super.setUsername(username);
	}

	@Override
	public String getEmail() {
		
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		
		super.setEmail(email);
	}

	@Override
	public void displayUserInfo() {
		
		super.displayUserInfo();
	}

	@Override
	public void updateEmail(String newEmail) {
		
		super.updateEmail(newEmail);
	}

	@Override
	public void placeOrder(Order order) {
		
		orders.add(order);
	}

	public void displayCustomerInfo() {
		System.out.println("Customer ID: " + getUserId());
		System.out.println("Username   : " + getUsername());
		System.out.println("Email      : " + getEmail());
		System.out.println("Address    : " + getAddress());
	}
	
	public void addToCart(Product product) {
		cart.add(product);
	}
	
	public void viewCart() {
		for (Product cart : cart) {
			System.out.printf("%-4s | %-22s | %.2f\n", cart.productId, cart.productName, cart.price);
		}
	}
	
}
