package com.genesiis.hra.command;

import java.text.ParseException;

import org.jboss.logging.Logger;

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

	public int execute(String gsonData) {
		int message = 0;
		try {
			// Get department object extract from Gson object.
			Department department = departmentManager.extractFromgson(gsonData);
			if (department != null) {
				if (departmentManager.validDepartment(department)) {
					message = departmentManager.add(department);
				} else {
					//message = departmentManager.validateDepartment(department);
				}
			} else {
				//message = MessageList.EMPTYVALUES.message();
			}
		} catch (NullPointerException e) {
			//message = MessageList.EMPTYFIELD.message();
			log.info("Exception-employee: " + e);
		} catch (ParseException e) {
			//message = MessageList.INVALIDDATE.message();
			log.info("Exception-employee: " + e);
		} catch (NumberFormatException e) {
			//message = MessageList.ERROR.message();
			log.info("Exception-employee: " + e);
		}
		return message;
	}
}