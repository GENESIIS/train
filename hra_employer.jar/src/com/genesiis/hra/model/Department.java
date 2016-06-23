package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;

///***********************************************
//* 20160422 PN HRA-3 created Department.java class
//* 
//***********************************************/

public class Department implements ICrud {
	static Logger log = Logger.getLogger(Department.class.getName());

	private String departmentNumber;
	private String departmentName;
	private String departmentLocation;
	private String departmentHead;

	public String getDepartmentnumber() {
		return departmentNumber;
	}

	public void setDepartmentnumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentname() {
		return departmentName;
	}

	public void setDepartmentname(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentlocation() {
		return departmentLocation;
	}

	public void setDepartmentlocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public String getDepartmenthead() {
		return departmentHead;
	}

	public void setDepartmenthead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public Department() {
	}

	public Department(String dnum, String dname, String dl, String dh) {
		this.departmentNumber = dnum;
		this.departmentName = dname;
		this.departmentLocation = dl;
		this.departmentHead = dh;
	}

	@Override
	public String toString() {
		return departmentNumber + " - " + departmentName + " - "
				+ departmentLocation + " - " + departmentHead;
	}

	@Override
	public int add(Object object) {
		String query = "INSERT INTO [HRA.DEPARTMENT] (NAME, LOCATION, MANAGERID, MODBY,MODON) VALUES (?, ?, ?, ?,GETDATE())";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department department = (Department) object;
		int status = 0;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, department.getDepartmentname());
			ps.setString(2, department.getDepartmentlocation());
			ps.setString(3, department.getDepartmenthead());
			ps.setString(4, "SYSTEM");

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				rs = ps.getGeneratedKeys();
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
				if (rs != null) {
					rs.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	public List<String> getDepartments() {
		String query = "SELECT * FROM [HRA.DEPARTMENT]";
		Connection conn = null;
		List<String> departments = new ArrayList<String>();
		Statement statement = null;
		try {
			conn = ConnectionManager.getConnection();
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				departments
						.add(result.getString(1) + "#" + result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return departments;
	}

	public List<String> getManagers() {
		String query = "SELECT * FROM [HRA.EMPLOYEE] WHERE DESIGNATION='Manager';";
		Connection conn = null;
		List<String> managers = new ArrayList<String>();
		Statement statement = null;
		try {
			conn = ConnectionManager.getConnection();
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				managers.add(result.getString(1) + "#" + result.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}

				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return managers;
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

	@Override
	public int update(Object object, String epf) {
		// TODO Auto-generated method stub
		return 0;
	}

}