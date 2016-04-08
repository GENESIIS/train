package com.hra.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.hra.dao.Employee;

public class EmployeeDetailsController {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "";
	static final String DB_URL = "";

	// Database credentials
	static final String USERNAME = "";
	static final String PASSWORD = "";

	Connection conn = null;
	Statement stmt = null;

	public boolean inserEmployeeDetails(Employee employee) {
		boolean status = false;

		try {
			// Open a connection
			System.out.println("Connecting to database...");
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// Executing the SQL Statement
			String sql = "INSERT INTO Employee " + "VALUES ("
					+ employee.getEmployeeID() + ", "
					+ employee.getEmployeeName() + ","
					+ employee.getEmployeeDesignation() + " ,"
					+ employee.getEmployeeAddress() + ","
					+ employee.getDateOfJoin() + " ,"
					+ employee.getEmployeeDOB() + ","
					+ employee.getDepartmentID() + ","
					+ employee.getEmployeeEmail() + ","
					+ employee.getEmployeeGender() + ","
					+ employee.getEmployeeSalary() + ")";
			//stmt.executeUpdate(sql);
			
			System.out.println("Data Added.");
			status = true;
		} catch (Exception e) {
			System.out.println("Data Adding faild.");
			e.printStackTrace();
		}
		return status;

	}
}
