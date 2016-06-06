package com.genesiis.hra.command;

import java.util.HashMap;

public interface ICommandAJX {
	public String execute(String gsonData);

	public String execute(String gsonData, String epf);

	public Object extractFromJason(String data);

	public String validateValue(Object entiytObject); 

	public Boolean validateValue(HashMap<Integer, Object> entitytMap);

	public String execute(int epf);
}