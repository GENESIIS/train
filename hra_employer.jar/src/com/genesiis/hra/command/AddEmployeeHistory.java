package com.genesiis.hra.command;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.EmploymentHistory;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class AddEmployeeHistory implements ICommand {

	static Logger log = Logger.getLogger(AddEmployeeHistory.class.getName());

	public String execute(String gsonData) {

		// insert fiels validation
		MessageList message = MessageList.ERROR;

		try {

			// extracting gson data to object
			EmploymentHistory employmentHistory = (EmploymentHistory) extractFromJason(gsonData);

			// error fields will be visible
			String hasError = employmentHistory.isValidObjectd(employmentHistory);

			// if no error
			if (MessageList.SUCCESS.message().equalsIgnoreCase(hasError)) {

				// adding employee history to database table
				int hasInserted = employmentHistory.add(employmentHistory);

				// if ADD EMPLOYMENT HISTORY DETAILS success
				if (hasInserted == 1) {
					message = MessageList.ADDED;
				} else {// if ADD EMPLOYMENT HISTORY DETAILS fails
					message = MessageList.ERROR;
				}

			} else {
				// if error
				return message.message();
			}
		} catch (Exception e) {
			// if error
			log.info("execute - Exception " + e);
		}
		return message.message();

	}

	/**
	 * @tr extracting json data to object
	 * **/
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		EmploymentHistory employmentHistory = null;
		try {
			employmentHistory = gson.fromJson(data, EmploymentHistory.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return employmentHistory;
	}

	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}

	public String validateValue(HashMap<String, String> entiytMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public int validTaskId(String task) {
		// TODO Auto-generated method stub
		return 0;
	}
}
