package com.genesiis.hra.validation;

public enum ClassList {
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
	EDUCATION(3),
	STUDY_PROGRAM(4),
	LOAN(5),
	EMPLOYMENT_HISTORY(6);

	private final int value;

	ClassList(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}
}