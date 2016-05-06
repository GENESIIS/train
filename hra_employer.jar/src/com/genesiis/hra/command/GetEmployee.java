package com.genesiis.hra.command;


import com.genesiis.hra.model.EditEmployeeCrudJDBC;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

import java.util.logging.Logger;

public class GetEmployee {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	
	public String createGson() {
		String message = "";
		EditEmployeeCrudJDBC dataAcse  = new EditEmployeeCrudJDBC();	
		Gson gson = new Gson();  		 
		String employeD = null;		
				
	    try {
			  Employee employee = dataAcse.retrive("1");	
			  employeD = gson.toJson(employee);			
		    } catch (Exception e) {
			  message = MessageList.ERROR.message();
		}
		  
		return employeD;
	}
	
	
	
}
