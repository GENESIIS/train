package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetEmployee implements ICommandAJX {
	static Logger log = Logger.getLogger(GetEmployee.class.getName());

	@Override
	public String execute(String epf) {

		MessageList message = MessageList.ERROR;
		String empdetails = null;
		EmployeeCrudJDBC employeeManager = new EmployeeCrudJDBC();

		try {
			// Returns a Subclass object of Employee super class according to
			// the key. Key implies the sub class name
			// EmployeeFactory factory = new EmployeeFactory();
			// Employee emp = factory.getEmployeefactory(3);
			// Extract the particular class type object returned from the
			// factory.
			// emp = (Employee) extractFromJason(emp.getClass().getName(),
			// employeeDetails);

			// educationaDetails = emp.find(epf);
			log.info(epf +"====================================");
			empdetails = employeeManager.find(epf);
			log.info("execute");

			// log.info("educationaDetails.getClass().getName()" +
			// educationaDetails.getClass().getName());


			log.info(empdetails);
			// Only a valid object will added to the database.
			// if (emp.isValid(emp)) {

			// }else{

			// }
		} catch (Exception e) {
			log.error("execute - Exception " + e);
		}

		return empdetails;
	}

	 

	private Employee getEmployeeDetails(String data) {
		Employee employee = (Employee) extractFromJason(data);
		return employee;
	}

	@Override
	public Object extractFromJason(String data) {
		// Gson gson = new Gson();
		// // Class<?> clazz = Class.forName(className);
		// // Object object = clazz.newInstance();
		// Employee employee = null;
		// try {
		// // object = gson.fromJson(gsonData, clazz);
		// employee = gson.fromJson(data, Employee.class);
		// } catch (Exception e) {
		// log.error("ExtractFromgson - Exception " + e);
		// }
		// return employee;
		return null;
	}

	// Create geson object
	public String createGson(Employee emp) {
		Gson gson = new Gson();
		String empList = " ";
		try {
			empList = gson.toJson(emp);
		} catch (Exception e) {
			log.error("CreateFromgson - Exception " + e);
		}
		return empList;
	}

	@Override
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateValue(HashMap<Integer, Object> entiytMap)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}
}
