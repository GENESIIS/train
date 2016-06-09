package com.genesiis.hra.model;

///***********************************************
//* 20160506 PN HRA-4 created EditEmployeeCrudJDBC.java class
//*
//***********************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
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
public class EmployeeCrudJDBC extends SerchCrud {
	static Logger log = Logger.getLogger(EmployeeCrudJDBC.class.getName());


	public int add(Object object) {
		
		return 0;
	}


	public int update(Object employee, String epf) {
		// TODO Auto-generated method stub		
		return 0;
	}
		



	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
	@Override
	public Object find(int empEpf)throws SQLException, Exception {
		String query = "select * from [HRA.EMPLOYEE] where ID = ?";
		String message = "Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet retriveData = null;
		BasicData employee = new BasicData();
		log.info(employee.getEmployeeepf());
		try { 
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "1");

			retriveData = preparedStatement.executeQuery();

			try {
				if (retriveData.next()) {
					// set data to entity class
					employee.setEmployeeepf(retriveData.getString("ID"));
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
					log.info(employee.getEmployeeepf());
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
	public List<Object> find(String keyWord) throws SQLException, Exception {
		List<Object> employList = new LinkedList<Object>();
		String query = "select EPF, NAME,DESIGNATION, MOBILENO from [HRA.EMPLOYEE] where (EPF LIKE   ? OR NAME LIKE ? OR DESIGNATION LIKE  ? OR MOBILENO LIKE  ?)";
		String query1 = "select EPF, NAME,DESIGNATION, MOBILENO from [HRA.EMPLOYEE] where match (NAME) AGAINST(?)";
		String messege = "";
		Connection conn = null;
		PreparedStatement pd = null;
		ResultSet findData = null;
		 
		
		
		try {
			conn = ConnectionManager.getConnection();
			pd = conn.prepareStatement(query);
			pd.setString(1, "%"+keyWord+"%"); 
			pd.setString(2, "%"+keyWord+"%");
			pd.setString(3, "%"+keyWord+"%");
			pd.setString(4, "%"+keyWord+"%");
			findData = pd.executeQuery();
			
			try {
				while(findData.next()){					
					// set data to entity class
					BasicData employee = new BasicData();
					employee.setEmployeeepf(findData.getString("EPF"));
					employee.setEmployeename(findData.getString("NAME"));
					employee.setEmployeedesignation(findData.getString("DESIGNATION"));					
					employee.setEmployeemobile(findData.getString("MOBILENO"));		
					employList.add(employee);
					log.info("Inside loop at find methode");
				}					
			} catch (SQLException e) {
				// TODO: handle exception
				log.info("find methode "+e.toString());
			}
		} catch (Exception ex) {
			// TODO: handle exception
			log.info("find methode "+ex.toString());
		}finally{
			try {
				if (pd != null) {
					pd.close();
				}
				conn.close();
			} catch (SQLException e) {
				log.info("find methode "+ e.toString());
			}
		}
		
		return employList;
	
	}




	@Override
	public String findByEpf(String id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		BasicData emp = new BasicData();
	
		String employeeDetails = null;
	
		Gson gson = new Gson();
		log.info(id + "////");
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement("SELECT [HRA.EMPLOYEE].ID, [HRA.EMPLOYEE].NAME, [HRA.EMPLOYEE].DESIGNATION, [HRA.EMPLOYEE].EMAIL, [HRA.EMPLOYEE].DOB, [HRA.EMPLOYEE].NIC, [HRA.EMPLOYEE].GENDER, [HRA.EMPLOYEE].PERMENENTADDRESS, [HRA.EMPLOYEE].TEMPORARYADDRESS, [HRA.EMPLOYEE].MOBILENO, [HRA.EMPLOYEE].OTHERNO, [HRA.DEPARTMENT].NAME, [HRA.EMPLOYEE].MARITALSTATUS, [HRA.EMPLOYEE].DATEOFJOIN, [HRA.EMPLOYEE].EPF, [HRA.EMPLOYEE].BASIS  FROM [HRA.EMPLOYEE] INNER JOIN [HRA.DEPARTMENT] ON [HRA.EMPLOYEE].DEPTID = [HRA.DEPARTMENT].ID WHERE EPF = ?");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
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

	public boolean validEmployee(BasicData employee) throws ParseException {
		if (employee.isValidObject(employee)) {
			return true;
		} else {
			return false;
		}
	}


	public String getId(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}