/**
 * 20160407 PN HRA-1 created hra.helper.js class. 20160415 PN HRA-1 Modified
 * addEmployeeDetails() Function. 20160429 PN HRA-3 addDepartmentDetails()
 * function Modified. 20160505 PN HRA-2 clearAddemployeeform() function
 * modified.
 */

getEmployeetoupdate();
function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
}

function loadContentEmployee() {
	$("#mainContent").load("manageEmployee.jsp");
}

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
}

// Get Employees for Add Department Form
function getManager() {
	$.getJSON('DepartmentController', {
		task : "FIND"
	}, function(data) {
		var select = $('#departmentHead');
		select.find('option').remove();
		$('<option>').val("").text("--Select--").appendTo(select);
		$.each(data, function(index, value) {
			var result = value.split("#");
			$('<option>').val(result[0]).text(result[1]).appendTo(select);
		});
	});
}

// Get Departments for Add Employee Form
function getDepartment() {
	$.get('EmployeeController', {
		task : "FIND"
	}, function(data) {
		var select = $('#employeeDepartment');
		select.find('option').remove();
		$('<option>').val("").text("--Select--").appendTo(select);
		$.each(data, function(index, value) {
			var result = value.split("#");
			$('<option>').val(result[0]).text(result[1]).appendTo(select);
		});
	});
}

// Get data and sent to EmployeeController.java.
function addEmployeeDetails() {
	var employeeFirstname = $("#employeeFirstname").val() + ","
			+ $("#employeeMiddlename").val() + ","
			+ $("#employeeLastname").val();
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
	var employeeNumber = $("#employeeNumber").val();

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
		"employeeId" : employeeNumber
	};

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(employeeData),
			task : "ADD"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
				clearAddemployeeform();
				// document.getElementById("moredetails").disabled = false;
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
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
	$("#employeeNumber").val("");
	getDepartment();
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

// load data to edit
$(document).on("click", "#ebutton", function() {
	$.get("EmployerController", function(data, status) {

		alert(data);
		json = JSON.parse(data);
		$(".modal-body #employeeNumberEdit").val(json.ID);
		$(".modal-body #employeeNameEdit").val(json.NAME);
		$(".modal-body #employeeDesignationEdit").val(json.DESIGNATION);
		// (".modal-body #employeeDateofBothEdit").val( json.Salary);
		$(".modal-body #employeeEmailEdit").val(json.EMAIL);
		$(".modal-body #employeeDateofBothEdit").val(json.DOB);
		$(".modal-body #employeeNICEdit").val(json.NIC);
		$(".modal-body #employeeGenderEdit").val(json.GENDER);
		$(".modal-body #employeeAddressEdit").val(json.PERMENENTADDRESS);
		$(".modal-body #employeeMobileNumberEdit").val(json.MOBILENO);
		$(".modal-body #employeeOtherNumberEdit").val(json.OTHERNO);
		$(".modal-body #employeeDepartmentEdit").val(json.DEPTID);
		$(".modal-body #employeeJoinDateEdit").val(json.DATEOFJOIN);
		$(".modal-body #employeeMaritalEdit").val(json.MARITALSTATUS);
		$(".modal-body #employeeEPFEdit").val(json.EPF);
		$(".modal-body #employeeTempADDEdit").val(json.TEMPORARYADDRESS);

	});

});
// ajax Json parsing
function updateEmployeeDetails() {
	var employeeNumber = $("#employeeNumberEdit").val();
	var employeeName = $("#employeeNameEdit").val();
	var employeeDesignation = $("#employeeDesignationEdit").val();
	var employeeDateofBoth = $("#employeeDateofBothEdit").val();
	var employeeGender = $("#employeeGenderEdit").val();
	var employeeAddress = $("#employeeAddressEdit").val();
	var employeeMobileNumber = $("#employeeMobileNumberEdit").val();
	var employeeOtherNumber = $("#employeeOtherNumberEdit").val();
	var employeeEmail = $("#employeeEmailEdit").val();
	var employeeDepartment = $("#employeeDepartmentEdit").val();
	var employeeJoinDate = $("#employeeJoinDateEdit").val();
	var MARITALSTATUS = $("employeeMaritalEdit").val;
	var MODBY = null;
	var MODON = null;
	var EPF = $("employeeEPFEdit").val;
	var BASIS = null;

	var employeeData = {

		"ID" : employeeNumber,
		"NAME" : employeeName,
		"DESIGNATION" : employeeDesignation,
		"DOB" : employeeDateofBoth,
		"GENDER" : employeeGender,
		"PERMENENTADDRESS" : employeeAddress,

		"MOBILENO" : employeeMobileNumber,
		"OTHERNO" : employeeOtherNumber,
		"EMAIL" : employeeEmail,
		"DEPTID" : employeeDepartment,
		"DATEOFJOIN" : employeeJoinDate,
		"MARITALSTATUS" : MARITALSTATUS,
		"MODBY" : MODBY,
		"MODON" : MODON,
		"EPF" : EPF,
		"BASIS" : BASIS
	};

	alert(JSON.stringify(employeeData));
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			Data : JSON.stringify(employeeData)
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

// Get data and sent to DepartmentController.java.
function addDepartmentDetails() {
	var departmentNumber = $("#departmentNumber").val();
	var departmentName = $("#departmentName").val();
	var departmentLocation = $("#departmentLocation").val();
	var departmentHead = $("#departmentHead").val();

	var jsonData = {
		"departmentNumber" : departmentNumber,
		"departmentName" : departmentName,
		"departmentLocation" : departmentLocation,
		"departmentHead" : departmentHead
	};

	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "ADD"
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

// Get data and sent to DepartmentController.java.
function deleteDepartmentDetails() {

}

function clearDepartmentform() {
	$("#departmentNumber").val("");
	$("#departmentName").val("");
	$("#departmentLocation").val("");
	getManager();
}

$(document).on("click", "#vbutton", function() {

	$.get("EmployerController", function(data, status) {

		$("#view").load("viewEmployee.jsp", function(datatl) {
			json = JSON.parse(data);
			$("#userid").text(json.ID);
			$(".panel-body #username").text(json.NAME);
			$(".panel-body #disignation").text(json.DESIGNATION);
			// $(".panel-body #salary").text( json.Salary);
			$(".panel-body #email").text(json.EMAIL);
			$(".panel-body #dob").text(json.DOB);
			$(".panel-body #Nic").text(json.NIC);
			$(".panel-body #gender").text(json.GENDER);
			$(".panel-body #adress").text(json.PERMENENTADDRESS);
			$(".panel-body #MobNumber").text(json.MOBILENO);
			$(".panel-body #OthNumber").text(json.OTHERNO);
			$(".panel-body #depid").text(json.DEPTID);
			$(".panel-body #doj").text(json.DATEOFJOIN);
			$(".modal-body #userid").val(json.EPF);
			$(".modal-body #userid").val(json.TEMPORARYADDRESS);

			$(".panel-body #doj").text(json.MARITALSTATUS);
			// $(".modal-body #userid").val( json.EPF);
			// $(".modal-body #userid").val( json.TEMPORARYADDRESS);

			alert(data);
		});
	});
});

// ///load more employee views/////////////////////////////////////

function loadviewqlifications() {
	$("#viewmodelrest").load("viewemployeeDetails/vieweducationalDetails.jsp");
}

function loadviewemployementhistory() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemployementHistory.jsp");
}

function loadviewstudyprograms() {
	$("#viewmodelrest").load("viewemployeeDetails/viewstudyPrograms.jsp");
}

function loadviewlanguages() {
	$("#viewmodelrest").load("viewemployeeDetails/viewlanguageProficiency.jsp");
}

function loadviewloandetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}
function loadviewfamilydetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewfamilyDetails.jsp");
}
function loadviewemergencycontacts() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemergencyContacts.jsp");
}

function loadEditContentloandetails() {
	$("#Editmodelrest").load("EditemployeeDetails/EditloanDetails.jsp");
}
function loadEditContentfamilydetails() {
	$("#Editmodelrest").load("EditemployeeDetails/EditfamilyDetails.jsp");
}
function loadEditemergencycontacts() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemergencyContacts.jsp");
}

// Load more details contents
function loadfamilydetails() {
	$("#modelrest").load("employeeDetails/familyDetails.jsp");
}

function disableButton() {
	// document.getElementById("moredetails").disabled = true;
}

// //Add Family Details
function addFamilyDetails() {
	var fmemployeeId = $("#fmemployeeId").val();
	var relationship = $("#relationship").val();
	var relationDateofbirth = $("#relationDateofbirth").val();
	var relationName = $("#relationName").val();
	var occupation = $("#occupation").val();
	var workingPlace = $("#workingPlace").val();

	var employeeIdtb = isEmptyfield(fmemployeeId);
	var relationshiptb = isEmptyfield(relationship);
	var relationDateofbirthtb = isPastdate(relationDateofbirth);
	var relationNametb = isEmptyfield(relationName);

	if (employeeIdtb == false) {
		document.getElementById('fmemployeeidError').innerHTML = "** Invalid EPF Number.";
	}
	if (relationshiptb == false) {
		document.getElementById('relationshipError').innerHTML = "** Relationship can not be Empty.";
	}
	if (relationDateofbirthtb == false) {
		document.getElementById('relationbirthdateError').innerHTML = "** Invalid Birth Date.";
	}
	if (relationNametb == false) {
		document.getElementById('relationnameError').innerHTML = "** Name cannot be Empty.";
	}

	if ((employeeIdtb == true) && (relationshiptb == true)
			&& (relationDateofbirthtb == true) && (relationNametb == true)) {
		var jsonData = {
			"employeeEpf" : fmemployeeId,
			"fmRelationship" : relationship,
			"fmDateofbirth" : relationDateofbirth,
			"fmName" : relationName,
			"fmOccupation" : occupation,
			"fmWorkingplace" : workingPlace
		};

		$.ajax({
			type : "POST",
			url : 'EmployeeController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "ADD"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearFamilydetails();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}

}

function clearFamilydetails() {
	$("#relationDateofbirth").val("");
	$("#relationName").val("");
	$("#occupation").val("");
	$("#workingPlace").val("");
	$("#fmemployeeidError").text("");
	$("#relationshipError").text("");
	$("#relationbirthdateError").text("");
	$("#relationnameError").text("");
	$('#relationship option').prop('selected', function() {
		return this.defaultSelected;
	});

}

// //Edit Family Details
function editFamilyDetails() {
	var fmemployeeId = $("#editfmemployeeId").val();
	var relationship = $("#editrelationship").val();
	var relationDateofbirth = $("#editrelationDateofbirth").val();
	var relationName = $("#editrelationName").val();
	var occupation = $("#editoccupation").val();
	var workingPlace = $("#editworkingPlace").val();

	var employeeIdtb = isEmptyfield(fmemployeeId);
	var relationshiptb = isEmptyfield(relationship);
	var relationDateofbirthtb = isPastdate(relationDateofbirth);
	var relationNametb = isEmptyfield(relationName);

	if (employeeIdtb == false) {
		document.getElementById('editfmemployeeidError').innerHTML = "** Invalid EPF Number.";
	}
	if (relationshiptb == false) {
		document.getElementById('editrelationshipError').innerHTML = "** Relationship can not be Empty.";
	}
	if (relationDateofbirthtb == false) {
		document.getElementById('editrelationbirthdateError').innerHTML = "** Invalid Birth Date.";
	}
	if (relationNametb == false) {
		document.getElementById('editrelationnameError').innerHTML = "** Name cannot be Empty.";
	}

	if ((employeeIdtb == true) && (relationshiptb == true)
			&& (relationDateofbirthtb == true) && (relationNametb == true)) {
		var jsonData = {
			"employeeEpf" : fmemployeeId,
			"fmRelationship" : relationship,
			"fmDateofbirth" : relationDateofbirth,
			"fmName" : relationName,
			"fmOccupation" : occupation,
			"fmWorkingplace" : workingPlace
		};

		$.ajax({
			type : "POST",
			url : 'EmployeeController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "UPDATE_FAMILYMEMBER"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details updated successfully.") {
					clearFamilydetails();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}

}

function editclearFamilydetails() {
	$("#editrelationDateofbirth").val("");
	$("#editrelationName").val("");
	$("#editoccupation").val("");
	$("#editworkingPlace").val("");
	$("#editfmemployeeidError").text("");
	$("#editrelationshipError").text("");
	$("#editrelationbirthdateError").text("");
	$("#editrelationnameError").text("");
	$('#editrelationship option').prop('selected', function() {
		return this.defaultSelected;
	});
}

function getEmployeetoupdate() {
	var jsonData = 2;
	$.get("EmployeeController", function(data, status) {
		alert(data);
		json = JSON.parse(data);
	});

}