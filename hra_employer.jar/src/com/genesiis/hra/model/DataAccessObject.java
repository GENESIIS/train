package com.genesiis.hra.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.genesiis.hra.validation.MessageList;


///***********************************************
//* 20160422 PN HRA-3 created Department.java class
//* 
//***********************************************/

/**
 * Session Bean implementation class DepartmentDao
 */
@Stateless
public class DataAccessObject implements IDataAccessor {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("hra_employer");
	EntityManager entityManager = emf.createEntityManager();

	@Override
	public String add(Object object) {
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
		}
		return message;
	}

	@Override
	public String update(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObjectid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}