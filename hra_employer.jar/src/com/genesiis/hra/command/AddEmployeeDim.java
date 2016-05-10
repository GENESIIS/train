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
public class AddEmployeeDim {
	static Logger log = Logger.getLogger(AddEmployeeDim.class.getName());

	public String execute(int key, Employee employee) {
		String message = "";
		try {
			EmployeeFactory factory = new EmployeeFactory();
			Employee emp = factory.getEmployeefactory(key);
			message = emp.add(employee);
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
		// Employee employee = null;
		try {
			object = gson.fromJson(gsonData, clazz);
		} catch (Exception e) {
			log.error("ExtractFromgson - Exception " + e);
		}
		return object;
	}
}
