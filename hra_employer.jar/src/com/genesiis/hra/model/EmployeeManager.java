package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;


///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
//* 20160501 PN HRA-3 getManagers() method created.
//***********************************************/

public class EmployeeManager implements IDataAccessor {
	static Logger log = Logger.getLogger(EmployeeManager.class.getName());

	@Override
	public String add(Object object) {
		String query = "INSERT INTO [HRA.EMPLOYEE] (ID, NAME, DESIGNATION, "
				+ "EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, "
				+ "MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, EPF, BASIS) "
				+ "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Employee employee = (Employee) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "EMP001");
			preparedStatement.setString(2, employee.getEmployeename());
			preparedStatement.setString(3, employee.getEmployeedesignation());
			preparedStatement.setString(4, employee.getEmployeeemail());
			preparedStatement.setString(5, employee.getEmployeedateofbirth());
			preparedStatement.setString(6, employee.getEmployeenic());
			preparedStatement.setString(7, employee.getEmployeegender());
			preparedStatement.setString(8,
					employee.getEmployeepermenetaddress());
			preparedStatement.setString(9,
					employee.getEmployeetemporaryaddress());
			preparedStatement.setString(10, employee.getEmployeemobile());
			preparedStatement.setString(11, employee.getEmployeetelephone());
			preparedStatement.setString(12, employee.getEmployeedepartment());
			preparedStatement
					.setString(13, employee.getEmployeemaritalstatus());
			preparedStatement.setString(14, employee.getEmployeejoindate());
			preparedStatement.setString(15, "SYSTEM");
			preparedStatement.setString(16, employee.getEmployeeepf());
			preparedStatement.setString(17, employee.getEmployeebasis());

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObjectid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		return null;
	}

	// Method to extract EmployeeDetails from jsonData.
	public Employee extractFromgson(String gsonData) {
		Gson gson = new Gson();
		Employee employee = null;
		try {
			employee = gson.fromJson(gsonData, Employee.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return employee;
	}

	public String validEmployee(Employee employee) throws ParseException {
		DataValidator validator = new DataValidator();
		if (validator.isValidString(employee.getEmployeename())
				&& validator.isValidNic(employee.getEmployeenic())
				&& validator.isValidString(employee.getEmployeeepf())
				&& validator.isPastDate(employee.getEmployeedateofbirth())
				&& validator.isValidString(employee.getEmployeedepartment())) {
			return MessageList.SUCCESS.message();
		} else {
			return MessageList.EMPTYFIELD.message();
		}
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
			while(result.next()){
				managers.add(result.getString(1)+"#"+result.getString(2));
			}
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return managers;
	}
}
