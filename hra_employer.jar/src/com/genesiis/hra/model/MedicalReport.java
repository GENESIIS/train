package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;


public class MedicalReport extends Employee{

	static Logger log = Logger.getLogger(MedicalReport.class.getName());

	private int code;
	private String reportDescription;
	private String reportPath;
	private String modby;
	private String modon;
	private String crtby;
	private String crton;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getReportdescription() {
		return reportDescription;
	}

	public void setReportdescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public String getReportpath() {
		return reportPath;
	}

	public void setReportpath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getModby() {
		return modby;
	}

	public void setModby(String modby) {
		this.modby = modby;
	}

	public String getModon() {
		return modon;
	}

	public void setModon(String modon) {
		this.modon = modon;
	}

	public String getCrtby() {
		return crtby;
	}

	public void setCrtby(String crtby) {
		this.crtby = crtby;
	}

	public String getCrton() {
		return crton;
	}

	public void setCrton(String crton) {
		this.crton = crton;
	}

	/**
	 * @param mh
	 *            Medical History
	 * @param ps
	 *            Prepared Statement
	 * **/
	public int add(Object object) {
		String query = "INSERT INTO [HRA.MEDICALREPORT] (CODE , REPORTDESCRIPTION  , REPORTPATH , MODBY, MODON, CRTBY, CRTON ) VALUES (?, ?, ?, ?,GETDATE(), ?, GETDATE())";
		int insertStatus = -1;// when invalid insert
		Connection conn = null;// when connecting to database
		PreparedStatement ps = null;
		MedicalReport medicalReport = (MedicalReport) object;

		try {
			conn = com.genesiis.hra.utill.ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, medicalReport.getCode());
			ps.setString(2, medicalReport.getReportdescription());
			ps.setString(3, medicalReport.getReportpath());
			ps.setString(4, medicalReport.getModby());
			ps.setString(5, medicalReport.getCrtby());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted > 0) {
				insertStatus = 1;// when success
			}


		} catch (SQLException exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception: Medical History Add" + exception);
		} catch (Exception exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception: Medical History Add" + exception);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.info("Exception: Medical History Add" + exception);
			}
		}
		// insertStatus=1(when success)
		// insertStatus=-1(when fails)
		return insertStatus;
	}

	
	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object findByEpf(String empEpf) {

		log.info("epf"+empEpf);
    	
		String query = "SELECT CODE, REPORTDESCRIPTION, REPORTPATH, MODBY, MODON, CRTBY, CRTON FROM dbo.[HRA.MEDICALREPORT]  "
				+ " WHERE CODE = ?";


		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		MedicalReport object = new MedicalReport();
		try {

			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, empEpf);

			rs = ps.executeQuery();

			try {
				if (rs.next()) {

					// set data to entity class
					object.setCode
					(rs.getInt("CODE"));
					
					object.setReportdescription
					(rs.getString("REPORTDESCRIPTION"));
					
					object.setReportpath
					(rs.getString("REPORTPATH"));

					String subString = object.getReportpath();
					String retval[] = subString.split("C:/sdb/ctxdeploy/hras.war");
					
					object.setReportpath
					(retval[1]);
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
		return object;
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

	@Override
	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(Object object, String code) {
		
		String query = "UPDATE [HRA.MEDICALREPORT] SET REPORTDESCRIPTION=? , REPORTPATH =? , MODBY=? , CRTBY=?  WHERE CODE=?";

		int status = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		MedicalReport medicalReport = (MedicalReport) object;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, medicalReport.getReportdescription());
			ps.setString(2, medicalReport.getReportpath());
			ps.setString(3, medicalReport.getModby());
			ps.setString(4, medicalReport.getCrtby());
			ps.setString(5, code);
			
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
	
}