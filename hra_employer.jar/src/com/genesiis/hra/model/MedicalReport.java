package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;

public class MedicalReport {

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
	 *            - Medical History
	 * @param ps
	 *            - Prepared Statement
	 * **/
	public int add(Object object) {
		String query = "INSERT INTO [HRA.MEDICALREPORT] (CODE , REPORTDESCRIPTION  , REPORTPATH , MODBY, MODON, CRTBY, CRTON ) VALUES (?, ?, ?, ?,GETDATE(), ?, GETDATE())";
		int insertStatus = -1;// fires when valid insert
		Connection conn = null;// fires when connecting to database
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
			log.info("rowsInserted"+rowsInserted);
			
			if (rowsInserted > 0) {
				insertStatus = 1;// when success 
			}

			log.info("rowsInserted"+rowsInserted);
			
		} catch (SQLException exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception: EducationData Add" + exception);
		} catch (Exception exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception: EducationData Add" + exception);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.info("Exception: EducationData Add" + exception);
			}
		}
		return insertStatus;// insertStatus=1 ; when success // insertStatus = -1 ; when fails
	}
	
	
	
	public String isValidObject(Object object) {

		String messagetxt = MessageList.MEDICALHISTORYSUCCESS.message();

		DataValidator val = new DataValidator();
		MedicalReport medicalReport = (MedicalReport) object;

		int vall = 0;
		if (val.isValidInt(medicalReport.getCode()) != true)
			vall |= 0x1;
		if (val.isValidString(medicalReport.getReportdescription()) != true)
			vall |= 0x2;
		if (val.isValidString(medicalReport.getReportpath()) != true)
			vall |= 0x3;

		switch (vall) {

		case 0: // Both too short
			messagetxt = MessageList.MEDICALHISTORYPASS.message();
			break;

		case 1: // User Ok, pass too short
			messagetxt = MessageList.MEDICALREPORTDESCRIPTIONNOTVALID.message();
			break;

		case 2: // User too short, pass ok
			messagetxt = MessageList.MEDICALREPORTPATHNOTVALID.message();
			break;

		case 3: // Both Ok
			messagetxt = MessageList.MEDICALREPORTNOTVALID.message();
			break;

		}

		return messagetxt;

	}
}
