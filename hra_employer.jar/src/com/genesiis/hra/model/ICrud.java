package com.genesiis.hra.model;

import java.util.List;

///***********************************************
//* 20160422 PN created IFactory.java interface
//* 
//***********************************************/

public interface ICrud {
	
	public int add(Object object);

	public String update(Object object);

	public String delete(Object object);

	public String getId(String id);

	public List<Object> getAll();
	
	public boolean isValid(Object object);

	//thumeera - Employee history retrive using id
	public List<Object> getRetrive(String id);

	//thumeera - Employee history update using id with data
	public int updateEmployeeHistory(Object object);

	//thumeera - Employee history get recode using id with data
	public Object getRetriveRecode(String id);

	boolean isValidUpdate(Object object);

	public String getEmployee(int employeeId);
}