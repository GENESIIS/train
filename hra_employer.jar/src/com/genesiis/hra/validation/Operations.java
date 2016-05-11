package com.genesiis.hra.validation;

public enum Operations {
	
	/**
	 * This is for return the operations with related to the class.
	 * **/
	ADD_EMPLOYEE("ADD", 5),
	UPDATE_EMPLOYEE("UPDATE", 5),
	ADD_BASICDATA("ADD", 1),
	UPDATE_BASICDATA("UPDATE", 1),
	ADD_FAMILYMEMBER("ADD", 2),
	UPDATE_FAMILYMEMBER("UPDATE", 2);

	private final String TASK;
	private final int CLASSCODE;

	private Operations(String task, int classCode) {
		this.TASK = task;
		this.CLASSCODE = classCode;
	}

	public String getTask() {
		return TASK;
	}

	public int getclassCode() {
		return CLASSCODE;
	}
}
