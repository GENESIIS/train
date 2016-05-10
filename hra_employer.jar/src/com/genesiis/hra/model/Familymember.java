package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;

/**
 * 20160509 PN created Familymember.java Entity class.
 * 
 * 
 * **/
public class Familymember extends Employee {
	private String fmName;
	private String fmDateofbirth;
	private String fmRelationship;
	private String fmOccupation;
	private String fmWorkingplace;

	public String getFmname() {
		return fmName;
	}

	public void setFmname(String fmName) {
		this.fmName = fmName;
	}

	public String getFmdateofbirth() {
		return fmDateofbirth;
	}

	public void setFmdateofbirth(String fmDateofbirth) {
		this.fmDateofbirth = fmDateofbirth;
	}

	public String getFmrelationship() {
		return fmRelationship;
	}

	public void setFmrelationship(String fmRelationship) {
		this.fmRelationship = fmRelationship;
	}

	public String getFmoccupation() {
		return fmOccupation;
	}

	public void setFmoccupation(String fmOccupation) {
		this.fmOccupation = fmOccupation;
	}

	public String getFmWorkingplace() {
		return fmWorkingplace;
	}

	public void setFmWorkingplace(String fmWorkingplace) {
		this.fmWorkingplace = fmWorkingplace;
	}

	public Familymember() {
	}

	public Familymember(String fmName, String fmDateofbirth,
			String fmRelationship, String fmOccupation, String fmWorkingplace,
			String employeeEpf) {
		super();
		this.fmName = fmName;
		this.fmDateofbirth = fmDateofbirth;
		this.fmRelationship = fmRelationship;
		this.fmOccupation = fmOccupation;
		this.fmWorkingplace = fmWorkingplace;
		this.employeeEpf = employeeEpf;
	}

	@Override
	public String add(Object object) {
		String query = "INSERT INTO [HRA.FAMILY] (EMPLOYEEID, NAME, DATEOFBIRTH, RELATIONSHIP, "
				+ "OCCUPATION, PLACE, MODBY) VALUES (?, ?, ?, ?, ?, ?, ?)";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Familymember fm = (Familymember) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, fm.getEmployeeepf());
			preparedStatement.setString(2, fm.getFmname());
			preparedStatement.setString(3, fm.getFmdateofbirth());
			preparedStatement.setString(4, fm.getFmrelationship());
			preparedStatement.setString(5, fm.getFmoccupation());
			preparedStatement.setString(6, fm.getFmWorkingplace());
			preparedStatement.setString(7, "SYSTEM");

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return message;
	}
}
