package com.genesiis.hra.command;
import java.util.logging.Logger;

import com.genesiis.hra.model.DataManager;
import com.genesiis.hra.model.Employees;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;


public class EditEmployee {

	static Logger log = Logger.getLogger(EditEmployee.class.getName());
	
	// Method to execute JsonData 
	public void execute(String gsonData) {		
		DataManager accessdata = new DataManager();		
		String message = "";		
		Employees employee = extractFromgson(gsonData);
		
		if (validEmployee(employee)) {
			message = accessdata.update(employee);
		} else {
			message = MessageList.ERROR.message();
		}
		
	}
	
	// Method to extract DepartmentDetails from jsonData.
		public Employees extractFromgson(String gsonData) {
			Gson gson = new Gson();
			Employees employee = null;
			try {
				employee = gson.fromJson(gsonData, Employees.class);
				
			} catch (Exception e) {
				log.info(e.toString());
			}
			return employee;
		}
		
				
		public boolean validEmployee(Employees empl) {
			DataValidator validator = new DataValidator();
			if (validator.isValidString(empl.getEmployeename())) {
				return true;
			} else {
				return false;
			}
		}
}

