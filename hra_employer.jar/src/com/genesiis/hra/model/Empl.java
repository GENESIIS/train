package com.genesiis.hra.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;


//com.genesiis.hra.model.Employee

///***********************************************
// * 20160407 PN HRA-1 created Employee.java class
// * 20160411 PN HRA-1 changes Employee.java class. Added employeeNic attribute.
// * 
// ***********************************************/
@Entity
public class Empl {
	@Id
	@Column 
	private String ID;
	@Column
	private String NAME;
	@Column
	private String DESIGNATION;
	@Column
	private String EMAIL;
	@Column
	private String DOB;
	@Column
	private String NIC;
	@Column
	private String GENDER;
	@Column
	private String PERMENENTADDRESS;
	@Column
	private String TEMPORARYADDRESS;
	@Column
	private String MOBILENO;
	@Column
	private String OTHERNO;
	@Column
	private String DEPTID;
	@Column
	private String DATEOFJOIN;
	@Column
	private String MODON;
	@Column
	private String MODBY;	
	@Column
	private String EPF;	
	@Column
	private String MARITALSTATUS;
	@Column
	private String BASIS;

	public String getEmployeeid() {
		return ID;
	}

	public void setEmployeeid(String employeeId) {
		this.ID = employeeId;
	}

	public String getEmployeename() {
		return NAME;
	}

	public void setEmployeename(String employeeName) {
		this.NAME = employeeName;
	}

	public String getEmployeedesignation() {
		return DESIGNATION;
	}

	public void setEmployeedesignation(String employeeDesignation) {
		this.DESIGNATION = employeeDesignation;
	}

	public String getEmployeeemail() {
		return EMAIL;
	}

	public void setEmployeeemail(String employeeEmail) {
		this.EMAIL = employeeEmail;
	}

	public String getEmployeedob() {
		return DOB;
	}

	public void setEmployeedob(String employeeDob) {
		this.DOB = employeeDob;
	}

	public String getEmployeenic() {
		return NIC;
	}

	public void setEmployeenic(String employeeNic) {
		this.NIC = employeeNic;
	}

	public String getEmployeegender() {
		return GENDER;
	}

	public void setEmployeegender(String employeeGender) {
		this.GENDER = employeeGender;
	}

	public String getEmployeeTempdddress() {
		return PERMENENTADDRESS;
	}

	public void setEmployeeTempdddress(String employeeTempAddress) {
		this.TEMPORARYADDRESS = employeeTempAddress;
	}
	
	public String getEmployeedddress() {
		return PERMENENTADDRESS;
	}

	public void setEmployeedddress(String employeeAddress) {
		this.PERMENENTADDRESS = employeeAddress;
	}

	public String getEmployeemobileno() {
		return MOBILENO;
	}

	public void setEmployeemobileno(String employeeMobileno) {
		this.MOBILENO = employeeMobileno;
	}

	public String getEmployeeotherno() {
		return OTHERNO;
	}

	public void setEmployeeotherno(String employeeOtherno) {
		this.OTHERNO = employeeOtherno;
	}

	public String getDepartmentid() {
		return DEPTID;
	}

	public void setDepartmentid(String departmentId) {
		this.DEPTID = departmentId;
	}

	public String getDateofjoin() {
		return DATEOFJOIN;
	}

	public void setDateOfJoin(String DoJ) {
		this.DATEOFJOIN = DoJ;
	}

	public String getModon() {
		return MODON;
	}

	public void setModon(String modOn) {
		this.MODON = modOn;
	}

	public String getModby() {
		return MODBY;
	}

	public void setModby(String modBy) {
		this.MODBY = modBy;
	}

	public String getMARITALSTATUS() {

		return MARITALSTATUS;
	}

	public void setMARITALSTATUS(String MARITALSTATUS) {
		this.MARITALSTATUS = MARITALSTATUS;
	}

	public String getEPF() {
		return EPF;
	}

	public void setEPF(String EPF) {
		this.EPF = EPF;
	}

	public String getBASIS() {
	
		return BASIS;
	}
	public void setBASIS(String BASIS) {
		this.BASIS = BASIS;
	}

	public Empl() {
	}
	
	

	public Empl(String employeeId, String employeeName,
			String employeeDesignation, String employeeEmail, String employeeDob, String employeeNic,
			String employeeGender, String employeeAddress,
			String employeeMobileno, String employeeOtherno,
			String departmentId, String dateOfjoin, String modOn, String modBy,String mrstus, String epf, String basis, String employeeTempAddress ) {
		super();
		this.ID = employeeId;
		this.NAME = employeeName;
		this.DESIGNATION = employeeDesignation;		
		this.EMAIL = employeeEmail;
		this.DOB = employeeDob;
		this.NIC = employeeNic;
		this.GENDER = employeeGender;
		this.PERMENENTADDRESS = employeeAddress;
		this.TEMPORARYADDRESS = employeeTempAddress;
		this.MOBILENO = employeeMobileno;
		this.OTHERNO = employeeOtherno;
		this.DEPTID = departmentId;
		this.DATEOFJOIN = dateOfjoin;
		this.MODON = modOn;
		this.MODBY = modBy;
		this.EPF = epf;
		this.MARITALSTATUS = mrstus;
		this.BASIS = basis;
	}

}


