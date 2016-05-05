package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.validation.MessageList;

///***********************************************
//* 20160430 PN HRA-2 created AddEmployee.java class
//***********************************************/

public class AddEmployee {
	static Logger log = Logger.getLogger(AddEmployee.class.getName());
	EmployeeCrudJDBC employeeManager = new EmployeeCrudJDBC();

	public String execute(String gsonData) {
		String message = "";
		try {
			// Get employee object extract from Gson object.

			log.info("gsonData: " + gsonData);
			Employee employee = employeeManager.extractFromgson(gsonData);
			if (employee != null) {
				if (employeeManager.validEmployee(employee)) {
					message = employeeManager.add(employee);
				} else {
					message = employeeManager.validateEmployee(employee);
				}
			} else {
				message = MessageList.EMPTYVALUES.message();
			}
		} catch (Exception e) {
			message = MessageList.ERROR.message();
			log.info("Exception-employee: " + e);
		}
		return message;
	}
}