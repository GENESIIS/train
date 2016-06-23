package com.genesiis.hra.command;
/*
 * 20160609 PC HRA 38 created AddStuddyProgram.java class
 * 20160610 PC HRA 39 modified and overloaded execute method
*/
import java.util.HashMap;
import org.jboss.logging.Logger;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.StudyProgram;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class AddStuddyProgram implements ICommandAJX{
static Logger log = Logger.getLogger(AddStuddyProgram.class.getName());
	// Method to execute JsonData and add employee study
	public String execute(String gsonData) {		
		Employee accessdata = new StudyProgram();		
		int id = -1;
		MessageList message = MessageList.ERROR;
		try{
			StudyProgram employee = (StudyProgram)extractFromJason(gsonData);	
		      if (validateEmployee(employee).equalsIgnoreCase("True")) {
			     id = accessdata.add(employee);
			     if(id > 0)
			    	 message = MessageList.ADDED;
		       } else {
			     
		       }
		}catch(Exception e){
			 message = MessageList.ERROR;
		}
		return message.message();
	}
	
	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Method to execute JsonData and Update employee Study
	@Override
	public String execute(String gsonData, String epf) {
		
		Employee accessdata = new StudyProgram();		
		int id = -1;
		MessageList message = MessageList.ERROR;
		try{
			StudyProgram employee = (StudyProgram)extractFromJason(gsonData);	
			 if (validateEmployee(employee).equalsIgnoreCase("True")) {
			     id = accessdata.update(employee,epf);
			    // if(id > 0)
			    	 message = MessageList.ADDED;
		       } else {
			     
		       }
		}catch(Exception e){
			 message = MessageList.ERROR;
		}
		return message.message();
	}
	
	// Method to extract Employee detail from jsonData.
	@Override
	public Object extractFromJason(String gsonData) {
		Gson gson = new Gson();
		StudyProgram employee = null;
		try {
			employee = gson.fromJson(gsonData, StudyProgram.class);	
			log.error("Inside the extract from gson method -" + employee.getEmployeeepf());
			
		} catch (Exception e) {
			log.error(e);
		}
		return employee;
	}
		//validating employee data
		public String validateEmployee(StudyProgram employee)  {
			DataValidator validator = new DataValidator();
			String message = "True";		
			if (!validator.isValidString(employee.getInstitution())) {
				message = message + MessageList.EMPTYFIELD.message() +" ";
			}
			if (!validator.isValidString(employee.getDuration())) {
				message = message + MessageList.NICERROR.message() +" ";
			}
			if (!validator.isValidString(employee.getStudyTime())) {
				message = message + MessageList.EMPTYFIELD.message() +" ";
			}
			if (!validator.isValidString(employee.getAdmissionDate())) {
				message = message + MessageList.INVALIDBIRTDAY.message() +" ";
			}
			if (!validator.isValidString(employee.getTypofCourse())) {
				message = message + MessageList.MOBILENUMBERERROR.message() +" ";
			}			
			return message;
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
