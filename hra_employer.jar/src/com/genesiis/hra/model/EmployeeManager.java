package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;


///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
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
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeeDesignation());
			preparedStatement.setString(4, employee.getEmployeeEmail());
			preparedStatement.setString(5, employee.getEmployeeDateofbirth());
			preparedStatement.setString(6, employee.getEmployeeNic());
			preparedStatement.setString(7, employee.getEmployeeGender());
			preparedStatement.setString(8,
					employee.getEmployeePermenetaddress());
			preparedStatement.setString(9,
					employee.getEmployeeTemporaryaddress());
			preparedStatement.setString(10, employee.getEmployeeMobile());
			preparedStatement.setString(11, employee.getEmployeeTelephone());
			preparedStatement.setString(12, employee.getEmployeeDepartment());
			preparedStatement
					.setString(13, employee.getEmployeeMaritalstatus());
			preparedStatement.setString(14, employee.getEmployeeJoindate());
			preparedStatement.setString(15, "SYSTEM");
			preparedStatement.setString(16, employee.getEmployeeEpf());
			preparedStatement.setString(17, employee.getEmployeeBasis());

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
		if (validator.isValidString(employee.getEmployeeName())
				&& validator.isValidNic(employee.getEmployeeNic())
				&& validator.isValidString(employee.getEmployeeEpf())
				&& validator.isPastDate(employee.getEmployeeDateofbirth())
				&& validator.isValidString(employee.getEmployeeDepartment())) {
			return MessageList.SUCCESS.message();
		} else {
			return MessageList.EMPTYFIELD.message();
		}
	}

}
