package model;

public class MaterialLine {
	private Material m;
	private int qty;
	public MaterialLine(Material m, int qty) {
		this.m = m;
		this.qty = qty;
	}
	public Material getM() {
		return m;
	}
	public void setM(Material m) {
		this.m = m;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
