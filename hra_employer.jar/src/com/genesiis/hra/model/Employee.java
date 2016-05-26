package com.genesiis.hra.model;

import java.util.List;

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

public class Employee implements ICrud {
	protected String employeeEpf;
	
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
	
	private String employeeBasis;

	public String getEmployeeepf() {
		return employeeEpf;
	}

	public void setEmployeeepf(String employeeEpf) {
		this.employeeEpf = employeeEpf;
	}

	public String getEmployeeid() {
		return employeeId;
	}

	public void setEmployeeid(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public Employee() {
	}

	public Employee(String employeeEpf) {
		super();
		this.employeeEpf = employeeEpf;
	}

	@Override
	public int add(Object object) {
		return -1;
	}

	@Override
	public int update(Object object) {
		return -1;
	}

	@Override
	public String delete(Object object) {
		return null;
	}

	@Override
	public String find(String id) {
		return null;
	}

	@Override
	public List<Object> getAll() {
		return null;
	}

	@Override
	public boolean isValid(Object object) {
		return false;
	}
	
	@Override
	public String getEmployee(int emploeeId) {
		return "";
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

	public String getEmployeeemail() {
		return employeeEmail;
	}

	public void setEmployeeemail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeedateofbirth() {
		return employeeDateofbirth;
	}

	public void setEmployeedateofbirth(String employeeDateofbirth) {
		this.employeeDateofbirth = employeeDateofbirth;
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

	public String getEmployeepermenetaddress() {
		return employeePermenetaddress;
	}

	public void setEmployeepermenetaddress(String employeePermenetaddress) {
		this.employeePermenetaddress = employeePermenetaddress;
	}

	public String getEmployeetemporaryaddress() {
		return employeeTemporaryaddress;
	}

	public void setEmployeetemporaryaddress(String employeeTemporaryaddress) {
		this.employeeTemporaryaddress = employeeTemporaryaddress;
	}

	public String getEmployeemobile() {
		return employeeMobile;
	}

	public void setEmployeemobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeetelephone() {
		return employeeTelephone;
	}

	public void setEmployeetelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone;
	}

	public String getEmployeedepartment() {
		return employeeDepartment;
	}

	public void setEmployeedepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeemaritalstatus() {
		return employeeMaritalstatus;
	}

	public void setEmployeemaritalstatus(String employeeMaritalstatus) {
		this.employeeMaritalstatus = employeeMaritalstatus;
	}

	public String getEmployeejoindate() {
		return employeeJoindate;
	}

	public void setEmployeejoindate(String employeeJoindate) {
		this.employeeJoindate = employeeJoindate;
	}



	public String getEmployeebasis() {
		return employeeBasis;
	}

	public void setEmployeebasis(String employeeBasis) {
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