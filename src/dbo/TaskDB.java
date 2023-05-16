package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Task;

public class TaskDB implements TaskDBIF {

	private static final String addTaskStmt ="";
	private PreparedStatement addTask;
	@Override
	public void addTask(Task newTask) {
		// TODO Auto-generated method stub
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
				String phoneNumber = rs.getString(6);
				task = new Task(id,information, date,taskType,status,phoneNumber);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return task;
		
	}

}
