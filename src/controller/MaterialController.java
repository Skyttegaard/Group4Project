package controller;

import dbo.MaterialDBIF;
import model.Material;

public class MaterialController implements MaterialControllerIF {
	private MaterialDBIF materialDB;

	
	public Material findMaterial(String inputMaterialName) {
		return materialDB.findMaterial(inputMaterialName);
		
	}
}
