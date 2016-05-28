package com.genesiis.hra.command;

import java.util.HashMap;
import java.util.logging.Logger;

import com.genesiis.hra.model.MedicalHistory;
import com.genesiis.hra.model.MedicalReport;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class AddMedicalReport implements ICommand{

static Logger log = Logger.getLogger(AddMedicalReport.class.getName());
	
	@Override
	public String execute(String gsonData) {
		String insertedSuccess = "";
		try {

			MedicalReport medicalReport = (MedicalReport) extractFromJason(gsonData);

			// Only a valid object will added to the database.
			String hasError = medicalReport.isValidObject(medicalReport);
			
			if (hasError=="pass") {
				
				//adding medical history to database table
				int hasInserted = medicalReport.add(medicalReport);
				
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
		MedicalReport medicalReport = null;
		try {
			medicalReport = gson.fromJson(data, MedicalReport.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return medicalReport;
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
