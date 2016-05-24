package com.genesiis.hra.model;

import java.util.List;

///***********************************************
//* 20160422 PN created IFactory.java interface
//* 
//***********************************************/

public interface IDataAccessor {
	
	public String add(Object object);
	
	public String update(Employees object);
	
	public String update(Object object);

	public String delete(Object object);

	public Employees retrive(String id);

	public List<Object> getAll();
}
 