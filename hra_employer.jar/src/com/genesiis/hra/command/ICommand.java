package com.genesiis.hra.command;

import java.util.Map;

public interface ICommand {

	public String execute(String gsonData);
	
	public String execute(String gsonData,String employeeEpf);

	public Object extractFromJason(String data);

	public boolean validateValue(Map<String, String> entiytMap);
	
}
