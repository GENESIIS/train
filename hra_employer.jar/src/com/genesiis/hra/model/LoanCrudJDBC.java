package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;
/***********************************************
//* 20160510 PN HRA-13 created LoanCrudJDBC.java class
//* 20160513 PN HRA-13  validateEmployee() method Modified.
//***********************************************/
public class LoanCrudJDBC implements IDataAccessor {
	static Logger log = Logger.getLogger(DepartmentCrudJDBC.class.getName());

	@Override
	//Add data to DB
	public String add(Object object) {
		String query = "INSERT INTO [HRA.LOAN] (EMPLOYEEID , DUEDATE , "
				+ "TOTALOUTSTANDING , GUARANTOR1 , GUARANTOR2, MONTHLYPAYMENT , ENDDATE, MODBY)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);			
			preparedStatement.setString(1, lnDetail.getemployeeEpf());
			preparedStatement.setString(2, lnDetail.getLoanDueDate());
			preparedStatement.setString(3, lnDetail.getLoanAmount());
			preparedStatement.setString(4, lnDetail.getLoanGuarantor1());
			preparedStatement.setString(5, lnDetail.getLoanGuarantor2());
			preparedStatement.setString(6, lnDetail.getLoanmonthlyPayment());
			preparedStatement.setString(7, lnDetail.getLoanEndDate());
			preparedStatement.setString(8, "Saman");
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String update(Object object) {
		return null;
	}

	@Override
	public String delete(Object object) {
		return null;
	}

	@Override
	public Object retrive(String id) {
		return null;
	}

	@Override
	public List<Object> getAll() {
		return null;
	}

	

	
}