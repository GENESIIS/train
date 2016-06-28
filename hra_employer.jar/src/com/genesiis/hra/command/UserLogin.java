package com.genesiis.hra.command;

///***********************************************
//* 20160628 AS HRA-44 created UserLogin.java class
//***********************************************/

import org.jboss.logging.Logger;

import com.genesiis.hra.validation.MessageList;

public class UserLogin {

	static Logger log = Logger.getLogger(UserLogin.class.getName());

	public String execute(String gsonData) {

		MessageList message = MessageList.ERROR;
		
		

		return message.message();
	}
}
