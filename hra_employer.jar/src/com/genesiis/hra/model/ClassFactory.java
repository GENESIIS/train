package com.genesiis.hra.model;


///***********************************************
//* 20160422 PN created ClassFactory.java class
//* 
//***********************************************/


public class ClassFactory {
	public static IFactory getClassfactory(String classType) {
		if (classType.equalsIgnoreCase("DepartmentDao"))
			return new DepartmentDao();
		return null;
	}

}