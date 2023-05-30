package controller;

import model.Customer;
import model.Task;

public interface TaskControllerIF {
	public void createTask();
	
	public void addCustomer(int customerId);
	
	public void addChecklist(String taskType);
	
	public void addInformation(String information);
	
	public void changeCustomer(String phoneNumber);
	
	public void updateTask();
	
	public void updateInformation(String information);
	
	public void addTask();
	
	public void deleteTask(int taskId);
	
	public Task findTask(int taskId);
}
