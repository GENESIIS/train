package com.genesiis.hra.command;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.SalaryComponent;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetSalaryComponent implements ICommandAJX{
	static Logger log = Logger.getLogger(GetSalaryComponent.class.getName()); 
	@Override
	public String execute(String compKey) {
		SalaryComponent component = new  SalaryComponent();
		String message = MessageList.ERROR.message();
		 List<Object>  componentList = null ;
		try {
			componentList = component.find(compKey);
			message = createGson(componentList);
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
	public String createGson(List<Object> componentList) {					
		Gson gson = new Gson();	
		String component = " ";
		try {
			component = gson.toJson(componentList);			
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
