
public class Monster extends ListMonster {
	private String name;
	private int healthPoint;
	private int goldPoint;
	
	public Monster(String name, int currHealthPoint, int currGoldPoint) {
		this.name = name;
		this.healthPoint = currHealthPoint;
		this.goldPoint = currGoldPoint;
		
		if(name.compareTo("Cocolia") == 0) {
			currHealthPoint -= 100;
			currGoldPoint += 30;
		}
		else if(name.compareTo("Kafka") == 0) {
			currHealthPoint -= 120;
			currGoldPoint += 100;
		}
		else if(name.compareTo("SilverGuard") == 0) {
			currHealthPoint -= 150;
			currGoldPoint += 50;
		}
		
		setHealthPoint(currHealthPoint);
		setGoldPoint(currGoldPoint);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealthPoint() {
		return healthPoint;
	}
	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}
	public int getGoldPoint() {
		return goldPoint;
	}
	public void setGoldPoint(int goldPoint) {
		this.goldPoint = goldPoint;
	}
		
}
