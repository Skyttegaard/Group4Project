package controller;

import dbo.CustomerDBIF;
import model.Customer;

public class CustomerController implements CustomerControllerIF{

	private CustomerDBIF customerDB;
	@Override
	public Customer findCustomer(String phoneNumber) {
		Customer c = customerDB.findCustomer(phoneNumber);
		return c;
	}
	

}
