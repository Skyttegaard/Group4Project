package controller;

import model.Checklist;
import model.Material;

public interface WorkcardControllerIF {
	public void createWorkcard(int taskId, int fitterId);
	public void updateWorkcard();
	public void addHours(int hours, int overtimeHours, String comment);
	public void updateChecklist(Checklist checklist);
	public Material findMaterial(String inputMaterialName);
	public void addMaterial(Material m, int qty);
	public void addMaterialLines();
	public void addWorkcard();
	public void deleteWorkcard();
	
}
