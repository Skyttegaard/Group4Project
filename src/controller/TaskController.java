package controller;

import dbo.TaskDBIF;
import model.Customer;
import model.Task;

public class TaskController implements TaskControllerIF{

	private Task newTask;
	private TaskDBIF taskDB;
	
	@Override
	public void createTask() {
		newTask = new Task();
	}

	@Override
	public void addCustomer(String phoneNumber) {
		newTask.setPhoneNumber(phoneNumber);
		
	}

	@Override
	public void addChecklist(String taskType) {
		newTask.setTaskType(taskType);
	}

	@Override
	public void addInformation(String information) {
		newTask.setInformation(information);
		
	}
	
}
