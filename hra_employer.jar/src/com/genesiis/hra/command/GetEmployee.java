package com.genesiis.hra.command;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.genesiis.hra.model.Familymember;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

public class GetEmployee implements ICommandAJX {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());

	// insert fiels validation
	MessageList message = MessageList.ERROR;
	boolean hasError = false;
	String jsonArray = null;

	public String execute(String gsonData, Operation operation) {

		switch (operation) {

		case GET_FAMILY_MEMBER:
			jsonArray = executeFamilyDetails(gsonData);
			break;

		default:
			break;
		}

		return jsonArray;
	}

	public String executeFamilyDetails(String gsonData) {

		Gson gson = new Gson();
		
		// extracting gson data to object
		Familymember familyMember = 
				gson.fromJson(gsonData, Familymember.class);
		
		String familyMemberResult = 
				familyMember.getEmployee(Integer.parseInt(familyMember.getEmployeeepf()));

		if (familyMemberResult != null) {
			message = MessageList.IDFOUND;
		} else {
			// adding medical history to database table fail
			message = MessageList.IDNOTFOUND;
		}

		System.out.println("executeFamilyDetails"+familyMemberResult);
		return familyMemberResult;
	}

	public String execute(String gsonData) {
		return null;
	}

	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean validateValue(Map<String, String> entiytMap) {
		// TODO Auto-generated method stub
		return false;
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

}
