package com.genesiis.hra.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.EmploymentHistory;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;


public class AddEmployeeHistory implements ICommand {

	static Logger log = Logger.getLogger(AddEmployeeHistory.class.getName());

	public String execute(String gsonData) {

		// insert fiels validation
		MessageList message = MessageList.ERROR;
		boolean hasError = false;

		try {

			// extracting gson data to OBJECT
			EmploymentHistory employmentHistory = (EmploymentHistory) extractFromJason(gsonData);

			// extracting gson data to MAP for error check
			Map<String, String> attributeMap = jsonToMap(gsonData);

			// validating map return error map
			hasError = validateValue(attributeMap);

			// return error map is empty -> no errors
			if (!hasError) {
				
				// adding employee history to database table
				int hasInserted = employmentHistory.add(employmentHistory);

				// employee history data added
				if (hasInserted == 1) {
					message = MessageList.ADDED;
				} else {// employee history data not added
					message = MessageList.NOTADDED;
				}
				
			} else {
				// if return error map is not empty -> errors
				log.info("Execute - Error in mandatory fields are marked with an asterisk in *");
				message = MessageList.MANDATORYFIELDREQUIRED;
			}
		} catch (Exception e) {
			// if error
			log.info("Execute - AddEmployeeHistory - Exception " + e);
			return message.message();
		}
		return message.message();

	}

	public String execute(String gsonData,String task) {

		// insert fiels validation
		MessageList message = MessageList.ERROR;
		boolean hasError = false;

		try {

			// extracting gson data to OBJECT
			EmploymentHistory employmentHistory = (EmploymentHistory) extractFromJason(gsonData);

			// extracting gson data to MAP for error check
			Map<String, String> attributeMap = jsonToMap(gsonData);

			// validating map return error map
			hasError = validateValue(attributeMap);

			// return error map is empty -> no errors
			if (!hasError) {
				
				// adding employee history to database table
				int hasUpdated = employmentHistory.update(employmentHistory);

				// employee history data added
				if (hasUpdated == 1) {
					message = MessageList.UPDATED;
				} else {// employee history data not added
					message = MessageList.NOTUPDATED;
				}
				
			} else {
				// if return error map is not empty -> errors
				log.info("Execute - Error in mandatory fields are marked with an asterisk in *");
				message = MessageList.MANDATORYFIELDREQUIRED;
			}
		} catch (Exception e) {
			// if error
			log.info("Execute - AddEmployeeHistory - Exception " + e);
			return message.message();
		}
		return message.message();

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
			log.info("ExtractFromgson - AddEmployeeHistory - Exception " + e.getMessage());
		}
		return employmentHistory;
	}

	// @TR - converting Gson string to map for check errors
	public Map<String, String> jsonToMap(String t) {

		// local initialization
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();

		try {
			// convert gson into map
			map = (HashMap<String, String>) gson.fromJson(t, map.getClass());
		} catch (Exception e) {
			// error handling
			log.info("GsonToMap - AddEmployeeHistory - Exception " + e.getMessage());
		}
		return map;
	}

	// @TR - validation according to the form fields
	public boolean validateValue(Map<String, String> entiytMap) {

		// get isValidString()
		DataValidator dataValidator = new DataValidator();
		// errors are caught to
		boolean hasError = false;
		
		try {
			for (Entry<String, String> e : entiytMap.entrySet()) {
				
				// attribute value
				String value = e.getValue();

				// when fails hasError = true
				if (!dataValidator.isValidString(value)) {
					hasError = true;
				}
			}
		} catch (Exception e) {
			// error handling
			log.info("ValidateValue - AddEmployeeHistory - Exception " + e.getMessage());
		}
		return hasError;
	}

}
