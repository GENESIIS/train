package com.hra.dao;

/***********************************************
 * 20160407 PN HRA-1 created Department.java class
 * 
 *
 ***********************************************/

public class Department implements java.io.Serializable {
	private String departmentID;
	private String departmentName;
	private String departmentLocation;
	private String managerID;
	private String updatedBy;
	private String updatedOn;
	
	
	public Department() {
	}


	public Department(String departmentID, String departmentName,
			String departmentLocation, String managerID, String updatedBy,
			String updatedOn) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
		this.managerID = managerID;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}


	public String getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentLocation() {
		return departmentLocation;
	}


	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}


	public String getManagerID() {
		return managerID;
	}


	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	
}
