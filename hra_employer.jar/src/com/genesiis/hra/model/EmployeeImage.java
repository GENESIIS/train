package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jboss.logging.Logger;

public class EmployeeImage implements ICrud{

	static Logger log = Logger.getLogger(Employee.class.getName());
	
	private String code;
	private String employeeEpf;
	private String status;
	private String imagePath;
	private String modOn;
	private String modBy;
	private String crtOn;
	private String crtBy;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmployeeepf() {
		return employeeEpf;
	}

	public void setEmployeeepf(String employeeEpf) {
		this.employeeEpf = employeeEpf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImagepath() {
		return imagePath;
	}

	public void setImagepath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getModon() {
		return modOn;
	}

	public void setModon(String modOn) {
		this.modOn = modOn;
	}

	public String getModby() {
		return modBy;
	}

	public void setModby(String modby) {
		this.modBy = modby;
	}

	public String getCrton() {
		return crtOn;
	}

	public void setCrton(String crtOn) {
		this.crtOn = crtOn;
	}

	public String getCrtby() {
		return crtBy;
	}

	public void setCrtby(String crtby) {
		this.crtBy = crtby;
	}

	@Override
	/**
	 * @param 
	 * String object
	 * @return 
	 * int rowsInserted
	 * 
	 * insert data to Employee Image table
	 * **/
	public int add(Object object) {
		
		String query = "INSERT INTO [HRA.EMPLOYEEIMAGE] (EMPLOYEEEPF, STATUS, IMAGEPATH, MODON, MODBY, CRTON, CRTBY) VALUES (?, ?, ?, GETDATE(), ?, GETDATE(), ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeImage ei = (EmployeeImage) object;
		int rowsInserted = 0;
		
		try {
			conn = com.genesiis.hra.utill.ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, ei.getEmployeeepf());
			ps.setString(2, ei.getStatus());
			ps.setString(3, ei.getImagepath());
			ps.setString(4, ei.getModby());
			ps.setString(5, ei.getCrtby());
	

			// throws exception in SQL
			rowsInserted = ps.executeUpdate();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			log.error("Exception: EmployeeImage Add" + exception);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.error("Exception: EmployeeImage Add" + exception);
			}
		}
		return rowsInserted;
	}

	@Override
	public int update(Object object, String epf) {
		// TODO Auto-generated method stub
		return 0;
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
	public Object findByEpf(String empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(String id) {
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
