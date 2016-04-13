package com.genesiis.hra.model;

import java.text.ParseException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;

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
    
    DataValidator validator = new DataValidator();
    
	@Override
	public String addEmployee(Employee employee) {
		//Incompleate method.
		String message = "";
		try {
			if(validator.isPastDate(employee.getEmployeeDob())||validator.isValidNic(employee.getEmployeeNic())){
				entityManager.persist(employee);
				message = "Employee Details added Successfully";
			}else{
				message = "Invalied Details. Please Check.";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return message;
	}
//    ProfessorService service = new ProfessorService(em);
//	private EntityManager entityManager;


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
