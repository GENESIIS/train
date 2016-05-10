package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;

public class Loan extends Employee {

		
	String LoanAmount;
	String LoanBorrowers;
	String LoanmonthlyPayment;
	String LoanDueDate;	
	
	public String getLoanAmount() {
		return LoanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		LoanAmount = loanAmount;
	}
	public String getLoanBorrowers() {
		return LoanBorrowers;
	}
	public void setLoanBorrowers(String loanBorrowers) {
		LoanBorrowers = loanBorrowers;
	}
	public String getLoanmonthlyPayment() {
		return LoanmonthlyPayment;
	}
	public void setLoanmonthlyPayment(String loanmonthlyPayment) {
		LoanmonthlyPayment = loanmonthlyPayment;
	}
	public String getLoanDueDate() {
		return LoanDueDate;
	}
	public void setLoanDueDate(String loanDueDate) {
		LoanDueDate = loanDueDate;
	} 
	
	public Loan( String LoanAmount, String LoanBorrowers, String LoanmonthlyPayment, String LoanDueDate) {
		super();
		this.LoanAmount = LoanAmount;
		this.LoanBorrowers = LoanBorrowers;
		this.LoanmonthlyPayment = LoanmonthlyPayment;
		this.LoanmonthlyPayment = LoanmonthlyPayment;
		this.LoanDueDate = LoanDueDate;
	}
	public Loan() {
	}
	
	@Override
	public String add(Object object) {
		String query = "INSERT INTO [HRA.LOAN] (ID, EMPLOYEEID , DUEDATE , "
				+ "TOTALOUTSTANDING , BORROWER , MONTHLYPAYMENT , MODBY , MODON)"
				+ "VALUES (?, ?, ?, ?, ?,?, ?, ?) ";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "13");
			preparedStatement.setString(2, "1");
			preparedStatement.setString(3, lnDetail.getLoanDueDate());
			preparedStatement.setString(4, lnDetail.getLoanAmount());
			preparedStatement.setString(5, lnDetail.getLoanBorrowers());
			preparedStatement.setString(6, lnDetail.getLoanmonthlyPayment());
			preparedStatement.setString(7, "Saman");
			preparedStatement.setString(8, "2016-05-10");
			

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
	
}
