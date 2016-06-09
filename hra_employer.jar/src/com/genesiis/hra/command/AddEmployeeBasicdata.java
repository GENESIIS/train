package com.genesiis.hra.command;

import java.text.ParseException;
import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.BasicData;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160422 PN HRA-2 created AddEmployee.java class.
//* 20160425 PN HRA-2 modified executeAddEmployee(String gsonData), method.
//* 20160429 PN HRA-2 modified executeAddEmployee(String gsonData), method with providing proper error messages.
//* 20160503 PN HRA-2 modified the execute method.
//***********************************************/

public class AddEmployeeBasicdata implements ICommandAJX {
	static Logger log = Logger.getLogger(BasicData.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	public String execute(String inputdata, String task) {
		EmployeeCrudJDBC accessdata = new EmployeeCrudJDBC();
		int id = -1;
		MessageList message = MessageList.ERROR;
		try {
			BasicData employee = (BasicData) extractFromJason(inputdata);
			if (validateEmployee(employee).equalsIgnoreCase("True")) {
				id = accessdata.update(employee, "1");
			} else {

			}
		} catch (Exception e) {
			message = MessageList.ERROR;
		}
		return message.message();
	}

	public String validateEmployee(BasicData employee) throws ParseException {
		DataValidator validator = new DataValidator();
		String message = "True";
		if (!validator.isValidString(employee.getEmployeename())) {
			message = message + MessageList.EMPTYFIELD.message() + " ";
		}
		if (!validator.isValidNic(employee.getEmployeenic())) {
			message = message + MessageList.NICERROR.message() + " ";
		}
		if (!validator.isValidString(employee.getEmployeeepf())) {
			message = message + MessageList.EMPTYFIELD.message() + " ";
		}
		if (!validator.isPastDate(employee.getEmployeedateofbirth())) {
			message = message + MessageList.INVALIDBIRTDAY.message() + " ";
		}
		if (!validator.isValidTelephone(employee.getEmployeemobile())) {
			message = message + MessageList.MOBILENUMBERERROR.message() + " ";
		}
		if (!validator.isValidTelephone(employee.getEmployeetelephone())) {
			message = message + MessageList.PHONENUMBERERROR.message() + " ";
		}
		if (!validator.isValidemail(employee.getEmployeeemail())) {
			message = message + MessageList.EMAILERROR.message() + " ";
		}
		return message;
	}

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

	public String execute(int epf) {
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
