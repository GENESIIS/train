package com.genesiis.hra.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class EmployeeDim {
	// This class named only till the merge get done.
	@Id
	@Column
	private String id;
	@Column
	private String name;
	@Column
	private String designation;
	@Column
	private String email;
	@Column
	private String dateOfbirth;
	@Column
	private String nic;
	@Column
	private String gender;
	@Column
	private String permanentAddress;
	@Column
	private String temporaryAdddress;
	@Column
	private String mobileNo;
	@Column
	private String otherNo;
	@Column
	private String deptId;
	@Column
	private String dateOfjoin;
	@Column
	private String modOn;
	@Column
	private String modBy;
	@Column
	private String epf;
	@Column
	private String maritalStatus;
	@Column
	private String basis;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateofbirth() {
		return dateOfbirth;
	}

	public void setDateofbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPermanentaddress() {
		return permanentAddress;
	}

	public void setPermanentaddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getTemporaryadddress() {
		return temporaryAdddress;
	}

	public void setTemporaryadddress(String temporaryAdddress) {
		this.temporaryAdddress = temporaryAdddress;
	}

	public String getMobileno() {
		return mobileNo;
	}

	public void setMobileno(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOtherno() {
		return otherNo;
	}

	public void setOtherno(String otherNo) {
		this.otherNo = otherNo;
	}

	public String getDeptid() {
		return deptId;
	}

	public void setDeptid(String deptI) {
		this.deptId = deptI;
	}

	public String getDateofjoin() {
		return dateOfjoin;
	}

	public void setDateofjoin(String dateOfjoin) {
		this.dateOfjoin = dateOfjoin;
	}

	public String getModOn() {
		return modOn;
	}

	public void setModOn(String modOn) {
		this.modOn = modOn;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public String getEpf() {
		return epf;
	}

	public void setEpf(String epf) {
		this.epf = epf;
	}

	public String getMaritalstatus() {
		return maritalStatus;
	}

	public void setMaritalstatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

}
