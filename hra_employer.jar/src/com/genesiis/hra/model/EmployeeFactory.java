package com.genesiis.hra.model;

/**
 * 20160510 GetCrudJDBC class created to return a particular
 * **/
public class EmployeeFactory {
	public Employee getCrudJDBC(int value) {
		switch (value) {
		case 1:
			return new BasicData();
		case 2:
			return new Familymember();	
		case 3:
			return new Loan();
		case 4:
			return new Familymember();
		case 5:
			return new Familymember();
		default:
			return null;
		}
	}
}