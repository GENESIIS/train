package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import com.genesiis.hra.validation.DataValidator;

/**
 * 20160511 created EducationData entity class - as
 **/

public class EducationData extends Employee {
	static Logger log = Logger.getLogger(Employee.class.getName());

	private String eduQualification;
	private String eduUniversity;
	private String eduMedium;
	private String eduStartedon;
	private String eduCompltedon;
	private String eduStudytime;
	
	

	public String getEduQualification() {
		return eduQualification;
	}

	public void setEduQualification(String eduQualification) {
		this.eduQualification = eduQualification;
	}

	public String getEduUniversity() {
		return eduUniversity;
	}

	public void setEduUniversity(String eduUniversity) {
		this.eduUniversity = eduUniversity;
	}

	public String getEduMedium() {
		return eduMedium;
	}

	public void setEduMedium(String eduMedium) {
		this.eduMedium = eduMedium;
	}

	public String getEduStartedon() {
		return eduStartedon;
	}

	public void setEduStartedon(String eduStartedon) {
		this.eduStartedon = eduStartedon;
	}

	public String getEduCompltedon() {
		return eduCompltedon;
	}

	public void setEduCompltedon(String eduCompltedon) {
		this.eduCompltedon = eduCompltedon;
	}

	public String getEduStudytime() {
		return eduStudytime;
	}

	public void setEduStudytime(String eduStudytime) {
		this.eduStudytime = eduStudytime;
	}

	public EducationData() {

	}

	public EducationData(String eduQualification, String eduUniversity,
			String eduMedium, String eduStartedOn, String eduCompltedOn,
			String employeeEpf, String eduStudyTime) {

		super();
		this.eduQualification = eduQualification;
		this.eduUniversity = eduUniversity;
		this.eduMedium = eduMedium;
		this.eduStartedon = eduStartedOn;
		this.eduCompltedon = eduCompltedOn;
		this.employeeEpf = employeeEpf;
		this.eduStudytime = eduStudyTime;

	}

	@Override
	public int add(Object object) {
		String query = "INSERT INTO [HRA.QUALIFICATION] (EMPLOYEEID, STUDYPLACE, ADDMISSIONDATE, QUALIFICATION, MEDIUM, LEAVINGDATE, STUDYTIME, MODBY) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int status = -1;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		EducationData edu = (EducationData) object;

		try {
			conn = com.genesiis.hra.utill.ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, edu.getEmployeeepf());
			preparedStatement.setString(2, edu.getEduUniversity());
			preparedStatement.setString(3, edu.getEduStartedon());
			preparedStatement.setString(4, edu.getEduQualification());
			preparedStatement.setString(5, edu.getEduMedium());
			preparedStatement.setString(6, edu.getEduCompltedon());
			preparedStatement.setString(7, edu.getEduStudytime());
			preparedStatement.setString(8, "SYSTEM");

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			log.error("Exception: EducationData Add" + exception);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.error("Exception: EducationData Add" + exception);
			}
		}
		return status;
	}

	@Override
	public boolean isValid(Object object) {

		DataValidator val = new DataValidator();
		EducationData edu = (EducationData) object;

		if ((val.isValidString(edu.getEduQualification()) == true)
				&& (val.isValidString(edu.getEduCompltedon())) == true) {
			return true;
		} else {
			return false;
		}

	}
}