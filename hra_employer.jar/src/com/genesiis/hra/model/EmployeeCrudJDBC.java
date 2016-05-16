package com.genesiis.hra.model;

///***********************************************
//* 20160506 PN HRA-4 created EditEmployeeCrudJDBC.java class
//*
//***********************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;

///***********************************************
//* 20160506 PN HRA-4 created EditEmployeeCrudJDBC.java class
//*
//***********************************************/ 

/**
 * Session Bean implementation class DepartmentDao
 */
@Stateless
public class EmployeeCrudJDBC implements ICrud {
	static Logger log = Logger.getLogger(EmployeeCrudJDBC.class.getName());
	@Override
	public String add(Object object) {	
		return null;
	}
	
	// Update Employee data
	public String update(Employee employee) {
		// TODO Auto-generated method stub		
		String query = "UPDATE [hra-2].[dbo].[HRA.EMPLOYEE] SET NAME = ? ,  DESIGNATION = ? , "
				+ "  EMAIL = ? ,  DOB = ? ,  NIC = ?,  GENDER = ?,  PERMENENTADDRESS = ?, TEMPORARYADDRESS = ?, "
				+ "  MOBILENO = ?,  OTHERNO = ?,  DEPTID = ?,  MARITALSTATUS = ?,  DATEOFJOIN = ?,  MODBY = ?,  EPF = ?,  BASIS  = ? WHERE ID = ?";
		String message ="Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmployeename());
			preparedStatement.setString(2, employee.getEmployeedesignation());
			preparedStatement.setString(3, employee.getEmployeeemail());
			preparedStatement.setString(4, employee.getEmployeedateofbirth());
			preparedStatement.setString(5, employee.getEmployeenic());
			preparedStatement.setString(6, employee.getEmployeegender());
			preparedStatement.setString(7,
					employee.getEmployeepermenetaddress());
			preparedStatement.setString(8,
					employee.getEmployeetemporaryaddress());
			preparedStatement.setString(9, employee.getEmployeemobile());
			preparedStatement.setString(10, employee.getEmployeetelephone());
			preparedStatement.setString(11, employee.getEmployeedepartment());
			preparedStatement
					.setString(12, employee.getEmployeemaritalstatus());
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

		} finally {
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
	// retrive employe data
	public Employee retrive(String id) {
		// TODO Auto-generated method stub
		String query = "select * from [hra-2].[dbo].[HRA.EMPLOYEE] where ID = ?";
		String message = "Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet retriveData = null;

		Employee employee = new Employee();
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "1");
			retriveData = preparedStatement.executeQuery();

			try {
				if (retriveData.next()) {
					// set data to entity class
					employee.setEmployeeid(retriveData.getString("ID"));
					employee.setEmployeename(retriveData.getString("NAME"));
					employee.setEmployeedesignation(retriveData
							.getString("DESIGNATION"));
					employee.setEmployeeemail(retriveData.getString("EMAIL"));
					employee.setEmployeedateofbirth(retriveData
							.getString("DOB"));
					employee.setEmployeenic(retriveData.getString("NIC"));
					employee.setEmployeegender(retriveData.getString("GENDER"));
					employee.setEmployeepermenetaddress(retriveData
							.getString("PERMENENTADDRESS"));
					employee.setEmployeemobile(retriveData
							.getString("MOBILENO"));
					employee.setEmployeedepartment(retriveData
							.getString("DEPTID"));
					employee.setEmployeetelephone(retriveData
							.getString("OTHERNO"));
					employee.setEmployeejoindate(retriveData
							.getString("DATEOFJOIN"));
					employee.setEmployeeepf(retriveData.getString("EPF"));
					employee.setEmployeemaritalstatus(retriveData
							.getString("MARITALSTATUS"));
					employee.setEmployeebasis(retriveData.getString("BASIS"));
					employee.setEmployeetemporaryaddress(retriveData
							.getString("TEMPORARYADDRESS"));			

				}
			} catch (Exception e) {
				log.info(e.toString());
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return employee;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}