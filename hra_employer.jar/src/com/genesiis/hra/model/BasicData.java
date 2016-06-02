package com.genesiis.hra.model;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;

public class BasicData extends Employee {
	static Logger log = Logger.getLogger(BasicData.class.getName());
	
	private String employeeName;
	private String employeeDesignation;
	private String employeeEmail;
	private String employeeDateofbirth;
	private String employeeNic;
	private String employeeGender;
	private String employeePermenetaddress;
	private String employeeTemporaryaddress;
	private String employeeMobile;
	private String employeeTelephone;
	private String employeeDepartment;
	private String employeeMaritalstatus;
	private String employeeJoindate;
	
	// private String employeeEpf;
	private String employeeBasis;

	public String getEmployeename() {
		return employeeName;
	}

	public void setEmployeename(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeedesignation() {
		return employeeDesignation;
	}

	public void setEmployeedesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeemail() {
		return employeeEmail;
	}

	public void setEmployeeemail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeedateofbirth() {
		return employeeDateofbirth;
	}

	public void setEmployeedateofbirth(String employeeDateofbirth) {
		this.employeeDateofbirth = employeeDateofbirth;
	}

	public String getEmployeenic() {
		return employeeNic;
	}

	public void setEmployeenic(String employeeNic) {
		this.employeeNic = employeeNic;
	}

	public String getEmployeegender() {
		return employeeGender;
	}

	public void setEmployeegender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeepermenetaddress() {
		return employeePermenetaddress;
	}

	public void setEmployeepermenetaddress(String employeePermenetaddress) {
		this.employeePermenetaddress = employeePermenetaddress;
	}

	public String getEmployeetemporaryaddress() {
		return employeeTemporaryaddress;
	}

	public void setEmployeetemporaryaddress(String employeeTemporaryaddress) {
		this.employeeTemporaryaddress = employeeTemporaryaddress;
	}

	public String getEmployeemobile() {
		return employeeMobile;
	}

	public void setEmployeemobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeetelephone() {
		return employeeTelephone;
	}

	public void setEmployeetelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone;
	}

	public String getEmployeedepartment() {
		return employeeDepartment;
	}

	public void setEmployeedepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeemaritalstatus() {
		return employeeMaritalstatus;
	}

	public void setEmployeemaritalstatus(String employeeMaritalstatus) {
		this.employeeMaritalstatus = employeeMaritalstatus;
	}

	public String getEmployeejoindate() {
		return employeeJoindate;
	}

	public void setEmployeejoindate(String employeeJoindate) {
		this.employeeJoindate = employeeJoindate;
	}

	public String getEmployeebasis() {
		return employeeBasis;
	}

	public void setEmployeebasis(String employeeBasis) {
		this.employeeBasis = employeeBasis;
	}
	
	public BasicData() {
		
	}
	

	public BasicData(String employeeName, String employeeDesignation,
			String employeeEmail, String employeeDateofbirth,
			String employeeNic, String employeeGender,
			String employeePermenetaddress, String employeeTemporaryaddress,
			String employeeMobile, String employeeTelephone,
			String employeeDepartment, String employeeMaritalstatus,
			String employeeJoindate, String employeeEpf, String employeeBasis) {
		super();
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeEmail = employeeEmail;
		this.employeeDateofbirth = employeeDateofbirth;
		this.employeeNic = employeeNic;
		this.employeeGender = employeeGender;
		this.employeePermenetaddress = employeePermenetaddress;
		this.employeeTemporaryaddress = employeeTemporaryaddress;
		this.employeeMobile = employeeMobile;
		this.employeeTelephone = employeeTelephone;
		this.employeeDepartment = employeeDepartment;
		this.employeeMaritalstatus = employeeMaritalstatus;
		this.employeeJoindate = employeeJoindate;
		this.employeeEpf = employeeEpf;
		this.employeeBasis = employeeBasis;
	}

	public int add(Object object) {
		String query = "INSERT INTO [HRA.EMPLOYEE] (NAME, DESIGNATION, "
				+ "EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, "
				+ "MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, EPF, BASIS) "
				+ "VALUES (?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		BasicData data = (BasicData) object;
		int status = 0;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, data.getEmployeename());
			ps.setString(2, data.getEmployeedesignation());
			ps.setString(3, data.getEmployeeemail());
			ps.setString(4, data.getEmployeedateofbirth());
			ps.setString(5, data.getEmployeenic());
			ps.setString(6, data.getEmployeegender());
			ps.setString(7, data.getEmployeepermenetaddress());
			ps.setString(8, data.getEmployeetemporaryaddress());
			ps.setString(9, data.getEmployeemobile());
			ps.setString(10, data.getEmployeetelephone());
			ps.setString(11, data.getEmployeedepartment());
			ps.setString(12, data.getEmployeemaritalstatus());
			ps.setString(13, data.getEmployeejoindate());
			ps.setString(14, "SYSTEM");
			ps.setString(15, data.getEmployeeepf());
			ps.setString(16, data.getEmployeebasis());

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				int generatedKey = 0;
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
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Object> getAll() {
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
	public Employee retrive(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}