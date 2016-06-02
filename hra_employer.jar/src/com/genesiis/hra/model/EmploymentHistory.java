package com.genesiis.hra.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;

public class EmploymentHistory extends Employee {

	static Logger log = Logger.getLogger(EmploymentHistory.class.getName());

	private int ehid;
	private String ehEmployeeid;
	private String ehEmployername;
	private String ehDesignation;
	private String ehStartdate;
	private String ehEnddate;
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

	public String getEhemployeeid() {
		return ehEmployeeid;
	}

	public void setEhemployeeid(String ehEmployeeid) {
		this.ehEmployeeid = ehEmployeeid;
	}

	public String getEhemployername() {
		return ehEmployername;
	}

	public void setEhemployername(String ehEmployername) {
		this.ehEmployername = ehEmployername;
	}

	public String getEhdesignation() {
		return ehDesignation;
	}

	public void setEhdesignation(String ehDesignation) {
		this.ehDesignation = ehDesignation;
	}

	public String getEhstartdate() {
		return ehStartdate;
	}

	public void setEhstartdate(String ehStartdate) {
		this.ehStartdate = ehStartdate;
	}

	public String getEhenddate() {
		return ehEnddate;
	}

	public void setEhenddate(String ehEnddate) {
		this.ehEnddate = ehEnddate;
	}

	public String getEhbasis() {
		return ehBasis;
	}

	public void setEhbasis(String ehBasis) {
		this.ehBasis = ehBasis;
	}

	public String getEhcomments() {
		return ehComments;
	}

	public void setEhcomments(String ehComments) {
		this.ehComments = ehComments;
	}

	public String getEhemail() {
		return ehEmail;
	}

	public void setEhemail(String ehEmail) {
		this.ehEmail = ehEmail;
	}

	public String getEhreferenceonename() {
		return ehReferenceonename;
	}

	public void setEhreferenceonename(String ehReferenceonename) {
		this.ehReferenceonename = ehReferenceonename;
	}

	public String getEhreferenceonephone() {
		return ehReferenceonephone;
	}

	public void setEhreferenceonephone(String ehReferenceonephone) {
		this.ehReferenceonephone = ehReferenceonephone;
	}

	public String getEhreferenceonemobile() {
		return ehReferenceonemobile;
	}

	public void setEhreferenceonemobile(String ehReferenceonemobile) {
		this.ehReferenceonemobile = ehReferenceonemobile;
	}

	public String getEhreferenceoneaddress() {
		return ehReferenceoneaddress;
	}

	public void setEhreferenceoneaddress(String ehReferenceoneaddress) {
		this.ehReferenceoneaddress = ehReferenceoneaddress;
	}

	public String getEhReferenceonedesignation() {
		return ehReferenceonedesignation;
	}

	public void setEhReferenceonedesignation(String ehReferenceonedesignation) {
		this.ehReferenceonedesignation = ehReferenceonedesignation;
	}

	public String getEhreferenceonecomments() {
		return ehReferenceonecomments;
	}

	public void setEhreferenceonecomments(String ehReferenceonecomments) {
		this.ehReferenceonecomments = ehReferenceonecomments;
	}

	public String getEhreferencetwoname() {
		return ehReferencetwoname;
	}

	public void setEhreferencetwoname(String ehReferencetwoname) {
		this.ehReferencetwoname = ehReferencetwoname;
	}

	public String getEhreferencetwophone() {
		return ehReferencetwophone;
	}

	public void setEhreferencetwophone(String ehReferencetwophone) {
		this.ehReferencetwophone = ehReferencetwophone;
	}

	public String getEhreferencetwomobile() {
		return ehReferencetwomobile;
	}

	public void setEhreferencetwomobile(String ehReferencetwomobile) {
		this.ehReferencetwomobile = ehReferencetwomobile;
	}

	public String getEhreferencetwoaddress() {
		return ehReferencetwoaddress;
	}

	public void setEhreferencetwoaddress(String ehReferencetwoaddress) {
		this.ehReferencetwoaddress = ehReferencetwoaddress;
	}

	public String getEhreferencetwodesignation() {
		return ehReferencetwodesignation;
	}

	public void setEhreferencetwodesignation(String ehReferencetwodesignation) {
		this.ehReferencetwodesignation = ehReferencetwodesignation;
	}

	public String getEhreferencetwocomments() {
		return ehReferencetwocomments;
	}

	public void setEhreferencetwocomments(String ehReferencetwocomments) {
		this.ehReferencetwocomments = ehReferencetwocomments;
	}

	public String getEhreferencemodby() {
		return ehReferencemodby;
	}

	public void setEhreferencemodby(String ehReferencemodby) {
		this.ehReferencemodby = ehReferencemodby;
	}

	public String getEhreferencemodon() {
		return ehReferencemodon;
	}

	public void setEhreferencemodon(String ehReferencemodon) {
		this.ehReferencemodon = ehReferencemodon;
	}

	public EmploymentHistory() {
		super();
	}

	public EmploymentHistory(String employeeEpf) {
		super(employeeEpf);
		// TODO Auto-generated constructor stub
	}

	public EmploymentHistory(int ehId, String ehEmployeeid, String ehEmployername,
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
	public int add(Object object) {

		String query = "INSERT INTO [HRA.EMPLOYMENTHISTORY] (EMPLOYEEID,EMPLOYERNAME,DESIGNATION,STARTDATE,ENDDATE,BASIS,COMMENTS,EMAIL,"
				+ "REFERENCEONENAME,REFERENCEONEPHONE,REFERENCEONEMOBILE,REFERENCEONEADDRESS,REFERENCEONEDESIGNATION,REFERENCEONECOMMENTS,"
				+ "REFERENCETWOENAME,REFERENCETWOPHONE,REFERENCETWOMOBILE,REFERENCETWOADDRESS,REFERENCETWODESIGNATION,REFERENCETWOCOMMENTS,"
				+ "MODBY,MODON ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE())";
		int status = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		EmploymentHistory eh = (EmploymentHistory) object;
		DataValidator validator = new DataValidator();
		try {
			conn = ConnectionManager.getConnection();

			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.valueOf(eh.getEhemployeeid()));
			ps.setString(2, String.valueOf(eh.getEhemployername()));
			ps.setString(3, String.valueOf(eh.getEhdesignation()));
			
			ps.setDate
			(4,	validator.convertStringDatetoSqlDate(eh.getEhstartdate()));
			ps.setDate
			(5,	validator.convertStringDatetoSqlDate(eh.getEhenddate()));
			
			ps.setString(6, String.valueOf(eh.getEhbasis()));
			ps.setString(7, String.valueOf(eh.getEhcomments()));
			ps.setString(8, String.valueOf(eh.getEhemail()));

			ps.setString(9, String.valueOf(eh.getEhreferenceonename()));
			ps.setString(10, String.valueOf(eh.getEhreferenceonephone()));
			ps.setString(11, String.valueOf(eh.getEhreferenceonemobile()));
			ps.setString(12, String.valueOf(eh.getEhreferenceoneaddress()));
			ps.setString(13, String.valueOf(eh.getEhReferenceonedesignation()));
			ps.setString(14, String.valueOf(eh.getEhreferenceonecomments()));

			ps.setString(15, String.valueOf(eh.getEhreferencetwoname()));
			ps.setString(16, String.valueOf(eh.getEhreferencetwophone()));
			ps.setString(17, String.valueOf(eh.getEhreferencetwomobile()));
			ps.setString(18, String.valueOf(eh.getEhreferencetwoaddress()));
			ps.setString(19, String.valueOf(eh.getEhreferencetwodesignation()));
			ps.setString(20, String.valueOf(eh.getEhreferencetwocomments()));

			ps.setString(21, String.valueOf(eh.getEhreferencemodby()));

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted > 0) {
				status = 1;
			}

		} catch (SQLException exception) {
			log.info("SQLException - " + exception);
			exception.printStackTrace();
		} catch (Exception ex) {
			log.info("Exception - " + ex);
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				log.info("SQLException - Finally - add" + exception);
				exception.printStackTrace();
			}
		}
		return status;
	}


	public Object find(String id) {

		String query = "SELECT EH.ID,EH.EMPLOYEEID,EH.EMPLOYERNAME,EH.DESIGNATION,EH.STARTDATE,EH.ENDDATE, EH.BASIS,EH.COMMENTS,EH.EMAIL, "
				+ "EH.REFERENCEONENAME, EH.REFERENCEONEPHONE, EH.REFERENCEONEMOBILE, EH.REFERENCEONEADDRESS, EH.REFERENCEONEDESIGNATION, EH.REFERENCEONECOMMENTS, "
				+ "EH.REFERENCETWOENAME, EH.REFERENCETWOPHONE, EH.REFERENCETWOMOBILE, EH.REFERENCETWOADDRESS, EH.REFERENCETWODESIGNATION, EH.REFERENCETWOCOMMENTS, "
				+ "EH.MODBY, EH.MODON  "
				+ "FROM [HRA.EMPLOYMENTHISTORY] EH, [HRA.EMPLOYEE] EM "
				+ "WHERE EM.ID = EH.EMPLOYEEID AND EH.ID = ? ";


		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		EmploymentHistory employee = new EmploymentHistory();
		try {

			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));

			rs = ps.executeQuery();

			try {
				if (rs.next()) {

					// set data to entity class
					employee.setEhid
					(rs.getInt("ID"));
					
					employee.setEhemployeeid
					(rs.getString("EMPLOYEEID"));
					
					employee.setEhemployername
					(rs.getString("EMPLOYERNAME"));
					
					employee.setEhdesignation
					(rs.getString("DESIGNATION"));
					
					employee.setEhstartdate
					(rs.getString("STARTDATE"));
					
					employee.setEhenddate(rs.getString("ENDDATE"));
					employee.setEhbasis(rs.getString("BASIS"));
					employee.setEhcomments(rs.getString("COMMENTS"));
					employee.setEhemail(rs.getString("EMAIL"));

					employee.setEhreferenceonename
					(rs.getString("REFERENCEONENAME"));
					
					employee.setEhreferenceonephone
					(rs.getString("REFERENCEONEPHONE"));
					employee.setEhreferenceonemobile
					(rs.getString("REFERENCEONEMOBILE"));
					employee.setEhreferenceoneaddress
					(rs.getString("REFERENCEONEADDRESS"));
					employee.setEhReferenceonedesignation
					(rs.getString("REFERENCEONEDESIGNATION"));
					employee.setEhreferenceonecomments
					(rs.getString("REFERENCEONECOMMENTS"));

					employee.setEhreferencetwoname
					(rs.getString("REFERENCETWOENAME"));
					employee.setEhreferencetwophone
					(rs.getString("REFERENCETWOPHONE"));
					employee.setEhreferencetwomobile
					(rs.getString("REFERENCETWOMOBILE"));
					employee.setEhreferencetwoaddress
					(rs.getString("REFERENCETWOADDRESS"));
					employee.setEhreferencetwodesignation
					(rs.getString("REFERENCETWODESIGNATION"));
					employee.setEhreferencetwocomments
					(rs.getString("REFERENCETWOCOMMENTS"));

					employee.setEhreferencemodby
					(rs.getString("MODBY"));
					employee.setEhreferencemodon
					(rs.getString("MODON"));

				}
			} catch (Exception e) {
				log.info("Exception - " + e);
			}

		} catch (SQLException exception) {
			log.info("Exception - " + exception);
			exception.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				log.info("Exception - " + e);
				e.printStackTrace();
			}
		}
		return employee;
	}
	
	
	

	@Override
	public int update(Object object) {
		String query = "UPDATE [HRA.EMPLOYMENTHISTORY] SET EMPLOYERNAME=? , DESIGNATION =? , STARTDATE=? , ENDDATE=? , BASIS=? , COMMENTS=? , EMAIL=? ,"
				+ "REFERENCEONENAME=? , REFERENCEONEPHONE=? , REFERENCEONEMOBILE=? , REFERENCEONEADDRESS=? , REFERENCEONEDESIGNATION =? , REFERENCEONECOMMENTS=? ,"
				+ "REFERENCETWOENAME=? , REFERENCETWOPHONE=? , REFERENCETWOMOBILE=? , REFERENCETWOADDRESS=? , REFERENCETWODESIGNATION=? , REFERENCETWOCOMMENTS=? , MODBY=? WHERE ID=?";

		int status = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		EmploymentHistory eh = (EmploymentHistory) object;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, eh.getEhemployername());
			ps.setString(2, eh.getEhdesignation());
			ps.setString(3, eh.getEhstartdate());
			ps.setString(4, eh.getEhenddate());
			ps.setString(5, eh.getEhbasis());
			ps.setString(6, eh.getEhcomments());
			ps.setString(7, eh.getEhemail());

			ps.setString(8, eh.getEhreferenceonename());
			ps.setString(9, eh.getEhreferenceonephone());
			ps.setString(10, eh.getEhreferenceonemobile());
			ps.setString(11, eh.getEhreferenceoneaddress());
			ps.setString(12, eh.getEhReferenceonedesignation());
			ps.setString(13, eh.getEhreferenceonecomments());

			ps.setString(14, eh.getEhreferencetwoname());
			ps.setString(15, eh.getEhreferencetwophone());
			ps.setString(16, eh.getEhreferencetwomobile());
			ps.setString(17, eh.getEhreferencetwoaddress());
			ps.setString(18, eh.getEhreferencetwodesignation());
			ps.setString(19, eh.getEhreferencetwocomments());

			ps.setString(20, "SYSTEM");
			ps.setInt(21, eh.getEhid());

			log.info("getEhid:-" + eh.getEhid());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			log.info("Exception - " + exception);
			exception.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				log.info("Exception - " + exception);
				exception.printStackTrace();
			}
		}
		return status;
	}

	public Map<String, String> validateValue(Map<String, String> errorList) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
