package com.genesiis.hra.command;

import java.util.Map;

public interface ICommand {

	public String execute(String gsonData);

	public Object extractFromJason(String data);

	public boolean validateValue(Map<String, String> entiytMap);
	
}
