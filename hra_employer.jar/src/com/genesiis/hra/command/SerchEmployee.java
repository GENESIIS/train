package com.genesiis.hra.command;

import java.text.ParseException;
import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeCrudJDBC;
import com.genesiis.hra.model.SerchEmployeeCrudJDBC;
/* *********************************************
 * 20160520 HRA 30 pc create SercEmPloyee class 
 * 20160520 HRA 30 pc create execute method
*/
public class SerchEmployee implements ICommand {
static Logger loger = Logger.getLogger(SerchEmployee.class.getName());
	@Override
	public String execute(String emplIdenti) throws ParseException {
		// TODO Auto-generated method stub
		 String message = "";
		 EmployeeCrudJDBC employeeManager = new EmployeeCrudJDBC();
		 EmployeeCrudJDBC serchEmployeeManager = new SerchEmployeeCrudJDBC();
		 Employee  empList = null ;
		 try {
			 switch (validateFind(emplIdenti)) {
			case 1:
				  empList = (Employee) employeeManager.find(emplIdenti);
				break;
			case 2:
				  empList = (Employee) serchEmployeeManager.find(emplIdenti);
				break;
			case 3:
				  empList = (Employee) serchEmployeeManager.find(emplIdenti);
				break;

			default:
				break;
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateValue(Object entiytObject) throws ParseException {
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

	
}
