package com.genesiis.hra.validation;

public enum Operation {

	// For the time being
	BASIC_DATA(1) , 
	FAMILY_MEMBER(2) , 
	ADD_EDU_DETAILS(3) , 
	STUDY_PROGRAM(4) , 
	LOAN(5), 
	EMPLOYMENT_HISTORY(6) , 
	ADD_MEDICAL_HISTORY(7), //add medical history data to database
	GET_AILMENT_TYPES(8),//populate ailment type drop down	
	EMPLOYEE(9),
	NO_COMMAND(-1);

	private final int value;

	Operation(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

	public static Operation fromString(String task) {
		return Operation.valueOf(task);
	}

}
