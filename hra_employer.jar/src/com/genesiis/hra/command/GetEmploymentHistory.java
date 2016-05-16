package com.genesiis.hra.command;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeFactory;
import com.google.gson.Gson;

public class GetEmploymentHistory {

	static Logger log = Logger.getLogger(UpdateEmployee.class.getName());

	public List<Object> execute(int key, String employeeDetails) {
		
		List<Object> employeeHistoryList = new ArrayList<Object>();
		
		
		try {
			
			//Returns a Subclass object of Employee super class according to the key. Key implies the sub class name
			EmployeeFactory factory = new EmployeeFactory();
			
			Employee emp = factory.getEmployee(key);

			//Extract the particular class type object returned from the factory.
			emp = (Employee) extractFromJason(emp.getClass().getName(),	employeeDetails);

//			if (emp.isValid(emp)) {
				employeeHistoryList  = emp.getRetrive("1");
//			}
			
		} catch (Exception e) {
			log.error("execute - Exception " + e);
		}
		return employeeHistoryList;
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
	
}
