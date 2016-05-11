package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operations;
import com.google.gson.Gson;

public class UpdateEmployeeDim {

	static Logger log = Logger.getLogger(UpdateEmployeeDim.class.getName());

	public int execute(String operation, String employeeDetails) {

		int status = -1;
		int classCode = Operations.valueOf(operation).getclassCode();
		String task = Operations.valueOf(operation).getTask();
		int taskKey = validTaskId(task);

		try {
			EmployeeFactory factory = new EmployeeFactory();
			Employee emp = factory.getEmployee(classCode);
			emp = (Employee) extractFromJason(emp.getClass().getName(),
					employeeDetails);
			if (emp.isValid(emp)) {
				switch (taskKey) {
				case 1:
					status = emp.add(emp);
					break;
				case 2:
					emp.update(emp);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			log.error("execute - Exception " + e);
		}
		return status;
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

	public int validTaskId(String task) {
		if (task.equalsIgnoreCase(MessageList.ADD.message())) {
			return 1;
		} else if (task.equalsIgnoreCase(MessageList.UPDATE.message())) {
			return 2;
		} else if (task.equalsIgnoreCase(MessageList.DELETE.message())) {
			return 3;
		} else if (task.equalsIgnoreCase(MessageList.GETALL.message())) {
			return 4;
		} else if (task.equalsIgnoreCase(MessageList.FIND.message())) {
			return 5;
		} else {
			return -1;
		}
	}
}
