package com.genesiis.hra.validation;

import java.util.Map;

public enum Operation {

			EMPLOYEE("EMP"), 
			ADD_EMPLOYEE_BASICDATA("AEB"),
			BASIC_DATA("BASIC"),
			GET_BASIC_DATA("GETBASIC"),
			ADD_FAMILY_MEMBER("AFM"),
			GET_FAMILY("GETFAMILY"),
			ADD_DEPARTMENT("ADP"),
			GET_MANAGER("GMN"), 
			GET_DEPARTMENT("GDP"),
			ADD_EDU_DETAILS("AED"),
			UPDATE_EDU_DETAILS("UED"),
			GET_EDU_DETAILS("GED"),
			STUDY_PROGRAM("STD"),
			LOAN("LOAN"), 
			EMPLOYMENT_HISTORY("HIS"),
			ADD_SALARY_COMPONENT("ASC"),
			ADD_SALARY_SCHEME("ASL"),
			BAD_OPERATION("BO");

	private final String value;

	Operation(final String newValue) {
		this.value = newValue;
	}

	public String getValue() {
		return value;
	}

	// ////////////////////////////////////
	public static Operation getOperation(String o) {
		for (Operation op : values()) {

			if (op.getValue().equalsIgnoreCase(o))
				return op;
		}
		return BAD_OPERATION;
	}

}