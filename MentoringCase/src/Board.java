import java.util.Arrays;

public class Board {
	int size;
	char[][] boardGame = new char[size][size];
	
	public Board(int size, char[][] boardGame) {
		super();
		this.size = size;
		this.boardGame = boardGame;
	}
	
	public void initializeArray() {
		for(int i=0; i<size; i++) {
			Arrays.fill(boardGame[i], ' ');			
		}
	}
	
	public void printArray() {
		System.out.print("=");
		for(int j=0; j<size; j++) {
			System.out.print("=");
		}
		System.out.println("=");
		
		for(int i=0; i<size; i++) {
			System.out.print("=");
			for(int j=0; j<size; j++) {
				System.out.print(boardGame[i][j]);
			}
			System.out.println("=");
		}
		
		System.out.print("=");
		for(int j=0; j<size; j++) {
			System.out.print("=");
		}
		System.out.println("=");
	}
}
