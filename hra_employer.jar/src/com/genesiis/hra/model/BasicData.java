package com.genesiis.hra.model;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

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
				+ "MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS) "
				+ "VALUES (?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,GETDATE(),?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		BasicData data = (BasicData) object;
		int insertStatus = 0;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, data.getEmployeename());
			ps.setString(2, data.getEmployeedesignation());
			ps.setString(3, data.getEmployeeemail());
			ps.setDate(4, new DataValidator().convertStringDatetoSqlDate(data
					.getEmployeedateofbirth()));
			ps.setString(5, data.getEmployeenic());
			ps.setString(6, data.getEmployeegender());
			ps.setString(7, data.getEmployeepermenetaddress());
			ps.setString(8, data.getEmployeetemporaryaddress());
			ps.setString(9, data.getEmployeemobile());
			ps.setString(10, data.getEmployeetelephone());
			ps.setInt(11, Integer.parseInt(data.getEmployeedepartment()));
			ps.setString(12, data.getEmployeemaritalstatus());
			ps.setDate(13, new DataValidator().convertStringDatetoSqlDate(data
					.getEmployeejoindate()));
			ps.setString(14, "SYSTEM");
			ps.setString(15, data.getEmployeeepf());
			ps.setString(16, data.getEmployeebasis());

			insertStatus = ps.executeUpdate();

			// if (rowsInserted > 0) {
			// insertStatus = 1;// when valid insert
			// }

//			rs = ps.getGeneratedKeys();

		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
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

		return insertStatus;
	}

	@Override
	public int update(Object employee, String epf) {
		String query = "UPDATE [dbo].[HRA.EMPLOYEE] SET NAME = ? ,  DESIGNATION = ? , "
				+ "  EMAIL = ? ,  DOB = ? ,  NIC = ?,  GENDER = ?,  PERMENENTADDRESS = ?, TEMPORARYADDRESS = ?, "
				+ "  MOBILENO = ?,  OTHERNO = ?,  DEPTID = ?,  MARITALSTATUS = ?,  DATEOFJOIN = ?,  MODBY = ?,  MODON = GETDATE(), EPF = ?,  BASIS  = ? WHERE EPF = ?";
	
		String message = "Error";
		Connection conn = null;
		PreparedStatement ps = null;
		int status = 0;

		BasicData empBasic = (BasicData) employee;
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, empBasic.getEmployeename());
			ps.setString(2, empBasic.getEmployeedesignation());
			ps.setString(3, empBasic.getEmployeeemail());
			ps.setString(4, empBasic.getEmployeedateofbirth());
			ps.setString(5, empBasic.getEmployeenic());
			ps.setString(6, empBasic.getEmployeegender());
			ps.setString(7, empBasic.getEmployeepermenetaddress());
			ps.setString(8, empBasic.getEmployeetemporaryaddress());
			ps.setString(9, empBasic.getEmployeemobile());
			ps.setString(10, empBasic.getEmployeetelephone());
			ps.setString(11, empBasic.getEmployeedepartment());
			ps.setString(12, empBasic.getEmployeemaritalstatus());
			ps.setString(13, empBasic.getEmployeejoindate());
			ps.setString(14, "S");
			ps.setString(15, empBasic.getEmployeeepf());
			ps.setString(16, empBasic.getEmployeebasis());
			ps.setString(17, epf);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				/*
				 * ResultSet rs = ps.getGeneratedKeys(); int generatedKey = 0;
				 * message = "Succesfull"; if (rs.next()) { generatedKey =
				 * rs.getInt(1); } status = generatedKey;
				 */
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

	// use for View basci data and department
	@Override
	public Object findByEpf(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		BasicData emp = new BasicData();

		log.info(id + "id String");
		try {
			conn = ConnectionManager.getConnection();
			ps = conn
					.prepareStatement("SELECT [HRA.EMPLOYEE].ID, [HRA.EMPLOYEE].NAME, [HRA.EMPLOYEE].DESIGNATION, [HRA.EMPLOYEE].EMAIL, [HRA.EMPLOYEE].DOB, [HRA.EMPLOYEE].NIC, [HRA.EMPLOYEE].GENDER, [HRA.EMPLOYEE].PERMENENTADDRESS, [HRA.EMPLOYEE].TEMPORARYADDRESS, [HRA.EMPLOYEE].MOBILENO, [HRA.EMPLOYEE].OTHERNO, [HRA.DEPARTMENT].NAME, [HRA.EMPLOYEE].MARITALSTATUS, [HRA.EMPLOYEE].DATEOFJOIN, [HRA.EMPLOYEE].EPF, [HRA.EMPLOYEE].BASIS  FROM [HRA.EMPLOYEE] INNER JOIN [HRA.DEPARTMENT] ON [HRA.EMPLOYEE].DEPTID = [HRA.DEPARTMENT].ID WHERE EPF = ?");
			ps.setString(1, id);
			res = ps.executeQuery();
			if (res.next()) {

				emp.setEmployeename(res.getString(2));
				emp.setEmployeedesignation(res.getString(3));
				emp.setEmployeeemail(res.getString(4));
				emp.setEmployeedateofbirth(res.getString(5));
				emp.setEmployeenic(res.getString(6));
				emp.setEmployeegender(res.getString(7));
				emp.setEmployeepermenetaddress(res.getString(8));
				emp.setEmployeetemporaryaddress(res.getString(9));
				emp.setEmployeemobile(res.getString(10));
				emp.setEmployeetelephone(res.getString(11));
				emp.setEmployeedepartment(res.getString(12));
				emp.setEmployeemaritalstatus(res.getString(13));
				emp.setEmployeejoindate(res.getString(14));
				emp.setEmployeeepf(res.getString(15));
				emp.setEmployeebasis(res.getString(16));

				log.info(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (res != null) {
					res.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.error("Exception: EducationData Find" + exception);
			}
		}
		return emp;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

}