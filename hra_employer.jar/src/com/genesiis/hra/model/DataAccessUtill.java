package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.utill.ConnectionManager;

///***********************************************
//* 20160422 PN HRA-3 created DataAccessUtill.java class
//* 20160425 PN HRA-3 Modified add(Object object), method.
//***********************************************/

/**
 * Session Bean implementation class DepartmentDao
 */
@Stateless
public class DataAccessUtill implements IDataAccessor { 

	static Logger log = Logger.getLogger(DataAccessUtill.class.getName());

	@Override
	public String add(Object object) {
		/*EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("hra_employer");
		EntityManager entityManager = emf.createEntityManager();
		String message = "";
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			try {
				transaction.begin();
				entityManager.persist(object);
				transaction.commit();
				message = "Department " + MessageList.ADDED.message();
			} catch (Exception exception) {
				message = MessageList.ERROR.message() + " " + exception;
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
		} finally {
			entityManager.close();
		}*/
		return " ";
	}

	@Override
	public String update(Object object) {
		// TODO Auto-generated method stub
		/*EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("hra_employer");
		EntityManager entityManager = emf.createEntityManager();
		String message = "";
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			try {
				transaction.begin();				
				entityManager.persist(object);
				transaction.commit();
				message = "Employee " + MessageList.ADDED.message();
									
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
		} finally {
			entityManager.close();
		}*/
		return null;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getObjectid(String id) {
		// TODO Auto-generated method stub
		
		String query = "select * from Employee where EmployeeId = ?";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet retriveData = null;
		Employee employee = new Employee();
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "2");
			
			 retriveData = preparedStatement.executeQuery();
		
			 
				
				try{
					if (retriveData.next()) {
						employee.setEmployeeid(retriveData.getString("EmployeeId"));
						employee.setEmployeename(retriveData.getString("FirstName"));
						employee.setEmployeedesignation(retriveData.getString("Designation")); 
						employee.setEmployeesalary(Float.parseFloat(retriveData.getString("Salary")));
						employee.setEmployeeemail(retriveData.getString("Email"));
						employee.setEmployeedob(retriveData.getString("DoB"));
						employee.setEmployeenic(retriveData.getString("NIC"));
						employee.setEmployeegender(retriveData.getString("Gender"));
						employee.setEmployeedddress(retriveData.getString("Address"));
						employee.setEmployeemobileno(retriveData.getString("MobNumber"));
						employee.setDepartmentid(retriveData.getString("OtherNumber"));
						employee.setEmployeeotherno(retriveData.getString("Department"));
						employee.setDateOfJoin(retriveData.getString("DoJ")); 
						employee.setModon("modOn");
						employee.setModby("MOD");
						
						log.info(retriveData.getString("EmployeeId")+"////////////////////////////////////////////////////////");
					}
				}catch(Exception e){
					log.info(e.toString());
				}
				
			preparedStatement.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			
		}
		
		
				
		
			
		
		
		///////////////////////////////////////////////////////////
		/*EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("hra_employer");
		EntityManager entityManager = emf.createEntityManager();
		
		
		 Employee empl = entityManager.find( Employee.class, "1");*/
////////////////////////////////////////////////////////////////
		return employee;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
