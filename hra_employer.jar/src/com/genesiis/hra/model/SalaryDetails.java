/**
 * 20160523 PN HRA-3 created SalaryDetails.java class
 */
package com.genesiis.hra.model;

import java.sql.SQLException;
import java.util.List;

/**
 * This class is the data access class when creating a Salary Details.
 */
public class SalaryDetails implements ICrud {
	int salarySchemecode;
	int[] employeeCode;
	String modyBy;

	public int getSalarySchemecode() {
		return salarySchemecode;
	}

	public void setSalarySchemecode(int salarySchemecode) {
		this.salarySchemecode = salarySchemecode;
	}

	public int[] getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int[] employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getModyBy() {
		return modyBy;
	}

	public void setModyBy(String modyBy) {
		this.modyBy = modyBy;
	}

	/**
	 * Salary Details constructor with Fields
	 */
	public SalaryDetails(int salarySchemecode, int[] employeeCode, String modyBy) {
		super();
		this.salarySchemecode = salarySchemecode;
		this.employeeCode = employeeCode;
		this.modyBy = modyBy;
	}

	/**
	 * Salary Details empty Constructor
	 * **/
	public SalaryDetails() {

	}

	public int add(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}



	public String getId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValid(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Object object, String epf) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findByEpf(String empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

}
