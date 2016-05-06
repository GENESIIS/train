package com.genesiis.hra.command;


import com.genesiis.hra.model.DataManager;
import com.genesiis.hra.model.Employees;
import com.google.gson.Gson;


import java.util.logging.Logger;



public class GetEmployee {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	String employeD = null;
	DataManager dataAcses = new DataManager();	
	public String createGson() {	
		Gson gson = new Gson();  								
		
		try {
			 employeD = gson.toJson(dataAcses.retrive("1"));
			
		} catch (Exception e) {
			
		}
		return employeD;
	}
	
	
	
}
