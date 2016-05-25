/**
 * 20160523 PN HRA-3 created AddSalaryComponent.java class
 */
package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.SalaryComponent;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

/**
 * @author pabodha
 * 
 */
public class AddSalaryComponent implements ICommand {
	static Logger log = Logger.getLogger(AddSalaryComponent.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	@Override
	public String execute(String gsonData) {
		String message = MessageList.ERROR.message();
		
		SalaryComponent component = (SalaryComponent) extractFromJason(gsonData);
		
		boolean hasError = validateValue(entiytMap);
		
		log.info("inside execute");
		if (hasError) {
			int rowInsetrted = component.add(component);
			if(rowInsetrted>0){
				message = MessageList.ADDED.message();
			}
			log.info("execute - hasNoError");
		} else {
			log.info("execute - hasError");
		}
		return message;
	}

	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		SalaryComponent component = null;
		try {
			component = gson.fromJson(data, SalaryComponent.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return component;
	}

	@Override
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateValue(HashMap<Integer, Object> entiytMap) {
		// TODO Auto-generated method stub
		return true;
	}

}
