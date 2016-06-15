/**
 * 20160531 PN created AddFamilyDetails.java command class.
 */
package com.genesiis.hra.command;

import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.fileupload.RequestHttpWrapper;
import com.genesiis.hra.model.Familymember;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

/**
 * @author pabodha
 * 
 */
public class AddFamilyDetails implements ICommandAJX {

	static Logger log = Logger.getLogger(AddFamilyDetails.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	/**
	 * @param 
	 * String gsonData
	 * @return 
	 * String message
	 * **/
	public String execute(String gsonData) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			Familymember familymember = (Familymember)extractFromJason(gsonData);
			validateComponent(errorList);
			id = familymember.add(familymember);
			if (id != -1) {
				message = MessageList.ADDED;
			} else {
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
	 * @param 
	 * String gsonData
	 * String task
	 * @return 
	 * String message
	 * **/
	@Override
	public String execute(String inputValue, String epf) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			log.info("execute");
			Familymember familymember = (Familymember) extractFromJason(inputValue);
			validateComponent(errorList);
			id = familymember.update(familymember, epf);
			if (id != -1) {
				message = MessageList.UPDATED;
			} else {
				message = MessageList.ERROR;
			}
		} catch (Exception e) { // User Defined exception. This comes from the
								// validation of the Component ->
								// validateComponent()
			message = MessageList.ERROR;
			log.error("Exception - execute(String gsonData,String task) : ERR"
					+ e);
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

	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}


}
