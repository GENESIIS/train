package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.EducationData;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetEducation implements ICommandAJX {
	static Logger log = Logger.getLogger(GetEducation.class.getName());

	@Override
	public String execute(String epf) {
		MessageList message = MessageList.ERROR;
		String educationdetails = null;

		EducationData EducationManager = new EducationData();
		try {
			educationdetails = EducationManager.findByEpf(epf);
		} catch (Exception e) {
			log.error("execute - Exception " + e);
		}
		return educationdetails;
	}

	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
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

	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
