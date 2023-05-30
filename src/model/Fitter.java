package model;

public class Fitter {
	private int fitterId;
	private String name;
	private String phoneNumber;
	private String address;
	private String position;
	private String password;
	
	
	public Fitter(int fitterId, String name, String phoneNumber, String address, String position, String password) {
		this.fitterId = fitterId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
		this.password = password;
	}

	public int getFitterId() {
		return fitterId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
