package com.genesiis.hra.model;

import org.jboss.logging.Logger;

import com.genesiis.hra.validation.Operation;

/**
 * 20160510 GetCrudJDBC class created to return a particular
 * **/
public class EmployeeFactory {
	static Logger log = Logger.getLogger(EmployeeFactory.class.getName());	
	public Employee getEmployeeObject(String task) {
//		switch (value) {
//		case 1:
//			return new BasicData();
//		case 2:
//			return new Familymember();
//		case 3:
//			return new EducationData();
//		case 4:
//		//	return new Studyprogram();
//		default:
//			return null;
//		} 
		
		Operation o = Operation.BAD_OPERATION;
		o = Operation.getOperation(task);
		log.info("Operation"+o);
		switch (o) {
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