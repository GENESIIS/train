package com.genesiis.hra.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import com.genesiis.hra.utill.ConnectionManager;



/**
 * Session Bean implementation class DepartmentDao
 */
@Stateless
public class DataManager implements IDataAccessor { 

	static Logger log = Logger.getLogger(DataManager.class.getName());

	@Override
	public String add(Object object) {
		
		return null;
	}

	@Override
	public String update(Object object) {
		
		return null;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees retrive(String id) {
		// TODO Auto-generated method stub		
		String query = "select * from [hra-2].[dbo].[HRA.EMPLOYEE] where ID = ?";		
		String message ="Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet retriveData = null;		
		Employees employee = new Employees();
		
		try {			
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "1");
			
			 retriveData = preparedStatement.executeQuery();			 
				
				try{
					if (retriveData.next()) {
						// set data to entity class
						employee.setEmployeeid(retriveData.getString("ID"));
						employee.setEmployeename(retriveData.getString("NAME"));
						employee.setEmployeedesignation(retriveData.getString("DESIGNATION")); 						
						employee.setEmployeeemail(retriveData.getString("EMAIL"));
						employee.setEmployeedob(retriveData.getString("DOB"));
						employee.setEmployeenic(retriveData.getString("NIC"));
						employee.setEmployeegender(retriveData.getString("GENDER"));
						employee.setEmployeedddress(retriveData.getString("PERMENENTADDRESS"));
						employee.setEmployeemobileno(retriveData.getString("MOBILENO"));
						employee.setDepartmentid(retriveData.getString("DEPTID"));
						employee.setEmployeeotherno(retriveData.getString("OTHERNO"));
						employee.setDateOfJoin(retriveData.getString("DATEOFJOIN")); 
						employee.setModon(retriveData.getString("MODON"));
						employee.setEPF(retriveData.getString("EPF"));
						employee.setMARITALSTATUS(retriveData.getString("MARITALSTATUS"));
						employee.setBASIS(retriveData.getString("BASIS"));
						employee.setModby(retriveData.getString("modBy"));
						employee.setEmployeeTempdddress(retriveData.getString("TEMPORARYADDRESS"));					
						
					}
				}catch(Exception e){
					log.info(e.toString());
				}
				
			preparedStatement.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			
		}
		
		
		return employee;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
