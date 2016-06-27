package com.genesiis.hra.model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public abstract class SerchPersistJDBC implements ICrud {
	
	@Override
	public Object find(int empEpf)throws SQLException, Exception {
		
		return null;
	}

	@Override 
	public List<Object> find(String keyWord) throws SQLException, Exception {
				
		return null;
	
	}
	
	@Override
	public Object findByEpf(String id) {
		
		return null;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Method to extract EmployeeDetails from jsonData.
	public Employee extractFromgson(String gsonData) {
		
		return null;
	}

	public String validateEmployee(BasicData employee) throws ParseException {
		
		return null;
	}

	
	
}
