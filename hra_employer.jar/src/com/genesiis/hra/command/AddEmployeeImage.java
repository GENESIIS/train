package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.EmployeeImage;
import com.genesiis.hra.model.MedicalHistory;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class AddEmployeeImage implements ICommandAJX {

	static Logger log = Logger.getLogger(AddFamilyDetails.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();
	
	@Override
	/**
	 * @param 
	 * String gsonData
	 * @return 
	 * String message
	 * 
	 * Add employee image data
	 * **/
	public String execute(String gsonData) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;

		try {
			EmployeeImage  employeeImage = (EmployeeImage)extractFromJason(gsonData);

			id = employeeImage.add(employeeImage);
			if (id != 0) {
				message = MessageList.ADDED;
			} else {
				message = MessageList.ERROR;
			}

		} catch (Exception e) { // User Defined exception. 
			//This comes from the validation of the Component
								// validateComponent()
			message = MessageList.ERROR;
			log.error("Exception - execute(): ERR" + e);
		}
		return message.message();
	}
	
	@Override
	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	/**
	 * @param 
	 * String gsonData
	 * @return 
	 * String EmployeeImageObject
	 * **/
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		EmployeeImage employeeImage = null;
		try {
			// convert gson into object
			employeeImage = gson.fromJson(data, EmployeeImage.class);
		} catch (Exception e) {
			// error handling
			log.info("ExtractFromgson - AddMedicalHistory - Exception "
					+ e.getMessage());
		}
		return employeeImage;
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
