package com.genesiis.hra.command;

///***********************************************
//* 20160427 PN HRA-9 created ICommandAJX.java class
//***********************************************/

import java.util.HashMap;

public interface ICommandAJX {
	public String execute(String gsonData);

	public Object extractFromJason(String data);

	public boolean validateValue(Object entiytObject);

	
	//Work on this from next Sprint.
	public boolean validateValue(HashMap<Integer, Object> entiytMap) throws Exception;
}