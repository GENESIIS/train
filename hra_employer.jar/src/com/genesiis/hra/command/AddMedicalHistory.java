 package com.genesiis.hra.command;

import java.util.HashMap;
import java.util.logging.Logger;

import com.genesiis.hra.model.Department;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.model.MedicalHistory;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * This class is for replace the AddEmployee Command Class after completing the design.
 * **/

public class AddMedicalHistory implements ICommand{

	static Logger log = Logger.getLogger(AddMedicalHistory.class.getName());
	
	@Override
	public String execute(String gsonData) {
		String insertedSuccess = "";
		try {

			MedicalHistory medicalHistory = (MedicalHistory) extractFromJason(gsonData);

			// Only a valid object will added to the database.
			String hasError = medicalHistory.isValidED(medicalHistory);
			
			if (hasError=="success") {
				
				//adding medical history to database table
				int hasInserted = medicalHistory.add(medicalHistory);
				
				 //For ADD EMPLOYMENT HISTORY DETAILS operations.
				if (hasInserted == 1) {
					insertedSuccess = MessageList.ADDED.message();
				} else {
					insertedSuccess = MessageList.ERROR.message();
				}
				
			}else{
				return hasError;
			}
		} catch (Exception e) {
			log.info("execute - Exception " + e);
		}
		return insertedSuccess;
	}

	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		MedicalHistory medicalHistory = null;
		try {
			medicalHistory = gson.fromJson(data, MedicalHistory.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return medicalHistory;
	}


	@Override
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateValue(HashMap<Integer, Object> entiytMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int validTaskId(String task) {
		DataValidator validator = new DataValidator();
		int validTask = validator.validTaskId(task);
		return validTask;
	}

}
