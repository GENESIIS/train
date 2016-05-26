package com.genesiis.hra.validation;


public enum Operation {
	ADD_SALARY_COMPONENT("ASC"),
	ADD_SALARY_SCHEME("ASL"),
	BAD_OPERATION("BO"),
	SERCH_EMPLOYEE("SE"),
	REGISTER_LOAN("RL"),
	EDIT_LOAN("EL");
	
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