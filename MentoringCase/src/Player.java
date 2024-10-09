
public class Player {
	private int posX;
	private int posY;
	private char icon;
	
	public Player(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.icon = 'P';
	}

	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public char getIcon() {
		return icon;
	}
	
	public void setIcon(char icon) {
		this.icon = icon;
	}
	
	
}
