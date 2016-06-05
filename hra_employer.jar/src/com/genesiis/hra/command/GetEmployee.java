
package com.genesiis.hra.command;
import com.genesiis.hra.model.Employee;import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Logger;

public class GetEmployee implements ICommandAJX{

	static Logger log = Logger.getLogger(GetEmployee.class.getName());		
	@Override
	public String execute(int gsonData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String execute(String inputValue, String task) {
		EmployeeFactory empOblect = new EmployeeFactory();	
		String message = MessageList.ERROR.message();	
		Employee employee = null;
		try{			
			employee = (Employee) empOblect.getEmployeeObject(task).findByEpf(inputValue);
			log.info(task);
			message = createGson(employee);	
			log.info(message);
		}catch(SQLException e){
			 message = MessageList.ERROR.message();
		}catch(Exception e){
			 message = MessageList.ERROR.message();
		}
		return message;
	}

	@Override
	public Object extractFromJason(String data) {	
		
		return null;
	}
	
	public String createGson(Object employee) throws Exception {			
		Gson gson = new Gson();  		 
		String employeeGoson = null;						
	    try {		
	    	log.info("Create Gson");
	    	employeeGoson = gson.toJson(employee);			
		    } catch (Exception e) {
		    	log.info("Error on createGson" +e);
		}		  
		return employeeGoson;
	}

	@Override
	public String validateValue(Object entiytObject) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(String gsonData) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}