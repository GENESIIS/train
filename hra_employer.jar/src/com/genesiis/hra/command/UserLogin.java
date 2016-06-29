package com.genesiis.hra.command;

///***********************************************
//* 20160628 AS HRA-44 created UserLogin.java class
//***********************************************/

import org.jboss.logging.Logger;

import com.genesiis.hra.model.LoginDetails;
import com.genesiis.hra.model.SalaryComponent;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class UserLogin {

	static Logger log = Logger.getLogger(UserLogin.class.getName());

	public String execute(String gsonData) {

		MessageList message = MessageList.ERROR;
		
		

		return message.message();
	}
	
	private LoginDetails getLogon (String Data){
		LoginDetails loginDetails = (LoginDetails) extractFromJason(Data);
		return loginDetails;
	}
	
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		SalaryComponent component = null;
		try {
			component = gson.fromJson(data, SalaryComponent.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return component;
	}

}
