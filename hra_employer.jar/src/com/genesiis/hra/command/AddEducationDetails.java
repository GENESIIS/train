package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.EducationData;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class AddEducationDetails implements ICommandAJX{

	static Logger log = Logger.getLogger(AddEducationDetails.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();
	@Override
	public String execute(String gsonData) {
		int id = -1;
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();
		
		try {
			EducationData educationData = getEducationDetails(gsonData);
			log.info("JasonData object :   "+gsonData);
			validateComponent(errorList);
			id = educationData.add(educationData);
			message = MessageList.ADDED;
		} catch (Exception e ) {
			message = MessageList.ERROR;
			log.error(" execute(): ERR" + e);
		} 
		
		// TODO Auto-generated method stub
		return message.message();
	}
	
	public String execute(String gsonData,String task) {
		int id = -1;
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();
		try {
		EducationData educationData = getEducationDetails(gsonData);
		validateComponent(errorList);
		id = educationData.update(educationData);
		message = MessageList.UPDATED;
		} catch (Exception e) {
			log.info("ExcuteUpdate() : ERR "+e);
		}
		
		return message.message();
	}
	
	private EducationData getEducationDetails(String data){
		EducationData educationdata = (EducationData) extractFromJason(data);
		log.info("Extract form jason :  "+educationdata);
		return educationdata;
	}
	
	private void validateComponent(HashMap<Integer, Object> errorList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		EducationData educationdata =  null;
		try {
			educationdata = gson.fromJson(data, EducationData.class);
			
		} catch (Exception e) {
			log.info("Extract From Gson - Exception " +e);
		}
		return educationdata;
	}
	@Override
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean validateValue(HashMap<Integer, Object> entiytMap)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
