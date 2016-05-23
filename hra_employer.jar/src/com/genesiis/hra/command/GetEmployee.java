package com.genesiis.hra.command;


import com.genesiis.hra.model.DataManager;
import com.genesiis.hra.model.Employees;
import com.genesiis.hra.validation.DataValidator;
import com.google.gson.Gson;

import java.util.logging.Logger;

public class GetEmployee {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	
	public String createGson() {	
		DataManager dataAcse  = new DataManager();		
		Employees employee = dataAcse.retrive("1");			
	    String employeD = null;	   

		Gson gson = new Gson();		
		
		try {
			// employeD = gson.toJson(dataAcse.retrive("1"));
			
		} catch (Exception e) {
			
		}
		return employeD;
	}
	
	
	
}
