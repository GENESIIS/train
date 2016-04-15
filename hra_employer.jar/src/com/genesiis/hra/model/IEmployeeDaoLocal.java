package com.genesiis.hra.model;

import java.util.List;

import javax.ejb.Local;

import com.genesiis.hra.model.Employee;

/***********************************************
 * 20160407 PN HRA-1 created Employee.java class
 * 20160411 PN HRA-1 changes Employee.java class. Added employeeNic attribute.
 * 
 ***********************************************/



@Local
public interface IEmployeeDaoLocal {
	public String addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public Employee getEmployee(String employeeId);
	
	public List<Employee> getAllemployees();
}
