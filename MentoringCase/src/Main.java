import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		System.out.print("Input board size: ");
		int size = scan.nextInt();
		scan.nextLine();
		System.out.println();
		
		char[][] boardGame = new char[size][size];
		boolean[][] check = new boolean[size][size];
		
		for(int i=0; i<size; i++) {
			Arrays.fill(check[i], false);
		}
		
		Board board = new Board(size, boardGame);
		board.initializeArray();
		
		Player p = new Player(0, 0);
		board.boardGame[p.getPosX()][p.getPosY()] = p.getIcon();
		check[p.getPosX()][p.getPosY()] = true;
		
		int gold = size/2;
		System.out.println("Gold to be collected: " + gold);
		for(int i=0; i<gold; i++) {
			int x, y;
			do {
				x = random.nextInt(size);
				y = random.nextInt(size);				
			} while(check[x][y] == true);
			Gold g = new Gold(x, y);
			board.boardGame[g.getPosX()][g.getPosY()] = g.getIcon();
		}
		
		board.printArray();
		
		do {
			System.out.print("Input w/a/s/d: ");
			char command = scan.nextLine().charAt(0);
			board.boardGame[p.getPosX()][p.getPosY()] = ' ';
			System.out.println();
		
			if(command == 'w') {
				if(p.getPosX()-1 >= 0 && p.getPosX()-1 < size) {
					p.setPosX(p.getPosX()-1);
				}
			}
			else if(command == 'a') {
				if(p.getPosY()-1 >= 0 && p.getPosY()-1 < size) {
					p.setPosY(p.getPosY()-1);
				}
			}
			else if(command == 's') {
				if(p.getPosX()+1 >= 0 && p.getPosX()+1 < size) {
					p.setPosX(p.getPosX()+1);
				}
			}
			else if(command == 'd') {
				if(p.getPosY()+1 >= 0 && p.getPosY()+1 < size) {
					p.setPosY(p.getPosY()+1);
				}
			}
			
			if(boardGame[p.getPosX()][p.getPosY()] == 'G') {
				gold--;
			}
			
			board.boardGame[p.getPosX()][p.getPosY()] = p.getIcon();
			
			System.out.println("Gold to be collected: " + gold);

			board.printArray();
		} while(gold != 0);
		
		System.out.println("Game Over!");
	}

}
