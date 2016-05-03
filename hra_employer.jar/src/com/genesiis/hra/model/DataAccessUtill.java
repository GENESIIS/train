package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;


///***********************************************
//* 20160422 PN HRA-3 created DataAccessUtill.java class
//* 20160425 PN HRA-3 Modified add(Object object), method.
//***********************************************/

/**
 * Session Bean implementation class DepartmentDao
 */
@Stateless
public class DataAccessUtill implements IDataAccessor { 

	/*EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("hra_employer");
	EntityManager entityManager = emf.createEntityManager();*/

	@Override
	public String add(Object object) {
		String message = "";
		
		return message;
	}

	@Override
	public String update(Employee object) {
		// TODO Auto-generated method stub
		
		
		String query = "UPDATE [hra-2].[dbo].[HRA.EMPLOYEE] SET NAME = ? WHERE ID = ?";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		//Employee empl = (Employee) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, object.getEmployeename());
			preparedStatement.setString(2, "1");
			

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}			
		}
		return message;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getObjectid(String id) {
		// TODO Auto-generated method stub
		
		/*EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("hra_employer");
		EntityManager entityManager = emf.createEntityManager();
		
		
		 Employee empl = entityManager.find( Employee.class, "1");*/

		return null;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
