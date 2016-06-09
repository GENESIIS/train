package com.genesiis.hra.command;

import java.util.HashMap;

///***********************************************
//* 20160427 PN HRA-9 created ICommandAJX.java class
//***********************************************/

public interface ICommandAJX {
	
	public String execute(int epf);
	
	public String execute(String gsonData);

	public String execute(String inputValue, String epf);

	public Object extractFromJason(String data);

	public String validateValue(Object entiytObject); 

	public Boolean validateValue(HashMap<Integer, Object> entitytMap);


	
	
}

