package dbo;

import model.Customer;

public interface CustomerDBIF {
	public Customer findCustomer(String phoneNumber);
}
