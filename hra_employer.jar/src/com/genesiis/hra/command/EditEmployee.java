package com.genesiis.hra.command;
import java.text.ParseException;
import java.util.logging.Logger;

import com.genesiis.hra.model.BasicData;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

import java.text.ParseException;

///***********************************************
//* 20160430 PC HRA-4 created EditEmployee.java class
//* 20160516 PC HRA-4  execute() method Modified.
//***********************************************/

public class EditEmployee {

	static Logger log = Logger.getLogger(EditEmployee.class.getName());
	
	// Method to execute JsonData 
	public String execute(String gsonData) {		
		EmployeeCrudJDBC accessdata = new EmployeeCrudJDBC();		
		int id = -1;
		MessageList message = MessageList.ERROR;
		try{
			BasicData employee = extractFromgson(gsonData);	
		      if (validateEmployee(employee).equalsIgnoreCase("True")) {
			     id = accessdata.update(employee);
		       } else {
			     
		       }
		}catch(Exception e){
			 message = MessageList.ERROR;
		}
		return message.message();
	}
	
	// Method to extract DepartmentDetails from jsonData.
		public BasicData extractFromgson(String gsonData) {
			Gson gson = new Gson();
			String message = "";
			BasicData employee = null;
			try {
				employee = gson.fromJson(gsonData, BasicData.class);				
			} catch (Exception e) {
				 message = MessageList.ERROR.message();;
			}
			return employee;
		}			
		
		
		public String validateEmployee(BasicData employee) throws ParseException  {
			DataValidator validator = new DataValidator();
			String message = "True";		
			if (!validator.isValidString(employee.getEmployeename())) {
				message = message + MessageList.EMPTYFIELD.message() +" ";
			}
			if (!validator.isValidNic(employee.getEmployeenic())) {
				message = message + MessageList.NICERROR.message() +" ";
			}
			if (!validator.isValidString(employee.getEmployeeepf())) {
				message = message + MessageList.EMPTYFIELD.message() +" ";
			}
			if (!validator.isPastDate(employee.getEmployeedateofbirth())) {
				message = message + MessageList.INVALIDBIRTDAY.message() +" ";
			}
			if (!validator.isValidTelephone(employee.getEmployeemobile())) {
				message = message + MessageList.MOBILENUMBERERROR.message() +" ";
			}
			if (!validator.isValidTelephone(employee.getEmployeetelephone())) {
				message = message + MessageList.PHONENUMBERERROR.message() +" ";
			}
			if (!validator.isValidemail(employee.getEmployeeemail())) {
				message = message + MessageList.EMAILERROR.message() +" ";
			}
			return message;
		}
		
}

