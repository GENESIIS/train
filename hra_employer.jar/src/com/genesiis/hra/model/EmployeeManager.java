package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class EmployeeManager implements IDataAccessor {
	static Logger log = Logger.getLogger(EmployeeManager.class.getName());
	
	
	@Override
	public String add(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObjectid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		return null;
	}

	// Method to extract DepartmentDetails from jsonData.
		public Employee extractFromgson(String gsonData) {
			Gson gson = new Gson();
			Employee department = null;
			try {
				department = gson.fromJson(gsonData, Employee.class);
			} catch (Exception e) {
				log.info("ExtractFromgson - Exception " + e);
			}
			return department;
		}

		public String validEmployee(Employee employee) {
			return null;
		}

}
