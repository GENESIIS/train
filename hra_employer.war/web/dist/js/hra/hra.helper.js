/**
 * 20160407 PN HRA-1 created hra.helper.js class. 20160415 PN HRA-1 Modified
 * addEmployeeDetails() Function. 20160429 PN HRA-3 addDepartmentDetails()
 * function Modified. 20160505 PN HRA-2 clearAddemployeeform() function
 * modified. 20160509 addEducationDetails() Function
 */

var theNewScript = document.createElement("script");
theNewScript.type = "text/javascript";
theNewScript.src = "hra.validation.js";
theNewScript.src = "hra.employer.js";
var empEpf = null;

function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
};

function loadContentEmployee() {
	$("#mainContent").load("manageEmployee.jsp");
};

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
};

function loadContentqualifications() {
	$("#modelrest").load("employeeDetails/educationalDetails.jsp");
}

function loadViewEmployee() {
	$("#mainContent").load("ViewemployeeDetails/viewEmployeeDetails.jsp");
	loademployeeDetails();
}

function loadBasicTable() {
	$("#basicTable").load("TableDetail/serchBasic.jsp");
}

// Only for Sprint -1 demo.
function deleteAlert() {
	alert("Data Deleted Successfully.");
}

// Load more details contents
function loadfamilydetails() {
	$("#modelrest").load("employeeDetails/familyDetails.jsp");
}

// load more edit Employeee Detail
function loadEditContentqualifications() {
	$("#Editmodelrest").load("EditemployeeDetails/EditeducationalDetails.jsp");
	loadDataEducationalDetails();
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("EditemployeeDetails/EditstudyPrograms.jsp");
}

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}

// Only for Sprint -1 demo.
function addedAlert() {
	// document.getElementById("moredetails").disabled = false;
	document.getElementById("moredetails").disabled = false;
	alert("Data Added Successfully.");
}

function updatedAlert() {
	alert("Data Updated Successfully.");
}

// Get Employees for Add Department Form
function getManager() {
	var jsonData = {};
	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "GMN"
		},
		dataType : "json",
		success : function(data) {
			var select = $('#departmentHead');
			select.find('option').remove();
			$('<option>').val("").text("--Select--").appendTo(select);
			$.each(JSON.parse(data), function(index, value) {
				var result = value.split("#");
				$('<option>').val(result[0]).text(result[1]).appendTo(select);
			});
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

function getDepartment() {
	var jsonData = {};
	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "GDP"
		},
		dataType : "json",
		success : function(data) {
			var select = $('#employeeDepartment');
			select.find('option').remove();
			$('<option>').val("").text("--Select--").appendTo(select);
			$.each(JSON.parse(data), function(index, value) {
				var result = value.split("#");
				$('<option>').val(result[0]).text(result[1]).appendTo(select);
			});
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}
// ///////////////////////////////////////////////

// Get data and sent to DepartmentController.java.
function addDepartmentDetails() {
	var departmentName = $("#departmentName").val();
	var departmentLocation = $("#departmentLocation").val();
	var departmentHead = $("#departmentHead").val();

	var departmentNameerror = $("#departmentNameerror").text();
	var departmentHeaderror = $("#departmentHeaderror").text();

	var jsonData = {
		"departmentName" : departmentName,
		"departmentLocation" : departmentLocation,
		"departmentHead" : departmentHead
	};

	if ((departmentName == "") || (departmentHead == "")) {
		alert("Please fill the Empty fields.");
	} else if ((departmentNameerror != "") || (departmentHeaderror)) {
		alert("Please fill the details correctly.");
	} else {
		$.ajax({
			type : "POST",
			url : 'DepartmentController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "ADP"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearDepartmentform();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
}

function loadEditContentqualifications() {
	$("#Editmodelrest").load("EditemployeeDetails/EditeducationalDetails.jsp");
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("EditemployeeDetails/EditstudyPrograms.jsp");
}

function clearDepartmentform() {
	$("#departmentName").val("");
	$("#departmentLocation").val("");
	getManager();
	$("#departmentNameerror").text("");
	$("#departmentHeaderror").text("");
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function isLetter(evt) {
	var inputValue = evt.charCode;
	if (!(inputValue >= 65 && inputValue <= 120)
			&& (inputValue != 32 && inputValue != 0)) {
		evt.preventDefault();
	}
}

// Get data and sent to EmployerController.java.
function addEmployeeDetails() {
	var fname = $("#employeeFirstname").val();
	var mname = $("#employeeMiddlename").val();
	var lname = $("#employeeLastname").val();

	var employeeFirstname = fname + "," + mname + "," + lname;
	var employeeDateofbirth = $("#employeeDateofbirth").val();
	var employeeNic = $("#employeeNic").val();
	var employeeGender = $("#employeeGender").val();
	var employeeMaritalstatus = $("#employeeMaritalstatus").val();
	var employeeEpf = $("#employeeEpf").val();
	var employeeBasis = $("#employeeBasis").val();
	var employeeDesignation = $("#employeeDesignation").val();
	var employeeDepartment = $("#employeeDepartment").val();
	var employeePermenetaddress = $("#employeePermenetaddress").val();
	var employeeTemporaryaddress = $("#employeeTemporaryaddress").val();
	var employeeTelephone = $("#employeeTelephone").val();
	var employeeMobile = $("#employeeMobile").val();
	var employeeEmail = $("#employeeEmail").val();
	var employeeJoindate = $("#employeeJoindate").val();

	var employeeFirstnameerror = $("#employeeFirstnameerror").text();
	var employeeMiddlenameerror = $("#employeeMiddlenameerror").text();
	var employeeLastnameerror = $("#employeeLastnameerror").text();
	var employeeNicerror = $("#employeeNicerror").text();
	var employeeEpferror = $("#employeeEpferror").text();
	var employeeDesignationerror = $("#employeeDesignationerror").text();

	var employeeData = {
		"employeeName" : employeeFirstname,
		"employeeDateofbirth" : employeeDateofbirth,
		"employeeNic" : employeeNic,
		"employeeGender" : employeeGender,
		"employeeMaritalstatus" : employeeMaritalstatus,
		"employeeEpf" : employeeEpf,
		"employeeBasis" : employeeBasis,
		"employeeDesignation" : employeeDesignation,
		"employeeDepartment" : employeeDepartment,
		"employeePermenetaddress" : employeePermenetaddress,
		"employeeTemporaryaddress" : employeeTemporaryaddress,
		"employeeTelephone" : employeeTelephone,
		"employeeMobile" : employeeMobile,
		"employeeEmail" : employeeEmail,
		"employeeJoindate" : employeeJoindate,
	};

	if ((fname == "") || (mname == "") || (lname == "") || (employeeNic == "")
			|| (employeeEpf == "") || (employeeDesignation == "")) {
		alert("Please fill the Empty fields.");
	} else if ((employeeFirstnameerror != "")
			|| (employeeMiddlenameerror != "") || (employeeLastnameerror != "")
			|| (employeeNicerror != "") || (employeeEpferror != "")
			|| (employeeDesignationerror != "")) {
		alert("Please fill the details correctly.");
	} else {
		$.ajax({
			type : "POST",
			url : 'EmployerController',
			data : {
				jsonData : JSON.stringify(employeeData),
				task : "AEB"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearAddemployeeform();
					document.getElementById("moredetails").disabled = false;
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
}

function clearAddemployeeform() {
	$("#employeeFirstname").val("");
	$("#employeeMiddlename").val("");
	$("#employeeLastname").val("");
	$("#employeeDateofbirth").val("");
	$("#employeeNic").val("");
	$("#employeeGender").val("");
	$("#employeeMaritalstatus").val("");
	$("#employeeEpf").val("");
	$("#employeeBasis").val("");
	$("#employeeDesignation").val("");
	$("#employeePermenetaddress").val("");
	$("#employeeTemporaryaddress").val("");
	$("#employeeTelephone").val("");
	$("#employeeMobile").val("");
	$("#employeeEmail").val("");
	$("#employeeJoindate").val("");
	$("#employeeFirstnameerror").text("");
	$("#employeeMiddlenameerror").text("");
	$("#employeeLastnameerror").text("");
	$("#employeeNicerror").text("");
	$("#employeeEpferror").text("");
	$("#employeeDesignationerror").text("");
	getDepartment();
}






