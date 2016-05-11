package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.genesiis.hra.validation.DataValidator;

/**
 * 20160511 created EducationData entity class - as
 **/

public class EducationData extends Employee {
	private String eduQualification;
	private String eduUniversity;
	private String eduMedium;
	private String eduStartedOn;
	private String eduCompltedOn;

	public String getQualification() {
		return eduQualification;
	}

	public String getUniversity() {
		return eduUniversity;
	}

	public String getMedium() {
		return eduMedium;
	}

	public String getStartedOn() {
		return eduStartedOn;
	}

	public void getStartedOn(String eduStartedOn) {
		this.eduStartedOn = eduStartedOn;
	}

	public String getCompletedOn() {
		return eduCompltedOn;

	}

	public void getCompletedOn(String eduCompltedOn) {
		this.eduCompltedOn = eduCompltedOn;
	}

	public EducationData() {

	}

	public EducationData(String eduQualification, String eduUniversity,
			String eduMedium, String eduStartedOn, String eduCompltedOn,
			String employeeEpf) {

		super();
		this.eduQualification = eduQualification;
		this.eduUniversity = eduUniversity;
		this.eduMedium = eduMedium;
		this.eduStartedOn = eduStartedOn;
		this.eduCompltedOn = eduCompltedOn;
		this.employeeEpf = employeeEpf;

	}

	@Override
	public int add(Object object) {
		String query = "INSERT INTO [HRA.QUALIFICATION] (EMPLOYEEID, STUDYPLACE< ADDMISSIONYEAR, QUALIFICATION, MEDIUM, LEAVINGDATE, MODBY) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int status = -1;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		EducationData edu = (EducationData) object;

		try {
			conn = com.genesiis.hra.utill.ConnectionManager.getConnection();
			preparedStatement.setString(1, edu.getEmployeeepf());
			preparedStatement.setString(2, edu.getUniversity());
			preparedStatement.setString(3, edu.getStartedOn());
			preparedStatement.setString(4, edu.getQualification());
			preparedStatement.setString(5, edu.getMedium());
			preparedStatement.setString(6, edu.getCompletedOn());
			preparedStatement.setString(7, "SYSTEM");

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public boolean isValid(Object object) {

		DataValidator val = new DataValidator();
		EducationData edu = (EducationData) object;

		if ((val.isValidString(edu.getQualification()) == true)
				&& (val.isValidString(edu.getCompletedOn())) == true) {
			return true;
		} else {
			return false;
		}

	}
}