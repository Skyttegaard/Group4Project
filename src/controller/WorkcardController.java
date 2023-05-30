package controller;

import dbo.WorkcardDBIF;
import model.Checklist;
import model.Material;
import model.MaterialLine;
import model.Workcard;

public class WorkcardController implements WorkcardControllerIF {
	private Workcard workcard;
	private WorkcardDBIF workcardDB;
	
	public void createWorkcard(int taskId, int fitterId) {
		workcard = new Workcard();
		workcard.setTaskId(taskId);
		workcard.setFitterId(fitterId);
	}
	
	public void updateWorkcard(int hours, int overtimeHours, String comment) {
		workcard.setNormalHours(hours);
		workcard.setOvertimeHours(overtimeHours);
		workcard.setComment(comment);
		workcardDB.updateWorkcard(workcard);
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

	public void addWordcard() {
		workcardDB.addWorkcard(workcard);
	}
	public void deleteWorkcard() {
		workcardDB.deleteWorkcard(workcard.getWorkcardId());
	}

}
