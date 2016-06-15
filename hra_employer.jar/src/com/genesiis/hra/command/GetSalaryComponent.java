package com.genesiis.hra.command;

import java.sql.SQLException;
import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.SalaryComponent;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetSalaryComponent implements ICommandAJX{
	static Logger log = Logger.getLogger(GetLoan.class.getName());
	@Override
	public String execute(String inputValue) {
		SalaryComponent component = new  SalaryComponent();
		String message = MessageList.ERROR.message();
		try {
			component = (SalaryComponent) component.find(inputValue);
			message = createGson(component);
		} catch (SQLException e) {
			log.error(e);
			message = MessageList.ERROR.message();
		} catch (Exception ex) {
			log.error(ex);
			message = MessageList.ERROR.message();
		}
		
		return message;
	}
	
	// Create Gson object
	public String createGson(SalaryComponent com) {					
		Gson gson = new Gson();	
		String component = " ";
		try {
			component = gson.toJson(com);			
		} catch (Exception e) {
			
		}
		return component;
	}
	@Override
	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
