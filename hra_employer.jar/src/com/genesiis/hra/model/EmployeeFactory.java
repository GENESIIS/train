package com.genesiis.hra.model;

/**
 * 20160510 GetCrudJDBC class created to return a particular
 * **/
public class EmployeeFactory {
	public Employee getEmployeefactory(int value) {
		switch (value) {
		case 1:
			return new BasicData();
		case 2:
			return new Familymember();
		case 3:
			return new EducationData();
		case 4:
		//	return new Studyprogram();
		default:
			return null;
		}
	}
}