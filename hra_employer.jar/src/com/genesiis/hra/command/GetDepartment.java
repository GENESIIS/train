package com.genesiis.hra.command;

import java.util.List;
import org.jboss.logging.Logger;
import com.genesiis.hra.model.DepartmentCrudJDBC;

///***********************************************
//* 20160506 PN HRA-2 created GetDepartment.java class
//***********************************************/

public class GetDepartment {
	static Logger log = Logger.getLogger(GetDepartment.class.getName());

	public List<String> execute() {
		List<String> list = null;
		try {
			DepartmentCrudJDBC departmentManager = new DepartmentCrudJDBC();
			list = departmentManager.getDepartments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
