package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160422 PN HRA-3 created JDBCTransaction.java class
//* 20160425 PN HRA-3 modified executeAdddepartment(String gsonData), method, Renamed the class to DepartmentManager.java
//* 20160429 PN Modified the add(Object object) Method.
//***********************************************/

public class DepartmentCrudJDBC implements ICrud {
	static Logger log = Logger.getLogger(DepartmentCrudJDBC.class.getName());

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
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}			
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
		return null;
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

}
