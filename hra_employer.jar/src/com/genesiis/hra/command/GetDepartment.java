package com.genesiis.hra.command;



///***********************************************
//* 20160531 PN HRA-3 created GetDepartment.java class
//* 20160531 PN HRA-3 execute() method modified.. 
//***********************************************/

import java.util.HashMap;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Department;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetDepartment implements ICommandAJX {
	static Logger log = Logger.getLogger(GetDepartment.class.getName());
	HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

	@Override
	public String execute(String gsonData) {
		String message = MessageList.ERROR.message();
		try {
			Department department = new Department();
			List<String> list = department.getDepartments();
			String gson = null;
			gson = new Gson().toJson(list);
			message = gson;
		} catch (Exception mne) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateComponent() 
			message = MessageList.ERROR.message();
			log.error("--> execute(): ERR" + mne);
		}
		return message;
	}
 
	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
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