package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Fitter;

public class FitterDB implements FitterDBIF{

	private static final String findFitterStmt = "SELECT * FROM Fitter WHERE FitterId = ?";
	private PreparedStatement findFitter;
	@Override
	public Fitter getFitter(int fitterId) {
		ResultSet rs = null;
		try {
			findFitter = DBConnection.getInstance().getDBCon().prepareStatement(findFitterStmt);
			findFitter.setInt(1, fitterId);
			rs = findFitter.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return buildObject(rs);
	}
	private Fitter buildObject(ResultSet rs) {
		Fitter fitter = null;
		try {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String phoneNumber = rs.getString(3);
			String address = rs.getString(4);
			String position = rs.getString(5);
			String password = rs.getString(6);
			fitter = new Fitter(id,name,phoneNumber,address,position, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return fitter;
	}

}
