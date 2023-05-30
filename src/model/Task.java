package model;

import java.util.Date;

public class Task {
	private int taskId;
	private String information;
	private Date date;
	private String taskType;
	private String status;
	private int customerId;
	
	public Task(int taskId, String information, Date date, String taskType, String status, int customerId) {
		this.taskId = taskId;
		this.information = information;
		this.date = date;
		this.taskType = taskType;
		this.status = status;
		this.customerId = customerId;
	}
	public Task() {
		date = new Date();
		status = "New";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTaskId() {
		return taskId;
	}
	
	
}
