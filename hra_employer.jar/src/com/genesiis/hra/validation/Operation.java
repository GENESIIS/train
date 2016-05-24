package com.genesiis.hra.validation;

public enum Operation {
	EMPLOYEE(9),
	BASIC_DATA(1),
	FAMILY_MEMBER(2),
	ADD_EDU_DETAILS(3),
	STUDY_PROGRAM(4),
	LOAN(5),
	EMPLOYMENT_HISTORY(6),
	
	
	
	
	// Payroll section//
	ADD_SALARY_COMPONENT(11),
	
	NO_COMMAND(-1);

	private final int value;

	Operation(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}
}