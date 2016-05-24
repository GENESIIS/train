package com.genesiis.hra.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

//	public HashMap<Integer,String> getDeclaredFields(){
//		HashMap<Integer,String> declarMap = new HashMap<Integer, String>();
//		declarMap.put(1,this.medicalHistoryemployeeid);
//		declarMap.put(2,this.medicalHistoryailment);
//		declarMap.put(3,this.medicalHistorydescription);
//		declarMap.put(4,this.medicalHistorydescription);
//		return declarMap;
//	}
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
			ps = conn.prepareStatement(query);

			ps.setString(1, mh.getMedicalHistoryemployeeid());
			ps.setString(2, mh.getMedicalHistoryailment());
			ps.setString(3, mh.getMedicalHistorydescription());
			ps.setString(4, mh.getMedicalHistorymodby());
			ps.setString(5, mh.getMedicalHistorycrtby());

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				insertStatus = 1;// when success
			}

		} catch (SQLException exception) {
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
		return insertStatus;// insertStatus=1 ; when success //// insertStatus =
							// -1 ; when fails
	}

	@Override
	public boolean isValid(Object object) {

		final int i =0;
		
		DataValidator val = new DataValidator();
		MedicalHistory edu = (MedicalHistory) object;

//		HashMap<Integer,String> dataMap = new HashMap<Integer, String>();
//		
//		dataMap = this.getDeclaredFields();
		
		for (Field field : edu.getClass().getDeclaredFields()) 
		{
			log.info("||----------field.getName()-----"+field.getName()+"--------------------------||");
		}

		
		 if ((val.isValidString(edu.getMedicalHistoryemployeeid()) == true) && (val.isValidString(edu.getMedicalHistoryailment()) == true) && (val.isValidString(edu.getMedicalHistorydescription() ) == true)) {
		 return true;
		 } else {
		 return false;
		 }

	}

	@Override
	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
