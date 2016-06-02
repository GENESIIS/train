package com.genesiis.hra.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.model.EmploymentHistory;
import com.genesiis.hra.model.MedicalHistory;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * This class is for replace the AddEmployee Command Class after completing the
 * design.
 * **/

public class AddMedicalHistory implements ICommand {

	static Logger log = Logger.getLogger(AddMedicalHistory.class.getName());

	public String execute(String gsonData) {

		// insert fiels validation
		MessageList message = MessageList.ERROR;
		boolean hasError = false;

		try {

			// extracting gson data to object
			MedicalHistory medicalHistory = (MedicalHistory) extractFromJason(gsonData);

			// extracting gson data to MAP for error check
			Map<String, String> attributeMap = jsonToMap(gsonData);

			// validating map return error map
			hasError = validateValue(attributeMap);

			// return error map is empty -> no errors
			if (!hasError) {

				// adding medical history to database table
				int hasInserted = medicalHistory.add(medicalHistory);

				// adding medical history to database table pass
				if (hasInserted == 1) {
					message = MessageList.ADDED;
				} else {
					// adding medical history to database table fail
					message = MessageList.NOTADDED;
				}

			} else {
				// if return error map is not empty -> errors
				log.info("Execute - Error in mandatory fields are marked with an asterisk in *");
				message = MessageList.MANDATORYFIELDREQUIRED;
			}
		} catch (Exception e) {
			// if error
			log.info("Execute - AddMedicalHistory - Exception " + e);
			return message.message();
		}
		return message.message();
	}

	// @tr - extracting Gson data to object for save
	public Object extractFromJason(String data) {

		Gson gson = new Gson();
		MedicalHistory medicalHistory = null;
		try {
			// convert gson into object
			medicalHistory = gson.fromJson(data, MedicalHistory.class);
		} catch (Exception e) {
			// error handling
			log.info("ExtractFromgson - AddMedicalHistory - Exception "
					+ e.getMessage());
		}
		return medicalHistory;
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
			log.info("GsonToMap - AddMedicalHistory - Exception "
					+ e.getMessage());
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
			log.info("ValidateValue - AddMedicalHistory - Exception "
					+ e.getMessage());
		}
		return hasError;
	}

}
