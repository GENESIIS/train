package com.genesiis.hra.command;

import java.util.List;
import org.jboss.logging.Logger;
import com.genesiis.hra.model.EmployeeCrudJDBC;

///***********************************************
//* 20160506 PN HRA-2 created GetManager.java class
//***********************************************/

public class GetManager {
	static Logger log = Logger.getLogger(GetDepartment.class.getName());

	public List<String> execute() {
		List<String> list = null;
//		try {
//			EmployeeCrudJDBC employeeManager = new EmployeeCrudJDBC();
//			list = employeeManager.getManagers();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return list;
	}
}
