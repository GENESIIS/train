package com.genesiis.hra.validation;

import java.util.Map;

public enum Operation {

	// For the time being
	EMPLOYEE("EMP"), BASIC_DATA("BASIC"), FAMILY_MEMBER("FAM"), ADD_EDU_DETAILS(
			"EDU"), STUDY_PROGRAM("STD"), LOAN("LOAN"), EMPLOYMENT_HISTORY(
			"HIS"), BAD_OPERATION("BO");

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