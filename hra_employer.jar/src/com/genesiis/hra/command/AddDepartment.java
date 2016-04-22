package com.genesiis.hra.command;

import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Logger;

import com.genesiis.hra.model.ClassFactory;
import com.genesiis.hra.model.Department;
import com.genesiis.hra.model.IFactory;
import com.genesiis.hra.validation.DataValidator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

///***********************************************
//* 20160422 PN HRA-3 created AddDepartment.java class
//* 
//***********************************************/

public class AddDepartment {
	private static final String DEPARTMENTDAO_CLASS = "DepartmentDao";
	static Logger log = Logger.getLogger(AddDepartment.class.getName());

	public void execute(String gsonData) {
		log.info("gsonData " + gsonData);
		ClassFactory classFactory = new ClassFactory();
		IFactory iFactory = classFactory.getClassfactory(DEPARTMENTDAO_CLASS);
		String message = "";

		try {
			Department department = extractFromgson(gsonData);
			if (validDepartment(department).equalsIgnoreCase("Successfull")) {
				log.info("validDepartment(department) "
						+ validDepartment(department));
				// message = iFactory.add(department);
			} else {
				message = validDepartment(department);
			}
		} catch (Exception e) {
			log.info("Exception-department: " + e);
		}
	}

	//Method to extract DepartmentDetails from jsonData.
	public Department extractFromgson(String gsonData) {
		Gson gson = new GsonBuilder().create();
		Department department = null;
		try {
			Reader targetReader = new StringReader(gsonData);
			department = gson.fromJson(targetReader, Department.class);

			log.info("Department department" + department);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return department;
	}

	public String validDepartment(Department department) {
		DataValidator validator = new DataValidator();
		if (validator.isValidString(department.getDepartmentName())) {
			return DataValidator.ValidationErrors.SUCCESS.message();
		} else {
			return DataValidator.ValidationErrors.EMPTYFIELD.message();
		}
	}

}
