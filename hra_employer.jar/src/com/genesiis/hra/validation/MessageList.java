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
	INVALIDENDDATE("Invalid End date."),
	INVALIDAMOUNT("Invalid Amount."),
	//PROBLEM WHEN INSERTING DATA TO DATABASE
	NOTADDED("Problem when inserting data."), 	
	//PROBLEM WHEN UPDATING DATA TO DATABASE
	NOTUPDATED("Problem when updating data."), 	
	//PROBLEM WHEN MANDATORY REQUIREDS
	MANDATORYFIELDREQUIRED("Fields marked with asterisk (*) are required"), 	
	//EMPOYEE MEDICAL HISTORY ATTRIBUTES ERROR MESSAGES
	MEDICALHISTORYEMPLOYEEID("Medical History Employee id not valid."),
	MEDICALHISTORYAILMENT("Medical History Ailment not valid."),
	MEDICALHISTORYDESCRIPTION("Medical History Description not valid"),
	MEDICALHISTORYPASS("pass"),
	MEDICALHISTORYSUCCESS("success"),
	MEDICALHISTORYNOID("No Medical History ID obtained."),		
	//EMPOYEE MEDICAL REPORT ATTRIBUTES ERROR MESSAGES
	MEDICALREPORTDESCRIPTIONNOTVALID("Medical Report Description not valid."),
	MEDICALREPORTPATHNOTVALID("Medical Report path not valid."),
	MEDICALREPORTNOTVALID("Medical Report not valid"),	
	EHADD("EHADD"),//EMPLOYE HISTORY ADD
	EHUPDATE("EHUPDATE"),//EMPLOYE HISTORY UPDATE
	EHGET("EHGET"),//EMPLOYE HISTORY UPDATE
	EHDELETE("EHDELETE"),//EMPLOYE HISTORY DELETE
	EHFIND("EHFIND");
	
	private String message;

	MessageList(String message) {
		this.message = message;
	}

	public String message() {
		return message;
	}
	
}