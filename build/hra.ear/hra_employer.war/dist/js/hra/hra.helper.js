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

function addedAlert() {
	alert("Data Added Successfully.");
	document.getElementById("moredetails").disabled = false;
	alert("Data Added Successfully.");
}

function updatedAlert() {
	alert("Data Updated Successfully.");
}

// load data to edit emplyee details no changed
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

// ////load more edit Employeee Detail///////////////

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}
// ///////////////////////////////////////////////

$("#buttonAddemployee").click(function() {
	alert(this.id);
});

// ////load more edit Employeee Detail///////////////
// ///////////////////////////////////////////////
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

function resetLabels() {
	var fmemployeeId = $("#fmemployeeId").val();
	var relationship = $("#relationship").val();
	var relationDateofbirth = $("#relationDateofbirth").val();
	var relationName = $("#relationName").val();

	var employeeIdtb = isEmptyfield(fmemployeeId);
	var relationshiptb = isEmptyfield(relationship);
	var relationDateofbirthtb = isPastdate(relationDateofbirth);
	var relationNametb = isEmptyfield(relationName);

	if (employeeIdtb == false) {
		document.getElementById('fmemployeeidError').innerHTML = "** Invalid EPF Number.";
	} else {
		document.getElementById('fmemployeeidError').innerHTML = "";
	}
	if (relationshiptb == false) {
		document.getElementById('relationshipError').innerHTML = "** Relationship can not be Empty.";
	} else {
		document.getElementById('relationshipError').innerHTML = "";
	}
	if (relationDateofbirthtb == false) {
		document.getElementById('relationbirthdateError').innerHTML = "** Invalid Birth Date.";
	} else {
		document.getElementById('relationbirthdateError').innerHTML = "";
	}
	if (relationNametb == false) {
		document.getElementById('relationnameError').innerHTML = "** Name cannot be Empty.";
	} else {
		document.getElementById('relationnameError').innerHTML = "";
	}
}

function loadEditContentqualifications() {
	$("#Editmodelrest").load("EditemployeeDetails/EditeducationalDetails.jsp");
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("EditemployeeDetails/EditstudyPrograms.jsp");
}

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}

// ///load more employee views/////////////////////////////////////

function loadviewqlifications() {
	$("#viewmodelrest").load("viewemployeeDetails/vieweducationalDetails.jsp");
}

function loadviewstudyprograms() {
	$("#viewmodelrest").load("viewemployeeDetails/viewstudyPrograms.jsp");
}

function loadviewlanguages() {
	$("#viewmodelrest").load("viewemployeeDetails/viewlanguageProficiency.jsp");
}

function loadviewfamilydetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewfamilyDetails.jsp");
}
function loadviewemergencycontacts() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemergencyContacts.jsp");
}

function loadEditContentfamilydetails() {
	$("#Editmodelrest").load("EditemployeeDetails/EditfamilyDetails.jsp");
}
function loadEditemergencycontacts() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemergencyContacts.jsp");
}
