package com.genesiis.hra.model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
/*
 * 20160622 PC HRA-30 create Abstract class SearchPersistJDBC
*/
public abstract class SearchPersistJDBC implements ICrud {

	@Override
	public int add(Object object) {
		
		return 0;
	}
 
	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}	


	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public String retrive(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object find(int empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String keyWord) throws SQLException, Exception {
	
		return null;
	}

	@Override
	public List<Object> getAll() {
		return null;
	}

	public String validateEmployee(Employee employee) throws ParseException {
		
		return null;
	}

	
	public boolean validEmployee(Employee employee) throws ParseException {
		
			return false;		
	}
	
	public List<String> getManagers() {
		
		return null;
	}


	
}
