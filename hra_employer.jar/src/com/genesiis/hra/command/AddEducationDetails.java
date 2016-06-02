package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.EducationData;
import com.genesiis.hra.validation.MessageList;

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
			
			
		} catch (Exception e ) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	private EducationData getEducationDetails(String data){
		EducationData educationdata = (EducationData) extractFromJason(data);
		return educationdata;
	}
	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
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
