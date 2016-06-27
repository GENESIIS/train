package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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


	public int add(Object object) {
		String query = "INSERT INTO [HRA.FAMILY] (EMPLOYEEID, NAME, DATEOFBIRTH, RELATIONSHIP, "
				+ "OCCUPATION, PLACE, MODBY, MODON) VALUES (?, ?, ?, ?, ?, ?, ?, GETDATE())";
		Connection conn = null;
		PreparedStatement ps = null;
		Familymember fm = (Familymember) object;
		int status = 0;
		
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, fm.getEmployeeepf());
			ps.setString(2, fm.getFmname());
			ps.setDate(3, new DataValidator().convertStringDatetoSqlDate(fm.getFmdateofbirth()));
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
	public int update(Object object, String epf) {
		String query = "UPDATE [HRA.FAMILY] SET NAME=?, DATEOFBIRTH=?, RELATIONSHIP=? , OCCUPATION=?, PLACE=?, MODBY=? WHERE EMPLOYEEID=?";
		int status = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		Familymember fm = (Familymember) object;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, fm.getFmname());
			ps.setDate(2, new DataValidator().convertStringDatetoSqlDate(fm.getFmdateofbirth()));
			ps.setString(3, fm.getFmrelationship());
			ps.setString(4, fm.getFmoccupation());
			ps.setString(5, fm.getFmWorkingplace());
			ps.setString(6, "SYSTEM");
			ps.setString(7, epf);

			log.info("***"+fm.getFmname()+"***"+new DataValidator().convertStringDatetoSqlDate(fm.getFmdateofbirth())+"***"+fm.getFmrelationship()+"***"+fm.getFmoccupation()+"***"+fm.getFmWorkingplace());
			
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	public Object findByEpf(String id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Familymember fm = new Familymember();
		String Familymember = null;
		Gson gson = new Gson();
		try {
			conn = ConnectionManager.getConnection();
			ps = conn
					.prepareStatement("SELECT * FROM [HRA.FAMILY] WHERE EMPLOYEEID=?");
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				fm.setEmployeeepf(rs.getString("EMPLOYEEID"));
				log.info("res.getString(2)" + rs.getString("EMPLOYEEID"));
				
				fm.setFmdateofbirth(rs.getString(4));
				log.info("res.getString(4)" + rs.getString(4));
				
				fm.setFmname(rs.getString(3));
				log.info("res.getString(3)" + rs.getString(3));
				
				fm.setFmoccupation(rs.getString(6));
				log.info("res.getString(6)" + rs.getString(6));
				
				fm.setFmrelationship(rs.getString(5));
				log.info("res.getString(5)" + rs.getString(5));
				
				fm.setFmWorkingplace(rs.getString(7));
				log.info("res.getString(7)" + rs.getString(7));
				Familymember = gson.toJson(fm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if (ps != null) {
					ps.close();
				}if (rs != null) {
					rs.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}

		return fm;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
}