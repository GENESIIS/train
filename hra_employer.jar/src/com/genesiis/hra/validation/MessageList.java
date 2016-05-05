package com.genesiis.hra.validation;

///***********************************************
//* 20160422 PN HRA-3 created Message.List Enum class
//* 
//***********************************************/


public enum MessageList {	
	//Message set that will return by the CRUD methods.
	ADDED("Details added successfully."), 
	UPDATED("Details updated successfully."), 
	DELETED("Details deleted successfully."), 
	IDFOUND("ID found."), 
	IDNOTFOUND("ID not found."), 
	ERROR("Unsuccessful."), 
	UNKNOWN(""),
    EMPTYFIELD("Field is Empty."),
    SUCCESS("Successfull"),
    FAILED_TO_CREATE("Object not created"),
	ADD("ADD"),
	UPDATE("UPDATE"),
	DELETE("DELETE"),
	FIND("FIND"),
	GETALL("GETALL"),
	NICERROR("Invalid NIC Number."),
	PHONENUMBERERROR("Invalid Phone Number."),
	EMAILERROR("Invalid Email."),
	INVALIDDATE("In valid Birthdate."),
	EMPTYVALUES("Empty data Fields.");

	private String message;

	MessageList(String message) {
		this.message = message;
	}

	public String message() {
		return message;
	}
	
}