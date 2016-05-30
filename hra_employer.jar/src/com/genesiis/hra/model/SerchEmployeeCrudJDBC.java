package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.genesiis.hra.utill.ConnectionManager;

/* *************************************************
 * 20160520 pc HRA-30  created SercEmPloyeeCtudJDBC class 
 * 20160520 pc HRA-30  created find() method
*/
public class SerchEmployeeCrudJDBC extends EmployeeCrudJDBC {

	public Object find(int empEpf) {
		// TODO Auto-generated method stub
		String query = "select * from [hra-2].[dbo].[HRA.EMPLOYEE] where EPF = ?";
		Connection conn = null;
		PreparedStatement pd = null;
		ResultSet findData = null;
		
		Employee employee = new Employee(); 
		try {
			conn = ConnectionManager.getConnection(); 
			pd = conn.prepareStatement(query);
			pd.setInt(1, empEpf);
			findData = pd.executeQuery();
			log.info("find int" + empEpf);
			try { 
				if(findData.next()){
					// set data to entity class
					employee.setEmployeeid(findData.getString("ID"));
					employee.setEmployeename(findData.getString("NAME"));
					employee.setEmployeedesignation(findData
							.getString("DESIGNATION"));
					employee.setEmployeeemail(findData.getString("EMAIL"));
					employee.setEmployeedateofbirth(findData
							.getString("DOB"));
					employee.setEmployeenic(findData.getString("NIC"));
					employee.setEmployeegender(findData.getString("GENDER"));
					employee.setEmployeepermenetaddress(findData
							.getString("PERMENENTADDRESS"));
					employee.setEmployeemobile(findData
							.getString("MOBILENO"));
					employee.setEmployeedepartment(findData
							.getString("DEPTID"));
					employee.setEmployeetelephone(findData
							.getString("OTHERNO"));
					employee.setEmployeejoindate(findData
							.getString("DATEOFJOIN"));
					employee.setEmployeeepf(findData.getString("EPF"));
					employee.setEmployeemaritalstatus(findData
							.getString("MARITALSTATUS"));
					employee.setEmployeebasis(findData.getString("BASIS"));
					employee.setEmployeetemporaryaddress(findData
							.getString("TEMPORARYADDRESS"));
				}
			} catch (SQLException e) {
				// TODO: handle exception
				log.info("find epf methode "+e.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("find epf methode "+e.toString());
		}finally{
			try {
				if (pd != null) {
					pd.close();
				}
				conn.close();
			} catch (SQLException e) {
				log.info("find epf methode finally "+e.toString());
			}
		}
		return employee;
	}

	@Override
	public List<Object> find(String designation) {
		// TODO Auto-generated method stub
		String query = "select ID, NAME,D ESIGNATION, MOBILENO from HRA.EMPLOYEE where DESIGNATION = ?";
		String messege = "";
		Connection conn = null;
		PreparedStatement pd = null;
		ResultSet findData = null;
		
		Employee employee = new Employee();
		
		try {
			conn = ConnectionManager.getConnection();
			pd = conn.prepareStatement(query);
			pd.setString(1, designation);
			findData = pd.executeQuery();
			
			try {
				if(findData.next()){
					// set data to entity class
					employee.setEmployeeid(findData.getString("ID"));
					employee.setEmployeename(findData.getString("NAME"));
					employee.setEmployeedesignation(findData.getString("DESIGNATION"));					
					employee.setEmployeemobile(findData.getString("MOBILENO"));					
										
				}
			} catch (SQLException e) {
				// TODO: handle exception
				log.info("find methode keyword serch"+e.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("find methode keyword serch"+e.toString());
		}finally{
			try {
				if (pd != null) {
					pd.close();
				}
				conn.close();
			} catch (SQLException e) {
				log.info("find methode keyword serch finally"+e.toString());
			}
		}
		return null;
	}
}
