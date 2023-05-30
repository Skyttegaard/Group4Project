package dbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Checklist;
import model.MaterialLine;
import model.Workcard;

public class WorkcardDB implements WorkcardDBIF{

	private static final String findWorkcardStmt = "SELECT * FROM Workcard WHERE WorkcardID = ?";
	private static final String deleteWorkcardStmt = "DELETE FROM Workcard WHERE WorkcardID = ?";
	private static final String updateWorkcardStmt = "UPDATE Workcard SET NormalHours = ?, OvertimeHours = ?, Comments = ?, Checklist = ?, Status = ? WHERE WorkcardID = ?";
	private static final String addWorkcardStmt = "INSERT INTO Workcard(NormalHours,OvertimeHours,Comments,Checklist,Status,TaskID,FitterID) VALUES (?,?,?,?,?,?,?)";
	private static final String addMaterialLineStmt = "INSERT INTO MaterialLine(Quantity,MaterialID,WorkcardID) VALUES (?,?,?)";
	
	private PreparedStatement workcardStmt;
	public Workcard findWorkcard(int workcardId) {
		ResultSet rs = null;
		try {
			workcardStmt= DBConnection.getInstance().getDBCon().prepareStatement(findWorkcardStmt);
			workcardStmt.setInt(1, workcardId);
			rs = workcardStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildObject(rs);
	}
	
	private Workcard buildObject(ResultSet rs) {
		Workcard workcard = null;
		try {
			if(rs.next()) {
				int id = rs.getInt(1);
				int normalHours = rs.getInt(2);
				int overTimeHours = rs.getInt(3);
				String comment = rs.getString(4);
				Checklist checklist = new Checklist(rs.getString(5));
				String status = rs.getString(6);
				int taskId = rs.getInt(7);
				int fitterId = rs.getInt(8);
				workcard = new Workcard(id,normalHours,overTimeHours,comment,checklist,status,taskId,fitterId);
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return workcard;
		
	}

	@Override
	public void deleteWorkcard(int workcardId) {
		try {
			workcardStmt = DBConnection.getInstance().getDBCon().prepareStatement(deleteWorkcardStmt);
			workcardStmt.setInt(1, workcardId);
			workcardStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateWorkcard(Workcard workcard) {
		try {
			workcardStmt = DBConnection.getInstance().getDBCon().prepareStatement(updateWorkcardStmt);
			workcardStmt.setInt(1, workcard.getNormalHours());
			workcardStmt.setInt(2, workcard.getOvertimeHours());
			workcardStmt.setString(3, workcard.getComment());
			workcardStmt.setString(4, workcard.getChecklist().getChecklist());
			workcardStmt.setString(5, workcard.getStatus());
			workcardStmt.setInt(6, workcard.getWorkcardId());
			workcardStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addMaterialLines(Workcard workcard) {
		DBConnection.getInstance().startTransaction();
		
		try {
			workcardStmt = DBConnection.getInstance().getDBCon().prepareStatement(addMaterialLineStmt);
			for(MaterialLine m : workcard.getMaterialLines()) {
				workcardStmt.setInt(1, m.getQty());
				workcardStmt.setInt(2, m.getM().getMaterialId());
				workcardStmt.setInt(3, workcard.getWorkcardId());
				workcardStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			DBConnection.getInstance().rollbackTransaction();
		} finally {
			DBConnection.getInstance().commitTransaction();
		}
		
	}

	@Override
	public int addWorkcard(Workcard workcard) {
		int generatedKey = 0;
		try {
			workcardStmt = DBConnection.getInstance().getDBCon().prepareStatement(addWorkcardStmt, Statement.RETURN_GENERATED_KEYS);
			workcardStmt.setInt(1, workcard.getNormalHours());
			workcardStmt.setInt(2, workcard.getOvertimeHours());
			workcardStmt.setString(3, workcard.getComment());
			workcardStmt.setString(4, workcard.getChecklist().getChecklist());
			workcardStmt.setString(5, workcard.getStatus());
			workcardStmt.setInt(6, workcard.getTaskId());
			workcardStmt.setInt(7, workcard.getFitterId());
			workcardStmt.executeUpdate();
			ResultSet rs = workcardStmt.getGeneratedKeys();
			generatedKey = rs.getInt(1);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return generatedKey;
	}
	
}
