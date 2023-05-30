package model;

public class Material {
	private int materialId;
	private String name;
	public Material(int materialId, String name) {
		this.materialId = materialId;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaterialId() {
		return materialId;
	}
	
	
}
