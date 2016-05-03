package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.model.Department;
import com.genesiis.hra.model.DepartmentCrudJDBC;

///***********************************************
//* 20160422 PN HRA-3 created AddDepartment.java class.
//* 20160425 PN HRA-3 modified executeAdddepartment(String gsonData), method.
//* 20160429 PN HRA-3 modified executeAdddepartment(String gsonData), method with providing proper error messages.
//* 20160503 PN HRA-3 modified the execute method.
//***********************************************/

public class AddDepartment {
	static Logger log = Logger.getLogger(AddDepartment.class.getName());
	DepartmentCrudJDBC departmentManager = new DepartmentCrudJDBC();

	public String execute(String gsonData) {
		String message = "";
		try {
			// Get department object extract from Gson object.
			Department department = departmentManager.extractFromgson(gsonData);
			if (validDepartment(department)) {
				message = departmentManager.add(department);
			} else {
				message = MessageList.ERROR.message();
			}
		} catch (Exception e) {
			message = MessageList.FAILED_TO_CREATE.message();
			log.info("Exception-department: " + e);
		}
		return message;
	}

	public boolean validDepartment(Department department) {
		DataValidator validator = new DataValidator();
		if (validator.isValidString(department.getDepartmentname())
				&& validator.isValidString(department.getDepartmentNumber())) {
			return true;
		} else {
			return false;
		}
	}
}