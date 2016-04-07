CREATE TABLE IF NOT EXISTS `department` (
  `departmentTblID` int(11) NOT NULL AUTO_INCREMENT,
  `departmentID` varchar(5) DEFAULT NULL,
  `departmentName` varchar(20) DEFAULT NULL,
  `departmentLocation` varchar(20) DEFAULT NULL,
  `managerID` varchar(6) DEFAULT NULL,
  `addedBy` varchar(10) DEFAULT NULL,
  `updatedBy` varchar(10) DEFAULT NULL,
  `addedOn` varchar(10) DEFAULT NULL,
  `updatedOn` varchar(10) DEFAULT NULL,
  `envCode` varchar(10) DEFAULT NULL,  
  PRIMARY KEY (`departmentTblID`),
  FOREIGN KEY (managerID) REFERENCES employee(employeeID)
);

CREATE TABLE IF NOT EXISTS `employee` (
  `employeeTblID` int(11) NOT NULL AUTO_INCREMENT,
  `employeeID` varchar(6) DEFAULT NULL,
  `employeeName` varchar(100) DEFAULT NULL,
  `employeeDesignation` varchar(50) DEFAULT NULL,
  `employeeEmail` varchar(50) DEFAULT NULL,
  `employeeDOB` date DEFAULT NULL,
  `employeeGender` varchar(1) DEFAULT NULL,
  `employeeAddress` varchar(300) DEFAULT NULL,
  `employeeMobileNO` varchar(10) DEFAULT NULL,
  `employeeOtherNO` varchar(10) DEFAULT NULL,
  `departmentID` varchar(5) DEFAULT NULL,
  `dateOfJoin` date DEFAULT NULL,
  `addedBy` varchar(10) DEFAULT NULL,
  `updatedBy` varchar(10) DEFAULT NULL,
  `addedOn` varchar(10) DEFAULT NULL,
  `updatedOn` varchar(10) DEFAULT NULL,
  `envCode` varchar(10) DEFAULT NULL, 
  PRIMARY KEY (`employeeTblID`),
  FOREIGN KEY (departmentID) REFERENCES department(departmentID)
);

CREATE TABLE IF NOT EXISTS `dependent` (
  `dependentTblID` int(11) NOT NULL AUTO_INCREMENT,
  `dependentID` varchar(5) DEFAULT NULL,
  `dependentName` varchar(100) DEFAULT NULL,
  `dependentDOB` date DEFAULT NULL,
  `employeeID` varchar(6) DEFAULT NULL,
  `addedBy` varchar(10) DEFAULT NULL,
  `updatedBy` varchar(10) DEFAULT NULL,
  `addedOn` varchar(10) DEFAULT NULL,
  `updatedOn` varchar(10) DEFAULT NULL,
  `envCode` varchar(10) DEFAULT NULL,  
  PRIMARY KEY (`dependentID`),
  FOREIGN KEY (employeeID) REFERENCES employee(employeeID)
);