package com.genesiis.hra.command;

///***********************************************
//* 20160427 PN HRA-9 created ICommandAJX.java class
//***********************************************/

import java.util.HashMap;

import com.genesiis.hra.validation.Operation;

public interface ICommandAJX {
	
	public String execute(String gsonData);
	
	public String execute(String gsonData,Operation operation);

	public Object extractFromJason(String data);

	public boolean validateValue(Object entiytObject);

	public boolean validateValue(HashMap<Integer, Object> entiytMap) throws Exception;

}