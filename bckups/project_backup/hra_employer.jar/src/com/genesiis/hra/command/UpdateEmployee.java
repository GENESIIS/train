package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.BasicData;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

/**
 * 2016/05/16 Removed Icommand implimention.
 * 
 * **/
public class UpdateEmployee implements ICommandAJX {
	static Logger log = Logger.getLogger(UpdateEmployee.class.getName());

	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	// @Override
	// public String execute(String gsonData) {
	// int id = -1;
	// MessageList message = MessageList.ERROR;
	// HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();
	// try {
	// // Returns a Subclass object of Employee super class according to
	// // the key. Key implies the sub class name
	// EmployeeFactory factory = new EmployeeFactory();
	// Employee emp = factory.getEmployeefactory(3);
	// // Extract the particular class type object returned from the
	// // factory.
	// // emp = (Employee) extractFromJason(emp.getClass().getName(),
	// // employeeDetails);
	//
	// emp = (Employee) createGson(emp.getClass().getName(),
	// employeeDetails);
	// log.info("emp.getClass().getName()" + emp.getClass().getName());
	// log.info("emp.getEmployeeepf()" + emp.getEmployeeepf());
	// // Only a valid object will added to the database.
	// // if (emp.isValid(emp)) {
	// validateComponent(errorList);
	// id = emp.update(emp);
	// // }else{
	// log.info("status" + id);
	// // }
	// } catch (Exception e) {
	// log.error("execute - Exception " + e);
	// }
	// return message.message();
	// }

	@Override
	public String execute(String epf) {
		int id = -1;
		MessageList message = MessageList.ERROR;
		String educationaDetails = null;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();
		try {
			// Returns a Subclass object of Employee super class according to
			// the key. Key implies the sub class name
			EmployeeFactory factory = new EmployeeFactory();
			Employee emp = factory.getEmployeeObject("GED");
			// Extract the particular class type object returned from the
			// factory.
			// emp = (Employee) extractFromJason(emp.getClass().getName(),
			// employeeDetails);

//			educationaDetails = emp.findByEpf(epf);

			log.info("emp.getClass().getName()" + emp.getClass().getName());
			log.info("emp.getEmployeeepf()" + emp.getEmployeeepf());
			// Only a valid object will added to the database.
			// if (emp.isValid(emp)) {
			validateComponent(errorList);

			// }else{
			log.info("status" + id);
			// }
		} catch (Exception e) {
			log.error("execute - Exception " + e);
		}

		return educationaDetails;
	}

	private void validateComponent(HashMap<Integer, Object> errorList) {

	}

	private Employee getEmployeeDetails(String data) {
		Employee employee = (Employee) extractFromJason(data);
		return employee;
	}

	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		// Class<?> clazz = Class.forName(className);
		// Object object = clazz.newInstance();
		Employee employee = null;
		try {
			// object = gson.fromJson(gsonData, clazz);
			employee = gson.fromJson(data, Employee.class);
		} catch (Exception e) {
			log.error("ExtractFromgson - Exception " + e);
		}
		return employee;
	}

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
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(String gsonData, String epf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}

}