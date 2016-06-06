package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
//* 20160505 PN HRA-2  validateEmployee() method Modified.
//* 20160525 AS HRA-30  Find method Created 
//***********************************************/

public class EmployeeCrudJDBC extends Employee {
	static Logger log = Logger.getLogger(EmployeeCrudJDBC.class.getName());

	@Override
	public int add(Object object) {
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
		return -1;
	}

	@Override
	public String findByEpf(String id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		EmployeeCrudJDBC emp = new EmployeeCrudJDBC();
	
		String employeeDetails = null;
	
		Gson gson = new Gson();
		log.info(id + "////");
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn
					.prepareStatement("SELECT [HRA.EMPLOYEE].ID, [HRA.EMPLOYEE].NAME, [HRA.EMPLOYEE].DESIGNATION, [HRA.EMPLOYEE].EMAIL, [HRA.EMPLOYEE].DOB, [HRA.EMPLOYEE].NIC, [HRA.EMPLOYEE].GENDER, [HRA.EMPLOYEE].PERMENENTADDRESS, [HRA.EMPLOYEE].TEMPORARYADDRESS, [HRA.EMPLOYEE].MOBILENO, [HRA.EMPLOYEE].OTHERNO, [HRA.DEPARTMENT].NAME, [HRA.EMPLOYEE].MARITALSTATUS, [HRA.EMPLOYEE].DATEOFJOIN, [HRA.EMPLOYEE].EPF, [HRA.EMPLOYEE].BASIS  FROM [HRA.EMPLOYEE] INNER JOIN [HRA.DEPARTMENT] ON [HRA.EMPLOYEE].DEPTID = [HRA.DEPARTMENT].ID WHERE EPF = ?");
			preparedStatement.setString(1, id);
			ResultSet res = preparedStatement.executeQuery();
			if (res.next()) {

				emp.setEmployeename(res.getString(2));
				emp.setEmployeedesignation(res.getString(3));
				emp.setEmployeeemail(res.getString(4));
				emp.setEmployeedateofbirth(res.getString(5));
				emp.setEmployeenic(res.getString(6));
				emp.setEmployeegender(res.getString(7));
				emp.setEmployeepermenetaddress(res.getString(8));
				emp.setEmployeetemporaryaddress(res.getString(9));
				emp.setEmployeemobile(res.getString(10));
				emp.setEmployeetelephone(res.getString(11));
				emp.setEmployeedepartment(res.getString(12));
				emp.setEmployeemaritalstatus(res.getString(13));
				emp.setEmployeejoindate(res.getString(14));
				emp.setEmployeeepf(res.getString(15));
				emp.setEmployeebasis(res.getString(16));

				
			
				employeeDetails = gson.toJson(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		return employeeDetails;

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
			message = message + MessageList.EMPTYFIELD.message() + " ";
		}
		if (!validator.isValidString(employee.getEmployeename())) {
			message = message + MessageList.EMPTYFIELD.message() + " ";
		}
		if (!validator.isValidNic(employee.getEmployeenic())) {
			message = message + MessageList.NICERROR.message() + " ";
		}
		if (!validator.isValidString(employee.getEmployeeepf())) {
			message = message + MessageList.EMPTYFIELD.message() + " ";
		}
		if (!validator.isPastDate(employee.getEmployeedateofbirth())) {
			message = message + MessageList.INVALIDBIRTDAY.message() + " ";
		}
		if (!validator.isValidTelephone(employee.getEmployeemobile())) {
			message = message + MessageList.MOBILENUMBERERROR.message() + " ";
		}
		if (!validator.isValidTelephone(employee.getEmployeetelephone())) {
			message = message + MessageList.PHONENUMBERERROR.message() + " ";
		}
		if (!validator.isValidemail(employee.getEmployeeemail())) {
			message = message + MessageList.EMAILERROR.message() + " ";
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

}
