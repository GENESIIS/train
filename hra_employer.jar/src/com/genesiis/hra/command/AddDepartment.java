package com.genesiis.hra.command;

import java.util.logging.Logger;

import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.model.DataAccessUtill;
import com.genesiis.hra.model.Department;
import com.genesiis.hra.validation.DataValidator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

///***********************************************
//* 20160422 PN HRA-3 created AddDepartment.java class
//* 20160425 PN HRA-3 modified executeAdddepartment(String gsonData), method
//***********************************************/

public class AddDepartment {
	static Logger log = Logger.getLogger(AddDepartment.class.getName());

	public void executeAdddepartment(String gsonData) {
		DataAccessUtill accessUtill = new DataAccessUtill();		
		String message = "";

		//Format the JsonData Object.
		String jsonObject = gsonData.substring(12, gsonData.length()-1);
		log.info("jsonObject" + jsonObject);
		
		try {
			//Get department object extract from Gson object.
			Department department = extractFromgson(gsonData);
			if (validDepartment(department).equalsIgnoreCase("Successfull")) {
				log.info("validDepartment(department) "
						+ validDepartment(department));
				//message = accessUtill.add(department);
			} else {
				message = MessageList.ERROR.message();
			}
		} catch (Exception e) {
			log.info("Exception-department: " + e);
		}
	}

	// Method to extract DepartmentDetails from jsonData.
	public Department extractFromgson(String gsonData) {
		Gson gson = new GsonBuilder().create();
		Department department = null;
		try {
			department = gson.fromJson(gsonData, Department.class);
			log.info("Department department" + department);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return department;
	}

	public String validDepartment(Department department) {
		DataValidator validator = new DataValidator();
		if (validator.isValidString(department.getDepartmentName())) {
			return MessageList.SUCCESS.message();
		} else {
			return MessageList.EMPTYFIELD.message();
		}
	}

}