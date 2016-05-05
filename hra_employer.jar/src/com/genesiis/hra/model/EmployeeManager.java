package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;


///***********************************************
//* 20160430 PN HRA-2 created EmployeeManager.java class
//* 20160501 PN HRA-3 getManagers() method created.
//***********************************************/

public class EmployeeManager implements ICrud {
	static Logger log = Logger.getLogger(EmployeeManager.class.getName());

	@Override
	public String add(Object object) {
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
	
	public List<String> getManagers() {
		String query = "SELECT * FROM [HRA.EMPLOYEE] WHERE DESIGNATION='Manager';";
		Connection conn = null;
		List<String> managers = new ArrayList<String>();
		Statement statement = null;
		try {
			conn = ConnectionManager.getConnection();
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()){
				managers.add(result.getString(1)+"#"+result.getString(2));
			}
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return managers;
	}
}
