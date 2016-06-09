package com.genesiis.hra.validation;

public enum Operation {

	EMPLOYEE("EMP"), 
	BAD_OPERATION("BO"),
	
	ADD_SALARY_COMPONENT("ASC"),
	ADD_SALARY_SCHEME("ASL"),
	REGISTER_LOAN("RL"),
	ADD_EMPLOYEE_HISTORY("AEH"), //add employee history data to database
	ADD_EMPLOYEE_BASICDATA("AEB"),
	ADD_MEDICAL_HISTORY("AMH"), //add medical history data to database
	ADD_MEDICAL_REPORT("AMR"), //add medical report data to database
	ADD_DEPARTMENT("ADP"),
	ADD_FAMILY_MEMBER("AFM"),
	ADD_EDU_DETAILS("AED"),
		
	SERCH_EMPLOYEE("SE"),
	BASIC_DATA("BASIC"),
	STUDY_PROGRAM("STD"),
	LOAN("LOAN"),
	EMPLOYMENT_HISTORY("HIS"),
	
	UPDATE_LOAN("UL"),
	UPDATE_EMPLOYEE_BASIC("UEB"),
	UPDATE_EMPLOYEE_HISTORY("UEH"), //update employee history data to database
	UPDATE_EDU_DETAILS("UED"),
	UPDATE_FAMILY_MEMBER("UFM"),
	
	GET_LOAN("GL"),
	GET_EMPLOYEE_BASIC("GEB"),
	GET_EMPLOYEE_HISTORY("GEH"), //get employee history data from database
	GET_MANAGER("GMN"), 
	GET_DEPARTMENT("GDP"),
	GET_FAMILY("GF"),
	GET_EDU_DETAILS("GED"),
	GET_FAMILY_MEMBER("GFM"),
	
	
	VIEW_EMPLOYEE_DETAILS("VPD");

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



