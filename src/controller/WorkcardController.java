package controller;

import dbo.WorkcardDB;
import dbo.WorkcardDBIF;
import model.Checklist;
import model.Material;
import model.MaterialLine;
import model.Workcard;

public class WorkcardController implements WorkcardControllerIF {
	private Workcard workcard;
	private WorkcardDBIF workcardDB = new WorkcardDB();
	
	public void createWorkcard(int taskId, int fitterId) {
		workcard = new Workcard();
		workcard.setTaskId(taskId);
		workcard.setFitterId(fitterId);
	}
	
	public void updateWorkcard() {
		workcardDB.updateWorkcard(workcard);
	}
	
	public void addHours(int hours, int overtimeHours,String comment) {
		if(hours >0 && hours<25 && overtimeHours >0 && overtimeHours<25 && comment!=null) {
			workcard.setNormalHours(hours);
			workcard.setOvertimeHours(overtimeHours);
			workcard.setComment(comment);
			
		}
	}

	
	public void updateChecklist(Checklist checklist) {
		workcard.setChecklist(checklist);
	}

	
	public Material findMaterial(String inputMaterialName) {
		MaterialController mController = new MaterialController();
		
		return mController.findMaterial(inputMaterialName);
	}

	
	public void addMaterial(Material m, int qty) {
		MaterialLine ml = new MaterialLine(m,qty);
		workcard.addMaterialLine(ml);
		
	}
	
	public void addMaterialLines() {
		workcardDB.addMaterialLines(workcard);
	}

	public void addWorkcard() {
		int id = workcardDB.addWorkcard(workcard);
		workcard.setWorkcardId(id);
	}
	public void deleteWorkcard() {
		workcardDB.deleteWorkcard(workcard.getWorkcardId());
	}
	
	public Workcard findWorkcard(int workcardId) {
		workcard = workcardDB.findWorkcard(workcardId);
		return workcard;
	}
	
	public Workcard testGetWorkcard() {
		return workcard;
	}

}
