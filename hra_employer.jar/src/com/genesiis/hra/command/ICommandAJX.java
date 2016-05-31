package com.genesiis.hra.command;

import java.util.HashMap;

public interface ICommandAJX {
	public String execute(String gsonData);

	public Object extractFromJason(String data);

	public boolean validateValue(Object entiytObject);

	public boolean validateValue(HashMap<Integer, Object> entiytMap) throws Exception;
}