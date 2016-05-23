/**
 * 20160523 PN HRA-3 created SalaryDetails.java class
 */
package com.genesiis.hra.model;

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

}
