package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
//* 20160505 PN HRA-2  validateEmployee() method Modified.
//***********************************************/

public class EmployeeCrudJDBC implements ICrud {
	static Logger log = Logger.getLogger(EmployeeCrudJDBC.class.getName());

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
			preparedStatement.setString(8, employee.getEmployeepermenetaddress());
			preparedStatement.setString(9, employee.getEmployeetemporaryaddress());
			preparedStatement.setString(10, employee.getEmployeemobile());
			preparedStatement.setString(11, employee.getEmployeetelephone());
			preparedStatement.setString(12, employee.getEmployeedepartment());
			preparedStatement.setString(13, employee.getEmployeemaritalstatus());
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
		String query = "UPDATE [hra-2].[dbo].[HRA.EMPLOYEE] SET NAME = ? ,  DESIGNATION = ? , "
				+ "  EMAIL = ? ,  DOB = ? ,  NIC = ?,  GENDER = ?,  PERMENENTADDRESS = ?, TEMPORARYADDRESS = ?, "
				+ "  MOBILENO = ?,  OTHERNO = ?,  DEPTID = ?,  MARITALSTATUS = ?,  DATEOFJOIN = ?,  MODBY = ?,  EPF = ?,  BASIS  = ? WHERE ID = ?";
		String message = "Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;		

		try {
			Employee employee = (Employee) object;
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmployeename());
			preparedStatement.setString(2, employee.getEmployeedesignation());
			preparedStatement.setString(3, employee.getEmployeeemail());
			preparedStatement.setString(4, employee.getEmployeedateofbirth());
			preparedStatement.setString(5, employee.getEmployeenic());
			preparedStatement.setString(6, employee.getEmployeegender());
			preparedStatement.setString(7, employee.getEmployeepermenetaddress());
			preparedStatement.setString(8, employee.getEmployeetemporaryaddress());
			preparedStatement.setString(9, employee.getEmployeemobile());
			preparedStatement.setString(10, employee.getEmployeetelephone());
			preparedStatement.setString(11, employee.getEmployeedepartment());
			preparedStatement.setString(12, employee.getEmployeemaritalstatus());
			preparedStatement.setString(13, employee.getEmployeejoindate());
			preparedStatement.setString(14, "S");
			preparedStatement.setString(15, employee.getEmployeeepf());
			preparedStatement.setString(16, employee.getEmployeebasis());
			preparedStatement.setString(17, "1");

			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				message = "Succesfull";
			}
		} catch (SQLException exception) {
			exception.printStackTrace();

		} catch (ClassCastException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return message;
	}
		


	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public String retrive(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object find(int empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String name) {
		List<Object> employList = new LinkedList<Object>();
		String query = "select ID, NAME,D ESIGNATION, MOBILENO from HRA.EMPLOYEE where DESIGNATION = ?";
		String messege = "";
		Connection conn = null;
		PreparedStatement pd = null;
		ResultSet findData = null;
		
		Employee employee = new Employee();
		
		try {
			conn = ConnectionManager.getConnection();
			pd = conn.prepareStatement(query);
			pd.setString(1, name);
			findData = pd.executeQuery();
			
			try {
				while(findData.next()){
					// set data to entity class
					employee.setEmployeeid(findData.getString("ID"));
					employee.setEmployeename(findData.getString("NAME"));
					employee.setEmployeedesignation(findData.getString("DESIGNATION"));					
					employee.setEmployeemobile(findData.getString("MOBILENO"));		
					employList.add(employee);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				log.info(e.toString());
			}
		} catch (Exception ex) {
			// TODO: handle exception
			log.info(ex.toString());
		}finally{
			try {
				if (pd != null) {
					pd.close();
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employList;
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
