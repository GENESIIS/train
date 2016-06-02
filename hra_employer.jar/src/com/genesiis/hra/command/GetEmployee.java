package com.genesiis.hra.command;

import java.util.Map;
import java.util.logging.Logger;

import com.genesiis.hra.model.EmploymentHistory;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetEmployee implements ICommand {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	
	// insert fiels validation
	MessageList message = MessageList.ERROR;
	boolean hasError = false;
	String employeeJsonArray = null;

	public String execute(String gsonData) {
		
		// extracting gson data to object
		EmploymentHistory employmentHistory = (EmploymentHistory) extractFromJason(gsonData);
		EmploymentHistory employmentHistoryResult = (EmploymentHistory) employmentHistory.find(employmentHistory.getEhemployeeid());
	
		if (employmentHistoryResult.getEhemployeeid()!=null) {
			message = MessageList.IDFOUND;
		} else {
			// adding medical history to database table fail
			message = MessageList.IDNOTFOUND;
		}
		
		Gson gson = new Gson(); 
		employeeJsonArray = gson.toJson(employmentHistoryResult);	
		
		return employeeJsonArray;
	}

	// @tr - extracting Gson data to object for save
		public Object extractFromJason(String data) {

			Gson gson = new Gson();
			EmploymentHistory employmentHistory = null;
			try {
				// convert gson into object
				employmentHistory = gson.fromJson(data, EmploymentHistory.class);
			} catch (Exception e) {
				// error handling
				log.info("ExtractFromgson - EmploymentHistory - Exception "
						+ e.getMessage());
			}
			return employmentHistory;
		}

	public boolean validateValue(Map<String, String> entiytMap) {
		// TODO Auto-generated method stub
		return false;
	}

	public String execute(String gsonData, String employeeEpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
