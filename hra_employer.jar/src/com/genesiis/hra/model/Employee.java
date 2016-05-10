package com.genesiis.hra.model;

import java.util.List;

/**
 * This class is the super class of the design.
 * **/
public abstract class Employee implements ICrud {
	private String employeeId;

	public Employee() {
	}

	public String getEmployeeid() {
		return employeeId;
	}

	public void setEmployeeid(String employeeId) {
		this.employeeId = employeeId;
	}

	public Employee(String employeeId) {
		super();
		this.employeeId = employeeId;
	}

	@Override
	public String add(Object object) {
		return "You are in Employee";
	}

	@Override
	public String update(Object object) {
		return null;
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
}