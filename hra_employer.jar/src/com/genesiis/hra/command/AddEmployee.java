package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeManager;
import com.genesiis.hra.validation.MessageList;


public class AddEmployee {

	static Logger log = Logger.getLogger(AddEmployee.class.getName());
	EmployeeManager employeeManager = new EmployeeManager();

	public String executeAddemployee(String gsonData) {
		String message = "";
		try {
			// Get employee object extract from Gson object.
			Employee employee = employeeManager.extractFromgson(gsonData);
			if (employeeManager.validEmployee(employee).equalsIgnoreCase("Successfull")) {
				message = employeeManager.add(employee);
			} else {
				message = MessageList.ERROR.message();
			}
		} catch (Exception e) {
			log.info("Exception-employee: " + e);
		}
		return message;
	}
}