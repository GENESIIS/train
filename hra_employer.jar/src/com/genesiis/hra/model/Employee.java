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

	public String getEmployeeepf() {
		return employeeEpf;
	}

	public void setEmployeeepf(String employeeEpf) {
		this.employeeEpf = employeeEpf;
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
	public String getId(String id) {
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
}