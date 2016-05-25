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

	public String getMedicalHistorycode() {
		return medicalHistorycode;
	}

	public void setMedicalHistorycode(String medicalHistorycode) {
		this.medicalHistorycode = medicalHistorycode;
	}

	public String getMedicalHistoryemployeeid() {
		return medicalHistoryemployeeid;
	}

	public void setMedicalHistoryemployeeid(String medicalHistoryemployeeid) {
		this.medicalHistoryemployeeid = medicalHistoryemployeeid;
	}

	public String getMedicalHistoryailment() {
		return medicalHistoryailment;
	}

	public void setMedicalHistoryailment(String medicalHistoryailment) {
		this.medicalHistoryailment = medicalHistoryailment;
	}

	public String getMedicalHistorydescription() {
		return medicalHistorydescription;
	}

	public void setMedicalHistorydescription(String medicalHistorydescription) {
		this.medicalHistorydescription = medicalHistorydescription;
	}

	public String getMedicalHistorymodby() {
		return medicalHistorymodby;
	}

	public void setMedicalHistorymodby(String medicalHistorymodby) {
		this.medicalHistorymodby = medicalHistorymodby;
	}

	public String getMedicalHistorymodon() {
		return medicalHistorymodon;
	}

	public void setMedicalHistorymodon(String medicalHistorymodon) {
		this.medicalHistorymodon = medicalHistorymodon;
	}

	public String getMedicalHistorycrtby() {
		return medicalHistorycrtby;
	}

	public void setMedicalHistorycrtby(String medicalHistorycrtby) {
		this.medicalHistorycrtby = medicalHistorycrtby;
	}

	public String getMedicalHistorycrton() {
		return medicalHistorycrton;
	}

	public void setMedicalHistorycrton(String medicalHistorycrton) {
		this.medicalHistorycrton = medicalHistorycrton;
	}

	public HashMap<Integer, String> getDeclaredFields() {
		HashMap<Integer, String> declarMap = new HashMap<Integer, String>();
		declarMap.put(1, this.medicalHistoryemployeeid);
		declarMap.put(2, this.medicalHistoryailment);
		declarMap.put(3, this.medicalHistorydescription);
		return declarMap;
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
		MedicalHistory mh = (MedicalHistory) object;

		try {
			conn = com.genesiis.hra.utill.ConnectionManager.getConnection();
			ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, mh.getMedicalHistoryemployeeid());
			ps.setString(2, mh.getMedicalHistoryailment());
			ps.setString(3, mh.getMedicalHistorydescription());
			ps.setString(4, mh.getMedicalHistorymodby());
			ps.setString(5, mh.getMedicalHistorycrtby());

			int rowsInserted = ps.executeUpdate();
			log.info("rowsInserted"+rowsInserted);
			if (rowsInserted > 0) {
				insertStatus = 1;// when success 
			}

			ResultSet ss =ps.getGeneratedKeys();
			
			try  {
	            if (ss.next()) {
	            	mh.setMedicalHistoryemployeeid(ss.getString(1));
	            	log.info("----mh---"+mh.getMedicalHistoryemployeeid());
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
		if (val.isValidString(edu.getMedicalHistoryemployeeid()) != true)
			vall |= 0x1;
		if (val.isValidString(edu.getMedicalHistoryailment()) != true)
			vall |= 0x2;
		if (val.isValidString(edu.getMedicalHistorydescription()) != true)
			vall |= 0x3;

		switch (vall) {

		case 0: // Both too short
			messagetxt = "pass";
			break;

		case 1: // User Ok, pass too short
			log.info("getMedicalHistory employee id not valid");
			messagetxt = "getMedicalHistory employee id not valid";
			break;

		case 2: // User too short, pass ok
			log.info("getMedicalHistory ailment not valid");
			messagetxt = "getMedicalHistory ailment not valid";
			break;

		case 3: // Both Ok
			log.info("getMedicalHistory description not valid");
			messagetxt = "getMedicalHistory description not valid";
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
