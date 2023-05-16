package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Company;
import model.Customer;
import model.Private;

public class CustomerDB implements CustomerDBIF{

	private static final String findCustomerStmt = "";
	private PreparedStatement findCustomer;
	
	@Override
	public Customer findCustomer(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Customer buildObject(ResultSet rs) {
		int id = 0;
		String address = null;
		String mail = null;
		String phoneNumber = null;
		String comment = null;
		String customerType = null;
		try {
			if(rs.next()) {
				id = rs.getInt(1);
				address = rs.getString(2);
				mail = rs.getString(3);
				phoneNumber = rs.getString(4);
				comment = rs.getString(5);
				customerType = rs.getString(6);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Customer customer = null;
		
		try {
			switch(customerType) {
			case "Private":
				String firstName = rs.getString(8);
				String lastName = rs.getString(9);
				customer = new Private(id,address,mail,phoneNumber,comment,firstName,lastName);
				break;
			case "Company":
				String companyName = rs.getString(8);
				int CVR = rs.getInt(9);
				String contactPerson = rs.getString(10);
				customer = new Company(id,address,mail,phoneNumber,comment,companyName,CVR,contactPerson);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
