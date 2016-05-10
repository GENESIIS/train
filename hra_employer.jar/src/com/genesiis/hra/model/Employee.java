package com.genesiis.hra.model;

import java.util.List;

//@Entity
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
		return null;
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
	public String getObjectid(String id) {
		return null;
	}

	@Override
	public List<Object> getAll() {
		return null;
	}
}