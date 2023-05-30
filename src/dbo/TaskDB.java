package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Task;

public class TaskDB implements TaskDBIF {

	private static final String addTaskStmt ="INSERT INTO Task(Information, Date,TaskType,Status,CustomerID) VALUES (?,?,?,?,?)";
	private static final String deleteTaskStmt = "DELETE FROM Task WHERE TaskID = ?";
	private static final String updateTaskStmt = "UPDATE Task SET Information = ?, CustomerID = ? WHERE TaskID = ?";
	private static final String findTaskStmt = "SELECT * FROM Task WHERE TaskID = ?";
	private static final String findAllTaskStmt = "SELECT * FROM Task";
	private PreparedStatement taskStmt;
	@Override
	public void addTask(Task newTask) {
		try {
			taskStmt = DBConnection.getInstance().getDBCon().prepareStatement(addTaskStmt);
			taskStmt.setString(1, newTask.getInformation());
			taskStmt.setDate(2, new java.sql.Date(newTask.getDate().getTime()));
			taskStmt.setString(3, newTask.getTaskType());
			taskStmt.setString(4, newTask.getStatus());
			taskStmt.setInt(5, newTask.getCustomerId());
			taskStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Task> getAllTasks(){
		ArrayList<Task> tasks = new ArrayList<Task>();
		try {
			taskStmt = DBConnection.getInstance().getDBCon().prepareStatement(findAllTaskStmt);
			ResultSet rs = taskStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String information = rs.getString(2);
				Date date = rs.getDate(3);
				String taskType = rs.getString(4);
				String status = rs.getString(5);
				int customerId = rs.getInt(6);
				tasks.add(new Task(id,information, date,taskType,status,customerId));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	
	private Task buildObject(ResultSet rs) {
		Task task = null;
		try {
			if(rs.next()) {
				int id = rs.getInt(1);
				String information = rs.getString(2);
				Date date = rs.getDate(3);
				String taskType = rs.getString(4);
				String status = rs.getString(5);
				int customerId = rs.getInt(6);
				task = new Task(id,information, date,taskType,status,customerId);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return task;
		
	}


	@Override
	public void updateTask(Task newTask) {
		try {
			taskStmt = DBConnection.getInstance().getDBCon().prepareStatement(updateTaskStmt);
			taskStmt.setString(1,newTask.getInformation());
			taskStmt.setInt(2, newTask.getCustomerId());
			taskStmt.setInt(3, newTask.getTaskId());
			taskStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteTask(int taskId) {
		try {
			taskStmt = DBConnection.getInstance().getDBCon().prepareStatement(deleteTaskStmt);
			taskStmt.setInt(1, taskId);
			taskStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public Task findTask(int taskId) {
		ResultSet rs = null;
		try {
			taskStmt = DBConnection.getInstance().getDBCon().prepareStatement(findTaskStmt);
			taskStmt.setInt(1, taskId);
			rs = taskStmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return buildObject(rs);
	}

}
