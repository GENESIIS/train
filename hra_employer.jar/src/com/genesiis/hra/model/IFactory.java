package com.genesiis.hra.model;

import java.util.List;

///***********************************************
//* 20160422 PN created IFactory.java interface
//* 
//***********************************************/

public interface IFactory {
	
	//Message set that will return by the CRUD methods.
	public enum MessageList {
	    ADDED("Details added successfully."),
	    UPDATED("Details updated successfully."),
	    DELETED("Details deleted successfully."),
	    IDFOUND("ID found."),
	    IDNOTFOUND("ID not found."),
	    ERROR("Unsuccessful."),
	    UNKNOWN("");

	    private String message;

	    MessageList(String message) {
	        this.message = message;
	    }

	    public String message() {
	        return message;
	    }
	}
	
	
	public String add(Object object);

	public String update(Object object);

	public String delete(Object object);

	public String getObjectid(String id);

	public List<Object> getAll();
}
