package controller;

import model.Checklist;
import model.Material;

public interface WorkcardControllerIF {
	public void createWorkcard(int taskId, int fitterId);
	public void updateWorkcard(int hours, int overtimeHours, String comment);
	public void updateChecklist(Checklist checklist);
	public Material findMaterial(String inputMaterialName);
	public void addMaterial(Material m, int qty);
	public void deleteWorkcard();
}
