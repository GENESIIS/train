package com.genesiis.hra.model;

import java.util.List;

/**
 * This class is the super class of the design.
 * **/
public abstract class Employee implements ICrud {

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

	public int add(Object object) {
		return -1;
	}

	public int update(Object object) {
		return -1;
	}

	public String delete(Object object) {
		return null;
	}

	public String getId(String id) {
		return null;
	}

	public List<Object> getAll() {
		return null;
	}
	
	public boolean isValidObject(Object object) {
		return false;
	}


}