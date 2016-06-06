package com.genesiis.hra.validation;

public enum Operation {
	ADD_SALARY_COMPONENT("ASC"),
	ADD_SALARY_SCHEME("ASL"),
	BAD_OPERATION("BO"),
	SERCH_EMPLOYEE("SE"),
	REGISTER_LOAN("RL"),	
	UPDATE_LOAN("UL"),
	GET_LOAN("GL"),
	UPDATE_EMPLOYEE_BASIC("UEB"),
	GET_EMPLOYEE_BASIC("GEB"),
	ADD_EMPLOYEE_HISTORY("AEH"), //add employee history data to database
	GET_EMPLOYEE_HISTORY("GEH"), //get employee history data from database
	UPDATE_EMPLOYEE_HISTORY("UEH"), //update employee history data to database
	ADD_MEDICAL_HISTORY("AMH"), //add medical history data to database
	ADD_MEDICAL_REPORT("AMR"); //add medical report data to database
	 
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

	
