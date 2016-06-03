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
//* 20160510 PC HRA-13 created LoanCrudJDBC.java class
//* 20160513 PC HRA-13  validateEmployee() method Modified.
//***********************************************/
public class LoanCrudJDBC implements ICrud {
	static Logger log = Logger.getLogger(LoanCrudJDBC.class.getName());

	@Override
	//Add data to DB Table EMPLOYEE
	public int add(Object object) {
		String query = "INSERT INTO [HRA.LOAN] (EMPLOYEEID , DUEDATE , "
				+ "TOTALOUTSTANDING , GUARANTOR1 , GUARANTOR2, MONTHLYPAYMENT , ENDDATE, MODBY)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
		int status = -1;
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
				status = 1;
			}
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int update(Object object) {
		return (Integer) null;
	}	

	@Override
	public Object find(int empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
}