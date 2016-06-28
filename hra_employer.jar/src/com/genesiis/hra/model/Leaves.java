package com.genesiis.hra.model;



import java.sql.SQLException;
import java.util.List;

import com.genesiis.hra.model.ICrud;

public abstract class Leaves implements ICrud{

	
	public Leaves() {
	}


	public int add(Object object) {
		return -1;
	}

	public int update(Object object, String epf) {
		return 0;
	}

	public int delete(Object object) {
		return 0;
	}

	public Object find(int leaveid) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
