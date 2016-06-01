package com.genesiis.hra.model;

import java.sql.SQLException;
import java.util.List;

///***********************************************
//* 20160422 PN created IFactory.java interface
//* 
//***********************************************/

public interface ICrud {
	
	public int add(Object object);
	 
	public int update(Object object);

	public String delete(Object object);
	
	public String retrive(int id);

	public Object find(int empEpf);
	
	public List<Object> find(String empIdenti) throws SQLException, Exception;

	public List<Object> getAll();

	Object retrive(String id);
}