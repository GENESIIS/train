package com.genesiis.hra.model;

import java.util.List;

///***********************************************
//* 20160422 PN created IFactory.java interface
//* 
//***********************************************/

public interface ICrud {
	public int add(Object object);

	public int update(Object object);

	public String delete(Object object);

	public String getId(String id);

	public List<Object> getAll();

	public boolean isValid(Object object);

	String getEmployee(int employeeId);
}