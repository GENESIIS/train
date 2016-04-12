package com.genesiis.hra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//com.genesiis.hra.model.Employee

///***********************************************
// * 20160407 PN HRA-1 created Employee.java class
// * 20160411 PN HRA-1 changes Employee.java class. Added employeeNic attribute.
// * 
// ***********************************************/
@Entity
@NamedQueries(@NamedQuery(name="Employee.getAll",query="SELECE e from EMPLOYEE e"))

public class Employee {
//	@Id
//	@Column
	private String employeeId;
//	@Column
	private String employeeName;
//	@Column
	private String employeeDesignation;
//	@Column
	private float employeeSalary;
//	@Column
	private String employeeEmail;
//	@Column
	private String employeeDob;
//	@Column
	private String employeeNic;
//	@Column
	private String employeeGender;
//	@Column
	private String employeeAddress;
//	@Column
	private String employeeMobileNo;
//	@Column
	private String employeeOtherNo;
//	@Column
	private String departmentId;
//	@Column
	private String dateOfJoin;
//	@Column
	private String modOn;
//	@Column
	private String ModBy;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(String employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeNic() {
		return employeeNic;
	}

	public void setEmployeeNic(String employeeNic) {
		this.employeeNic = employeeNic;
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

	public String getEmployeeMobileNo() {
		return employeeMobileNo;
	}

	public void setEmployeeMobileNo(String employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
	}

	public String getEmployeeOtherNo() {
		return employeeOtherNo;
	}

	public void setEmployeeOtherNo(String employeeOtherNo) {
		this.employeeOtherNo = employeeOtherNo;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public String getModOn() {
		return modOn;
	}

	public void setModOn(String modOn) {
		this.modOn = modOn;
	}

	public String getModBy() {
		return ModBy;
	}

	public void setModBy(String modBy) {
		ModBy = modBy;
	}

	public Employee() {
	}

	public Employee(String employeeId, String employeeName,
			String employeeDesignation, float employeeSalary,
			String employeeEmail, String employeeDob, String employeeNic,
			String employeeGender, String employeeAddress,
			String employeeMobileNo, String employeeOtherNo,
			String departmentId, String dateOfJoin, String modOn, String modBy) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeSalary = employeeSalary;
		this.employeeEmail = employeeEmail;
		this.employeeDob = employeeDob;
		this.employeeNic = employeeNic;
		this.employeeGender = employeeGender;
		this.employeeAddress = employeeAddress;
		this.employeeMobileNo = employeeMobileNo;
		this.employeeOtherNo = employeeOtherNo;
		this.departmentId = departmentId;
		this.dateOfJoin = dateOfJoin;
		this.modOn = modOn;
		ModBy = modBy;
	}

}
