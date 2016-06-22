package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import org.jboss.logging.Logger;
import com.genesiis.hra.utill.ConnectionManager;

///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
//* 20160505 PN HRA-2  validateEmployee() method Modified.
//  20160622 PC HRA-30 Rename EmployeeManager to EmployeePersistJDBC 
//***********************************************/

public class EmployeePersistJDBC extends SearchPersistJDBC {
	static Logger log = Logger.getLogger(EmployeePersistJDBC.class.getName());

	@Override
	public int add(Object object) {
		 
		return 0;
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
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
	public List<Object> find(String keyWord) throws SQLException, Exception {
		List<Object> employList = new LinkedList<Object>();
		String query = "select EPF, NAME,DESIGNATION, MOBILENO from [hra-2].[dbo].[HRA.EMPLOYEE] where (EPF LIKE   ? OR NAME LIKE ? OR DESIGNATION LIKE  ? OR MOBILENO LIKE  ?)";
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
				log.info("find methode "+e.toString());
			}
		} catch (Exception ex) {
			log.info("find methode "+ex.toString());
		}finally{
			try {
				if (pd != null) {
					pd.close();
				}
				if (findData != null) {
					findData.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.info("find methode "+ e.toString());
			}
		}
		return employList;
	}

	@Override
	public List<Object> getAll() {
		return null;
	}

	public String validateEmployee(Employee employee) throws ParseException {
		
		return null;
	}

	
	public boolean validEmployee(Employee employee) throws ParseException {
		
			return false;		
	}
	
	public List<String> getManagers() {
		
		return null;
	}


	
}
