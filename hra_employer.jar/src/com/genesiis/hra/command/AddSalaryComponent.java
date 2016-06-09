/**
 * 20160523 PN HRA-3 created AddSalaryComponent.java class
 */
package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.SalaryComponent;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * @author pabodha
 * 
 */
public class AddSalaryComponent implements ICommandAJX {
	static Logger log = Logger.getLogger(AddSalaryComponent.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	public String execute(String gsonData) {
		int id = -1; // The new row id created when a salary component is
						// inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			SalaryComponent component = (SalaryComponent)extractFromJason(gsonData);
			boolean isValid = validateValue(errorList);
			isValid = true; //not yet implemented
			if(isValid){
				id = component.add(component);
				message = MessageList.ADDED;
			}else{
				message = MessageList.ERROR;
				log.error("ERR" + message);
			}
			
		} catch (Exception mne) { // User Defined exception. This comes from the validation of the Component -> validateComponent()
			message = MessageList.ERROR;
			log.error("--> execute(): ERR" + mne);
		}
		return message.message();
	}

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

	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}

	public String validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}


}
