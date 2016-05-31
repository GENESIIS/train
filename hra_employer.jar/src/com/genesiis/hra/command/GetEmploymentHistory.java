package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.model.EmploymentHistory;
import com.google.gson.Gson;

public class GetEmploymentHistory {

	static Logger log = Logger.getLogger(GetEmploymentHistory.class.getName());

	public String execute(int key, String employeeDetails) {
		
		String ehGson="";
		try {
			
			//Returns a Subclass object of Employee super class according to the key. Key implies the sub class name
			EmployeeFactory factory = new EmployeeFactory();
			
			Employee emp = factory.getEmployee(key);

			
			//Extract the particular class type object returned from the factory.
			//emp = (Employee) extractFromJason(emp.getClass().getName(),	employeeDetails);

			//employeeHistoryList  = emp.getRetrive("1");
			try {
				log.info("execute");
				EmploymentHistory employmentHistory = new EmploymentHistory();
				 employmentHistory.getRetriveRecode("7");	
				ehGson = createGson(employmentHistory);			
			} catch (Exception e) {
				log.info("Exception - GetEmploymentHistory: " + e);
			}	
			
			
		} catch (Exception e) {
			log.error("execute - Exception " + e);
		}
		return ehGson;
	}

	public Object extractFromJason(String className, String gsonData) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Gson gson = new Gson();
		Class<?> clazz = Class.forName(className);
		Object object = clazz.newInstance();
		try {
			object = gson.fromJson(gsonData, clazz);
		} catch (Exception e) {
			log.error("ExtractFromgson - Exception " + e);
		}
		return object;
	}
	
	// Create geson object
		public String createGson(EmploymentHistory eh) {					
			Gson gson = new Gson();	
			String empHistory = " ";
			try {
				empHistory = gson.toJson(eh);			
			} catch (Exception e) {
				log.info("Execption - GetEmploymentHistory - createGson");
			}
			return empHistory;
		}
		
	
}
