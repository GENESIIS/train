package com.genesiis.hra.command;

import org.jboss.logging.Logger;

import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.model.Department;
import com.genesiis.hra.model.DepartmentManager;

///***********************************************
//* 20160422 PN HRA-3 created AddDepartment.java class.
//* 20160425 PN HRA-3 modified executeAdddepartment(String gsonData), method.
//* 20160429 PN HRA-3 modified executeAdddepartment(String gsonData), method with providing proper error messages.
//***********************************************/

public class AddDepartment {
	static Logger log = Logger.getLogger(AddDepartment.class.getName());
	DepartmentManager departmentManager = new DepartmentManager();

	public String executeAdddepartment(String gsonData) {
		String message = "";
		DepartmentManager transaction = new DepartmentManager();
		try {
			// Get department object extract from Gson object.
			Department department = departmentManager.extractFromgson(gsonData);
			if (departmentManager.validDepartment(department).equalsIgnoreCase("Successfull")) {
				message = transaction.add(department);
			} else {
				message = MessageList.ERROR.message();
			}
		} catch (Exception e) {
			log.info("Exception-department: " + e);
		}
		return message;
	}
}