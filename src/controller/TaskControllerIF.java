package controller;

import model.Customer;
import model.Task;

public interface TaskControllerIF {
	public void createTask();
	
	public void addCustomer(int customerId);
	
	public void addChecklist(String taskType);
	
	public void addInformation(String information);
}
