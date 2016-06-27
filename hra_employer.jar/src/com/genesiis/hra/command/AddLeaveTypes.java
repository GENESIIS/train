package com.genesiis.hra.command;

import java.util.HashMap;

import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.model.LeaveType;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;

import org.jboss.logging.Logger;

public class AddLeaveTypes implements ICommandAJX {

	static Logger log = Logger.getLogger(AddLeaveTypes.class.getName());

	public String execute(String gsonData) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			LeaveType data = getLeaveTypedetails(gsonData);
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

	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
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
		LeaveType leavetype = (LeaveType) extractFromJason(data);
		return leavetype;
	}
	
}
