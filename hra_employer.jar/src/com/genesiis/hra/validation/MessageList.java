package com.genesiis.hra.validation;

///***********************************************
//* 20160422 PN HRA-3 created Message.List Enum class
//* 20160505 PN HRA-3 New values added to the MessageList Enum
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
	PHONENUMBERERROR("Invalid Telephone Number."),
	MOBILENUMBERERROR("Invalid Mobile Number."),
	EMAILERROR("Invalid Email."),
	INVALIDDATE("Invalid DateFormat."),
	EMPTYVALUES("Empty data Fields."),
	INVALIDBIRTDAY("Invalid Birthdate."),
	
	EHADD("EHADD"),//EMPLOYE HISTORY ADD
	EHUPDATE("EHUPDATE"),//EMPLOYE HISTORY UPDATE
	EHGET("EHGET"),//EMPLOYE HISTORY UPDATE
	EHDELETE("EHDELETE"),//EMPLOYE HISTORY DELETE
	EHFIND("EHFIND"),

	INVALIDEMPLOYEEID("Invalid Employee Id"),
	INVALIDEMPLOYERNAME("Invalid Employer Name"),
	INVALIDEMPLOYERDESIGNATION("Invalid Employer Name"),
	INVALIDEMPLOYEMENTBASIS("Invalid Employment Basis"),
	INVALIDSTARTEDDATE("Invalid Started Date"),
	INVALIDCOMPLETEDDATE("Invalid Completed Date"),
	
	INVALID_REFERENCE_ONE_NAME("Invalid Reference One Name"),
	INVALID_REFERENCE_TWO_NAME("Invalid Reference Two Name"),
	INVALID_REFERENCE_ONE_COMMENT("Invalid Reference One Comment"),
	INVALID_REFERENCE_TWO_COMMENT("Invalid Reference Two Comment"),
	INVALID_REFERENCE_ONE_PHONE("Invalid Reference One Phone"),
	INVALID_REFERENCE_TWO_PHONE("Invalid Reference Two Phone"),
	INVALID_REFERENCE_ONE_MOBILE("Invalid Reference One Mobile"),
	INVALID_REFERENCE_TWO_MOBILE("Invalid Reference Two Mobile"),
	INVALID_REFERENCE_ONE_ADDRESS("Invalid Reference One Address"),
	INVALID_REFERENCE_TWO_ADDRESS("Invalid Reference Two Address"),
	INVALID_REFERENCE_ONE_DESIGNATION("Invalid Reference One Designation"),
	INVALID_REFERENCE_TWO_DESIGNATION("Invalid Reference Two Designation"),
	;
	
	private String message;

	MessageList(String message) {
		this.message = message;
	}

	public String message() {
		return message;
	}
	
}