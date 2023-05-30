package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Material;

public class MaterialDB implements MaterialDBIF {
	private static final String findMaterialStmt = "SELECT * FROM Material WHERE Name=?";
	private PreparedStatement findMaterial;
	
	public Material findMaterial(String inputMaterialName) {
		ResultSet rs = null;
		try {
			findMaterial = DBConnection.getInstance().getDBCon().prepareStatement(findMaterialStmt);
			findMaterial.setString(1, inputMaterialName);
			rs = findMaterial.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildObject(rs);
	}
	
	private Material buildObject(ResultSet rs) {
		Material m = null;
		try {
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				m = new Material(id,name);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	
}
