package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Company;
import model.Customer;
import model.Private;

public class CustomerDB implements CustomerDBIF{

	private static final String findCustomerTypeStmt = "SELECT CustomerType, CustomerID FROM Customer WHERE PhoneNumber = ?";
	private static final String findCustomerStmt = "SELECT * FROM CUSTOMER INNER JOIN %s ON Customer.CustomerID = %s.CustomerID WHERE Customer.CustomerID = ?";
	private PreparedStatement findCustomer;
	
	@Override
	public Customer findCustomer(String phoneNumber) {
		ResultSet rs = null;
		String customerType = null;
		int customerId = 0;
		try {
			findCustomer = DBConnection.getInstance().getDBCon().prepareStatement(findCustomerTypeStmt);
			findCustomer.setString(1, phoneNumber);
			rs = findCustomer.executeQuery();
			if(rs.next()) {
				customerType = rs.getString(1);
				customerId = rs.getInt(2);
			}
			String s = String.format(findCustomerStmt, customerType,customerType);
			findCustomer = DBConnection.getInstance().getDBCon().prepareStatement(s);
			
			findCustomer.setInt(1, customerId);
			rs = findCustomer.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildObject(rs);
	}
	
	public List<Customer> findCustomers(String phoneNumberPrefix){
		
		
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
				String firstName = rs.getString(7);
				String lastName = rs.getString(8);
				customer = new Private(id,address,mail,phoneNumber,comment,firstName,lastName);
				break;
			case "Company":
				String companyName = rs.getString(7);
				int CVR = rs.getInt(8);
				String contactPerson = rs.getString(9);
				customer = new Company(id,address,mail,phoneNumber,comment,companyName,CVR,contactPerson);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
