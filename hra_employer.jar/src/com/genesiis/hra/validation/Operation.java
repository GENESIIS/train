package com.genesiis.hra.validation;

//2016/05/13 AS Changed class name add commands 
import java.util.HashMap;
import java.util.Map;

public enum Operation {

	// For the time being
	EMPLOYEE(9), BASIC_DATA(1), FAMILY_MEMBER(2), ADD_EDU_DETAILS(3), STUDY_PROGRAM(
			4), LOAN(5), EMPLOYMENT_HISTORY(6), NO_COMMAND(-1);

	private final int value;

	Operation(final int newValue) {
		this.value = newValue;
	}

	public int getValue() {
		return value;
	}

	// ////////////////////////////////////
	/**
	 * Method to get Enum name from given value.
	 * **/
	private static final Map lookup = new HashMap();
	static {
		// Create reverse lookup hash map
		for (Operation d : Operation.values())
			lookup.put(d.getValue(), d);
	}

	public static Operation get(int revValue) {
		// the reverse lookup by simply getting
		// the value from the lookup HsahMap.
		return (Operation) lookup.get(revValue);
	}

}