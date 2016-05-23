/**
 * 20160523 PN HRA-3 created SalaryScheme.java class
 */
package com.genesiis.hra.model;

/**
 * This class is the data access class when creating a Salary Scheme.
 */
public class SalaryScheme implements ICrud{
	int[] componentCode;
	String description, criteria, modBy;

	public int[] getComponentcode() {
		return componentCode;
	}

	public void setComponentcode(int[] componentCode) {
		this.componentCode = componentCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getModby() {
		return modBy;
	}

	public void setModby(String modBy) {
		this.modBy = modBy;
	}

	/**
	 * Salary Scheme constructor with Fields
	 */
	public SalaryScheme(int[] componentCode, String description,
			String criteria, String modBy) {
		super();
		this.componentCode = componentCode;
		this.description = description;
		this.criteria = criteria;
		this.modBy = modBy;
	}

	/**
	 * Salary Scheme empty Constructor
	 * **/
	public SalaryScheme() {
	}

}
