package controller;

import dbo.MaterialDB;
import dbo.MaterialDBIF;
import model.Material;

public class MaterialController implements MaterialControllerIF {
	private MaterialDBIF materialDB = new MaterialDB();

	
	public Material findMaterial(String inputMaterialName) {
		return materialDB.findMaterial(inputMaterialName);
		
	}
}
