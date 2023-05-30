package model;

import java.util.ArrayList;
import java.util.List;

public class Workcard {
	private int workcardId;
	private int normalHours;
	private int overtimeHours;
	private String comment;
	private Checklist checklist;
	private String status;
	private int fitterId;
	private int taskId;
	private List<MaterialLine> materials;
	public Workcard(int workcardId, int normalHours, int overtimeHours, String comment, Checklist checklist,
			String status, int taskId, int fitterId) {
		this.workcardId = workcardId;
		this.normalHours = normalHours;
		this.overtimeHours = overtimeHours;
		this.comment = comment;
		this.checklist = checklist;
		this.status = status;
		this.taskId = taskId;
		this.fitterId = fitterId;
		materials = new ArrayList<MaterialLine>();
	}
	public Workcard() {
		materials = new ArrayList<MaterialLine>();
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getFitterId() {
		return fitterId;
	}
	public void setFitterId(int fitterId) {
		this.fitterId = fitterId;
	}
	public int getNormalHours() {
		return normalHours;
	}
	public void setNormalHours(int normalHours) {
		this.normalHours = normalHours;
	}
	public int getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(int overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Checklist getChecklist() {
		return checklist;
	}
	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getWorkcardId() {
		return workcardId;
	}
	public void addMaterialLine (MaterialLine m) {
		materials.add(m);
	}
	public List<MaterialLine> getMaterialLines() {
		return new ArrayList<MaterialLine>(materials);
	}
	
	

}
