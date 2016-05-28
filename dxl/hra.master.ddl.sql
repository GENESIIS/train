/*
*20160424 PN hra.master.ddl.sql V02 created.
*20160504 PN Tables modified with DEFAULT CONSTRAINT.
*
*HRA.DEPARTMENT - MANAGERID DEFAULT ('-') changed to MANAGERID DEFAULT 0 2016-05-05 TR
*/

CREATE TABLE [HRA.EMPLOYEE] (
ID INT NOT NULL IDENTITY (1,1),
NAME varchar(300) NOT NULL CONSTRAINT DF_NAME_EMPLOYEE DEFAULT ('-') ,
DESIGNATION varchar(50) NOT NULL CONSTRAINT DF_DESIGNATION_EMPLOYEE DEFAULT ('-') ,
EMAIL varchar(50) NOT NULL CONSTRAINT DF_EMAIL_EMPLOYEE DEFAULT ('-') ,
DOB date NOT NULL CONSTRAINT DF_DOB_EMPLOYEE DEFAULT (getdate()) ,
NIC varchar(15) NOT NULL CONSTRAINT DF_NIC_EMPLOYEE DEFAULT ('-') ,
GENDER varchar(1) NOT NULL CONSTRAINT DF_GENDER_EMPLOYEE DEFAULT ('-') ,
PERMENENTADDRESS varchar(300) NOT NULL CONSTRAINT DF_PERMENENTADDRESS_EMPLOYEE DEFAULT ('-') ,
TEMPORARYADDRESS varchar(300) NOT NULL CONSTRAINT DF_TEMPORARYADDRESS_EMPLOYEE DEFAULT ('-') ,
MOBILENO varchar(10) NOT NULL CONSTRAINT DF_MOBILENO_EMPLOYEE DEFAULT ('-') ,
OTHERNO varchar(10) NOT NULL CONSTRAINT DF_OTHERNO_EMPLOYEE DEFAULT ('-') ,
DEPTID INT NOT NULL CONSTRAINT DF_DEPTID_EMPLOYEE DEFAULT 0 ,
MARITALSTATUS varchar(10) NOT NULL CONSTRAINT DF_MARITALSTATUS_EMPLOYEE DEFAULT ('-') ,
DATEOFJOIN date NOT NULL CONSTRAINT DF_DATEOFJOIN_EMPLOYEE DEFAULT (getdate()) ,
MODBY varchar(10) NOT NULL CONSTRAINT DF_MODBY_EMPLOYEE DEFAULT ('-') ,
MODON date NOT NULL CONSTRAINT DF_MODON_EMPLOYEE DEFAULT (getdate()) ,
EPF varchar(10) NOT NULL CONSTRAINT DF_EPF_EMPLOYEE DEFAULT ('-') ,
BASIS varchar(10) NOT NULL CONSTRAINT DF_BASIS_EMPLOYEE DEFAULT ('-'),
CONSTRAINT PK_EMPLOYEE PRIMARY KEY (ID)
)


-- ----------------------------
-- Table structure for DEPARTMENT
-- ----------------------------
CREATE TABLE [HRA.DEPARTMENT] (
ID INT NOT NULL IDENTITY (1,1),
NAME varchar(20) NOT NULL CONSTRAINT DF_NAME_DEPARTMENT DEFAULT ('-') ,
LOCATION varchar(20) NOT NULL CONSTRAINT DF_LOCATION_DEPARTMENT DEFAULT ('-') ,
MANAGERID INT NOT NULL CONSTRAINT DF_MANAGERID_DEPARTMENT DEFAULT 0 ,
MODBY varchar(10) NOT NULL CONSTRAINT DF_MODBY_DEPARTMENT DEFAULT ('-') ,
MODON date NOT NULL CONSTRAINT DF_MODON_DEPARTMENT DEFAULT ('-') ,
CONSTRAINT PK_DEPARTMENT PRIMARY KEY (ID),
CONSTRAINT FK_DEPARTMENT_EMPLOYEE FOREIGN KEY (MANAGERID) REFERENCES [HRA.EMPLOYEE](ID)
)

-- ----------------------------
-- Table structure for EMPLOYMENTHISTORY
-- ----------------------------
CREATE TABLE [HRA.EMPLOYMENTHISTORY] (
  ID INT NOT NULL IDENTITY (1,1),
  EMPLOYEEID INT NOT NULL CONSTRAINT DF_EMPLOYEEID_EMPLOYMENTHISTORY DEFAULT ('-') ,
  EMPLOYERNAME varchar(100) NOT NULL CONSTRAINT DF_EMPLOYERNAME_EMPLOYMENTHISTORY DEFAULT ('-') ,
  DESIGNATION varchar(20) NOT NULL CONSTRAINT DF_NAME_EMPLOYMENTHISTORY DEFAULT ('-') ,
  STARTDATE date NOT NULL CONSTRAINT DF_DESIGNATION_EMPLOYMENTHISTORY DEFAULT (getdate()) ,
  ENDDATE date NOT NULL CONSTRAINT DF_ENDDATE_EMPLOYMENTHISTORY DEFAULT (getdate()) ,
  BASIS varchar(10) NOT NULL CONSTRAINT DF_BASIS_EMPLOYMENTHISTORY DEFAULT ('-') ,
  COMMENTS varchar(200) NOT NULL CONSTRAINT DF_COMMENTS_EMPLOYMENTHISTORY DEFAULT ('-') ,
  REFERENCENAME varchar(300) NOT NULL CONSTRAINT DF_REFERENCENAME_EMPLOYMENTHISTORY DEFAULT ('-') ,
  REFERENCEPHONE varchar(30) NOT NULL CONSTRAINT DF_REFERENCEPHONE_EMPLOYMENTHISTORY DEFAULT ('-') ,
  REFERENCEMOBILE varchar(30) NOT NULL CONSTRAINT DF_REFERENCEMOBILE_EMPLOYMENTHISTORY DEFAULT ('-') ,
  REFERENCEADDRESS varchar(500) NOT NULL CONSTRAINT DF_REFERENCEADDRESS_EMPLOYMENTHISTORY DEFAULT ('-') ,
  REFERENCEDESIGNATION varchar(100) NOT NULL CONSTRAINT DF_REFERENCEDESIGNATION_EMPLOYMENTHISTORY DEFAULT ('-') ,
  REFERENCECOMMENTS varchar(300) NOT NULL CONSTRAINT DF_REFERENCECOMMENTS_EMPLOYMENTHISTORY DEFAULT ('-') ,
  MODBY date NOT NULL CONSTRAINT DF_MODBY_EMPLOYMENTHISTORY DEFAULT (getdate()) ,
  MODON date NOT NULL CONSTRAINT DF_MODON_EMPLOYMENTHISTORY DEFAULT (getdate()) ,
  CONSTRAINT PK_EMPLOYMENTHISTORY PRIMARY KEY (ID),
  CONSTRAINT FK_EMPLOYMENTHISTORY_EMPOYEE FOREIGN KEY (EMPLOYEEID) REFERENCES [HRA.EMPLOYEE](ID)
)

-- ----------------------------
-- Table structure for FAMILY
-- ----------------------------
CREATE TABLE [HRA.FAMILY] (
  ID INT NOT NULL IDENTITY (1,1),
  EMPLOYEEID INT NOT NULL CONSTRAINT DF_EMPLOYEEID_FAMILY DEFAULT ('-') ,
  NAME varchar(200) NOT NULL CONSTRAINT DF_NAME_FAMILY DEFAULT ('-') ,
  DATEOFBIRTH date NOT NULL CONSTRAINT DF_DATEOFBIRTH_FAMILY DEFAULT (getdate()) ,
  RELATIONSHIP varchar(10) NOT NULL CONSTRAINT DF_RELATIONSHIP_FAMILY DEFAULT ('-') ,
  OCCUPATION varchar(20) NOT NULL CONSTRAINT DF_OCCUPATION_FAMILY DEFAULT ('-') ,
  PLACE varchar(200) NOT NULL CONSTRAINT DF_PLACE_FAMILY DEFAULT ('-') ,
  MODBY date NOT NULL CONSTRAINT DF_MODBY_FAMILY DEFAULT (getdate()) ,
  MODON date NOT NULL CONSTRAINT DF_MODON_FAMILY DEFAULT (getdate()) ,
  CONSTRAINT PK_FAMILY PRIMARY KEY (ID),
  CONSTRAINT FK_FAMILY_EMPLOYEE FOREIGN KEY (EMPLOYEEID) REFERENCES [HRA.EMPLOYEE](ID)
) 

-- ----------------------------
-- Table structure for QUALIFICATION
-- ----------------------------
CREATE TABLE [HRA.QUALIFICATION] (
  ID INT NOT NULL IDENTITY (1,1),
  EMPLOYEEID INT NOT NULL CONSTRAINT DF_EMPLOYEEID_QUALIFICATION DEFAULT ('-') ,
  STUDYPLACE varchar(100) NOT NULL CONSTRAINT DF_STUDYPLACE_QUALIFICATION DEFAULT ('-') ,
  ADDMISSIONYEAR INT NOT NULL CONSTRAINT DF_ADDMISSIONYEAR_QUALIFICATION DEFAULT 0 ,
  QUALIFICATION varchar(200) NOT NULL CONSTRAINT DF_QUALIFICATION_QUALIFICATION DEFAULT ('-') ,
  MEDIUM varchar(10) NOT NULL CONSTRAINT DF_MEDIUM_QUALIFICATION DEFAULT ('-') ,
  LEAVINGDATE date NOT NULL CONSTRAINT DF_LEAVINGDATE_QUALIFICATION DEFAULT (getdate()) ,
  MODBY date NOT NULL CONSTRAINT DF_MODBY_QUALIFICATION DEFAULT (getdate()) ,
  MODON date NOT NULL CONSTRAINT DF_MODON_QUALIFICATION DEFAULT (getdate()) ,
  CONSTRAINT PK_QUALIFICATION PRIMARY KEY (ID),
  CONSTRAINT FK_QUALIFICATION_EMPLOYEE FOREIGN KEY (EMPLOYEEID) REFERENCES [HRA.EMPLOYEE](ID)
); 

-- ----------------------------
-- Table structure for STUDYPROGRAM
-- ----------------------------
CREATE TABLE [HRA.STUDYPROGRAM] (
  ID INT NOT NULL IDENTITY (1,1),
  EMPLOYEEID INT NOT NULL CONSTRAINT DF_EMPLOYEEID_STUDYPROGRAM DEFAULT ('-') ,
  TIMEPERIOD varchar(10) NOT NULL CONSTRAINT DF_TIMEPERIOD_STUDYPROGRAM DEFAULT ('-') ,
  INSTITUTION varchar(200) NOT NULL CONSTRAINT DF_INSTITUTION_STUDYPROGRAM DEFAULT ('-') ,
  COURSETYPE varchar(50) NULL CONSTRAINT DF_COURSETYPE_STUDYPROGRAM DEFAULT ('-') ,
  ADDMISIONDATE date NOT NULL CONSTRAINT DF_ADDMISIONDATE_STUDYPROGRAM DEFAULT (getdate()) ,
  DURATION INT NOT NULL CONSTRAINT DF_DURATION_STUDYPROGRAM DEFAULT 0 ,
  MODBY date NOT NULL CONSTRAINT DF_MODBY_STUDYPROGRAM DEFAULT (getdate()) ,
  MODON date NOT NULL CONSTRAINT DF_MODON_STUDYPROGRAM DEFAULT (getdate()) ,
  CONSTRAINT PK_STUDYPROGRAM PRIMARY KEY (ID),
  CONSTRAINT PK_STUDYPROGRAM_EMPLOYEE FOREIGN KEY (EMPLOYEEID) REFERENCES [HRA.EMPLOYEE](ID)
);

-- ----------------------------
-- Table structure for LOAN
-- ----------------------------
CREATE TABLE [HRA.LOAN] (
  ID INT NOT NULL IDENTITY (1,1),
  EMPLOYEEID INT NOT NULL CONSTRAINT DF_EMPLOYEEID_LOAN DEFAULT ('-') ,
  DUEDATE date NOT NULL CONSTRAINT DF_DUEDATE_LOAN DEFAULT (getdate()) ,
  TOTALOUTSTANDING MONEY NOT NULL CONSTRAINT DF_TOTALOUTSTANDING_LOAN DEFAULT 0 ,
  BORROWER varchar(200) NOT NULL CONSTRAINT DF_BORROWER_LOAN DEFAULT ('-') ,
  MONTHLYPAYMENT MONEY NOT NULL CONSTRAINT DF_MONTHLYPAYMENT_LOAN DEFAULT 0 ,
  MODBY date NOT NULL CONSTRAINT DF_MODBY_LOAN DEFAULT (getdate()) ,
  MODON date NOT NULL CONSTRAINT DF_MODON_LOAN DEFAULT (getdate()) ,
  CONSTRAINT PK_LOAN PRIMARY KEY (ID),
  CONSTRAINT FK_LOAN_EMPLOYEE FOREIGN KEY (EMPLOYEEID) REFERENCES [HRA.EMPLOYEE](ID)
); 

/**
 * EMPLOYEE DATA
 * 20160505 - TR 
 */
INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Nirmala Gamage'), ('Manager'), ('jbutt@gmail.com'), (getdate()), ('445872159V'), ('F'), ('6649 N Blue Gum St'), ('4 B Blue Ridge Blvd'), ('5046218927'), ('8102929388'), (1), ('single'), (getdate()), ('tr'), (getdate()), (1), ('parental'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Nalaka Suranga'), ('Ass. Manager'), ('josephine_darakjy@darakjy.org'), (getdate()), ('774851524V'), ('M'), ('8 W Cerritos Ave #54'), ('639 Main St'), ('8566368749'), ('9073854412'), (2), ('married'), (getdate()), ('tr'), (getdate()), (2), ('annual'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Saman Joy'), ('Supp. Manager'), ('art@venere.org'), (getdate()), ('475825361V'), ('F'), ('34 Center St'), ('25 E 75th St #69'), ('5135701893'), ('4195032484'), (3), ('married'), (getdate()), ('tr'), (getdate()), (3), ('personal'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('James Smith'), ('Supp. Human Resource Manager'), ('lpaprocki@hotmail.com'), (getdate()), ('475825361V'), ('M'), ('3 Mcauley Dr'), ('2371 Jerrold Ave'), ('7735736914'), ('4087523500'), (4), ('married'), (getdate()), ('tr'), (getdate()), (4), ('annual'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Mary Johnson'), ('Supp. Vice Manager'), ('donette.foller@cox.net'), (getdate()), ('475825361V'), ('F'), ('7 Eads St'), ('228 Runamuck Pl #2808'), ('6054142147'), ('4106558723'), (5), ('married'), (getdate()), ('tr'), (getdate()), (5), ('parental'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('John Williams'), ('Supp. Manager'), ('simona@morasca.com'), (getdate()), ('475825361V'), ('M'), ('7 W Jackson Blvd'), ('5 Boston Ave #88 Los Angeles'), ('2158741229'), ('6313353414'), (6), ('married'), (getdate()), ('tr'), (getdate()), (6), ('parental'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Lisa Walker'), ('Supp. Accountant'), ('mitsue_tollner@yahoo.com'), (getdate()), ('475825361V'), ('F'), ('37275 St  Rt 17m M'), ('98 Connecticut Ave Nw Anchorage'), ('3104985651'), ('4407808425'), (7), ('married '), (getdate()), ('tr'), (getdate()), (7), ('annual'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Larry West'), ('Supp. Manager'), ('leota@hotmail.com'), (getdate()), ('475825361V'), ('M'), ('56 E Morehead St'), ('73 State Road 434 E Brighton'), ('9565376195'), ('6022774385'), (8), ('married'), (getdate()), ('tr'), (getdate()), (8), ('sick'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Karen Scott'), ('Supp. Human Resource Manager'), ('sage_wieser@cox.net'), (getdate()), ('475825361V'), ('F'), ('69734 E Carrillo St'), ('322 New Horizon Blvd'), ('9313139635'), ('4146619598'), (9), ('married'), (getdate()), ('tr'), (getdate()), (9), ('parental'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Lawrence Sperry'), ('Supp. Manager'), ('kris@gmail.com'), (getdate()), ('475825361V'), ('M'), ('1 State Route 27'), ('394 Manchester Blvd'), ('3132887937'), ('8158282147'), (10), ('married'), (getdate()), ('tr'), (getdate()), (10), ('annual'));

INSERT INTO "hra-3".dbo."HRA.EMPLOYEE" ( NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS)
VALUES( ('Lawrence Sperry'), ('Supp. Manager'), ('kris@gmail.com'), (getdate()), ('475825361V'), ('M'), ('1 State Route 27'), ('394 Manchester Blvd'), ('3132887937'), ('8158282147'), (11), ('married'), (getdate()), ('tr'), (getdate()), (11), ('annual'));

/**
 * DEPARTMENT DATA
 * 20160505 - TR 
 */

INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Executive'), ('Head Office'), (1), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('IT'), ('Head Office'), (2), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Finance'), ('Head Office'), (3), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Purchasing'), ('Head Office'), (4), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Shipping'), ('Head Office'), (5), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Sales'), ('Head Office'), (6), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Administartion'), ('Head Office'), (7), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Marketing'), ('Head Office'), (8), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('HR'), ('Head Office'), (9), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Support Service'), ('Branch - Union Place'), (10), ('admin'), (getdate()));
INSERT INTO "hra-3".dbo."HRA.DEPARTMENT" ( NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES( ('Customer Care'), ('Branch - Union Place'), (11), ('admin'), (getdate()));


/**
 * SELECT DATA
 * 20160505 - TR 
 */
SELECT ID, NAME, LOCATION, MANAGERID, MODBY, MODON
FROM "hra-3".dbo."HRA.DEPARTMENT" WHERE ID=1;

SELECT ID, NAME, DESIGNATION, EMAIL, DOB, NIC, GENDER, PERMENENTADDRESS, TEMPORARYADDRESS, MOBILENO, OTHERNO, DEPTID, MARITALSTATUS, DATEOFJOIN, MODBY, MODON, EPF, BASIS
FROM "hra-3".dbo."HRA.EMPLOYEE" WHERE ID=2;

/**
 * UPDATE DATA
 * 20160505 - TR 
 */
UPDATE "hra-3".dbo."HRA.DEPARTMENT"
SET NAME=('Executive Update'), LOCATION=('Head Office Update'), MANAGERID=(2), MODBY=('admin'), MODON=(getdate())
WHERE ID=1;

UPDATE "hra-3".dbo."HRA.EMPLOYEE"
SET NAME=('Lawrence Sperry Update'), DESIGNATION=('Supp. Manager Update'), EMAIL=('kris@gmail.com Update'), DOB=(getdate()), NIC=('881592222V'), GENDER=('F'), PERMENENTADDRESS=('1 State Route 27 394 Manchester Blvd'), TEMPORARYADDRESS=('394 Manchester Blvd 8158282147'), MOBILENO=('9313139635'), OTHERNO=('4146619598'), DEPTID=((1)), MARITALSTATUS=('Single'), DATEOFJOIN=(getdate()), MODBY=('admin'), MODON=(getdate()), EPF=(1), BASIS=('Anual')
WHERE ID=11;

/**
 * DELETE DATA
 * 20160505 - TR 
 */
DELETE FROM  "hra-3".dbo."HRA.DEPARTMENT"
WHERE ID=11;

DELETE FROM  "hra-3".dbo."HRA.EMPLOYEE"
WHERE ID=11;


<!-- CREATE TABLE MEDICALHISTORY-->
CREATE TABLE "hra-3".dbo."HRA.MEDICALHISTORY" (
	CODE int NOT NULL IDENTITY (1,1),
	EMPLOYEEID int NOT NULL CONSTRAINT MH_EMPLOYEEID DEFAULT ('-'),
	AILMENT varchar(50) NOT NULL  CONSTRAINT MH_AILMENT  DEFAULT ('-'),
	DESCRIPTION varchar(100) NOT NULL CONSTRAINT MH_DESCRIPTION DEFAULT ('-'),
	MODBY varchar(50) NOT NULL CONSTRAINT MH_MODBY DEFAULT ('-'),
	MODON date NOT NULL CONSTRAINT MH_MODON DEFAULT ('getdate()'),
	CRTBY varchar(50) NOT NULL CONSTRAINT MH_CRTBY DEFAULT ('-'),
	CRTON date NOT NULL CONSTRAINT MH_CRTON DEFAULT ('getdate()'),
	CONSTRAINT PK_MEDICALHISTORY PRIMARY KEY (CODE),
	CONSTRAINT PK_MEDICALHISTORY_EMPLOYEE FOREIGN KEY (EMPLOYEEID) REFERENCES "hra-3".dbo."HRA.EMPLOYEE"(ID)
);

<!-- CREATE TABLE MEDICALREPORT-->
CREATE TABLE "hra-3".dbo."HRA.MEDICALREPORT" (
	CODE int NOT NULL CONSTRAINT MR_CODE  DEFAULT (0),
	REPORTDESCRIPTION varchar(100) NOT NULL CONSTRAINT MR_REPORTDESCRIPTION DEFAULT ('-'),
	REPORTPATH varchar(200) NOT NULL CONSTRAINT MR_REPORTPATH DEFAULT ('-'),
	MODBY varchar(50) NOT NULL CONSTRAINT MR_MODBY DEFAULT ('-'),
	MODON date NOT NULL CONSTRAINT MR_MODON DEFAULT ('getdate()'),
	CRTBY varchar(50) NOT NULL CONSTRAINT MR_CRTBY DEFAULT ('-'),
	CRTON date NOT NULL CONSTRAINT MR_CRTON DEFAULT ('getdate()'),
	CONSTRAINT PK_MEDICALREPORT PRIMARY KEY (CODE,REPORTDESCRIPTION,REPORTPATH),
	CONSTRAINT PK_MEDICALREPORT_CODE FOREIGN KEY (CODE) REFERENCES "hra-3".dbo."HRA.MEDICALHISTORY"(CODE)
);

