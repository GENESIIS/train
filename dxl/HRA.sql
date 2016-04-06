CREATE TABLE IF NOT EXISTS `department` (
  `departmentTblID` int(11) NOT NULL AUTO_INCREMENT,
  `departmentID` varchar(5) DEFAULT NULL,
  `departmentName` varchar(20) DEFAULT NULL,
  `departmentLocation` varchar(20) DEFAULT NULL,
  `managerID` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`departmentTblID`)
);

CREATE TABLE IF NOT EXISTS `employee` (
  `employeeTblID` int(11) NOT NULL AUTO_INCREMENT,
  `employeeID` varchar(6) DEFAULT NULL,
  `employeeName` varchar(150) DEFAULT NULL,
  `employeeDesignation` varchar(50) DEFAULT NULL,
  `employeeEmail` varchar(50) DEFAULT NULL,
  `employeeDOB` date DEFAULT NULL,
  `employeeGender` varchar(1) DEFAULT NULL,
  `employeeAddress` varchar(300) DEFAULT NULL,
  `employeeMobileNO` varchar(10) DEFAULT NULL,
  `employeeOtherNO` varchar(10) DEFAULT NULL,
  `departmentID` varchar(5) DEFAULT NULL,
  `dateOfJoin` date DEFAULT NULL,
  PRIMARY KEY (`employeeTblID`)
);