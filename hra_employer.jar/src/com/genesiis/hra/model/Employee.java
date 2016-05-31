package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.genesiis.hra.utill.ConnectionManager;

///***********************************************
// * 20160407 PN HRA-1 created Employee.java class
// * 20160411 PN HRA-1 changes Employee.java class. Added employeeNic attribute.
// * 
// ***********************************************/

public class Employee {
	protected String employeeEpf;

	public String getEmployeeepf() {
		return employeeEpf;
	}

	public void setEmployeeepf(String employeeEpf) {
		this.employeeEpf = employeeEpf;
	}

	public Employee() {
	}

	public Employee(String employeeEpf) {
		this.employeeEpf = employeeEpf;
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
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return managers;
	}

}