/*
*20160424 PN hra.master.ddl.sql V02 created.
*
*
*/

CREATE TABLE IF NOT EXISTS `EMPLOYEE` (
  `ID` varchar(6) DEFAULT "-",
  `NAME` varchar(100) DEFAULT "-",
  `DESIGNATION` varchar(50) DEFAULT "-",
  `SALARY` float DEFAULT 0.00,
  `EMAIL` varchar(50) DEFAULT "-",
  `DOB` date DEFAULT "-",
  `NIC` date DEFAULT "-",
  `GENDER` varchar(1) DEFAULT "-",
  `PERMENENTADDRESS` varchar(300) DEFAULT "-",
  `TEMPORARYADDRESS` varchar(300) DEFAULT "-",
  `MOBILENO` varchar(10) DEFAULT "-",
  `OTHERNO` varchar(10) DEFAULT "-",
  `DEPTID` varchar(5) DEFAULT "-",
  `MARITALSTATUS` varchar(10) DEFAULT "-",
  `WORKWDATFORCES` varchar(50) DEFAULT "-",
  `LABOURDEPARTMENTCASES` varchar(50) DEFAULT "-",
  `TRAVELBY` varchar(10) DEFAULT "-",
  `VEHICLENUMBER` varchar(10) DEFAULT "-",
  `RAISEDABOARD` varchar(50) DEFAULT "-",
  `CRIMINALOFFECNE` varchar(50) DEFAULT "-",
  `LANGUAGEPROFICIENCY` varchar(200) DEFAULT "-",
  `OTHERNO` varchar(10) DEFAULT "-",
  `DATEOFJOIN` date DEFAULT "-",
  `MODBY` date DEFAULT GETDATE(),
  `MODON` date DEFAULT GETDATE(),
  CONSTRAINT EMPLOYEE_ID_PK_ID PRIMARY KEY (ID),
  CONSTRAINT DEPARTMENT_ID_FK_DEPTFKID FOREIGN KEY (DEPTFKID) REFERENCES DEPARTMENT(ID)
);

-- ----------------------------
-- Table structure for `DEPARTMENT`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `DEPARTMENT`` (
  `ID` varchar(5) DEFAULT "-",
  `NAME` varchar(20) DEFAULT "-",
  `LOCATION` varchar(20) DEFAULT "-",
  `MANAGERID` varchar(6) DEFAULT "-",
  `MODBY` varchar(10) DEFAULT "-",
  `MODON` date DEFAULT GETDATE(),
  CONSTRAINT DEPARTMENT_ID_PK_ID PRIMARY KEY (ID),
  CONSTRAINT EMPLOYEE_ID_FK_MANAGERFKID FOREIGN KEY (MANAGERID) REFERENCES EMPLOYEE(ID)
);

-- ----------------------------
-- Table structure for `EMPLOYMENTHISTORY`
-- ----------------------------
DROP TABLE IF EXISTS `EMPLOYMENTHISTORY`;
CREATE TABLE `EMPLOYMENTHISTORY` (
  `ID` int(11) NOT NULL,
  `EMPLOYEEID` varchar(10) DEFAULT '-',
  `EMPLOYERNAME` varchar(100) DEFAULT '-',
  `DESIGNATION` varchar(20) DEFAULT '-',
  `STARTDATE` date DEFAULT GETDATE(),
  `ENDDATE` date DEFAULT GETDATE(),
  `BASIS` varchar(10) DEFAULT '-',
  `COMMENTS` varchar(200) DEFAULT '-',
  `REFERENCENAME` varchar(300) DEFAULT '-',
  `REFERENCEPHONE` varchar(30) DEFAULT '-',
  `REFERENCEMOBILE` varchar(30) DEFAULT '-',
  `REFERENCEADDRESS` varchar(500) DEFAULT '-',
  `REFERENCEDESIGNATION` varchar(100) DEFAULT '-',
  `REFERENCECOMMENTS` varchar(300) DEFAULT '-',
  `MODBY` date DEFAULT GETDATE(),
  `MODON` date DEFAULT GETDATE(),
  CONSTRAINT EMPLOYMENTHISTORY_ID_PK_ID PRIMARY KEY (ID),
  CONSTRAINT EMPLOYEE_ID_FK_MANAGERFKID FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(ID)
)

-- ----------------------------
-- Table structure for `FAMILY`
-- ----------------------------
DROP TABLE IF EXISTS `FAMILY`;
CREATE TABLE `FAMILY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEEID` varchar(10) DEFAULT '-',
  `NAME` varchar(200) DEFAULT '-',
  `DATEOFBIRTH` date DEFAULT GETDATE(),
  `RELATIONSHIP` varchar(10) DEFAULT '-',
  `OCCUPATION` varchar(20) DEFAULT '-',
  `PLACE` varchar(200) DEFAULT '-',
  `MODBY` date DEFAULT GETDATE(),
  `MODON` date DEFAULT GETDATE(),
  CONSTRAINT FAMILY_ID_PK_ID PRIMARY KEY (ID),
  CONSTRAINT EMPLOYEE_ID_FK_MANAGERFKID FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(ID)
) 

-- ----------------------------
-- Table structure for `LOAN`
-- ----------------------------
DROP TABLE IF EXISTS `LOAN`;
CREATE TABLE `LOAN` (
  `ID` int(11) NOT NULL,
  `EMPLOYEEID` varchar(10) DEFAULT '-',
  `DUEDATE` date DEFAULT GETDATE(),
  `TOTALOUTSTANDING` double DEFAULT '0',
  `BORROWER` varchar(200) DEFAULT '-',
  `MONTHLYPAYMENT` double DEFAULT '0',
  `MODBY` date DEFAULT GETDATE(),
  `MODON` date DEFAULT GETDATE(),
  CONSTRAINT LOAN_ID_PK_ID PRIMARY KEY (ID),
  CONSTRAINT EMPLOYEE_ID_FK_MANAGERFKID FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(ID)
) 

-- ----------------------------
-- Table structure for `QUALIFICATION`
-- ----------------------------
DROP TABLE IF EXISTS `QUALIFICATION`;
CREATE TABLE `QUALIFICATION` (
  `ID` int(11) NOT NULL,
  `EMPLOYEEID` varchar(10) DEFAULT '-',
  `STUDYPLACE` varchar(100) DEFAULT '-',
  `ADDMISSIONYEAR` int(11) DEFAULT NULL,
  `QUALIFICATION` varchar(200) DEFAULT '-',
  `MEDIUM` varchar(10) DEFAULT '-',
  `LEAVINGDATE` date DEFAULT GETDATE(),
  `MODBY` date DEFAULT GETDATE(),
  `MODON` date DEFAULT GETDATE(),
  CONSTRAINT QUALIFICATION_ID_PK_ID PRIMARY KEY (ID),
  CONSTRAINT EMPLOYEE_ID_FK_MANAGERFKID FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(ID)
) 

-- ----------------------------
-- Table structure for `studyprogram`
-- ----------------------------
DROP TABLE IF EXISTS `STUDYPROGRAM`;
CREATE TABLE `STUDYPROGRAM` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEEID` varchar(10) DEFAULT '-',
  `TIME` varchar(10) DEFAULT '-',
  `INSTITUTION` varchar(200) DEFAULT '-',
  `COURSETYPE` varchar(50) DEFAULT '-',
  `ADDMISIONDATE` date DEFAULT GETDATE(),
  `DURATION` int(11) DEFAULT '0',
  `MODBY` date DEFAULT GETDATE(),
  `MODON` date DEFAULT GETDATE(),
  CONSTRAINT STUDYPROGRAM_ID_PK_ID PRIMARY KEY (ID),
  CONSTRAINT EMPLOYEE_ID_FK_MANAGERFKID FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(ID)
) 

