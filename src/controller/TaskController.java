package controller;

import dbo.TaskDB;
import dbo.TaskDBIF;
import model.Customer;
import model.Task;

public class TaskController implements TaskControllerIF{

	private Task newTask;
	private TaskDBIF taskDB = new TaskDB();
	
	public Task findTask(int taskId) {
		newTask = taskDB.findTask(taskId);
		return newTask;
	}
	@Override
	public void createTask() {
		newTask = new Task();
	}

	@Override
	public void addCustomer(int customerId) {
		newTask.setCustomerId(customerId);
		
	}

	@Override
	public void addChecklist(String taskType) {
		newTask.setTaskType(taskType);
	}

	@Override
	public void addInformation(String information) {
		newTask.setInformation(information);
		
	}

	@Override
	public void changeCustomer(String phoneNumber) {
		CustomerController c = new CustomerController();
		Customer customer = c.findCustomer(phoneNumber);
		newTask.setCustomerId(customer.getCustomerId());
	}

	

	@Override
	public void updateInformation(String information) {
		newTask.setInformation(information);
	}
	public void deleteTask(int taskId) {
		taskDB.deleteTask(taskId);
	}

	@Override
	public void updateTask() {
		taskDB.updateTask(newTask);
		
	}

	@Override
	public void addTask() {
		taskDB.addTask(newTask);
		
	}
	
}
