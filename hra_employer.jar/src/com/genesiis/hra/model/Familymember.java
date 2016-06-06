package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
import com.google.gson.Gson;

/**
 * 20160509 PN created Familymember.java Entity class.
 * 
 * **/
public class Familymember extends Employee {
	static Logger log = Logger.getLogger(Familymember.class.getName());

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
	public boolean isValid(Object object) {
		DataValidator validator = new DataValidator();
		Familymember fm = (Familymember) object;
		if ((validator.isValidString(fm.getFmname()) == true)
				&& (validator.isValidString(fm.getFmdateofbirth())) == true) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#add(java.lang.Object)
	 */
	public int add(Object object) {
		String query = "INSERT INTO [HRA.FAMILY] (EMPLOYEEID, NAME, DATEOFBIRTH, RELATIONSHIP, "
				+ "OCCUPATION, PLACE, MODBY) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		Familymember fm = (Familymember) object;
		int status = 0;

		try {
			conn = ConnectionManager.getConnection();
			//ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, fm.getEmployeeepf());
			ps.setString(2, fm.getFmname());
			ps.setString(3, fm.getFmdateofbirth());
			ps.setString(4, fm.getFmrelationship());
			ps.setString(5, fm.getFmoccupation());
			ps.setString(6, fm.getFmWorkingplace());
			ps.setString(7, "SYSTEM");

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				int generatedKey = 0;
				if (rs.next()) {
					generatedKey = rs.getInt(1);
				}
				status = generatedKey;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int update(Object object) {
		String query = "UPDATE [HRA.FAMILY] SET NAME=?, DATEOFBIRTH=?, RELATIONSHIP=?,OCCUPATION=?, PLACE=?, MODBY=? WHERE ID=?";
		int status = -1;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Familymember fm = (Familymember) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, fm.getFmname());
			preparedStatement.setString(2, fm.getFmdateofbirth());
			preparedStatement.setString(3, fm.getFmrelationship());
			preparedStatement.setString(4, fm.getFmoccupation());
			preparedStatement.setString(5, fm.getFmWorkingplace());
			preparedStatement.setString(6, "SYSTEM");
			preparedStatement.setString(7, "2");

			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
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
		return status;
	}

	@Override
	public String getEmployee(int emploeeId) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Familymember fm = new Familymember();
		String Familymember = null;
		Gson gson = new Gson();
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn
					.prepareStatement("SELECT * FROM [HRA.FAMILY] WHERE ID=?");
			preparedStatement.setInt(1, emploeeId);
			ResultSet res = preparedStatement.executeQuery();
			if (res.next()) {
				fm.setEmployeeepf(res.getString(2));
				fm.setFmdateofbirth(res.getString(4));
				fm.setFmname(res.getString(3));
				fm.setFmoccupation(res.getString(6));
				fm.setFmrelationship(res.getString(5));
				fm.setFmWorkingplace(res.getString(7));
				Familymember = gson.toJson(fm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Familymember;
	}

	@Override
	public String find(String id) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Familymember fm = new Familymember();
		String Familymember = null;
		Gson gson = new Gson(); 
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn
					.prepareStatement("SELECT * FROM [HRA.FAMILY] WHERE EMPLOYEEID=?");
			preparedStatement.setString(1, id);
			ResultSet res = preparedStatement.executeQuery();
			if (res.next()) {
				fm.setEmployeeepf(res.getString(2));
				log.info("res.getString(2)" + res.getString(2));
				fm.setFmdateofbirth(res.getString(4));
				log.info("res.getString(4)" + res.getString(4));
				fm.setFmname(res.getString(3));  
				log.info("res.getString(3)" + res.getString(3));
				fm.setFmoccupation(res.getString(6));
				log.info("res.getString(6)" + res.getString(6));
				fm.setFmrelationship(res.getString(5));
				log.info("res.getString(5)" + res.getString(5));
				fm.setFmWorkingplace(res.getString(7));
				log.info("res.getString(7)" + res.getString(7));
				Familymember = gson.toJson(fm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Familymember;
	}
}