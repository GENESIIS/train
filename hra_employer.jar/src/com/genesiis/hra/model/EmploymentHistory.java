package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;

public class EmploymentHistory extends Employee{

	private int ehid;
	private int ehEmployeeid; 
	private String ehEmployername; 
	private String ehDesignation;
	private String ehStartdate;
	private String  ehEnddate;
	private String ehBasis;
	private String ehComments;
	private String ehEmail;
	
	private String ehReferenceonename;
	private String ehReferenceonephone;
	private String ehReferenceonemobile;
	private String ehReferenceoneaddress;
	private String ehReferenceonedesignation;
	private String ehReferenceonecomments;
	
	private String ehReferencetwoname;
	private String ehReferencetwophone;
	private String ehReferencetwomobile;
	private String ehReferencetwoaddress;
	private String ehReferencetwodesignation;
	private String ehReferencetwocomments;
	
	private String ehReferencemodby;
	private String ehReferencemodon;
	
	
	
	

	public int getEhid() {
		return ehid;
	}

	public void setEhid(int ehid) {
		this.ehid = ehid;
	}

	public int getEhEmployeeid() {
		return ehEmployeeid;
	}

	public void setEhEmployeeid(int ehEmployeeid) {
		this.ehEmployeeid = ehEmployeeid;
	}

	public String getEhEmployername() {
		return ehEmployername;
	}

	public void setEhEmployername(String ehEmployername) {
		this.ehEmployername = ehEmployername;
	}

	public String getEhDesignation() {
		return ehDesignation;
	}

	public void setEhDesignation(String ehDesignation) {
		this.ehDesignation = ehDesignation;
	}

	public String getEhStartdate() {
		return ehStartdate;
	}

	public void setEhStartdate(String ehStartdate) {
		this.ehStartdate = ehStartdate;
	}

	public String getEhEnddate() {
		return ehEnddate;
	}

	public void setEhEnddate(String ehEnddate) {
		this.ehEnddate = ehEnddate;
	}

	public String getEhBasis() {
		return ehBasis;
	}

	public void setEhBasis(String ehBasis) {
		this.ehBasis = ehBasis;
	}

	public String getEhComments() {
		return ehComments;
	}

	public void setEhComments(String ehComments) {
		this.ehComments = ehComments;
	}

	public String getEhEmail() {
		return ehEmail;
	}

	public void setEhEmail(String ehEmail) {
		this.ehEmail = ehEmail;
	}

	public String getEhReferenceonename() {
		return ehReferenceonename;
	}

	public void setEhReferenceonename(String ehReferenceonename) {
		this.ehReferenceonename = ehReferenceonename;
	}

	public String getEhReferenceonephone() {
		return ehReferenceonephone;
	}

	public void setEhReferenceonephone(String ehReferenceonephone) {
		this.ehReferenceonephone = ehReferenceonephone;
	}

	public String getEhReferenceonemobile() {
		return ehReferenceonemobile;
	}

	public void setEhReferenceonemobile(String ehReferenceonemobile) {
		this.ehReferenceonemobile = ehReferenceonemobile;
	}

	public String getEhReferenceoneaddress() {
		return ehReferenceoneaddress;
	}

	public void setEhReferenceoneaddress(String ehReferenceoneaddress) {
		this.ehReferenceoneaddress = ehReferenceoneaddress;
	}

	public String getEhReferenceonedesignation() {
		return ehReferenceonedesignation;
	}

	public void setEhReferenceonedesignation(String ehReferenceonedesignation) {
		this.ehReferenceonedesignation = ehReferenceonedesignation;
	}

	public String getEhReferenceonecomments() {
		return ehReferenceonecomments;
	}

	public void setEhReferenceonecomments(String ehReferenceonecomments) {
		this.ehReferenceonecomments = ehReferenceonecomments;
	}

	public String getEhReferencetwoname() {
		return ehReferencetwoname;
	}

	public void setEhReferencetwoname(String ehReferencetwoname) {
		this.ehReferencetwoname = ehReferencetwoname;
	}

	public String getEhReferencetwophone() {
		return ehReferencetwophone;
	}

	public void setEhReferencetwophone(String ehReferencetwophone) {
		this.ehReferencetwophone = ehReferencetwophone;
	}

	public String getEhReferencetwomobile() {
		return ehReferencetwomobile;
	}

	public void setEhReferencetwomobile(String ehReferencetwomobile) {
		this.ehReferencetwomobile = ehReferencetwomobile;
	}

	public String getEhReferencetwoaddress() {
		return ehReferencetwoaddress;
	}

	public void setEhReferencetwoaddress(String ehReferencetwoaddress) {
		this.ehReferencetwoaddress = ehReferencetwoaddress;
	}

	public String getEhReferencetwodesignation() {
		return ehReferencetwodesignation;
	}

	public void setEhReferencetwodesignation(String ehReferencetwodesignation) {
		this.ehReferencetwodesignation = ehReferencetwodesignation;
	}

	public String getEhReferencetwocomments() {
		return ehReferencetwocomments;
	}

	public void setEhReferencetwocomments(String ehReferencetwocomments) {
		this.ehReferencetwocomments = ehReferencetwocomments;
	}

	public String getEhReferencemodby() {
		return ehReferencemodby;
	}

	public void setEhReferencemodby(String ehReferencemodby) {
		this.ehReferencemodby = ehReferencemodby;
	}

	public String getEhReferencemodon() {
		return ehReferencemodon;
	}

	public void setEhReferencemodon(String ehReferencemodon) {
		this.ehReferencemodon = ehReferencemodon;
	}

	
	public EmploymentHistory() {
		super();
	}
	
	public EmploymentHistory(String employeeEpf) {
		super(employeeEpf);
		// TODO Auto-generated constructor stub
	}

	
	static Logger log = Logger.getLogger(EmploymentHistory.class.getName());
	
	public EmploymentHistory(int ehId, int ehEmployeeid, String ehEmployername,
			String ehDesignation, String ehStartdate, String ehEnddate,
			String ehBasis, String ehComments, String ehEmail,
			String ehReferenceonename, String ehReferenceonephone,
			String ehReferenceonemobile, String ehReferenceoneaddress,
			String ehReferenceonedesignation, String ehReferenceonecomments,
			String ehReferencetwoname, String ehReferencetwophone,
			String ehReferencetwomobile, String ehReferencetwoaddress,
			String ehReferencetwodesignation, String ehReferencetwocomments,
			String ehReferencemodby, String ehReferencemodon) {
		super();
		this.ehid = ehId;
		this.ehEmployeeid = ehEmployeeid;
		this.ehEmployername = ehEmployername;
		this.ehDesignation = ehDesignation;
		this.ehStartdate = ehStartdate;
		this.ehEnddate = ehEnddate;
		this.ehBasis = ehBasis;
		this.ehComments = ehComments;
		this.ehEmail = ehEmail;
		this.ehReferenceonename = ehReferenceonename;
		this.ehReferenceonephone = ehReferenceonephone;
		this.ehReferenceonemobile = ehReferenceonemobile;
		this.ehReferenceoneaddress = ehReferenceoneaddress;
		this.ehReferenceonedesignation = ehReferenceonedesignation;
		this.ehReferenceonecomments = ehReferenceonecomments;
		this.ehReferencetwoname = ehReferencetwoname;
		this.ehReferencetwophone = ehReferencetwophone;
		this.ehReferencetwomobile = ehReferencetwomobile;
		this.ehReferencetwoaddress = ehReferencetwoaddress;
		this.ehReferencetwodesignation = ehReferencetwodesignation;
		this.ehReferencetwocomments = ehReferencetwocomments;
		this.ehReferencemodby = ehReferencemodby;
		this.ehReferencemodon = ehReferencemodon;
	}

	
	@Override
	public boolean isValid(Object object) {

		DataValidator validator = new DataValidator();
		EmploymentHistory eh = (EmploymentHistory) object;

		if (((validator.isValidString(eh.getEhBasis()) == true)
				&& (validator.isValidString(eh.getEhComments()) == true)
				&& (validator.isValidString(eh.getEhDesignation()) == true)
				&& (validator.isValidString(eh.getEhEmail()) == true)
				&& (validator.isValidString(eh.getEhEmployername()) == true)
				&& (validator.isValidString(eh.getEhEnddate()) == true)
				&& (validator.isValidString(eh.getEhStartdate()) == true)
				&&

				(validator.isValidString(eh.getEhReferencemodby()) == true)
				&&

				(validator.isValidString(eh.getEhReferenceoneaddress()) == true)
				&& (validator.isValidString(eh.getEhReferenceonecomments()) == true)
				&& (validator.isValidString(eh.getEhReferenceonedesignation()) == true)
				&& (validator.isValidString(eh.getEhReferenceonemobile()) == true)
				&& (validator.isValidString(eh.getEhReferenceonename()) == true)
				&& (validator.isValidString(eh.getEhReferenceonephone()) == true)
				&&

				(validator.isValidString(eh.getEhReferencetwoaddress()) == true)
				&& (validator.isValidString(eh.getEhReferencetwocomments()) == true)
				&& (validator.isValidString(eh.getEhReferencetwodesignation()) == true)
				&& (validator.isValidString(eh.getEhReferenceonemobile()) == true)
				&& (validator.isValidString(eh.getEhReferencetwoname()) == true) && (validator
					.isValidString(eh.getEhReferencetwophone()) == true)

		)) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public boolean isValidEmployeeID(Object object) {

		DataValidator validator = new DataValidator();
		EmploymentHistory eh = (EmploymentHistory) object;

		if (((validator.isValidInt(eh.getEhEmployeeid()) == true))) {
			return true;
		} else {
			return false;
		}

	}

	@Override
public boolean isValidUpdate(Object object) {
	
	DataValidator validator = new DataValidator();
	EmploymentHistory eh = (EmploymentHistory) object;

	if ( ( (validator.isValidString(eh.getEhBasis()) == true) && 			(validator.isValidString(eh.getEhComments()) == true) && 			(validator.isValidString(eh.getEhDesignation()) == true) && 
			(validator.isValidString(eh.getEhEmail()) == true) &&			(validator.isValidString(eh.getEhEmployername()) == true) &&			(validator.isValidString(eh.getEhEnddate()) == true) &&
			(validator.isValidString(eh.getEhStartdate()) == true) &&			(validator.isValidString(eh.getEhReferencemodby()) == true) &&
			
			(validator.isValidString(eh.getEhReferenceoneaddress()) == true) &&			(validator.isValidString(eh.getEhReferenceonecomments()) == true) &&			(validator.isValidString(eh.getEhReferenceonedesignation()) == true) &&
			(validator.isValidString(eh.getEhReferenceonemobile()) == true) &&			(validator.isValidString(eh.getEhReferenceonename()) == true) &&			(validator.isValidString(eh.getEhReferenceonephone()) == true) &&
			
			(validator.isValidString(eh.getEhReferencetwoaddress()) == true) &&
			(validator.isValidString(eh.getEhReferencetwocomments()) == true) &&
			(validator.isValidString(eh.getEhReferencetwodesignation()) == true) &&
			(validator.isValidString(eh.getEhReferenceonemobile()) == true) &&
			(validator.isValidString(eh.getEhReferencetwoname()) == true) &&
			(validator.isValidString(eh.getEhReferencetwophone()) == true)
			
			
			)) {
		return true;
	} else {
		return false;
	}
	
}

	@Override
	public int add(Object object) {
		
		DataValidator dataValidator = new DataValidator();

		String query = "INSERT INTO [HRA.EMPLOYMENTHISTORY] (EMPLOYEEID,EMPLOYERNAME,DESIGNATION,STARTDATE,ENDDATE,BASIS,COMMENTS,EMAIL,"
				+ "REFERENCEONENAME,REFERENCEONEPHONE,REFERENCEONEMOBILE,REFERENCEONEADDRESS,REFERENCEONEDESIGNATION,REFERENCEONECOMMENTS,"
				+ "REFERENCETWOENAME,REFERENCETWOPHONE,REFERENCETWOMOBILE,REFERENCETWOADDRESS,REFERENCETWODESIGNATION,REFERENCETWOCOMMENTS,"
				+ "MODBY,MODON ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE())";
		int status = -1;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		EmploymentHistory eh = (EmploymentHistory) object;

		try {
			conn = ConnectionManager.getConnection();
			
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(eh.getEhEmployeeid()));
			preparedStatement.setString(2, String.valueOf(eh.getEhEmployername()));
			preparedStatement.setString(3, String.valueOf(eh.getEhDesignation()));
			preparedStatement.setDate(4, dataValidator.convertStringDatetoSqlDate(eh.getEhStartdate()));
			preparedStatement.setDate(5, dataValidator.convertStringDatetoSqlDate(eh.getEhEnddate()));
			preparedStatement.setString(6, String.valueOf(eh.getEhBasis()));
			preparedStatement.setString(7, String.valueOf(eh.getEhComments()));
			preparedStatement.setString(8, String.valueOf(eh.getEhEmail()));
			
			preparedStatement.setString(9, String.valueOf(eh.getEhReferenceonename()));
			preparedStatement.setString(10, String.valueOf(eh.getEhReferenceonephone()));
			preparedStatement.setString(11, String.valueOf(eh.getEhReferenceonemobile()));
			preparedStatement.setString(12, String.valueOf(eh.getEhReferenceoneaddress()));
			preparedStatement.setString(13, String.valueOf(eh.getEhReferenceonedesignation()));
			preparedStatement.setString(14, String.valueOf(eh.getEhReferenceonecomments()));
			
			preparedStatement.setString(15, String.valueOf(eh.getEhReferencetwoname()));
			preparedStatement.setString(16, String.valueOf(eh.getEhReferencetwophone()));
			preparedStatement.setString(17, String.valueOf(eh.getEhReferencetwomobile()));
			preparedStatement.setString(18, String.valueOf(eh.getEhReferencetwoaddress()));
			preparedStatement.setString(19, String.valueOf(eh.getEhReferencetwodesignation()));
			preparedStatement.setString(20, String.valueOf(eh.getEhReferencetwocomments()));
			
			preparedStatement.setString(21, String.valueOf(eh.getEhReferencemodby()));


			int rowsInserted = preparedStatement.executeUpdate();

			if (rowsInserted > 0) {
				status = 1;
			}
			
		} catch (SQLException exception) {
			log.info("SQLException - "+ exception);
			exception.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException exception) {
				log.info("SQLException - "+ exception);
				exception.printStackTrace();
			}
		}
		return status;
	}
	
	@Override
	public List<Object> getRetrive(String id) {
		
		// TODO Auto-generated method stub
		String query = "SELECT EH.ID,EH.EMPLOYEEID,EH.EMPLOYERNAME,EH.DESIGNATION,EH.STARTDATE,EH.ENDDATE,EH.BASIS,EH.COMMENTS,EH.EMAIL,"
				+ "EH.REFERENCEONENAME, EH.REFERENCEONEPHONE, EH.REFERENCEONEMOBILE, EH.REFERENCEONEADDRESS, EH.REFERENCEONEDESIGNATION, EH.REFERENCEONECOMMENTS,"
				+ "EH.REFERENCETWOENAME, EH.REFERENCETWOPHONE, EH.REFERENCETWOMOBILE, EH.REFERENCETWOADDRESS, EH.REFERENCETWODESIGNATION, EH.REFERENCETWOCOMMENTS,"
				+ "EH.MODBY, EH.MODON  FROM [HRA.EMPLOYMENTHISTORY] EH, [HRA.EMPLOYEE] EM WHERE EM.EMPLOYEEID = EH.EMPLOYEEID AND EMPLOYEEID = ?";
		
		String message = "Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rsRetriveData = null;
		List <Object> employeeHistoryList = new ArrayList<Object>();
		
		EmploymentHistory employee = new EmploymentHistory();
		try {

			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "1");
			
			rsRetriveData = preparedStatement.executeQuery();			 
				
				try{
					if (rsRetriveData.next()) {
						
						// set data to entity class
						employee.setEhid(rsRetriveData.getInt("ID"));
						employee.setEhEmployeeid(rsRetriveData.getInt("EMPLOYEEID"));
						employee.setEhEmployername(rsRetriveData.getString("EMPLOYERNAME")); 						
						employee.setEhDesignation(rsRetriveData.getString("DESIGNATION"));
						employee.setEhStartdate(rsRetriveData.getString("STARTDATE"));
						employee.setEhEnddate(rsRetriveData.getString("ENDDATE"));
						employee.setEhBasis(rsRetriveData.getString("BASIS"));
						employee.setEhComments(rsRetriveData.getString("COMMENTS"));
						employee.setEhEmail(rsRetriveData.getString("EMAIL"));
						
						employee.setEhReferenceonename(rsRetriveData.getString("REFERENCEONENAME"));
						employee.setEhReferenceonephone(rsRetriveData.getString("REFERENCEONEPHONE"));
						employee.setEhReferenceonemobile(rsRetriveData.getString("REFERENCEONEMOBILE")); 
						employee.setEhReferenceoneaddress(rsRetriveData.getString("REFERENCEONEADDRESS"));
						employee.setEhReferenceonedesignation(rsRetriveData.getString("REFERENCEONEDESIGNATION"));
						employee.setEhReferenceonecomments(rsRetriveData.getString("REFERENCEONECOMMENTS"));
						
						employee.setEhReferencetwoname(rsRetriveData.getString("REFERENCETWOENAME"));
						employee.setEhReferencetwophone(rsRetriveData.getString("REFERENCETWOPHONE"));
						employee.setEhReferencetwomobile(rsRetriveData.getString("REFERENCETWOMOBILE")); 
						employee.setEhReferencetwoaddress(rsRetriveData.getString("REFERENCETWOADDRESS"));
						employee.setEhReferencetwodesignation(rsRetriveData.getString("REFERENCETWODESIGNATION"));
						employee.setEhReferencetwocomments(rsRetriveData.getString("REFERENCETWOCOMMENTS"));
						
						employee.setEhReferencemodby(rsRetriveData.getString("MODBY"));
						employee.setEhReferencemodon(rsRetriveData.getString("MODON"));
						
						
						employeeHistoryList.add(employee);//add data to list


					}
				}catch(Exception e){
					log.info("Exception - "+ e);
				}
				
			
		} catch (SQLException exception) {
			log.info("Exception - "+ exception);
			exception.printStackTrace();
		}
		finally{
			try {
				if(conn!=null && preparedStatement!=null){
					preparedStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				log.info("Exception - "+ e);
				e.printStackTrace();
			}
		}
		return employeeHistoryList;
	}
	
	
	@Override
	public Object getRetriveRecode(String id) {
		
		log.info("*****************************getRetriveRecode"+id);
		// TODO Auto-generated method stub
		String query = "SELECT EH.ID,EH.EMPLOYEEID,EH.EMPLOYERNAME,EH.DESIGNATION,EH.STARTDATE,EH.ENDDATE,EH.BASIS,EH.COMMENTS,EH.EMAIL,"
				+ "EH.REFERENCEONENAME, EH.REFERENCEONEPHONE, EH.REFERENCEONEMOBILE, EH.REFERENCEONEADDRESS, EH.REFERENCEONEDESIGNATION, EH.REFERENCEONECOMMENTS,"
				+ "EH.REFERENCETWOENAME, EH.REFERENCETWOPHONE, EH.REFERENCETWOMOBILE, EH.REFERENCETWOADDRESS, EH.REFERENCETWODESIGNATION, EH.REFERENCETWOCOMMENTS,"
				+ "EH.MODBY, EH.MODON  FROM [HRA.EMPLOYMENTHISTORY] EH, [HRA.EMPLOYEE] EM WHERE EM.ID = EH.EMPLOYEEID AND EH.ID = ?";
		
		String message = "Error";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rsRetriveData = null;

		EmploymentHistory employee = new EmploymentHistory();
		try {

			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(id));
			
			rsRetriveData = preparedStatement.executeQuery();			 
				
				try{
					if (rsRetriveData.next()) {
						
						log.info("*****************************rsRetriveData"+id);
						
						// set data to entity class
						employee.setEhid(rsRetriveData.getInt("ID"));
						employee.setEhEmployeeid(rsRetriveData.getInt("EMPLOYEEID"));
						employee.setEhEmployername(rsRetriveData.getString("EMPLOYERNAME")); 						
						employee.setEhDesignation(rsRetriveData.getString("DESIGNATION"));
						employee.setEhStartdate(rsRetriveData.getString("STARTDATE"));
						employee.setEhEnddate(rsRetriveData.getString("ENDDATE"));
						employee.setEhBasis(rsRetriveData.getString("BASIS"));
						employee.setEhComments(rsRetriveData.getString("COMMENTS"));
						employee.setEhEmail(rsRetriveData.getString("EMAIL"));
						
						employee.setEhReferenceonename(rsRetriveData.getString("REFERENCEONENAME"));
						employee.setEhReferenceonephone(rsRetriveData.getString("REFERENCEONEPHONE"));
						employee.setEhReferenceonemobile(rsRetriveData.getString("REFERENCEONEMOBILE")); 
						employee.setEhReferenceoneaddress(rsRetriveData.getString("REFERENCEONEADDRESS"));
						employee.setEhReferenceonedesignation(rsRetriveData.getString("REFERENCEONEDESIGNATION"));
						employee.setEhReferenceonecomments(rsRetriveData.getString("REFERENCEONECOMMENTS"));
						
						employee.setEhReferencetwoname(rsRetriveData.getString("REFERENCETWOENAME"));
						employee.setEhReferencetwophone(rsRetriveData.getString("REFERENCETWOPHONE"));
						employee.setEhReferencetwomobile(rsRetriveData.getString("REFERENCETWOMOBILE")); 
						employee.setEhReferencetwoaddress(rsRetriveData.getString("REFERENCETWOADDRESS"));
						employee.setEhReferencetwodesignation(rsRetriveData.getString("REFERENCETWODESIGNATION"));
						employee.setEhReferencetwocomments(rsRetriveData.getString("REFERENCETWOCOMMENTS"));
						
						employee.setEhReferencemodby(rsRetriveData.getString("MODBY"));
						employee.setEhReferencemodon(rsRetriveData.getString("MODON"));

					}
				}catch(Exception e){
					log.info("Exception - "+ e);
				}
				
			
		} catch (SQLException exception) {
			log.info("Exception - "+ exception);
			exception.printStackTrace();
		}
		finally{
			try {
				if(conn!=null && preparedStatement!=null){
					preparedStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				log.info("Exception - "+ e);
				e.printStackTrace();
			}
		}
		return employee;
	}
	
	
	
	
	@Override
	public int updateEmployeeHistory(Object object) {
		
		
		String query = "UPDATE [HRA.EMPLOYMENTHISTORY] SET EMPLOYERNAME=? , DESIGNATION =? , STARTDATE=? , ENDDATE=? , BASIS=? , COMMENTS=? , EMAIL=? ,"
				+ "REFERENCEONENAME=? , REFERENCEONEPHONE=? , REFERENCEONEMOBILE=? , REFERENCEONEADDRESS=? , REFERENCEONEDESIGNATION =? , REFERENCEONECOMMENTS=? ,"
				+ "REFERENCETWOENAME=? , REFERENCETWOPHONE=? , REFERENCETWOMOBILE=? , REFERENCETWOADDRESS=? , REFERENCETWODESIGNATION=? , REFERENCETWOCOMMENTS=? , MODBY=? WHERE ID=?";
		
		
		
		int status = -1;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		EmploymentHistory eh = (EmploymentHistory) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, eh.getEhEmployername());
			preparedStatement.setString(2, eh.getEhDesignation());
			preparedStatement.setString(3, eh.getEhStartdate());
			preparedStatement.setString(4, eh.getEhEnddate());
			preparedStatement.setString(5, eh.getEhBasis());
			preparedStatement.setString(6, eh.getEhComments());
			preparedStatement.setString(7, eh.getEhEmail());
			
			preparedStatement.setString(8, eh.getEhReferenceonename());
			preparedStatement.setString(9, eh.getEhReferenceonephone());
			preparedStatement.setString(10, eh.getEhReferenceonemobile());
			preparedStatement.setString(11, eh.getEhReferenceoneaddress());
			preparedStatement.setString(12, eh.getEhReferenceonedesignation());
			preparedStatement.setString(13, eh.getEhReferenceonecomments());
			
			preparedStatement.setString(14, eh.getEhReferencetwoname());
			preparedStatement.setString(15, eh.getEhReferencetwophone());
			preparedStatement.setString(16, eh.getEhReferencetwomobile());
			preparedStatement.setString(17, eh.getEhReferencetwoaddress());
			preparedStatement.setString(18, eh.getEhReferencetwodesignation());
			preparedStatement.setString(19, eh.getEhReferencetwocomments());
			
			
			preparedStatement.setString(20, "SYSTEM");
			preparedStatement.setInt(21, eh.getEhid());

			log.info("getEhid:-"+eh.getEhid());

			int rowsUpdated = preparedStatement.executeUpdate();
			
			if (rowsUpdated > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			log.info("Exception - "+ exception);
			exception.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException exception) {
				log.info("Exception - "+ exception);
				exception.printStackTrace();
			}
		}
		return status;
	}

}
