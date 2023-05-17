package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Task;

public class TaskDB implements TaskDBIF {

	private static final String addTaskStmt ="INSERT INTO Task(Information, Date,TaskType,Status,CustomerID) VALUES (?,?,?,?,?)";
	private PreparedStatement addTask;
	@Override
	public void addTask(Task newTask) {
		try {
			addTask = DBConnection.getInstance().getDBCon().prepareStatement(addTaskStmt);
			addTask.setString(1, newTask.getInformation());
			addTask.setDate(2, new java.sql.Date(newTask.getDate().getTime()));
			addTask.setString(3, newTask.getTaskType());
			addTask.setString(4, newTask.getStatus());
			addTask.setInt(5, newTask.getCustomerId());
		}catch(SQLException e){
			e.printStackTrace();
		}
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

}
