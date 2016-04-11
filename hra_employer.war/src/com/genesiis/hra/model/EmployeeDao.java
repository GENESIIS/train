package com.genesiis.hra.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.genesiis.hra.model.Employee;

/***********************************************
 * 20160411 PN HRA-1 created EmployeeDao.java class
 * 
 * 
 ***********************************************/


/**
 * Session Bean implementation class EmployeeDao
 */
@Stateless
public class EmployeeDao implements IEmployeeDaoLocal {
	
//	@PersistenceContext(unitName = "employee-unit", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	public void addEmployee(Employee employee) {
	//	entityManager.persist(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
	//	entityManager.merge(employee);		
	}

	@Override
	public void deleteEmployee(Employee employee) {
	//	entityManager.remove(employee);
	}

	@Override
	public Employee getEmployee(String employeeId) {
		return null; //entityManager.find(Employee.class, employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return null; //entityManager.createNamedQuery("Employee.getAll").getResultList();
	}

}
