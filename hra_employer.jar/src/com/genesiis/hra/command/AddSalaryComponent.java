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
			SalaryComponent component = getComponentDetails(gsonData);
			validateComponent(errorList);
			id = component.add(component);
			message = MessageList.ADDED;
		} catch (Exception mne) { // User Defined exception. This comes from the validation of the Component -> validateComponent()
			message = MessageList.ERROR;
			log.error("--> execute(): ERR" + mne);
		}
		return message.message();
	}

	private void validateComponent(HashMap<Integer, Object> errorList) {
		
	}

	private SalaryComponent getComponentDetails(String data) {
		SalaryComponent component = (SalaryComponent) extractFromJason(data);
		return component;
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




	public String execute(String gsonData, Operation operation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(int epf) {
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

}
