package model;

public class Private extends Customer{

	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Private(int customerId, String address, String mail, String phoneNumber, String comment, String firstName, String lastName) {
		super(customerId, address, mail, phoneNumber, comment);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
