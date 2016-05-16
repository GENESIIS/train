package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeFactory;
import com.google.gson.Gson;

/**
 * 2016/05/16 Removed Icommand implimention.
 * 
 * **/
public class AddEmployeeDim {
	static Logger log = Logger.getLogger(AddEmployeeDim.class.getName());

	public int execute(int key, String employeeDetails) {
		int status = -1;
		try {
			// Returns a Subclass object of Employee super class according to
			// the key. Key implies the sub class name
			EmployeeFactory factory = new EmployeeFactory();
			Employee emp = factory.getEmployeefactory(key);
			// Extract the particular class type object returned from the
			// factory.
			emp = (Employee) extractFromJason(emp.getClass().getName(),
					employeeDetails);
			log.info("emp.getEmployeeepf()" + emp.getEmployeeepf());
			// Only a valid object will added to the database.
			if (emp.isValid(emp)) {
				status = emp.add(emp);
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

	/*
	 * @Override public String execute(String gsonData) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Object extractFromJason(String data) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public boolean validateValue(Object entiytObject) { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public boolean validateValue(HashMap<Integer, Object>
	 * entiytMap) { // TODO Auto-generated method stub return false; }
	 */
}