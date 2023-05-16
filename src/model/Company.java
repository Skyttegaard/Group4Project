package model;

public class Company extends Customer{

	private String companyName;
	private int CVR;
	private String contactPerson;
	public Company(int customerId, String address, String mail, String phoneNumber, String comment, String companyName, int CVR, String contactPerson) {
		super(customerId, address, mail, phoneNumber, comment);
		this.companyName = companyName;
		this.CVR = CVR;
		this.contactPerson = contactPerson;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCVR() {
		return CVR;
	}
	public void setCVR(int cVR) {
		CVR = cVR;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	

}
