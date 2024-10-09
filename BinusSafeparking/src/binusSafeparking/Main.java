package binusSafeparking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ClearScreen cls = new ClearScreen();
	EnterConfirmation enter = new EnterConfirmation();
	ArrayList<Vehicle> vehicle = new ArrayList<>();

	public void Main() {
		Boolean runMain = true;
		Integer menu;
		do {
			cls.ClearScreen();
			System.out.println("1. View Parked Vehicle");
			System.out.println("2. Vehicle In");
			System.out.println("3. Vehicle Out");
			System.out.println("4. Back to Login Page");
			System.out.print(">> ");
			try {
				menu = scan.nextInt();
				scan.nextLine();
				
				switch (menu) {
				case 1:
					viewParked();
					break;
					
				case 2:
					vehicleIn();
					break;
				
				case 3:
					viewParked();
					if (!vehicle.isEmpty()) {
						vehicleOut();
					}
					break;
					
				case 4:
					runMain = false;
					break;

				default:
					System.out.println("@@ Input must be 1-4");
					break;
				}
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("@@ Input must be a number");
			}
			enter.EnterConfirmation();
		} while (runMain);
			
	}
	
	public void viewParked() {
		cls.ClearScreen();
		System.out.println("Parked Vehicle List");
		System.out.println("============================");
		if (vehicle.isEmpty()) {
			System.out.println("\nThere is no Parked Vehicle!!!");
		} else {
			for (int i = 0; i < vehicle.size(); i++) {
				System.out.println((i + 1) + ". " + vehicle.get(i).getType() + ", " + vehicle.get(i).getPlateNum() + ",");
				System.out.println(" @ Time In : " + vehicle.get(i).getTimeIn() + " | Time Out : " + vehicle.get(i).getTimeOut());
			}
		}
	}
	
	public boolean validateInHour(Integer inHour) {
		if((inHour >= 0) && (inHour <= 23)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateInMin(Integer inMin) {
		if((inMin >= 0) && (inMin <= 59)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateType(String type) {
		if (type.equalsIgnoreCase("Motor") || type.equalsIgnoreCase("Mobil")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validatePlateNum(String plateNum) {
		if (plateNum.matches("^[A-Z]\\s\\d{4}\\s[A-Z]{3}$")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void vehicleIn() {
		cls.ClearScreen();
		
		String timeIn;
		
		Integer inHour = 0;
		do {
			System.out.print("Input the Hour Vehicle In [0-23]: ");
			try {
				inHour = scan.nextInt();
				scan.nextLine();
				if (!validateInHour(inHour)) {
					System.out.println("@@ the Inputted Hour Vehicle In does not match");
				} else {
					break;
				}
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("@@ the Inputted Hour Vehicle In does not match");
			}
		} while (true);
		if ((inHour >= 0) && (inHour <= 9)) {
			timeIn = ("0" + inHour);
		} else {
			timeIn = inHour.toString();
		}
		timeIn += ".";
		Integer inMin = 0;
		do {
			System.out.print("Input the Minute Vehicle In [0-59]: ");
			try {
				inMin = scan.nextInt();
				scan.nextLine();
				if (!validateInMin(inMin)) {
					System.out.println("@@ the Inputted Minute Vehicle In does not match");
				} else {
					break;
				}
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("@@ the Inputted Minute Vehicle In does not match");
			}
		} while (true);
		if ((inMin >= 0) && (inMin <= 9)) {
			timeIn += ("0" + inMin);
		} else {
			timeIn += inMin.toString();
		}
		
		String type = "";
		do {
			System.out.print("Input the Vehicle Type [Motor | Mobil] : ");
			try {
				type = scan.nextLine();
				if (!validateType(type)) {
					System.out.println("@@ You can only input \"Motor\" or \"Mobil\"");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("@@ You can only input \"Motor\" or \"Mobil\"");
			}
		} while (true);
		
		String plateNum = "";
		do {
			System.out.print("Input the plate Number ex. [B 1234 BIN] : ");
			try {
				plateNum = scan.nextLine();
				if (!validatePlateNum(plateNum)) {
					System.out.println("@@ the Inputted plate number does not match");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("@@ the Inputted plate number does not match");
			}
		} while (true);
		
		if (type.equalsIgnoreCase("Mobil")) {
			vehicle.add(new Vehicle("mobil", plateNum, timeIn, "-"));
		} else {
			vehicle.add(new Vehicle("motor", plateNum, timeIn, "-"));
		}
		
	}
	
	public boolean validateVehicleOut(Integer vhc) {
		if(((vhc - 1) >= 0) && ((vhc - 1) < vehicle.size())) {
			if(vehicle.get(vhc - 1).getTimeOut().equals("-")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateOutHour(Integer outHour) {
		if((outHour >= 0) && (outHour <= 23)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void vehicleOut() {
		System.out.println("\nVehicle Out");
		
		Integer vhc;
		do {
			System.out.print("Choose vehicle: ");
			try {
				vhc = scan.nextInt();
				scan.nextLine();
				if (!validateVehicleOut(vhc)) {
					System.out.println("@@ Input must be 1-" + vehicle.size());
				} else {
					break;
				}
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("@@ Input must be a number");
			}
		} while (true);
		
		String timeOut;
		Integer outHour;
		do {
			System.out.print("Input the Hour Vehicle Out [0-23]: ");
			try {
				outHour = scan.nextInt();
				scan.nextLine();
				if (!validateOutHour(outHour)) {
					System.out.println("@@ the Inputted Hour Vehicle Out does not match");
				} else {
					break;
				}
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("@@ the Inputted Hour Vehicle Out does not match");
			}
		} while (true);
		
		if ((outHour >= 0) && (outHour <= 9)) {
			timeOut = ("0" + outHour + ".00");
		} else {
			timeOut = (outHour + ".00");
		}
		
		vehicle.get(vhc - 1).setTimeOut(timeOut);
	}

}
