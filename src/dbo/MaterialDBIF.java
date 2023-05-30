package dbo;

import model.Material;

public interface MaterialDBIF {
	public Material findMaterial(String inputMaterialName);
}
