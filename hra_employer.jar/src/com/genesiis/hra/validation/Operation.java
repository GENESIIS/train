package com.genesiis.hra.validation;
//2016/05/13 Changed class name add commands 
public enum Operation {
	// private String message;
	//
	// ClassList(String message) {
	// this.message = message;
	// }
	//
	// public String message() {
	// return message;
	// }

	//For the time being
	EMPLOYEE(9),
	BASIC_DATA(1),
	FAMILY_MEMBER(2),
	ADD_EDU_DETAILS(3),
	STUDY_PROGRAM(4),
	LOAN(5),
	EMPLOYMENT_HISTORY(6), 
	NO_COMMAND(-1);

	private final int value;

	Operation(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}
}