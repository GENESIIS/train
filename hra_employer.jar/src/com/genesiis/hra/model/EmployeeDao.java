package com.genesiis.hra.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hra_employer");
    EntityManager entityManager = emf.createEntityManager();
    
//    ProfessorService service = new ProfessorService(em);
//	private EntityManager entityManager;

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
