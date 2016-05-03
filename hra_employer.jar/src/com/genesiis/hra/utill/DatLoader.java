package com.genesiis.hra.utill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.genesiis.hra.model.Employee;


  
public class DatLoader implements IDataLoader {
	
    public String  InsertData(){
    	///  Insert data in to table
    	String msge = "Error";
    	String query = "INSERT INTO [HRA.EMPLOYEE] (ID, NAME, DESIGNATION,EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, EPF, BASIS) "
				      + "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";
		
		Connection conn = null;
		
		PreparedStatement preparedStatement = null;
		

		try {
			//get connection
			conn = ConnectionManager.getConnection();
			
			preparedStatement = conn.prepareStatement(query);
			
			// set dat to insert
			preparedStatement.setString(1, "EMP001");
			preparedStatement.setString(2, "Sandun" );
			preparedStatement.setString(3, "Praogramer");
			preparedStatement.setString(4, "sandun@gmail.com");
			preparedStatement.setString(5,"1988-12-08" );
			preparedStatement.setString(6, "883458235v" );
			preparedStatement.setString(7, "Male ");
			preparedStatement.setString(8, "123,jayanthipura road, battaramulla");
			preparedStatement.setString(9, "123,jayanthipura road, battaramulla");
			preparedStatement.setString(10, "0777837993");
			preparedStatement.setString(11, "0783452680");
			preparedStatement.setString(12,"HR" );
			preparedStatement.setString(13,"Single");
			preparedStatement.setString(14,"2005-03-04");
			preparedStatement.setString(15, "SYSTEM");
			preparedStatement.setString(16, "EPF0001");
			preparedStatement.setString(17,"mod");

			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				
				msge = "Succesfull";
				
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			
		}
    	
    	return null;
    }
	
	public String  UpdateData(){
		
		String query = "UPDATE [hra-2].[dbo].[HRA.EMPLOYEE] SET NAME = ?, DESIGNATION = ? WHERE ID = ?";
		
		String mesg = "Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		

		try {
			//get connection
			conn = ConnectionManager.getConnection();
			
			preparedStatement = conn.prepareStatement(query);
			
			//set to be updated
			preparedStatement.setString(1, "KAVIDU");
			preparedStatement.setString(2, "Programer");
			preparedStatement.setString(3, "1");
			

			int rows = preparedStatement.executeUpdate();
			
			if (rows > 0) {
				
				mesg = "Succesfully Updated";
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}			
		}
		
		
		return mesg;
	}
	
	public String  DeleteDta(){
		
		String query = "delete from from [hra-2].[dbo].[HRA.EMPLOYEE] where id = ?";
        Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet retriveData = null;
		
		 try
		    {	     		       
			    //get connection
				conn = ConnectionManager.getConnection();
				
				preparedStatement = conn.prepareStatement(query);
				
				preparedStatement.setString(1,  "1");
		 
		      // execute the preparedstatement
				preparedStatement.execute();
		       
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		
		return null;
	}
	
	public String  RetriveData(){
	
		String query = "select * from [hra-2].[dbo].[HRA.EMPLOYEE] where ID = ?";
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet retriveData = null;
		
		Employee employee = new Employee();
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "1");
			
			 retriveData = preparedStatement.executeQuery();
		
			 
				
				try{
					if (retriveData.next()) {
						employee.setEmployeeid(retriveData.getString("ID"));
						employee.setEmployeename(retriveData.getString("NAME"));
						employee.setEmployeedesignation(retriveData.getString("DESIGNATION")); 						
						employee.setEmployeeemail(retriveData.getString("EMAIL"));
						employee.setEmployeedob(retriveData.getString("DOB"));
						employee.setEmployeenic(retriveData.getString("NIC"));
						employee.setEmployeegender(retriveData.getString("GENDER"));
						employee.setEmployeedddress(retriveData.getString("PERMENENTADDRESS"));
						employee.setEmployeemobileno(retriveData.getString("MOBILENO"));
						employee.setDepartmentid(retriveData.getString("OTHERNO"));
						employee.setEmployeeotherno(retriveData.getString("DEPTID"));
						employee.setDateOfJoin(retriveData.getString("DATEOFJOIN")); 
						employee.setModon("MODON");
						employee.setModby("EPF");
						employee.setMARITALSTATUS("MARITALSTATUS");
						employee.setBASIS("BASIS");
						employee.setModby("modBy");
						
						return "Succesfull Retrived";
					}
				}catch(Exception e){
					
				}
				
			preparedStatement.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			
		}
		
		return null;
	}

}
