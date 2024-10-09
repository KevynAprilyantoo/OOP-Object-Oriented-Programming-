package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class ShoppingSystem {

	Scanner scan = new Scanner(System.in);
	
	ArrayList<Product> products = new ArrayList<>();
	ArrayList<User> users = new ArrayList<>();
	
	int userIdx = -1;
	
	public static void main(String[] args) {
		new ShoppingSystem();

	}
	
	public ShoppingSystem() {
        users.add(new Customer("C003", "mike_jones", "mike.jones@email.com", "789 Pine Road, Villagetown"));

        products.add(new Clothing("P001", "T-Shirt - Blue", 19.99, "M", 144));
        products.add(new Clothing("P002", "Jeans - Slim Fit", 39.99, "32/34", 144));
        products.add(new Electronics("P003", "Smartphone - Model X", 499.99, "TechCo", 2));
        products.add(new Electronics("P004", "Laptop - UltraBook", 899.99, "MegaElect", 2));
        products.add(new Clothing("P005", "Sneakers - Sports", 59.99, "9", 20));
        products.add(new Electronics("P007", "Smartwatch - Fitness", 129.99, "FitTech", 5));

        System.out.println("=== Online Shopping Platform ===");

        String customerId;
        boolean runInputCustomerId = true;
        do {
            System.out.print("Input Customer ID: ");
            customerId = scan.nextLine();

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserId().equals(customerId)) {
                    userIdx = i;

                    displayMainMenu();
                    
                    runInputCustomerId = false;

                    break;
                }
            }
        } while (runInputCustomerId);
    }
	
	public void displayMainMenu() {
		boolean runMainMenu = true;
		do {
			System.out.println("=== Online Shopping Platform ===");
			
			int mainMenuChoice = -1;
			System.out.println("1. Shop for Products");
			System.out.println("2. View Shopping Cart");
			System.out.println("3. View Orders");
			System.out.println("4. Customer Info");
			System.out.println("5. Exit");
			
			do {
				try {
					System.out.print("Your Choice: ");
					mainMenuChoice = scan.nextInt();
					scan.nextLine();
					
					switch (mainMenuChoice) {
						case 1: {
							displayProductMenu();
							
							break;
						}
						
						case 2: {
							displayCartMenu();
							
							break;
						}
						
						case 3: {
							displayOrdersMenu();
							
							break;
						}
						
						case 4: {
							displayCustomerInfo();
							
							break;
						}
						
						case 5: {
							exit();
							
							runMainMenu = false;
							
							break;
						}
					}
				} catch (Exception e) {
					scan.nextLine();
					System.out.println("Input must be a number!");
					System.out.print("Press Enter to continue...");
					scan.nextLine();
				}
			} while ((mainMenuChoice < 1) || (mainMenuChoice > 5));
			System.out.println("");
		} while (runMainMenu);
	}
	
	public void displayProductMenu() {
		boolean runProductMenu = true;
		do {
			System.out.println("=== Shop for Products ===");
			
			int productMenuChoice = -1;
			System.out.println("1. View All Products");
			System.out.println("2. Add Clothing to Cart");
			System.out.println("3. Add Electronics to Cart");
			System.out.println("4. Back to Main Menu");
			
			do {
				try {
					System.out.print("Your Choice: ");
					productMenuChoice = scan.nextInt();
					scan.nextLine();
					
					switch (productMenuChoice) {
						case 1: {
							System.out.println("=== View All Products ===");
							System.out.println("ID   | Product Name           | Price   | Availability");
							System.out.println("------------------------------------------------------");
							for (Product product : products) {
								displayProductInfo(product);
							}
							System.out.println("------------------------------------------------------");
							
							for (int i = 0; i < 2; i++) {
								System.out.println();
							}
							
							System.out.print("Press Enter to go back to Shop for Products Menu...");
							scan.nextLine();
							
							break;
						}
						
						case 2: {
							System.out.println("=== Add Clothing to Cart ===");
							System.out.println("ID   | Clothing Name          | Price   | Size   | Availability");
							System.out.println("---------------------------------------------------------------");
							for (Product product : products) {
								if (product instanceof Clothing) {
									((Clothing) product).displayProductInfo();
								}
							}
							System.out.println("---------------------------------------------------------------");
							
							
							for (int i = 0; i < 2; i++) {
								System.out.println();
							}
							
							String productIdToAdd = "";
							boolean runInputProductIdToAdd = true;
							do {
								System.out.print("Enter the ID to add to your cart (or type 'back' to go back): ");
								productIdToAdd = scan.nextLine();
								
								if (productIdToAdd.equals("back")) {
									runInputProductIdToAdd = false;
									
									break;
								} else {
									for (Product product : products) {
										if (product instanceof Clothing && product.getProductId().equals(productIdToAdd)) {
											((Customer) users.get(userIdx)).addToCart(product);
											
											for (int i = 0; i < 2; i++) {
												System.out.println();
											}
											
											System.out.println("The Product has been added to your cart!");
											System.out.print("Press Enter to continue");
											scan.nextLine();
											
											runInputProductIdToAdd = false;
											
											break;
										}
									}
								}
									
							} while (runInputProductIdToAdd);
							
							break;
						}
						
						case 3: {
							System.out.println("=== Add Electronics to Cart ===");
							System.out.println("ID   | Electronics Name       | Price   | Brand       | Availability");
							System.out.println("--------------------------------------------------------------------");
							for (Product product : products) {
								if (product instanceof Electronics) {
									((Electronics) product).displayProductInfo();
								}
							}
							System.out.println("--------------------------------------------------------------------");
							
							
							for (int i = 0; i < 2; i++) {
								System.out.println();
							}
							
							String productIdToAdd = "";
							boolean runInputProductIdToAdd = true;
							do {
								System.out.print("Enter the ID to add to your cart (or type 'back' to go back): ");
								productIdToAdd = scan.nextLine();
								
								if (productIdToAdd.equals("back")) {
									runInputProductIdToAdd = false;
									
									break;
								} else {
									for (Product product : products) {
										if (product instanceof Electronics && product.getProductId().equals(productIdToAdd)) {
											((Customer) users.get(userIdx)).addToCart(product);
											
											for (int i = 0; i < 2; i++) {
												System.out.println();
											}
											
											System.out.println("The Product has been added to your cart!");
											System.out.print("Press Enter to continue");
											scan.nextLine();
											
											runInputProductIdToAdd = false;
											
											break;
										}
									}
								}
									
							} while (runInputProductIdToAdd);
							
							break;
						}
						
						case 4: {
							System.out.print("Press Enter to go back to Main Menu...");
							scan.nextLine();
							
							runProductMenu = false;
							
							break;
						}
					}
				} catch (Exception e) {
					scan.nextLine();
					System.out.println("Input must be a number!");
					System.out.print("Press Enter to continue...");
					scan.nextLine();
				}
			} while ((productMenuChoice < 1) || (productMenuChoice > 4));
		} while (runProductMenu);
	}
	
	public void displayCartMenu() {
		boolean runCartMenu = true;
		do {
			System.out.println("=== View Shopping Cart ===");
			
			int cartMenuChoice = -1;
			System.out.println("1. View Cart Contents");
			System.out.println("2. Checkout");
			System.out.println("3. Back to Main Menu");
			
			do {
				try {
					System.out.print("Your Choice: ");
					cartMenuChoice = scan.nextInt();
					scan.nextLine();
					
					switch (cartMenuChoice) {
						case 1: {
							System.out.println("=== View Cart Contents ===");
							System.out.println("Review your order:");
							System.out.println("ID   | Product Name           | Price");
							System.out.println("----------------------------------------");
							((Customer) users.get(userIdx)).viewCart();
							System.out.println("----------------------------------------");
							
							for (int i = 0; i < 2; i++) {
								System.out.println();
							}
							
							double totalCartPrice = 0.0;
							for (Product cart : ((Customer) users.get(userIdx)).cart) {
								totalCartPrice += cart.price;
							}
							System.out.println("Total Price: $" + totalCartPrice);
							
							System.out.print("Press Enter to go back to View Shopping Cart Menu...");
							scan.nextLine();
							
							break;
						}
						
						case 2: {
							System.out.println("=== Checkout ===");
							System.out.println("Review your order:");
							System.out.println("ID   | Product Name           | Price");
							System.out.println("----------------------------------------");
							((Customer) users.get(userIdx)).viewCart();
							System.out.println("----------------------------------------");
							
							for (int i = 0; i < 2; i++) {
								System.out.println();
							}
							
							double totalCartPrice = 0.0;
							for (Product cart : ((Customer) users.get(userIdx)).cart) {
								totalCartPrice += cart.price;
							}
							System.out.println("Total Price: $" + totalCartPrice);
							
							String orderConfirmation = "";
							do {
								System.out.print("Do you want to proceed with the checkout? (Y/N): ");
								orderConfirmation = scan.nextLine();
								
								if (orderConfirmation.equals("Y")) {
									String orderNumber = String.format("%03d", (((Customer) users.get(userIdx)).orders.size() + 1));
									String orderId = "O" + orderNumber;
									
									LocalDate localDate = java.time.LocalDate.now();
									String orderDate = localDate.toString();
									
									String Status = "Ordered";
									
									ArrayList<Product> orderedProducts = new ArrayList<>();
									for (Product cart : ((Customer) users.get(userIdx)).cart) {
										for (Product product : products) {
											if (product.getProductId().equals(cart.productId)) {
												if (product instanceof Clothing) {
													((Clothing) product).quantityInStock--;
												} else {
													((Electronics) product).warrantyPeriod--;
												}
												
												break;
											}
										}
										
										orderedProducts.add(cart);
									}
									
									Order newOrder = new Order(orderId, orderDate, Status, orderedProducts);
									((Customer) users.get(userIdx)).placeOrder(newOrder);
									
									for (int i = 0; i < 2; i++) {
										System.out.println();
									}
									
									newOrder.processOrder();
									System.out.print("Press Enter to continue...");
									scan.nextLine();
								}
							} while (!orderConfirmation.equals("Y") && !orderConfirmation.equals("N"));
							
							break;
						}
						
						case 3: {
							System.out.print("Press Enter to go back to Main Menu...");
							scan.nextLine();
							
							runCartMenu = false;
							
							break;
						}
					}
				} catch (Exception e) {
					scan.nextLine();
					System.out.println("Input must be a number!");
					System.out.print("Press Enter to continue...");
					scan.nextLine();
				}
			} while ((cartMenuChoice < 1) || (cartMenuChoice > 3));
		} while (runCartMenu);
		
	}
	
	public void displayOrdersMenu() {
		boolean runOrdersMenu = true;
		do {
			System.out.println("=== View Orders ===");
			System.out.println("1. View Order History");
			System.out.println("2. Track Order");
			System.out.println("3. Back to Main Menu");
			
			int ordersMenuChoice = -1;
			do {
				try {
					System.out.print("Your Choice: ");
					ordersMenuChoice = scan.nextInt();
					scan.nextLine();
					
					switch (ordersMenuChoice) {
						case 1: {
							System.out.println("=== View Order History ===");
							System.out.println("Order ID   | Order Date       | Total Price");
							System.out.println("--------------------------------------------");
							for (Order orders : ((Customer) users.get(userIdx)).orders) {
								orders.displayOrderInfo();
							}
							System.out.println("--------------------------------------------");
							
							String orderIdToView = "";
							boolean runInputOrderIdToView = true;
							do {
								System.out.print("Enter the Order ID to view details (or type 'back' to go back): ");
								orderIdToView = scan.nextLine();
								
								if (orderIdToView.equals("back")) {
									runInputOrderIdToView = false;
									
									break;
								} else {
									for (Order orders : ((Customer) users.get(userIdx)).orders) {
										if (orders.getOrderId().equals(orderIdToView)) {
											System.out.println("=== Order Details ===");
											System.out.println("Order ID: " + orders.getOrderId());
											System.out.println("Order Date: " + orders.getOrderDate());
											System.out.println("Total Price: $" + orders.calculateTotalPrice());
											
											for (int i = 0; i < 2; i++) {
												System.out.println();
											}
											
											System.out.println("Order Items:");
											System.out.println("ID   | Product Name           | Price");
											System.out.println("----------------------------------------");
											for (Product orderProducts : orders.products) {
												System.out.printf("%-4s | %-22s | %.2f\n", orderProducts.getProductId(), orderProducts.getProductName(), orderProducts.price);
											}
											System.out.println("----------------------------------------");
											
											for (int i = 0; i < 2; i++) {
												System.out.println();
											}
											
											System.out.print("Press Enter to go back to View Order History...");
											scan.nextLine();
											
											runInputOrderIdToView = false;
											
											break;
										}
									}
								}
							} while (runInputOrderIdToView);
							
							break;
						}
						
						case 2: {
							System.out.println("=== Track Order ===");
							
							String orderIdToTrack = "";
							boolean runInputOrderIdToTrack = true;
							do {
								System.out.print("Enter the Order ID to track (or type 'back' to go back): ");
								orderIdToTrack = scan.nextLine();
								
								if (orderIdToTrack.equals("back")) {
									runInputOrderIdToTrack = false;
									
									break;
								} else {
									for (Order orders : ((Customer) users.get(userIdx)).orders) {
										if (orders.getOrderId().equals(orderIdToTrack)) {
											System.out.println("=== Order Tracking ===");
											System.out.println("Order ID: " + orders.getOrderId());
											System.out.println("Order Status: " + orders.getStatus());
											
											for (int i = 0; i < 2; i++) {
												System.out.println();
											}
											
											System.out.print("Press Enter to go back to Track Order Menu...");
											scan.nextLine();
											
											runInputOrderIdToTrack = false;
											
											break;
										}
									}
								}
							} while (runInputOrderIdToTrack);
							
							break;
						}
						
						case 3: {
							System.out.print("Press Enter to go back to Main Menu...");
							scan.nextLine();
							
							runOrdersMenu = false;
							
							break;
						}
					}
				} catch (Exception e) {
					scan.nextLine();
					System.out.println("Input must be a number!");
					System.out.print("Press Enter to continue...");
					scan.nextLine();
				}
			} while ((ordersMenuChoice < 1) || (ordersMenuChoice > 3));
		} while (runOrdersMenu);
	}
	
	public void displayCustomerInfo() {
		System.out.println("=== Customer Info ===");
		
		((Customer) users.get(userIdx)).displayCustomerInfo();
		
		System.out.print("Press Enter to back to Main Menu...");
		scan.nextLine();
	}
	
	public void exit() {
		System.out.print("Press Enter to Exit the program...");
		scan.nextLine();
	}
	
	public double getPrice(Product product) {
		if (product instanceof Clothing) {
			return ((Clothing) product).getPrice();
		} else {
			return ((Electronics) product).getPrice();
		}
		
	}
	
	public void displayProductInfo(Product product) {
		if (isAvailable(product)) {
			System.out.printf("%-4s | %-22s | $%-6.2f | %s\n", product.getProductId(), product.getProductName(), getPrice(product), "In Stock");
		}
	}

	
	public boolean isAvailable(Product product) {
		if (product instanceof Clothing) {
			if (((Clothing) product).quantityInStock > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			if (((Electronics) product).warrantyPeriod > 0) {
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	public void processOrder() {
		String orderNumber = String.format("%03d", ((Customer) users.get(userIdx)).orders.size());
		String orderId = "O" + orderNumber;
		
		LocalDate localDate = java.time.LocalDate.now();
		String orderDate = localDate.toString();
		
		String Status = "Ordered";
		
		ArrayList<Product> orderedProducts = new ArrayList<>();
		for (Product cart : ((Customer) users.get(userIdx)).cart) {
			for (Product product : products) {
				if (product.getProductId().equals(cart.productId)) {
					if (product instanceof Clothing) {
						((Clothing) product).quantityInStock--;
					} else {
						((Electronics) product).warrantyPeriod--;
					}
					
					break;
				}
			}
			
			orderedProducts.add(cart);
		}
		
		Order newOrder = new Order(orderId, orderDate, Status, orderedProducts);
		((Customer) users.get(userIdx)).placeOrder(newOrder);
		
		for (int i = 0; i < 2; i++) {
			System.out.println();
		}
		
		newOrder.processOrder();
	}

}
