package binusSafeparking;

public class Vehicle {
	private String type;
	private String plateNum;
	private String timeIn;
	private String timeOut;
	public Vehicle(String type, String plateNum, String timeIn, String timeOut) {
		super();
		this.type = type;
		this.plateNum = plateNum;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
}
