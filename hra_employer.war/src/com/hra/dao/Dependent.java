package com.hra.dao;

/***********************************************
 * 20160407 PN HRA-1 created Dependent.java class
 * 
 *
 ***********************************************/

public class Dependent implements java.io.Serializable {
	private int dependentTblID;
	private String dependentID;
	private String dependentName;
	private String dependentDOB;
	private String employeeID;
	private String addedBy;
	private String updatedBy;
	private String addedOn;
	private String updatedOn;
	private String envCode;

	public Dependent() {
	}

	public Dependent(String dependentID, String dependentName,
			String dependentDOB, String employeeID, String addedBy,
			String updatedBy, String addedOn, String updatedOn, String envCode) {
		super();
		this.dependentID = dependentID;
		this.dependentName = dependentName;
		this.dependentDOB = dependentDOB;
		this.employeeID = employeeID;
		this.addedBy = addedBy;
		this.updatedBy = updatedBy;
		this.addedOn = addedOn;
		this.updatedOn = updatedOn;
		this.envCode = envCode;
	}

	public int getDependentTblID() {
		return dependentTblID;
	}

	public void setDependentTblID(int dependentTblID) {
		this.dependentTblID = dependentTblID;
	}

	public String getDependentID() {
		return dependentID;
	}

	public void setDependentID(String dependentID) {
		this.dependentID = dependentID;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getDependentDOB() {
		return dependentDOB;
	}

	public void setDependentDOB(String dependentDOB) {
		this.dependentDOB = dependentDOB;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getEnvCode() {
		return envCode;
	}

	public void setEnvCode(String envCode) {
		this.envCode = envCode;
	}

}
