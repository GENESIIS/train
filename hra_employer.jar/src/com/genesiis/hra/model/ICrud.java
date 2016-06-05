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

	public int delete(Object object);

	public Object find(int empEpf)throws SQLException, Exception;
	
	public List<Object> find(String empIdenti) throws SQLException, Exception;

	public Object findByEpf(String empEpf);

}