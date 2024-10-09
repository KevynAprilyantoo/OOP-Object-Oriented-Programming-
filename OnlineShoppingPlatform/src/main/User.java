package main;

public class User {
	String userId, username, email;

	public User(String userId, String username, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void displayUserInfo() {
		
	}
	
	public void updateEmail(String newEmail) {
		
	}
	
	public void placeOrder(Order order) {
		
	}
}
