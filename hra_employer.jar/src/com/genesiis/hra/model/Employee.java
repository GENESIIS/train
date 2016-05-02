package com.genesiis.hra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


//com.genesiis.hra.model.Employee

///***********************************************
// * 20160407 PN HRA-1 created Employee.java class
// * 20160411 PN HRA-1 changes Employee.java class. Added employeeNic attribute.
// * 
// ***********************************************/
@Entity
public class Employee {
	@Id
	@Column 
	private String EmployeeId;
	@Column
	private String FirstName;
	@Column
	private String Designation;
	@Column
	private float Salary;
	@Column
	private String Email;
	@Column
	private String DoB;
	@Column
	private String NIC;
	@Column
	private String Gender;
	@Column
	private String Address;
	@Column
	private String MobNumber;
	@Column
	private String OtherNumber;
	@Column
	private String Department;
	@Column
	private String DoJ;
	@Column
	private String modOn;
	@Column
	private String modBy;

	public String getEmployeeid() {
		return EmployeeId;
	}

	public void setEmployeeid(String employeeId) {
		this.EmployeeId = employeeId;
	}

	public String getEmployeename() {
		return FirstName;
	}

	public void setEmployeename(String employeeName) {
		this.FirstName = employeeName;
	}

	public String getEmployeedesignation() {
		return Designation;
	}

	public void setEmployeedesignation(String employeeDesignation) {
		this.Designation = employeeDesignation;
	}

	public float getEmployeesalary() {
		return Salary;
	}

	public void setEmployeesalary(float employeeSalary) {
		this.Salary = employeeSalary;
	}

	public String getEmployeeemail() {
		return Email;
	}

	public void setEmployeeemail(String employeeEmail) {
		this.Email = employeeEmail;
	}

	public String getEmployeedob() {
		return DoB;
	}

	public void setEmployeedob(String employeeDob) {
		this.DoB = employeeDob;
	}

	public String getEmployeenic() {
		return NIC;
	}

	public void setEmployeenic(String employeeNic) {
		this.NIC = employeeNic;
	}

	public String getEmployeegender() {
		return Gender;
	}

	public void setEmployeegender(String employeeGender) {
		this.Gender = employeeGender;
	}

	public String getEmployeedddress() {
		return Address;
	}

	public void setEmployeedddress(String employeeAddress) {
		this.Address = employeeAddress;
	}

	public String getEmployeemobileno() {
		return MobNumber;
	}

	public void setEmployeemobileno(String employeeMobileno) {
		this.MobNumber = employeeMobileno;
	}

	public String getEmployeeotherno() {
		return OtherNumber;
	}

	public void setEmployeeotherno(String employeeOtherno) {
		this.OtherNumber = employeeOtherno;
	}

	public String getDepartmentid() {
		return Department;
	}

	public void setDepartmentid(String departmentId) {
		this.Department = departmentId;
	}

	public String getDateofjoin() {
		return DoJ;
	}

	public void setDateOfJoin(String DoJ) {
		this.DoJ = DoJ;
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
		this.EmployeeId = employeeId;
		this.FirstName = employeeName;
		this.Designation = employeeDesignation;
		this.Salary = employeeSalary;
		this.Email = employeeEmail;
		this.DoB = employeeDob;
		this.NIC = employeeNic;
		this.Gender = employeeGender;
		this.Address = employeeAddress;
		this.MobNumber = employeeMobileno;
		this.OtherNumber = employeeOtherno;
		this.Department = departmentId;
		this.DoJ = dateOfjoin;
		this.modOn = modOn;
		this.modBy = modBy;
	}

	

}
