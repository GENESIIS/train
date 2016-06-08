/**
 * 20160531 PN created AddFamilyDetails.java command class.
 */
package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Familymember;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * @author pabodha
 *
 */
public class AddFamilyDetails implements ICommandAJX{
	
	
	static Logger log = Logger.getLogger(AddFamilyDetails.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	
	
	/**
	 * @param String gsonData 
	 * @return String message
	 * **/
	public String execute(String gsonData) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			Familymember familymember = getFamilymemberdetails(gsonData);
			validateComponent(errorList);
			id = familymember.add(familymember);
			if(id!=-1){
				message = MessageList.ADDED;
			}else{
				message = MessageList.ERROR;
			}
			
		} catch (Exception e) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateComponent()
			message = MessageList.ERROR;
			log.error("Exception - execute(): ERR" + e);
		}
		return message.message();
	}
	
	
	
	


	
	
	/**
	 * @param errorList
	 * @return void
	 */
	private void validateComponent(HashMap<Integer, Object> errorList) {
		// TODO Auto-generated method stub
	}

	private Familymember getFamilymemberdetails(String data) {
		Familymember familymember = (Familymember) extractFromJason(data);
		return familymember;
	}


	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		Familymember familymember = null;
		try {
			familymember = gson.fromJson(data, Familymember.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return familymember;
	}


	
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean validateValue(HashMap<Integer, Object> entiytMap)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	/**
	 * @param String gsonData 
	 * @param String task 
	 * @return String message
	 * **/
	public String execute(String gsonData, Operation operation) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			log.info("execute");
			Familymember familymember = getFamilymemberdetails(gsonData);
			validateComponent(errorList);
			id = familymember.update(familymember);
			if(id!=-1){
				message = MessageList.UPDATED;
			}else{
				message = MessageList.ERROR;
			}
		} catch (Exception e) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateComponent()
			message = MessageList.ERROR;
			log.error("Exception - execute(String gsonData,String task) : ERR" + e);
		}
		return message.message();
	}

}
