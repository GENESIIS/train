package com.genesiis.hra.model;

import java.util.logging.Logger;
import com.genesiis.hra.validation.Operation;

/**
 * 20160510 GetCrudJDBC class created to return a particular
 * **/
public class EmployeeFactory {
	static Logger log = Logger.getLogger(EmployeeFactory.class.getName());	
	public Employee getEmployeeObject(String task) {
		
		Operation o = Operation.BAD_OPERATION;
		o = Operation.getOperation(task);
		log.info("Operation"+o);
		switch (o) {
		case GET_EMPLOYEE_BASIC:
			return new BasicData();
		case GET_EMPLOYEE_HISTORY:
			return new EmploymentHistory();
		case GET_BASIC_DATA:
			return new BasicData();
		case GET_EDU_DETAILS:
			return new EducationData();
		case GET_FAMILY:
			return new Familymember();
		default:
			return null;
		}
	}
}
