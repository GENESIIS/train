
package com.genesiis.hra.command;

import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

import java.util.logging.Logger;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.validation.MessageList;

import java.util.logging.Logger;

///***********************************************
//* 20160430 PC HRA-8 created AddEmployee.java class
//* 20160516 PC HRA-8  execute() method Modified.
//***********************************************/
// Create json
public class GetEmployee {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	String employeD = null;
	EmployeeCrudJDBC dataAcses = new EmployeeCrudJDBC();	

	public String createGson() {
		String message = "";
		EmployeeCrudJDBC dataAcse  = new EmployeeCrudJDBC();	
		Gson gson = new Gson();  		 
		String employeD = null;		
				
	    try {
			  Employee employee = dataAcse.retrive("1");	
			  employeD = gson.toJson(employee);			
		    } catch (Exception e) {
			  message = MessageList.ERROR.message();
			  return message;			
		    }
		return employeD;
	}	
}


