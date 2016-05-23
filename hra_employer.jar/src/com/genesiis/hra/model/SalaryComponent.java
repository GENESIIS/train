/**
 * 20160523 PN HRA-3 created SalaryComponent.java class
 */
package com.genesiis.hra.model;

/**
 * This class is the data access class when creating a Salary Component.
 */
public class SalaryComponent implements ICrud{
	String componentType, componentName, description, modBy;
	double minAmount, maxAmount, rate;

	public String getComponentType() {
		return componentType;
	}

	public void setComponenttype(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentname() {
		return componentName;
	}

	public void setComponentname(String componentName) {
		this.componentName = componentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinamount() {
		return minAmount;
	}

	public void setMinamount(double minAmount) {
		this.minAmount = minAmount;
	}

	public double getMaxamount() {
		return maxAmount;
	}

	public void setMaxamount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	/**
	 * Salary Component empty constructor
	 * **/
	public SalaryComponent() {
	}

	/**
	 * Salary Component constructor with fields
	 */
	public SalaryComponent(String ct, String cn, String des, String mb,
			double min, double max, double r) {
		this.componentType = ct;
		this.componentName = cn;
		this.description = des;
		this.modBy = mb;
		this.minAmount = min;
		this.maxAmount = max;
		this.rate = r;
	}
}
