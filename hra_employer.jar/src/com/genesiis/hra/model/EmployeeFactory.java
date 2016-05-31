package com.genesiis.hra.model;

/**
 * 20160510 GetCrudJDBC class created to return a particular
 * **/
public class EmployeeFactory {
	public Employee getEmployee(int value) {
		switch (value) {
		case 6:
			return new EmploymentHistory();
		default:
			return null;
		}
	}
}
