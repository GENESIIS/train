package com.genesiis.hra.command;
import java.util.logging.Logger;

import com.genesiis.hra.model.DataManager;
import com.genesiis.hra.model.Employee;
import com.google.gson.Gson;


public class EditEmployee {

	static Logger log = Logger.getLogger(EditEmployee.class.getName());
	
	public void executeAddEmployee(String gsonData) {
		
		DataManager accessdata = new DataManager();		
		String message = "";
		
		Employee employee = extractFromgson(gsonData);
		message = accessdata.update(employee);
		
	}
	
	// Method to extract DepartmentDetails from jsonData.
		public Employee extractFromgson(String gsonData) {
			Gson gson = new Gson();
			Employee employee = null;
			try {
				employee = gson.fromJson(gsonData, Employee.class);
				
			} catch (Exception e) {
				log.info(e.toString());
			}
			return employee;
		}
		
		public String validEmployee(Employee employee) {
			
				return null;
			
		}
}

