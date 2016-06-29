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
			log.info("gsonData " + gsonData);

			LeaveType data = getLeaveTypedetails(gsonData);
			if (validCountandDuration(data).equalsIgnoreCase("incorrect")) {
				message = MessageList.INCORRECTDATACOMBINATION;
			} else if (validateLeaves(data).equalsIgnoreCase("True")) {
				id = data.add(data);
				message = MessageList.ADDED;
			} else {
				message = MessageList.INCORRECTLEAVEDATA;
			}

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
		System.out.println("extractFromJason(String gsonData) " + gsonData);
		Gson gson = new Gson();
		String message = "";
		LeaveType leave = null;
		try {
			leave = gson.fromJson(gsonData, LeaveType.class);
		} catch (Exception ex) {
			System.out.print("Error in extractFromJson");
			message = MessageList.ERROR.message();
			;
		}
		return leave;
	}

	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	public String validCountandDuration(LeaveType leaveType) {

		String message = "incorrectM";
		System.out.print(leaveType.getLeaveDuration());
		double duration = Double.parseDouble(leaveType.getLeaveDuration());
		double count = Double.parseDouble(leaveType.getLeaveCount());
		if ((duration < count)) {
			message = "incorrect";
		}

		return message;
	}
// Validate data is in correct format and empty field
	public String validateLeaves(LeaveType leaveType) {
		DataValidator validator = new DataValidator();
		String message = "True";
		if (!validator.isNumber((leaveType.getLeaveDuration()))) {
			message = message + MessageList.ERROR.message() + " ";
		}
		if (!validator.isNumberOrDecimal((leaveType.getLeaveCount()))) {
			message = message + MessageList.ERROR.message() + " ";
		}
		if (!validator.isNumberNotMinus((leaveType.getLeaveDuration()))) {
			message = message + MessageList.ERROR.message() + " ";
		}
		if (!validator.isNumberNotMinus((leaveType.getLeaveCount()))) {
			message = message + MessageList.ERROR.message() + " ";
		}
		if (!validator.isValidString(leaveType.getLeaveType())) {
			message = message + MessageList.EMPTYFIELD.message() + " ";
		}
		if (!validator.isValidString(leaveType.getLeaveDuration())) {
			message = message + MessageList.EMPTYFIELD.message() + " ";
		}
		if (!validator.isValidString(leaveType.getLeaveCount())) {
			message = message + MessageList.EMPTYFIELD.message() + " ";
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
		/*
		 * System.out.print("okk"); log.info("Hello");
		 * System.out.println("getLeaveTypedetails(String data) "+data);
		 */
		LeaveType leavetype = (LeaveType) extractFromJason(data);

		return leavetype;
	}

}
