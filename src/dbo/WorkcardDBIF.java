package dbo;

import model.Workcard;

public interface WorkcardDBIF {
	public Workcard findWorkcard(int workcardId);
	public void deleteWorkcard(int workcardId);
	public void updateWorkcard(Workcard workcard);
	public void addMaterialLines(Workcard workcard);
	public int addWorkcard(Workcard workcard);
}
