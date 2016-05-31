package com.genesiis.hra.validation;

public enum Operation {
	ADD_EMPLOYEE_BASICDATA("AEB"),
	ADD_SALARY_COMPONENT("ASC"),
	ADD_SALARY_SCHEME("ASL"),
	BAD_OPERATION("BO"),
	ADD_DEPARTMENT("ADP"),
	GET_MANAGER("GMN"),
	GET_DEPARTMENT("GDP");

	private final String value;

	Operation(String newValue) {
		this.value = newValue;
	}

	public String getValue() {
		return value;
	}
	
	public static Operation getOperation(String o){		
		for(Operation op : values()){
			
			if(op.getValue().equalsIgnoreCase(o))
				return op;			
		}		
		return BAD_OPERATION;
	}
}
