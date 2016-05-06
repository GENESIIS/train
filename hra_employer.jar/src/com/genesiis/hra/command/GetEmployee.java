package com.genesiis.hra.command;


import com.genesiis.hra.model.EditEmployeeCrudJDBC;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.google.gson.Gson;

import java.util.logging.Logger;

public class GetEmployee {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	
	public String createGson() {
		
		EditEmployeeCrudJDBC dataAcse  = new EditEmployeeCrudJDBC();		
		Employee employee = dataAcse.retrive("1");			
		Gson gson = new Gson();  		 
		String employeD = null;
		
		try {
			 employeD = gson.toJson(employee);
			
		} catch (Exception e) {
			
		}
		return employeD;
	}
	
	
	
}
