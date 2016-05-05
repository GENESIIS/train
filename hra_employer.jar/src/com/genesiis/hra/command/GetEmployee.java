package com.genesiis.hra.command;

import com.genesiis.hra.model.DataManager;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.google.gson.Gson;

import java.util.logging.Logger;

public class GetEmployee {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	
	public String createGson() {
		
		DataManager dataAcse  = new DataManager();		
		Employee employee = dataAcse.retrive("1");		
		
		/*employee.setEmployeeid("1");
		employee.setEmployeename("Genesiis");
		employee.setEmployeedesignation("Eng"); 
		employee.setEmployeeemail("we@mail");
		employee.setEmployeedob("2000.01.01");
		employee.setEmployeenic("903293950v");
		employee.setEmployeegender("mail");
		employee.setEmployeedddress("Colombo 3");
		employee.setEmployeemobileno("071111111");
		employee.setDepartmentid("111");
		employee.setEmployeeotherno("e5");
		employee.setDateOfJoin("2016.04.25"); 
		employee.setModon("mod");
		employee.setModby("modby");*/		
		
		//log.info();
		Gson gson = new Gson();  		 
		String employeD = null;
		
		try {
			 employeD = gson.toJson(employee);
			
		} catch (Exception e) {
			
		}
		return employeD;
	}
	
	
	
}
