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
	ADD_MEDICAL_REPORT("AMR"), //add medical report data to database
	EMPLOYEE("EMP"), 
	ADD_EMPLOYEE_BASICDATA("AEB"),
	BASIC_DATA("BASIC"),
	
	ADD_FAMILY_MEMBER("AFM"),
	GET_FAMILY("GF"), 
	ADD_DEPARTMENT("ADP"),
	GET_MANAGER("GMN"), 
	GET_DEPARTMENT("GDP"),
	ADD_EDU_DETAILS("AED"),
	UPDATE_EDU_DETAILS("UED"),
	GET_EDU_DETAILS("GED"),
	STUDY_PROGRAM("STD"),
	LOAN("LOAN"), 
	EMPLOYMENT_HISTORY("HIS"),
	VIEW_EMPLOYEE_DETAILS("VPD"),

	UPDATE_FAMILY_MEMBER("UFM"),
	GET_FAMILY_MEMBER("GFM"),
	ADD_STUDY_PROGRAM("ASP"),
	UPDATE_STUDY_PROGRAM("USP"),
	GET_STUDY_PROGRAM("GSP");
	
	private final String value;

	Operation(final String newValue) {
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