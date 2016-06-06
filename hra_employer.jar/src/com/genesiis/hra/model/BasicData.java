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
	public int update(Object employee) {
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
	public Object findByEpf(String empEpf) {
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
			preparedStatement.setString(1,empEpf);

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
	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
}