/**
 * <!-- 20160407 PN HRA-1 created hra.helper.js class --> <!-- 20160415 PN HRA-1
 * Modified addEmployeeDetails() Function -->
 */

function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
}

function loadContentEmployee() {
	$("#mainContent").load("createEmployee.jsp");
}

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
}

// Only for Sprint -1 demo.
function deleteAlert() {
	alert("Data Deleted Successfully.");
}

function addedAlert() {
	document.getElementById("moredetails").disabled = false;
	alert("Data Added Successfully.");
}

function addedDept() {
	alert("Data Added Successfully.");
}


function updatedAlert() {
	alert("Data Updated Successfully.");
	document.getElementById("moredetails").disabled = false;
}

// Get data to sent to Servlet
function addEmployeeDetails() {
	var employeeNumber = $("#employeeNumber").val();
	var employeeName = $("#employeeName").val();
	var employeeDesignation = $("#employeeDesignation").val();
	var employeeDateofBoth = $("#employeeDateofBoth").val();
	var employeeGender = $("#employeeGender").val();
	var employeeAddress = $("#employeeAddress").val();
	var employeeMobileNumber = $("#employeeMobileNumber").val();
	var employeeOtherNumber = $("#employeeOtherNumber").val();
	var employeeEmail = $("#employeeEmail").val();
	var employeeDepartment = $("#employeeDepartment").val();
	var employeeJoinDate = $("#employeeJoinDate").val();

	var employeeData = {
		"employeedata" : {
			"employeeNumber" : employeeNumber,
			"employeeName" : employeeName,
			"employeeDesignation" : employeeDesignation,
			"employeeDateofBoth" : employeeDateofBoth,
			"employeeGender" : employeeGender,
			"employeeAddress" : employeeAddress,
			"employeeMobileNumber" : employeeMobileNumber,
			"employeeOtherNumber" : employeeOtherNumber,
			"employeeEmail" : employeeEmail,
			"employeeDepartment" : employeeDepartment,
			"employeeJoinDate" : employeeJoinDate
		}
	};

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(employeeData)
		},
		dataType : "json",
		success : function(data) {
			alert(data);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

// Get data to sent to Servlet
function addDepartmentDetails() {
	var departmentNumber = $("#departmentNumber").val();
	var departmentName = $("#departmentName").val();
	var departmentLocation = $("#departmentLocation").val();
	var departmentHead = $("#departmentHead").val();

	var jsonData = {
		"jsonData" : {
			"departmentNumber" : departmentNumber,
			"departmentName" : departmentName,
			"departmentLocation" : departmentLocation,
			"departmentHead" : departmentHead
		}
	};



	alert(jsonData);

	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData)
		},
		dataType : "json",
		success : function(data) {
			alert(data);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

// Load Employee Contents
function loadContentbasicdata() {
	$("#modelrest").load("employeeDetails/basicData.jsp");
}

function loadContentqualifications() {
	$("#modelrest").load("employeeDetails/educationalDetails.jsp");
}

function loadContentemployementhistory() {
	$("#modelrest").load("employeeDetails/employementHistory.jsp");
}

function loadContentstudyprograms() {
	$("#modelrest").load("employeeDetails/studyPrograms.jsp");
}

function loadContentlanguages() {
	$("#modelrest").load("employeeDetails/languageProficiency.jsp");
}

function loadContentloandetails() {
	$("#modelrest").load("employeeDetails/loanDetails.jsp");
}
function loadContentfamilydetails() {
	$("#modelrest").load("employeeDetails/familyDetails.jsp");
}
function loadContentemergencycontacts() {
	$("#modelrest").load("employeeDetails/emergencyContacts.jsp");
}
function loadContentmoreDetails() {
	$("#modelrest").load("employeeDetails/moreDetails.jsp");
}

function loadContentmoreDetails() {
	$("#employeeContent").load("employeeDetails/moreDetails.jsp");
}

function loadContentmoreDetails() {
	$("#employeeContent").load("employeeDetails/moreDetails.jsp");

	// ///////////////////////////////////////////////
	$(document).on("click", "#vbutton", function() {

		$.get("EmployerController", function(data, status){
			
			alert(data);
			json = JSON.parse(data);
			$(".modal-body #userid").val( json.employeeId);
			$(".modal-body #username").val( json.employeeName);
			$(".modal-body #disignation").val( json.employeeDesignation);
			$(".modal-body #salary").val( json.employeeSalary);
			$(".modal-body #email").val( json.employeeEmail);
			$(".modal-body #dob").val( json.employeeDob);
			$(".modal-body #Nic").val( json.employeeNic);
			$(".modal-body #gender").val( json.employeeGender);
			$(".modal-body #adress").val( json.employeeAddress);
			$(".modal-body #MobNumber").val( json.employeeMobileno);
			$(".modal-body #OthNumber").val( json.employeeOtherno);
			$(".modal-body #depid").val( json.departmentId);
			$(".modal-body #doj").val( json.dateOfjoin);
			//$(".modal-body #userid").val( json.modOn);
			//$(".modal-body #userid").val( json.modBy);
			
		});

	});
	$(document).ready(function() {
		$('#employeeDetails').DataTable();

	});
}
