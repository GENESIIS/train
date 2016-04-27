package com.genesiis.hra.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

///***********************************************
//* 20160422 PN HRA-3 created Department.java class
//* 
//***********************************************/

@Entity
@NamedQueries(@NamedQuery(name="Department.getAll",query="SELECE e from DEPARTMENT e"))
public class Department {
	
	private String departmentNumber;
	private String departmentName;
	private String departmentLocation;
	private String departmentHead;

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
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

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public Department() {
	}

	public Department(String departmentNumber, String departmentName,
			String departmentLocation, String departmentHead) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
		this.departmentHead = departmentHead;
	}
	
	@Override
    public String toString() {
        return departmentNumber + " - " + departmentName+ " - " +departmentLocation+ " - " +departmentHead;
    }
}