package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
//* 20160505 PN HRA-2  validateEmployee() method Modified.
//***********************************************/

public class EmployeeCrudJDBC implements ICrud {
	static Logger log = Logger.getLogger(EmployeeCrudJDBC.class.getName());

	@SuppressWarnings("deprecation")
	@Override
	public String add(Object object) {
		String query = "INSERT INTO [HRA.EMPLOYEE] (NAME, DESIGNATION,  EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, "
				+ "MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, EPF, BASIS)  VALUES ( ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Employee employee = (Employee) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmployeename());
			preparedStatement.setString(2, employee.getEmployeedesignation());
			preparedStatement.setString(3, employee.getEmployeeemail());
			preparedStatement.setDate(4, new java.sql.Date(2016, 05, 11));
			preparedStatement.setString(5, employee.getEmployeenic());
			String gender = employee.getEmployeegender().toString().trim();

			if (gender == "Male") {
				preparedStatement.setString(6,
						String.valueOf(MaskValidator.MSK_MALE));
				log.info("+++++++++++++++++++++++++++"
						+ String.valueOf(MaskValidator.MSK_MALE));
			} else if (gender == "Female") {
				preparedStatement.setString(6,
						String.valueOf(MaskValidator.MSK_FEMALE));
				log.info("+++++++++++++++++++++++++++"
						+ String.valueOf(MaskValidator.MSK_FEMALE));
			} else {
				preparedStatement.setString(6,
						String.valueOf(MaskValidator.MSK_OTHER));
				log.info("+++++++++++++++++++++++++++"
						+ String.valueOf(MaskValidator.MSK_OTHER));
			}

			preparedStatement.setString(7,
					employee.getEmployeepermenetaddress());
			preparedStatement.setString(8,
					employee.getEmployeetemporaryaddress());
			preparedStatement.setString(9, employee.getEmployeemobile());
			preparedStatement.setString(10, employee.getEmployeetelephone());
			preparedStatement.setString(11, employee.getEmployeedepartment());
			preparedStatement
					.setString(12, employee.getEmployeemaritalstatus());
			preparedStatement.setDate(13, new java.sql.Date(2016, 05, 11));
			preparedStatement.setString(14, "SYSTEM");
			preparedStatement.setString(15, employee.getEmployeeepf());
			preparedStatement.setString(16, employee.getEmployeebasis());

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException exception) {
			System.out
					.println("----------------------------------------message-------------------------------------------------"
							+ message);
			exception.printStackTrace();
			message = MessageList.ERROR.message();
			System.out
					.println("-------------------------------------message---------------------------------------------------"
							+ message);
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

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Employee employee = new Employee();// to store ojects from result set
		List<Object> employeeList = null;// to collect data

		String query = "SELECT NAME, DESIGNATION,  EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS,  MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, EPF, BASIS  "
				+ " FROM [HRA.EMPLOYEE] ";
		try {

			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			result = preparedStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					employeeList = new ArrayList<Object>();// to collect data

					employee.setEmployeename(result.getString("NAME"));
					employee.setEmployeedesignation(result.getString("DESIGNATION"));
					employee.setEmployeeemail(result.getString("EMAIL"));
					employee.setEmployeedateofbirth(result.getString("DOB"));
					employee.setEmployeenic(result.getString("NIC"));
					String gender = result.getString("GENDER");

					if (gender.equals(String.valueOf(MaskValidator.MSK_MALE))) 
					{
						employee.setEmployeegender(MaskValidator.MSK_MALE_DES);
					} 
					else if (gender.equals(String.valueOf(MaskValidator.MSK_FEMALE))) 
					{
						employee.setEmployeegender(MaskValidator.MSK_FEMALE_DES);
					} 
					else 
					{
						employee.setEmployeegender(MaskValidator.MSK_OTHER_DES);
					}
					
					employee.setEmployeepermenetaddress(result
							.getString("PERMENENTADDRESS"));
					employee.setEmployeetemporaryaddress(result
							.getString("TEMPORARYADDRESS"));
					employee.setEmployeemobile(result.getString("MOBILENO"));
					employee.setEmployeetelephone(result.getString("OTHERNO"));
					employee.setEmployeedepartment(result.getString("DEPTID"));
					employee.setEmployeemaritalstatus(result
							.getString("MARITALSTATUS"));
					employee.setEmployeejoindate(result.getString("DATEOFJOIN"));
					employee.setEmployeeModifiedby(result.getString("MODBY"));
					employee.setEmployeeepf(result.getString("EPF"));
					employee.setEmployeebasis(result.getString("BASIS"));

					// System.out.println("*****************"+employee.getEmployeegender()+"*****************");

					employeeList.add(employee);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return employeeList;
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
