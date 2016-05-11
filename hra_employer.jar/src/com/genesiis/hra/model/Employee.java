package com.genesiis.hra.model;

import java.util.List;

/**
 * This class is the super class of the design.
 * **/
public abstract class Employee implements ICrud {
	protected String employeeEpf;	

	public String getemployeeEpf() {
		return employeeEpf;
	}

	public void setemployeeEpf(String employeeEpf) {
		this.employeeEpf = employeeEpf;
	}
	
	public Employee() {
	}

	public Employee(String employeeEpf) {
		super();
		this.employeeEpf = employeeEpf;
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