package com.genesiis.hra.model;

/**
 * 20160509 PN created Familymember.java Entity class.
 * 
 * 
 * **/
public class Familymember extends Employee{
	private String fmName;
	private String fmDateOfbirth;
	private String fmRelationship;
	private String fmOccupation;
	private String fmWorkingPlace;

	public String getFmname() {
		return fmName;
	}

	public void setFmname(String fmName) {
		this.fmName = fmName;
	}

	public String getFmdateofbirth() {
		return fmDateOfbirth;
	}

	public void setFmdateofbirth(String fmDateOfbirth) {
		this.fmDateOfbirth = fmDateOfbirth;
	}

	public String getFmrelationship() {
		return fmRelationship;
	}

	public void setFmrelationship(String fmRelationship) {
		this.fmRelationship = fmRelationship;
	}

	public String getFmoccupation() {
		return fmOccupation;
	}

	public void setFmoccupation(String fmOccupation) {
		this.fmOccupation = fmOccupation;
	}

	public String getFmWorkingplace() {
		return fmWorkingPlace;
	}

	public void setFmWorkingplace(String fmWorkingPlace) {
		this.fmWorkingPlace = fmWorkingPlace;
	}

	public Familymember() {
	}

	public Familymember(String fmName, String fmDateOfbirth,
			String fmRelationship, String fmOccupation, String fmWorkingPlace) {
		super();
		this.fmName = fmName;
		this.fmDateOfbirth = fmDateOfbirth;
		this.fmRelationship = fmRelationship;
		this.fmOccupation = fmOccupation;
		this.fmWorkingPlace = fmWorkingPlace;
	}
	
	@Override
	public String add(Object object) {
		return "You are in FamilyMember";
	}
}
