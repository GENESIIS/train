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
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160422 PN HRA-3 created JDBCTransaction.java class
//* 20160425 PN HRA-3 modified executeAdddepartment(String gsonData), method, Renamed the class to DepartmentManager.java
//* 20160429 PN Modified the add(Object object) Method.
//* 20160430 PN Created getDipartments() Method.
//***********************************************/

public class DepartmentManager implements ICurd {

	static Logger log = Logger.getLogger(DepartmentManager.class.getName());

	@Override
	public String add(Object object) {
		String query = "INSERT INTO [HRA.DEPARTMENT] (ID, NAME, LOCATION, MANAGERID, MODBY) VALUES (?, ?, ?, ?, ?)";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Department department = (Department) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, department.getDepartmentNumber());
			preparedStatement.setString(2, department.getDepartmentname());
			preparedStatement.setString(3, department.getDepartmentlocation());
			preparedStatement.setString(4, department.getDepartmentHead());
			preparedStatement.setString(5, "SYSTEM");

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
		}
		return message;
	}

	@Override
	public String update(Object object) {
		return null;
	}

	@Override
	public String delete(Object object) {
		return null;
	}

	@Override
	public String getObjectid(String id) {
		return null;
	}

	@Override
	public List<Object> getAll() {
		String query = "SELECT * FROM [HRA.DEPARTMENT]";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		List<Object> departments = new ArrayList<Object>();
		Statement statement = null;
		try {
			conn = ConnectionManager.getConnection();
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()){
				departments.add(result.getString(1)+","+result.getString(2));
			}
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			message = MessageList.ERROR.message();
		}
		
		return departments;
	}

	// Method to extract DepartmentDetails from jsonData.
	public Department extractFromgson(String gsonData) {
		Gson gson = new Gson();
		Department department = null;
		try {
			department = gson.fromJson(gsonData, Department.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return department;
	}

	public String validDepartment(Department department) {
		DataValidator validator = new DataValidator();
		if (validator.isValidString(department.getDepartmentname())) {
			return MessageList.SUCCESS.message();
		} else {
			return MessageList.EMPTYFIELD.message();
		}
	}
	
	public List<String> getDepartments() {
		String query = "SELECT * FROM [HRA.DEPARTMENT]";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		List<String> departments = new ArrayList<String>();
		Statement statement = null;
		try {
			conn = ConnectionManager.getConnection();
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()){
				departments.add(result.getString(1)+"#"+result.getString(2));
			}
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			message = MessageList.ERROR.message();
		}
		
		return departments;
	}
}