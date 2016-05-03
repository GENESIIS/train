package com.genesiis.hra.command;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.genesiis.hra.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.logging.Logger;
import com.genesiis.hra.model.DataAccessUtill;


public class GetEmployee {

	static Logger log = Logger.getLogger(GetEmployee.class.getName());
	
	public String createGson() {
		
		DataAccessUtill dataAcse  = new DataAccessUtill();
		
		Employee employee = da.getObjectid("saf");
		//Employee employee = new Employee();
		try{
		
		}catch(Exception e){
			
		}
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
		
		
		Gson gson = new Gson();  
		 
		String employeD = null;
		
		try {
			 employeD = gson.toJson(employee);
			
		} catch (Exception e) {
			
		}
		return employeD;
	}
	
}
