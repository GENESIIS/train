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
public class AddFamilyDetails implements ICommand{
	static Logger log = Logger.getLogger(AddFamilyDetails.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();

	/* (non-Javadoc)
	 * @see com.genesiis.hra.command.ICommandAJX#execute(java.lang.String)
	 */
	public String execute(String gsonData) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		HashMap<Integer, Object> errorList = new HashMap<Integer, Object>();

		try {
			Familymember familymember = getFamilymemberdetails(gsonData);
			validateComponent(errorList);
			id = familymember.add(familymember);
			message = MessageList.ADDED;
		} catch (Exception mne) { // User Defined exception. This comes from the
									// validation of the Component ->
									// validateComponent()
			message = MessageList.ERROR;
			log.error("--> execute(): ERR" + mne);
		}
		return message.message();
	}
	
	/**
	 * @param errorList
	 */
	private void validateComponent(HashMap<Integer, Object> errorList) {
		// TODO Auto-generated method stub
		
	}

	private Familymember getFamilymemberdetails(String data) {
		Familymember familymember = (Familymember) extractFromJason(data);
		return familymember;
	}

	/* (non-Javadoc)
	 * @see com.genesiis.hra.command.ICommandAJX#extractFromJason(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see com.genesiis.hra.command.ICommandAJX#validateValue(java.lang.Object)
	 */
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.genesiis.hra.command.ICommandAJX#validateValue(java.util.HashMap)
	 */
	public boolean validateValue(HashMap<Integer, Object> entiytMap)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String execute(String gsonData, Operation operation) {
		// TODO Auto-generated method stub
		return null;
	}

}
