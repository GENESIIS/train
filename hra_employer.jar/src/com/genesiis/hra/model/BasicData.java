package com.genesiis.hra.model;

import java.sql.SQLException;
import java.util.List;

public class BasicData extends Employee {
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
	
	public BasicData() {
	}

	public BasicData(String employeeName, String employeeDesignation,
			String employeeEmail, String employeeDateofbirth,
			String employeeNic, String employeeGender,
			String employeePermenetaddress, String employeeTemporaryaddress,
			String employeeMobile, String employeeTelephone,
			String employeeDepartment, String employeeMaritalstatus,
			String employeeJoindate, String employeeEpf, String employeeBasis) {
		super();
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

	

	@Override
	public String retrive(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(int empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}