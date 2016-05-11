package com.genesiis.hra.validation;

public enum Operations {
	
	/**
	 * This is for return the operations with related to the class.
	 * **/
	ADD_EMPLOYEE("ADD", "Employee"),
	UPDATE_EMPLOYEE("UPDATE", "Employee"),
	ADD_BASICDATA("ADD", "BasicData"),
	UPDATE_BASICDATA("UPDATE", "BasicData"),
	ADD_FAMILYMEMBER("ADD", "FamilyMember"),
	UPDATE_FAMILYMEMBER("UPDATE", "FamilyMember");

	private final String TASK;
	private final String CLASSNAME;

	private Operations(String task, String classname) {
		this.TASK = task;
		this.CLASSNAME = classname;
	}

	public String getTask() {
		return TASK;
	}

	public String getClassname() {
		return CLASSNAME;
	}
}
