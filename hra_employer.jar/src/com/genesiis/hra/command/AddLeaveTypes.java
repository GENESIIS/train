package com.genesiis.hra.command;

import java.util.HashMap;

import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.model.BasicData;
import com.genesiis.hra.model.LeaveType;
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

	public String validateLeaves(Object entiytObject) {
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
	private LeaveType getLeaveTypedetails(String data) {
		LeaveType leavetype = (LeaveType) extractFromJason(data);
		return leavetype;
	}
	
}
