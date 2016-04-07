package com.hra.dao;

/***********************************************
 * 20160407 PN HRA-1 created Employee.java class
 * 
 *
 ***********************************************/

public class Employee implements java.io.Serializable {
	private String employeeID;
	private String employeeName;
	private String employeeDesignation;
	private float employeeSalary;
	private String employeeEmail;
	private String employeeDOB;
	private String employeeGender;
	private String employeeAddress;
	private String employeeMobileNO;
	private String employeeOtherNO;
	private String departmentID;
	private String dateOfJoin;
	private String updatedBy;
	private String updatedOn;

	public Employee() {
	}

	public Employee(String employeeID, String employeeName,
			String employeeDesignation, float employeeSalary,
			String employeeEmail, String employeeDOB, String employeeGender,
			String employeeAddress, String employeeMobileNO,
			String employeeOtherNO, String departmentID, String dateOfJoin,
			String updatedBy, String updatedOn) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeSalary = employeeSalary;
		this.employeeEmail = employeeEmail;
		this.employeeDOB = employeeDOB;
		this.employeeGender = employeeGender;
		this.employeeAddress = employeeAddress;
		this.employeeMobileNO = employeeMobileNO;
		this.employeeOtherNO = employeeOtherNO;
		this.departmentID = departmentID;
		this.dateOfJoin = dateOfJoin;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public float getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(String employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeMobileNO() {
		return employeeMobileNO;
	}

	public void setEmployeeMobileNO(String employeeMobileNO) {
		this.employeeMobileNO = employeeMobileNO;
	}

	public String getEmployeeOtherNO() {
		return employeeOtherNO;
	}

	public void setEmployeeOtherNO(String employeeOtherNO) {
		this.employeeOtherNO = employeeOtherNO;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	

}
