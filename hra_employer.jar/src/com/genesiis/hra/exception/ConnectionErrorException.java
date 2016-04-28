package com.genesiis.hra.exception;

public class ConnectionErrorException extends Exception {

	// /***********************************************
	// * 20160428 PN HRA-9 created ConnectionErrorException.java class
	// *
	// ***********************************************/

	private static final long serialVersionUID = 1L;

	public ConnectionErrorException() {
		super("Database Connection Exception.");
	}
}
