package com.genesiis.hra.command;

import java.util.logging.Logger;

import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.model.DataAccessUtill;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddEmployee {

	static Logger log = Logger.getLogger(AddEmployee.class.getName());
	
	public void executeAddEmployee(String gsonData) {
		
		DataAccessUtill accessUtill = new DataAccessUtill();		
		String message = "";

		//Format the JsonData Object.
		
		//log.info("jsonObject" + jsonObject);
		
		Employee employee = extractFromgson(gsonData);
		message = accessUtill.update(employee);
		/*try { 
			//Get employee object extract from Gson object.
			
			if (validEmployee(employee).equalsIgnoreCase("Successfull")) {
				log.info("validEmployee(employee) "
						+ validEmployee(employee));
				message = accessUtill.add(employee);
			} else {
				message = MessageList.ERROR.message();
			}
		} catch (Exception e) {
			log.info("Exception-department: " + e);
		}*/
	}
	// Method to extract DepartmentDetails from jsonData.
		public Employee extractFromgson(String gsonData) {
			Gson gson = new Gson();
			Employee employee = null;
			try {
				employee = gson.fromJson(gsonData, Employee.class);
				log.info("Employee department" + employee.getEmployeename());
			} catch (Exception e) {
				log.info("ExtractFromgson - Exception " + e);
			}
			return employee;
		}
		
		public String validEmployee(Employee employee) {
			DataValidator validator = new DataValidator();
			if (validator.isValidString(employee.getEmployeename())) {
				return MessageList.SUCCESS.message();
			} else {
				return MessageList.EMPTYFIELD.message();
			}
		}
}
