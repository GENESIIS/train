package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.fileupload.RequestHttpWrapper;
import com.genesiis.hra.model.Department;
import com.google.gson.Gson;

///***********************************************
//* 20160422 PN HRA-3 created AddDepartment.java class.
//* 20160425 PN HRA-3 modified executeAdddepartment(String gsonData), method.
//* 20160429 PN HRA-3 modified executeAdddepartment(String gsonData), method with providing proper error messages.
//* 20160503 PN HRA-3 modified the execute method.
//***********************************************/

public class AddDepartment implements ICommandAJX {
	static Logger log = Logger.getLogger(AddDepartment.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	@Override
	public String execute(String gsonData) { 
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			Department department = getDepartmentdetails(gsonData);
			validateComponent(errorList);
			id = department.add(department);
			message = MessageList.ADDED;
		} catch (Exception mne) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateComponent()
			message = MessageList.ERROR;
			log.error("--> execute(): ERR" + mne);
		}
		return message.message();
	}
	
	private void validateComponent(HashMap<Integer, Object> errorList) {
		// TODO Auto-generated method stub
		
	}

	private Department getDepartmentdetails(String data) {
		Department department = (Department) extractFromJason(data);
		return department;
	}

	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		Department department = null;
		try {
			department = gson.fromJson(data, Department.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return department;
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