package com.genesiis.hra.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;
import com.sun.org.apache.regexp.internal.recompile;

///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
//* 20160505 PN HRA-2  validateEmployee() method Modified.
//***********************************************/

public class EmployeeCrudJDBC extends Employee{
	static Logger log = Logger.getLogger(EmployeeCrudJDBC.class.getName());

	/*
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
			preparedStatement.setString(1, employee.getEmployeeid());
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

	public String validateEmployee(Employee employee) throws ParseException {
		DataValidator validator = new DataValidator();
		String message = "";

		if (!validator.isValidString(employee.getEmployeeid())) {
			message = message + MessageList.EMPTYFIELD.message() +" ";
		}
		if (!validator.isValidString(employee.getEmployeename())) {
			message = message + MessageList.EMPTYFIELD.message() +" ";
		}
		if (!validator.isValidNic(employee.getEmployeenic())) {
			message = message + MessageList.NICERROR.message() +" ";
		}
		if (!validator.isValidString(employee.getEmployeeepf())) {
			message = message + MessageList.EMPTYFIELD.message() +" ";
		}
		if (!validator.isPastDate(employee.getEmployeedateofbirth())) {
			message = message + MessageList.INVALIDBIRTDAY.message() +" ";
		}
		if (!validator.isValidTelephone(employee.getEmployeemobile())) {
			message = message + MessageList.MOBILENUMBERERROR.message() +" ";
		}
		if (!validator.isValidTelephone(employee.getEmployeetelephone())) {
			message = message + MessageList.PHONENUMBERERROR.message() +" ";
		}
		if (!validator.isValidemail(employee.getEmployeeemail())) {
			message = message + MessageList.EMAILERROR.message() +" ";
		}
		return message;
	}

	public boolean validEmployee(Employee employee) throws ParseException {
		if (validateEmployee(employee).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	*/

}
