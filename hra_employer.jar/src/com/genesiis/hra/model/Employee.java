package com.genesiis.hra.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

///***********************************************
// * 20160407 PN HRA-1 created Employee.java class
// * 20160411 PN HRA-1 changes Employee.java class. Added employeeNic attribute.
// * 
// ***********************************************/
//@Entity
//@NamedQueries(@NamedQuery(name="Employee.getAll",query="SELECE e from EMPLOYEE e"))

public class Employee {
	private String employeeId;
	private String employeeName;
	private String employeeDesignation;
	private String employeeEmail;
	private String employeeDateofbirth;
	private String employeeNic;
	private String employeeGender;
	private String employeePermenetaddress;
	private String employeeTemporaryaddress;
	private String employeeMobile;
	private String employeeTelephone;
	private String employeeDepartment;
	private String employeeMaritalstatus;
	private String employeeJoindate;
	private String employeeEpf;
	private String employeeBasis;

	
	
	public Employee() {
	}

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

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeDateofbirth() {
		return employeeDateofbirth;
	}

	public void setEmployeeDateofbirth(String employeeDateofbirth) {
		this.employeeDateofbirth = employeeDateofbirth;
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

	public String getEmployeePermenetaddress() {
		return employeePermenetaddress;
	}

	public void setEmployeePermenetaddress(String employeePermenetaddress) {
		this.employeePermenetaddress = employeePermenetaddress;
	}

	public String getEmployeeTemporaryaddress() {
		return employeeTemporaryaddress;
	}

	public void setEmployeeTemporaryaddress(String employeeTemporaryaddress) {
		this.employeeTemporaryaddress = employeeTemporaryaddress;
	}

	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeeTelephone() {
		return employeeTelephone;
	}

	public void setEmployeeTelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeMaritalstatus() {
		return employeeMaritalstatus;
	}

	public void setEmployeeMaritalstatus(String employeeMaritalstatus) {
		this.employeeMaritalstatus = employeeMaritalstatus;
	}

	public String getEmployeeJoindate() {
		return employeeJoindate;
	}

	public void setEmployeeJoindate(String employeeJoindate) {
		this.employeeJoindate = employeeJoindate;
	}

	public String getEmployeeEpf() {
		return employeeEpf;
	}

	public void setEmployeeEpf(String employeeEpf) {
		this.employeeEpf = employeeEpf;
	}

	public String getEmployeeBasis() {
		return employeeBasis;
	}

	public void setEmployeeBasis(String employeeBasis) {
		this.employeeBasis = employeeBasis;
	}

	public Employee(String employeeId, String employeeName,
			String employeeDesignation, String employeeEmail,
			String employeeDateofbirth, String employeeNic,
			String employeeGender, String employeePermenetaddress,
			String employeeTemporaryaddress, String employeeMobile,
			String employeeTelephone, String employeeDepartment,
			String employeeMaritalstatus, String employeeJoindate,
			String employeeEpf, String employeeBasis) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeEmail = employeeEmail;
		this.employeeDateofbirth = employeeDateofbirth;
		this.employeeNic = employeeNic;
		this.employeeGender = employeeGender;
		this.employeePermenetaddress = employeePermenetaddress;
		this.employeeTemporaryaddress = employeeTemporaryaddress;
		this.employeeMobile = employeeMobile;
		this.employeeTelephone = employeeTelephone;
		this.employeeDepartment = employeeDepartment;
		this.employeeMaritalstatus = employeeMaritalstatus;
		this.employeeJoindate = employeeJoindate;
		this.employeeEpf = employeeEpf;
		this.employeeBasis = employeeBasis;
	}

}