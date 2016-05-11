package com.genesiis.hra.model;

import java.util.List;

///***********************************************
//* 20160422 PN created IFactory.java interface
//* 
//***********************************************/

public interface ICrud {
	
//	public String add(Object object);
//
//	public String update(Object object);
//
//	public String delete(Object object);
//
//	public String getObjectid(String id);
//
//	public List<Object> getAll();
	
	
	public int add(Object object);

	public String update(Object object);

	public String delete(Object object);

	public String getId(String id);

	public List<Object> getAll();
	
	public boolean isValid(Object object);
	
}