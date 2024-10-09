package binusSafeparking;

import java.util.Scanner;

public class Welcome {
	Scanner scan = new Scanner(System.in);
	ClearScreen cls = new ClearScreen();
	EnterConfirmation enter = new EnterConfirmation();
	Main main = new Main();

	public static void main(String[] args) {
		new Welcome();

	}
	
	public Welcome() {
		Boolean runWelcome = true;
		Integer menu = 0;
		do {
			cls.ClearScreen();
			System.out.println("          Binus safepArkIng\n");
			System.out.println("1. Login");
			System.out.println("2. Exit");
			System.out.print(">> ");
			try {
				menu = scan.nextInt();
				scan.nextLine();
				
				switch (menu) {
				case 1:
					login();
					main.Main();
					break;
				
				case 2:
					runWelcome = false;
					break;

				default:
					System.out.println("@@ Input must be 1-2");
					break;
				}
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("@@ Input must be a number");
			}
			enter.EnterConfirmation();
			
			if (menu == 2) {
				cls.ClearScreen();
				System.out.println("Thank you for using the program, have a great day :D");
			}
			
		} while (runWelcome);
	}
	
	public boolean validateLogin(String username, String password) {
		if(username.equalsIgnoreCase("admin") && password.equals("binusSafeParking")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void login() {
		String username = "", password = "";
		do {
			cls.ClearScreen();
			System.out.print("Username : ");
			try {
				username = scan.nextLine();
				
				System.out.print("Password : ");
				try {
					password = scan.nextLine();
					
					if (!validateLogin(username, password)) {
						System.out.println("@@ the Inputted username and password do not match");
					} else {
						break;
					}
				} catch (Exception e) {
					System.out.println("@@ Input must be a string");
				}
			} catch (Exception e) {
				System.out.println("@@ Input must be a string");
			}
			enter.EnterConfirmation();
		} while (true);
	}

}
