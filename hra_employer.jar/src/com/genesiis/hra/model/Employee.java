package com.genesiis.hra.model;

import javax.persistence.Entity;
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
	private String employeeMobileno;
//	@Column
	private String employeeOtherno;
//	@Column
	private String departmentId;
//	@Column
	private String dateOfjoin;
//	@Column
	private String modOn;
//	@Column
	private String modBy;

	public String getEmployeeid() {
		return employeeId;
	}

	public void setEmployeeid(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeename() {
		return employeeName;
	}

	public void setEmployeename(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeedesignation() {
		return employeeDesignation;
	}

	public void setEmployeedesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public float getEmployeesalary() {
		return employeeSalary;
	}

	public void setEmployeesalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeemail() {
		return employeeEmail;
	}

	public void setEmployeeemail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeedob() {
		return employeeDob;
	}

	public void setEmployeedob(String employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeenic() {
		return employeeNic;
	}

	public void setEmployeenic(String employeeNic) {
		this.employeeNic = employeeNic;
	}

	public String getEmployeegender() {
		return employeeGender;
	}

	public void setEmployeegender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeedddress() {
		return employeeAddress;
	}

	public void setEmployeedddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeemobileno() {
		return employeeMobileno;
	}

	public void setEmployeemobileno(String employeeMobileno) {
		this.employeeMobileno = employeeMobileno;
	}

	public String getEmployeeotherno() {
		return employeeOtherno;
	}

	public void setEmployeeotherno(String employeeOtherno) {
		this.employeeOtherno = employeeOtherno;
	}

	public String getDepartmentid() {
		return departmentId;
	}

	public void setDepartmentid(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDateofjoin() {
		return dateOfjoin;
	}

	public void setDateOfJoin(String dateOfjoin) {
		this.dateOfjoin = dateOfjoin;
	}

	public String getModon() {
		return modOn;
	}

	public void setModon(String modOn) {
		this.modOn = modOn;
	}

	public String getModby() {
		return modBy;
	}

	public void setModby(String modBy) {
		this.modBy = modBy;
	}

	public Employee() {
	}

	public Employee(String employeeId, String employeeName,
			String employeeDesignation, float employeeSalary,
			String employeeEmail, String employeeDob, String employeeNic,
			String employeeGender, String employeeAddress,
			String employeeMobileno, String employeeOtherno,
			String departmentId, String dateOfjoin, String modOn, String modBy) {
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
		this.employeeMobileno = employeeMobileno;
		this.employeeOtherno = employeeOtherno;
		this.departmentId = departmentId;
		this.dateOfjoin = dateOfjoin;
		this.modOn = modOn;
		this.modBy = modBy;
	}

	

}