package com.genesiis.hra.model;



import java.sql.SQLException;
import java.util.List;

import com.genesiis.hra.model.ICrud;

public abstract class Leaves implements ICrud{

	
	public Leaves() {
	}


	public int add(Object object) {
		// TODO Auto-generated method stub
		return -1;
	}

	public int update(Object object, String epf) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findByEpf(String empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

}
