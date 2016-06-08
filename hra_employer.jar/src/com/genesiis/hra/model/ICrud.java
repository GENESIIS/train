package com.genesiis.hra.model;

import java.sql.SQLException;
import java.util.List;
/***********************************************
* 20160422 PN created ICrud.java interface 
***********************************************/

public interface ICrud {
	public int add(Object object);
	
	public int update(Object object, String epf);

	public int delete(Object object);
	
	public Object find(int empEpf)throws SQLException, Exception;
	
	public List<Object> find(String empIdenti) throws SQLException, Exception;
	
	public Object findByEpf(String empEpf);
	
	public String getId(String id);

	public List<Object> getAll();
	
	public boolean isValidObject(Object object);
}