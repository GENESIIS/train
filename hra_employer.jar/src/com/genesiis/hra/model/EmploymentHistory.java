package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;

public class EmploymentHistory extends Employee{

	private int ehId;
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
	
	
	
	public int getEhId() {
		return ehId;
	}

	public void setEhId(int ehId) {
		this.ehId = ehId;
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
		this.ehId = ehId;
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

		if ( ( (validator.isValidString(eh.getEhBasis()) == true) && 
				(validator.isValidString(eh.getEhComments()) == true) && 
				(validator.isValidString(eh.getEhDesignation()) == true) && 
				(validator.isValidString(eh.getEhEmail()) == true) &&
				(validator.isValidString(eh.getEhEmployername()) == true) &&
				(validator.isValidString(eh.getEhEnddate()) == true) &&
				(validator.isValidString(eh.getEhStartdate()) == true) &&
				
				(validator.isValidString(eh.getEhReferencemodby()) == true) &&
				
				(validator.isValidString(eh.getEhReferenceoneaddress()) == true) &&
				(validator.isValidString(eh.getEhReferenceonecomments()) == true) &&
				(validator.isValidString(eh.getEhReferenceonedesignation()) == true) &&
				(validator.isValidString(eh.getEhReferenceonemobile()) == true) &&
				(validator.isValidString(eh.getEhReferenceonename()) == true) &&
				(validator.isValidString(eh.getEhReferenceonephone()) == true) &&
				
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
		return status;
	}
	
}
