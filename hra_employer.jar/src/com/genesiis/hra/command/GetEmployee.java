package com.genesiis.hra.command;

import com.genesiis.hra.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GetEmployee {

	public String createGson() {
		
		Employee employee = new Employee();
		employee.setEmployeeid("1");
		employee.setEmployeename("Genesiis");
		employee.setEmployeedesignation("Eng"); 
		employee.setEmployeesalary(1000);
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
		employee.setModby("modby");
		
		Gson gson = new Gson();  
		 
		String employeD = null;
		
		try {
			 employeD = gson.toJson(employee);
			
		} catch (Exception e) {
			
		}
		return employeD;
	}
	
}
