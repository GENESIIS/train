package com.genesiis.hra.command;
import java.util.logging.Logger;


import com.genesiis.hra.model.EditEmployeeCrudJDBC;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;
import java.text.ParseException;

public class EditEmployee {

	static Logger log = Logger.getLogger(EditEmployee.class.getName());
	
	// Method to execute JsonData 
	public void execute(String gsonData) {		
		EditEmployeeCrudJDBC accessdata = new EditEmployeeCrudJDBC();		
		String message = "";			
		try{
			Employee employee = extractFromgson(gsonData);		
		      if (validEmployee(employee)) {
			     message = accessdata.update(employee);
		       } else {
			     message = MessageList.ERROR.message();
		       }
		}catch(Exception e){
			
		}		
	}
	
	// Method to extract DepartmentDetails from jsonData.
		public Employee extractFromgson(String gsonData) {
			Gson gson = new Gson();
			String message = "";
			Employee employee = null;
			try {
				employee = gson.fromJson(gsonData, Employee.class);				
			} catch (Exception e) {
				 message = MessageList.ERROR.message();;
			}
			return employee;
		}
		
				
		public boolean validEmployee(Employee empl) {
			DataValidator validator = new DataValidator();
			if (validator.isValidString(empl.getEmployeename())) {
				return true;
			} else {
				return false;
			}
		}
		
		public String validateEmployee(Employee employee) throws ParseException {
			DataValidator validator = new DataValidator();
			String message = "";

			if (!validator.isValidString(employee.getEmployeeid())) {
				message = message + MessageList.EMPTYFIELD.message() +" ";
			}
			if (!validator.isValidString(employee.getEmployeename())) {
				message = message + MessageList.EMPTYFIELD.message() +" ";
			}
			if (!validator.isValidNic(employee.getEmployeenic())) {
				message = message + MessageList.NICERROR.message() +" ";
			}
			if (!validator.isValidString(employee.getEmployeeepf())) {
				message = message + MessageList.EMPTYFIELD.message() +" ";
			}
			if (!validator.isPastDate(employee.getEmployeedateofbirth())) {
				message = message + MessageList.INVALIDBIRTDAY.message() +" ";
			}
			if (!validator.isValidTelephone(employee.getEmployeemobile())) {
				message = message + MessageList.MOBILENUMBERERROR.message() +" ";
			}
			if (!validator.isValidTelephone(employee.getEmployeetelephone())) {
				message = message + MessageList.PHONENUMBERERROR.message() +" ";
			}
			if (!validator.isValidemail(employee.getEmployeeemail())) {
				message = message + MessageList.EMAILERROR.message() +" ";
			}
			return message;
		}
}

