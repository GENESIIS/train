package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
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
	
	public Loan( String LoanAmount, String LoanBorrowers, String LoanmonthlyPayment, String LoanDueDate, String employeeEpf) {
		super();
		this.LoanAmount = LoanAmount;
		this.LoanBorrowers = LoanBorrowers;
		this.LoanmonthlyPayment = LoanmonthlyPayment;		
		this.LoanDueDate = LoanDueDate;
		this.employeeEpf = employeeEpf;
	}
	public Loan() {
	}
	
	@Override
	public String add(Object object) {
		String query = "INSERT INTO [HRA.LOAN] (EMPLOYEEID , DUEDATE , "
				+ "TOTALOUTSTANDING , BORROWER , MONTHLYPAYMENT , MODBY)"
				+ "VALUES (?, ?, ?, ?, ?,?) ";
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
			preparedStatement.setString(4, lnDetail.getLoanBorrowers());
			preparedStatement.setString(5, lnDetail.getLoanmonthlyPayment());
			preparedStatement.setString(6, "Saman");
			
			

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
	
	public boolean validateValue(Object entityObject){
		DataValidator validator = new DataValidator();
		Loan loan =(Loan)entityObject;
		String message = "";
		if (loan!= null) {			
			if (!validator.isValidString(loan.getLoanAmount())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanBorrowers())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanmonthlyPayment())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanDueDate())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
		} else {
			return false;
		}
		return true;
	}
	
    public boolean validateValue(HashMap<Integer, Object> entityMap){
		
		return true;
	}
	
}
