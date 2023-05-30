package dbo;

import model.Task;

public interface TaskDBIF {
	public void addTask(Task newTask);
	public void updateTask(Task newTask);
	public void deleteTask(int taskId);
	public Task findTask(int taskId);
}
