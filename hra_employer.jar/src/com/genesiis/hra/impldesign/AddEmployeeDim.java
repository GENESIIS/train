package com.genesiis.hra.impldesign;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.ICommand;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.Familymember;
import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.model.ICrud;
import com.google.gson.Gson;

/**
 * This class is for replace the AddEmployee Command Class after completing the
 * design.
 * **/
public class AddEmployeeDim{
	static Logger log = Logger.getLogger(AddEmployeeDim.class.getName());
	public String execute(int key, EmployeeFactory factory) {
		return null;
	}


	public Object extractFromJason(String className, String gsonData) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Gson gson = new Gson();
		Class<?> clazz = Class.forName(className);
		Object object = clazz.newInstance();
		//Employee employee = null;
		try {
			object = gson.fromJson(gsonData, clazz);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return object;
	}
}
