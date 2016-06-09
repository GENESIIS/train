package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.Familymember;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetFamilyMember implements ICommandAJX {
	static Logger log = Logger.getLogger(GetFamilyMember.class.getName());


	public String execute(String epf) {
		MessageList message = MessageList.ERROR;
		String familydetails = null;

		Familymember familyManger = new Familymember();

		try {
			log.info(epf + "=========");
			// familydetails = familyManger.findByEpf(epf);
			log.info("execute");
		} catch (Exception e) {
			log.error("execute - Exception " + e);
		}
		return familydetails;
	}



	// Create geson object
	public String createGson(Employee emp) {
		Gson gson = new Gson();
		String empList = " ";
		try {
			empList = gson.toJson(emp);
		} catch (Exception e) {
			log.error("CreateFromgson - Exception " + e);
		}
		return empList;

	}



	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}



	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}



	public Object extractFromJason(String data) {
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
