package com.genesiis.hra.model;

import java.util.List;

/**
 * This class is the super class of the design.
 * **/
public abstract class Employee implements ICrud {

	protected int id;
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