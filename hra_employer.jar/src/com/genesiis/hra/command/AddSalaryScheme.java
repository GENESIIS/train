/**
 * 20160523 PN HRA-3 created AddSalaryScheme.java class
 */
package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.SalaryScheme;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * @author pabodha
 * 
 */
public class AddSalaryScheme implements ICommand {
	static Logger log = Logger.getLogger(AddSalaryScheme.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	@Override
	public String execute(String gsonData) {
		int id = -1; // The new row id created when a salary component is
		// inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			SalaryScheme scheme = getSalaryscheme(gsonData);
			validateScheme(errorList);
			id = scheme.add(scheme);
			message = MessageList.ADDED;
		} catch (Exception mne) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateScheme()
			message = MessageList.ERROR;
			log.error("--> execute(): ERR" + mne);
		}
		return message.message();
	}

	private void validateScheme(HashMap<Integer, Object> errorList) {

	}

	private SalaryScheme getSalaryscheme(String data) {
		SalaryScheme scheme = (SalaryScheme) extractFromJason(data);
		return scheme;
	}

	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		SalaryScheme scheme = null;
		try {
			scheme = gson.fromJson(data, SalaryScheme.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return scheme;
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
	public String execute(String gsonData, Operation operation) {
		// TODO Auto-generated method stub
		return null;
	}

}
