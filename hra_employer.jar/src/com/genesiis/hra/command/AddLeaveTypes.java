package com.genesiis.hra.command;

import java.util.HashMap;

import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.model.LeaveType;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

import org.jboss.logging.Logger;

public class AddLeaveTypes implements ICommandAJX {

	static Logger log = Logger.getLogger(AddLeaveTypes.class.getName());

	public String execute(String gsonData) {
		int id = -1;
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			log.info("gsonData "+ gsonData);
			LeaveType data = getLeaveTypedetails(gsonData);
			id = data.add(data);
			message = MessageList.ADDED;
		
		} catch (Exception ex) { 
			message = MessageList.ERROR;
			log.error("--> execute(): ERR" + ex);
		}
		return message.message();
	}

	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object extractFromJason(String gsonData) {
		System.out.println("extractFromJason(String gsonData) "+gsonData);
		Gson gson = new Gson();
		String message = "";
		LeaveType leave = null;
		try {
			leave = gson.fromJson(gsonData, LeaveType.class);	
			System.out.print(leave.getLeaveType()+" "+leave.getLeaveDuration()+" "+leave.getLeaveCount()+"  inside extractFromJason");
		} catch (Exception ex) {
			System.out.print("Error in extractFromJson");
			 message = MessageList.ERROR.message();;
		}
		return leave;
	}
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	public String validateLeaves(LeaveType leaveType) {
		DataValidator validator = new DataValidator();
		String message = "True";		
		if (!validator.isValidString(leaveType.getLeaveType())) {
			message = message + MessageList.EMPTYFIELD.message() +" ";
		}
		if (!validator.isValidString((leaveType.getLeaveDuration()))) {
			message = message + MessageList.EMPTYFIELD.message() +" ";
		}
		if (!validator.isValidInt((leaveType.getLeaveCount()))) {
			message = message + MessageList.EMPTYFIELD.message() +" ";
		}if (!validator.isDigit((leaveType.getLeaveCount()+""))) {
			message = message + MessageList.EMPTYFIELD.message() +" ";
		}
		return message;
	}


	public String validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}	
	private LeaveType getLeaveTypedetails(String data) {
		System.out.print("okk");
		log.info("Hello");
		System.out.println("getLeaveTypedetails(String data) "+data);
		LeaveType leavetype = (LeaveType) extractFromJason(data);
		
		return leavetype;
	}
	
}
