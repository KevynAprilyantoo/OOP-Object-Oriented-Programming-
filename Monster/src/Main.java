import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Scenario (Character has 500 HP and then 50 Gold Coin)");
		System.out.print("Enter the number of character that meets the enemies: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		
		int currHealthPoint = 500;
		int currGoldPoint = 50;
		
		for(int i=1; i<=num; i++) {
			System.out.print("Day " + i + ": ");
			String enemy = scan.nextLine();
			Monster m = new Monster(enemy, currHealthPoint, currGoldPoint);
			System.out.println("=> " + m.getHealthPoint() + "HP | " + m.getGoldPoint() + " Gold Points");
			currHealthPoint = m.getHealthPoint();
			currGoldPoint = m.getGoldPoint();
		}
		
		System.out.println();
		System.out.println("Total Reduce Health => " + (500-currHealthPoint) + " HP and getting " + (currGoldPoint-50) + " Gold Point.");
	}

}
