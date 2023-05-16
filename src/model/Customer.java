package model;

public class Customer {
	
	private int customerId;
	private String address;
	private String mail;
	private String phoneNumber;
	private String comment;
	public Customer(int customerId, String address, String mail, String phoneNumber, String comment) {
		this.customerId = customerId;
		this.address = address;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.comment = comment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCustomerId() {
		return customerId;
	}
	
	

}
