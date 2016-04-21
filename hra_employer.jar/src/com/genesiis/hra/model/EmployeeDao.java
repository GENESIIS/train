package com.genesiis.hra.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;

/***********************************************
 * 20160411 PN HRA-1 created EmployeeDao.java class
 * 20160412 PN HRA-1 created addEmployee() method
 * 20160415 PN HRA-1 edited addEmployee() method
 * 
 ***********************************************/

/**
 * Session Bean implementation class EmployeeDao
 */
@Stateless
public class EmployeeDao implements IEmployeeDaoLocal {
	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("hra_employer");
	EntityManager entityManager = emf.createEntityManager();

	// This message is to return only when the scenario is successful.
	final String successfullMessage = "Employee Details added Successfully.";

	@Override
	public String addEmployee(Employee employee) {
		String message = validateEmployeedetails(employee);
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			try {
				transaction.begin();
				if (message.equalsIgnoreCase(successfullMessage)) {
					entityManager.persist(employee);
					transaction.commit();
					return successfullMessage;
				} else {
					return message;
				}
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		// entityManager.merge(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// entityManager.remove(employee);
	}

	@Override
	public Employee getEmployee(String employeeId) {
		return null; // entityManager.find(Employee.class, employeeId);
	}

	@Override
	public List<Employee> getAllemployees() {
		return null; // entityManager.createNamedQuery("Employee.getAll").getResultList();
	}

	private String validateEmployeedetails(Employee employee) {
		String message = "DDDDDD";
		DataValidator validator = new DataValidator();
		try {
			boolean employeeNamestatus = validator.isValidString(employee
					.getEmployeename());
			boolean employeeDobstatus = validator.isPastDate(employee
					.getEmployeedob());
			boolean employeeNicstatus = validator.isValidNic(employee
					.getEmployeenic());
			boolean dateOfjoinstatus = validator.isPastDate(employee
					.getDateofjoin());

			if (employeeNamestatus && employeeDobstatus && employeeNicstatus
					&& dateOfjoinstatus) {
				message = successfullMessage;
			} else {
				if (!employeeNamestatus) {
					message.concat("Employee name cannot be Empty.");
				}
				if (!employeeDobstatus) {
					message.concat("Employee name cannot be Empty. Please Check. ");
				}
				if (!employeeNicstatus) {
					message.concat("Invalied birth Date. Please Check. ");
				}
				if (!dateOfjoinstatus) {
					message.concat("Invalied join Date. Please Check.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

}
