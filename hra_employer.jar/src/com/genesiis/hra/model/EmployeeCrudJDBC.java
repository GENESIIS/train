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
import com.google.gson.Gson;

///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
//* 20160505 PN HRA-2  validateEmployee() method Modified.
//***********************************************/

public class EmployeeCrudJDBC implements ICrud {
	static Logger log = Logger.getLogger(EmployeeCrudJDBC.class.getName());

	@Override
	public int add(Object object) {
		
		return (Integer) null;
	}

	@Override
	public int update(Object employee) {
		// TODO Auto-generated method stub
		String query = "UPDATE [hra-2].[dbo].[HRA.EMPLOYEE] SET NAME = ? ,  DESIGNATION = ? , "
				+ "  EMAIL = ? ,  DOB = ? ,  NIC = ?,  GENDER = ?,  PERMENENTADDRESS = ?, TEMPORARYADDRESS = ?, "
				+ "  MOBILENO = ?,  OTHERNO = ?,  DEPTID = ?,  MARITALSTATUS = ?,  DATEOFJOIN = ?,  MODBY = ?,  EPF = ?,  BASIS  = ? WHERE ID = ?";
		String message = "Error";
		Connection conn = null;
		PreparedStatement ps = null;
		int status = 0;
		
        BasicData empBasic = (BasicData)employee;
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, empBasic.getEmployeename());
			ps.setString(2, empBasic.getEmployeedesignation());
			ps.setString(3, empBasic.getEmployeeemail());
			ps.setString(4, empBasic.getEmployeedateofbirth());
			ps.setString(5, empBasic.getEmployeenic());
			ps.setString(6, empBasic.getEmployeegender());
			ps.setString(7,	empBasic.getEmployeepermenetaddress());
			ps.setString(8,	empBasic.getEmployeetemporaryaddress());
			ps.setString(9, empBasic.getEmployeemobile());
			ps.setString(10, empBasic.getEmployeetelephone());
			ps.setString(11, empBasic.getEmployeedepartment());
			ps.setString(12, empBasic.getEmployeemaritalstatus());
			ps.setString(13, empBasic.getEmployeejoindate());
			ps.setString(14, "S");
			ps.setString(15, empBasic.getEmployeeepf());
			ps.setString(16, empBasic.getEmployeebasis());
			ps.setString(17, "1");
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				int generatedKey = 0;
				message = "Succesfull";
				
				if (rs.next()) {
					generatedKey = rs.getInt(1);
				}
				status = generatedKey;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}
		


	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return (Integer) null;
	}	
	
	@Override
	public Object find(int empEpf)throws SQLException, Exception {
		String query = "select * from [hra-2].[dbo].[HRA.EMPLOYEE] where ID = ?";
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
		String query = "select EPF, NAME,DESIGNATION, MOBILENO from [hra-2].[dbo].[HRA.EMPLOYEE] where (EPF LIKE   ? OR NAME LIKE ? OR DESIGNATION LIKE  ? OR MOBILENO LIKE  ?)";
		String query1 = "select EPF, NAME,DESIGNATION, MOBILENO from [hra-2].[dbo].[HRA.EMPLOYEE] where match (NAME) AGAINST(?)";
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


}