package com.genesiis.hra.model;

import java.sql.Date;
 
public class Loan {

	private String employeeEpf ;	
	private String loanAmount;
	private String loanGuarantor1;
	private String loanGuarantor2;
	private String loanmonthlyPayment;
	private String loanDueDate;
	private String loanEndDate;	
	private String modOn;
	private String modBy;	
	
	public String getemployeeEpf() {
		return employeeEpf;
	}
	public void setEmployeeId(String employeeEpf) {
		this.employeeEpf = employeeEpf;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanGuarantor1() {
		return loanGuarantor1;
	}
	public void setLoanGuarantor1(String loanGuarantor1) {
		this.loanGuarantor1 = loanGuarantor1;
	}
	public String getLoanGuarantor2() {
		return loanGuarantor2;
	}
	public void setLoanGuarantor2(String loanGuarantor2) {
		this.loanGuarantor2 = loanGuarantor2;
	}
	public String getLoanmonthlyPayment() {
		return loanmonthlyPayment;
	}
	public void setLoanmonthlyPayment(String loanmonthlyPayment) {
		this.loanmonthlyPayment = loanmonthlyPayment;
	}
	public String getLoanDueDate() {
		return loanDueDate;
	}
	public void setLoanDueDate(String loanDueDate) {
		this.loanDueDate = loanDueDate;
	} 	
	public String getLoanEndDate() {
		return loanEndDate;
	}
	public void setLoanEndDate(String loanEndDate) {
		this.loanEndDate = loanEndDate;
	}	
	public String getModOn() {
		return modOn;
	}
	public void setModOn(String modOn) {
		this.modOn = modOn;
	}
	public String getmodBy() {
		return modBy;
	}
	public void setmodBy(String modBy) {
		this.modBy = modBy;
	}
	
	public Loan( String loanAmount, String loanGuarantor1, String loanGuarantor2, String loanmonthlyPayment, 
			String loanDueDate, String loanEndDate, String employeeEpf, String modBy, String modOn) {
		
		this.loanAmount = loanAmount;
		this.loanGuarantor1 = loanGuarantor1;
		this.loanGuarantor2 = loanGuarantor2;
		this.loanmonthlyPayment = loanmonthlyPayment;		
		this.loanDueDate = loanDueDate;
		this.loanEndDate = loanEndDate;
		this.employeeEpf = employeeEpf;
		this.modBy = modBy;
		this.modBy = modBy;
	}
	public Loan() {
	}
}
