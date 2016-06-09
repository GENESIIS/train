package com.genesiis.hra.command;


import com.genesiis.hra.model.Employee;import com.genesiis.hra.model.EmployeeFactory;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;


import com.genesiis.hra.model.Familymember;
import com.genesiis.hra.validation.Operation;

public class GetEmployee implements ICommandAJX {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());

	// insert fiels validation
	MessageList message = MessageList.ERROR;
	boolean hasError = false;
	String jsonArray = null;

	public String execute(String gsonData, Operation operation) {

		switch (operation) {

		case GET_FAMILY_MEMBER:
			jsonArray = executeFamilyDetails(gsonData);
			break;

		default:
			break;
		}

		return jsonArray;
	}

	public String executeFamilyDetails(String gsonData) {

		Gson gson = new Gson();
		
		// extracting gson data to object
		Familymember familyMember = 
				gson.fromJson(gsonData, Familymember.class);
		
		String familyMemberResult = 
				familyMember.getEmployee(Integer.parseInt(familyMember.getEmployeeepf()));

		if (familyMemberResult != null) {
			message = MessageList.IDFOUND;
		} else {
			// adding medical history to database table fail
			message = MessageList.IDNOTFOUND;
		}

		System.out.println("executeFamilyDetails"+familyMemberResult);
		return familyMemberResult;
	}


	

	// Create geson object
		public String createGson(Object employee) throws Exception {			
			Gson gson = new Gson();  		 
			String employeeGoson = null;						
		    try {		
		    	log.info("Create Gson");
		    	employeeGoson = gson.toJson(employee);			
			    } catch (Exception e) {
			    	log.info("Error on createGson" +e);
			}		  
			return employeeGoson;
		}

		public String execute(String inputValue, String task) {
			EmployeeFactory empOblect = new EmployeeFactory();	
			String message = MessageList.ERROR.message();	
			Employee employee = null;
			try{			
				employee = (Employee) empOblect.getEmployeeObject(task).findByEpf(inputValue);
				log.info(task);
				message = createGson(employee);	
				log.info(message);
			}catch(SQLException e){
				 message = MessageList.ERROR.message();
			}catch(Exception e){
				 message = MessageList.ERROR.message();
			}
			return message;
		}
		
		public String execute(String gsonData) {
			// TODO Auto-generated method stub
			return null;
		}

		public Object extractFromJason(String data) {
			// TODO Auto-generated method stub
			return null;
		}

		public String validateValue(Object entiytObject) {
			// TODO Auto-generated method stub
			return null;
		}

		public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
			// TODO Auto-generated method stub
			return null;
		}

		public String execute(int epf) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
