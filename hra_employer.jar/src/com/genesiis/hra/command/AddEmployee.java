package com.genesiis.hra.command;

import java.text.ParseException;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.validation.MessageList;

///***********************************************
//* 20160430 PN HRA-2 created AddEmployee.java class
//* 20160505 PN HRA-2  execute() method Modified.
//***********************************************/

public class AddEmployee {
	static Logger log = Logger.getLogger(AddEmployee.class.getName());
	EmployeeCrudJDBC employeeManager = new EmployeeCrudJDBC();

	public int execute(String gsonData) {
		int message = 0;
		try {
			// Get employee object extract from Gson object.
			Employee employee = employeeManager.extractFromgson(gsonData);
			if (employee != null) {
				if (employeeManager.validEmployee(employee)) {
					message = employeeManager.add(employee);
				} else {
					//message = employeeManager.validateEmployee(employee);
				}
			} else {
				//message = MessageList.EMPTYVALUES.message();
			}
		} catch (NullPointerException e) {
			//message = MessageList.EMPTYFIELD.message();
			log.info("Exception-employee: " + e);
		} catch (ParseException e) {
			//message = MessageList.INVALIDDATE.message();
			log.info("Exception-employee: " + e);
		} catch (NumberFormatException e) {
			//message = MessageList.ERROR.message();
			log.info("Exception-employee: " + e);
		}
		return message;
	}
}