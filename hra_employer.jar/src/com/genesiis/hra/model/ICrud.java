package com.genesiis.hra.model;

import java.util.List;

///***********************************************
//* 20160422 PN created IFactory.java interface
//* 
//***********************************************/

public interface ICrud {
	public String add(Object object);
 
	public String update(Object object);

	public String delete(Object object);
	
	public String retrive(int id);

	public Object find(int empEpf);
	
	public List<Object> find(String empIdenti);

	public List<Object> getAll();
}