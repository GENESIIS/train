package com.genesiis.hra.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.genesiis.hra.validation.DataValidator;

/**
 * 
 * 2016-05-24 class created to add medical data - entity class
 * 
 * @author thumeera @TR
 * **/
public class MedicalHistory extends Employee {

	static Logger log = Logger.getLogger(MedicalHistory.class.getName());

	private String medicalHistorycode;
	private String medicalHistoryemployeeid;
	private String medicalHistoryailment;
	private String medicalHistorydescription;
	private String medicalHistorymodby;
	private String medicalHistorymodon;
	private String medicalHistorycrtby;
	private String medicalHistorycrton;

	public String getMedicalhistorycode() {
		return medicalHistorycode;
	}

	public void setMedicalhistorycode(String medicalHistorycode) {
		this.medicalHistorycode = medicalHistorycode;
	}

	public String getMedicalhistoryemployeeid() {
		return medicalHistoryemployeeid;
	}

	public void setMedicalhistoryemployeeid(String medicalHistoryemployeeid) {
		this.medicalHistoryemployeeid = medicalHistoryemployeeid;
	}

	public String getMedicalhistoryailment() {
		return medicalHistoryailment;
	}

	public void setMedicalhistoryailment(String medicalHistoryailment) {
		this.medicalHistoryailment = medicalHistoryailment;
	}

	public String getMedicalhistorydescription() {
		return medicalHistorydescription;
	}

	public void setMedicalhistorydescription(String medicalHistorydescription) {
		this.medicalHistorydescription = medicalHistorydescription;
	}

	public String getMedicalhistorymodby() {
		return medicalHistorymodby;
	}

	public void setMedicalhistorymodby(String medicalHistorymodby) {
		this.medicalHistorymodby = medicalHistorymodby;
	}

	public String getMedicalhistorymodon() {
		return medicalHistorymodon;
	}

	public void setMedicalhistorymodon(String medicalHistorymodon) {
		this.medicalHistorymodon = medicalHistorymodon;
	}

	public String getMedicalhistorycrtby() {
		return medicalHistorycrtby;
	}

	public void setMedicalhistorycrtby(String medicalHistorycrtby) {
		this.medicalHistorycrtby = medicalHistorycrtby;
	}

	public String getMedicalhistorycrton() {
		return medicalHistorycrton;
	}

	public void setMedicalhistorycrton(String medicalHistorycrton) {
		this.medicalHistorycrton = medicalHistorycrton;
	}

	

	/**
	 * @param mh
	 *            - Medical History
	 * @param ps
	 *            - Prepared Statement
	 * **/
	public int add(Object object) {
		String query = "INSERT INTO [HRA.MEDICALHISTORY] (EMPLOYEEID, AILMENT, DESCRIPTION, MODBY, MODON, CRTBY, CRTON ) VALUES (?, ?, ?, ?,GETDATE(), ?, GETDATE())";
		int insertStatus = -1;// fires when valid insert
		Connection conn = null;// fires when connecting to database
		PreparedStatement ps = null;
		MedicalHistory medicalHistory = (MedicalHistory) object;

		try {
			conn = com.genesiis.hra.utill.ConnectionManager.getConnection();
			ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, medicalHistory.getMedicalhistoryemployeeid());
			ps.setString(2, medicalHistory.getMedicalhistoryailment());
			ps.setString(3, medicalHistory.getMedicalhistorydescription());
			ps.setString(4, medicalHistory.getMedicalhistorymodby());
			ps.setString(5, medicalHistory.getMedicalhistorycrtby());

			int rowsInserted = ps.executeUpdate();
			log.info("rowsInserted"+rowsInserted);
			if (rowsInserted > 0) {
				insertStatus = 1;// when success 
			}

			ResultSet ss =ps.getGeneratedKeys();
			
			try  {
	            if (ss.next()) {
	            	medicalHistory.setMedicalhistoryemployeeid(ss.getString(1));
	            	log.info("----mh---"+medicalHistory.getMedicalhistoryemployeeid());
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }catch (SQLException exception) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				exception.printStackTrace();
				log.info("Exception: EducationData Add" + exception);
			}
			
			
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
		return insertStatus;// insertStatus=1 ; when success //
		// insertStatus = -1 ; when fails
	}

	@Override
	public boolean isValid(Object object) {
		return false;
	}

	public String isValidObject(Object object) {

		String messagetxt = "success";

		DataValidator val = new DataValidator();
		MedicalHistory edu = (MedicalHistory) object;

		int vall = 0;
		if (val.isValidString(edu.getMedicalhistoryemployeeid()) != true)
			vall |= 0x1;
		if (val.isValidString(edu.getMedicalhistoryailment()) != true)
			vall |= 0x2;
		if (val.isValidString(edu.getMedicalhistorydescription()) != true)
			vall |= 0x3;

		switch (vall) {

		case 0: // Both too short
			messagetxt = "pass";
			break;

		case 1: // User Ok, pass too short
			messagetxt = "Medical History Employee id not valid";
			break;

		case 2: // User too short, pass ok
			messagetxt = "Medical History Ailment not valid";
			break;

		case 3: // Both Ok
			messagetxt = "Medical History Description not valid";
			break;

		}

		return messagetxt;

	}

	@Override
	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
