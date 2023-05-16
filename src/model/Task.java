package model;

import java.util.Date;

public class Task {
	private int taskId;
	private String information;
	private Date date;
	private String taskType;
	private String status;
	private String phoneNumber;
	
	public Task(int taskId, String information, Date date, String taskType, String status, String phoneNumber) {
		this.taskId = taskId;
		this.information = information;
		this.date = date;
		this.taskType = taskType;
		this.status = status;
		this.phoneNumber = phoneNumber;
	}
	public Task() {
		
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
