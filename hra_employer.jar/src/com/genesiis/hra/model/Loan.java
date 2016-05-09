package com.genesiis.hra.model;

import java.sql.Date;

public class Loan {

	String employeeId ;	
	String LoanAmount;
	String LoanBorrowers;
	String LoanmonthlyPayment;
	String LoanDueDate;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
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
}
