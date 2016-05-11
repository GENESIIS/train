package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

/**
 * This class is for replace the AddEmployee Command Class after completing the
 * design.
 * **/
public class AddEmployee {
	static Logger log = Logger.getLogger(AddEmployee.class.getName());

	public String execute(int key, String employeeDetails) {
		String message = "";
		try {
			EmployeeFactory factory = new EmployeeFactory();
			Employee emp = factory.getEmployeefactory(key);
			emp = (Employee) extractFromJason(emp.getClass().getName(),
					employeeDetails);
			message = emp.add(emp);
		} catch (Exception e) {
			message = MessageList.ERROR.toString();
			log.error("execute - Exception " + e);
		}
		return message;
	}

	public Object extractFromJason(String className, String gsonData)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
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
