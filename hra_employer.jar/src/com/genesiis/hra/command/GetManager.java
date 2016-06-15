package com.genesiis.hra.command;

import java.util.HashMap;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.fileupload.RequestHttpWrapper;
import com.genesiis.hra.model.Department;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetManager implements ICommandAJX {
	static Logger log = Logger.getLogger(GetManager.class.getName());
	HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

	@Override
	public String execute(String gsonData) {
		String message = MessageList.ERROR.message();
		try {
			Department department = new Department();
			List<String> list = department.getManagers();
			String gson = null;
			gson = new Gson().toJson(list);
			message = gson;
		} catch (Exception mne) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateComponent()
			message = MessageList.ERROR.message();
			log.error("--> execute(): ERR" + mne); 
		}
		return message;
	}

	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(String gsonData, String epf) {
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

	@Override
	public String executeWapper(String details,
			RequestHttpWrapper httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}