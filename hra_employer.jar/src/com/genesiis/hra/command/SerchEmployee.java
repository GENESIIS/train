package com.genesiis.hra.command;

import java.util.HashMap; 
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.EmployeePersistJDBC;
import com.genesiis.hra.model.SerchPersistJDBC;
import com.genesiis.hra.model.SerchEmployeePersistJDBC;
import com.google.gson.Gson;
/* *********************************************
 * 20160520 HRA 30 pc create SercEmPloyee class 
 * 20160520 HRA 30 pc create execute method
*/
public class SerchEmployee extends Serch {
static Logger loger = Logger.getLogger(SerchEmployee.class.getName());

    @Override
    public String execute(String gsonData, String epf) {
	     // TODO Auto-generated method stub
	     return null;
    }
	@Override
	public String execute(String keyWord) {
		 SerchPersistJDBC employeeManager = new EmployeePersistJDBC();
		 //this for if want to do OveWritte find method use this
		 SerchPersistJDBC serchEmployeeManager = new SerchEmployeePersistJDBC();
		 List<Object>  empList = null ;
		 try {			
				  empList =  employeeManager.find(keyWord); 
				  loger.info("This execute method"+empList);								
					
		} catch (Exception e) {
			// TODO: handle exception
			loger.info(e.toString());
		}
		return createGson(empList);
	}

	@Override
	public Object extractFromJason(String data) {
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
	public int validateFind(String emplIdenti) {
		// TODO Auto-generated method stub
		return (Integer) null;
	}
	
	// Create geson object
	public String createGson(List<Object> emp) {					
			Gson gson = new Gson();	
			String empList = " ";
			try {
				empList = gson.toJson(emp);			
			} catch (Exception e) {
				loger.info("This CretaeGson method"+empList);
			}
			return empList;
	}

	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
