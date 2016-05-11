package com.genesiis.hra.model;

import java.sql.Date;

public class Loan {

	String employeeEpf ;	
	String LoanAmount;
	String LoanBorrowers;
	String LoanmonthlyPayment;
	String LoanDueDate;
	
	public String getemployeeEpf() {
		return employeeEpf;
	}
	public void setEmployeeId(String employeeEpf) {
		this.employeeEpf = employeeEpf;
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
	
	public Loan( String LoanAmount, String LoanBorrowers, String LoanmonthlyPayment, String LoanDueDate, String employeeEpf) {
		
		this.LoanAmount = LoanAmount;
		this.LoanBorrowers = LoanBorrowers;
		this.LoanmonthlyPayment = LoanmonthlyPayment;		
		this.LoanDueDate = LoanDueDate;
		this.employeeEpf = employeeEpf;
	}
	public Loan() {
	}
}
