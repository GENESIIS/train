package com.genesiis.hra.command;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import com.genesiis.hra.model.ClassFactory;
import com.genesiis.hra.model.Department;
import com.genesiis.hra.model.IFactory;
import com.google.gson.Gson;

///***********************************************
//* 20160422 PN HRA-3 created AddDepartment.java class
//* 
//***********************************************/

public class AddDepartment {
	private static final String DEPARTMENT_CLASS = "Department";
	private static final String DEPARTMENTDAO_CLASS = "DepartmentDao";

	//private Department department = null;

	static Logger log = Logger.getLogger(AddDepartment.class.getName());

	public void execute(String gsonData) {
		log.info("gsonData " + gsonData);
		ClassFactory classFactory = new ClassFactory();
		IFactory iFactory = classFactory.getClassfactory(DEPARTMENTDAO_CLASS);
		String message = "";

		try {
			Department department = (Department) extractFromgson(gsonData, DEPARTMENT_CLASS,DEPARTMENTDAO_CLASS);
			log.info("department.getDepartmentName() " + department.getDepartmentName());
		} catch (Exception e) {
			log.info("Exception-department.getDepartmentName(): " + e);
		}

		
		

//		if (validDepartment(department).equalsIgnoreCase("Successfull")) {
//			log.info("validDepartment(department) "
//					+ validDepartment(department));
//			// message = iFactory.add(department);
//		} else {
//			message = validDepartment(department);
//		}
	}

	public Department extractFromgson(String gsonData, String entityClass,	String daoClass) {
		Gson gson = new Gson();
		String message = "";
		Object entityClassobject = null;
		Object dataAccessclassobject = null;

		try {
			BufferedReader brReader = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(
							gsonData.getBytes(StandardCharsets.UTF_8))));

			Class entity = Class.forName(entityClass);
			entityClassobject = entity.newInstance();

			Class dataAccess = Class.forName(daoClass);
			dataAccessclassobject = dataAccess.newInstance();
			

			entityClassobject = gson.fromJson(brReader, Department.class);
		} catch (Exception e) {
			log.info("extractFromgson " + e);
		}
		return (Department) entityClassobject;
	}

	public String validDepartment(Department department) {
//		DataValidator validator = new DataValidator();
//		if (validator.isValidString(department.getDepartmentName())) {
//			return DataValidator.ValidationErrors.SUCCESS.message();
//		} else {
//			return DataValidator.ValidationErrors.EMPTYFIELD.message();
//		}
		return null;
	}

}
