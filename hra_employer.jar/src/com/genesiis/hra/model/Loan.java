package com.genesiis.hra.model;

import java.sql.Date;

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
}
