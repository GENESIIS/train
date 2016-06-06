package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.BasicData;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

///***********************************************
//* 20160422 PN HRA-2 created AddEmployee.java class.
//* 20160425 PN HRA-2 modified executeAddEmployee(String gsonData), method.
//* 20160429 PN HRA-2 modified executeAddEmployee(String gsonData), method with providing proper error messages.
//* 20160503 PN HRA-2 modified the execute method.
//***********************************************/

public class AddEmployeeBasicdata implements ICommand {
	static Logger log = Logger.getLogger(BasicData.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	@Override
	public String execute(String gsonData) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			BasicData data = geBasicdetails(gsonData);
			id = data.add(data);
			message = MessageList.ADDED;
		} catch (Exception mne) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateComponent()
			message = MessageList.ERROR;
			log.error("--> execute(): ERR" + mne);
		}
		return message.message();
	}
	
	private BasicData geBasicdetails(String data) {
		BasicData basicData = (BasicData) extractFromJason(data);
		return basicData;
	}	

	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		BasicData basicData = null;
		try {
			basicData = gson.fromJson(data, BasicData.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return basicData;
	}

	@Override
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateValue(HashMap<Integer, Object> entiytMap)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String execute(String gsonData, Operation operation) {
		// TODO Auto-generated method stub
		return null;
	}

}
