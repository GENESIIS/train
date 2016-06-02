/**
 * 20160407 PN HRA-1 created hra.helper.js class. 20160415 PN HRA-1 Modified
 * addEmployeeDetails() Function. 20160429 PN HRA-3 addDepartmentDetails()
 * function Modified. 20160505 PN HRA-2 clearAddemployeeform() function
 * modified. 20160509 addEducationDetails() Function
 */

var theNewScript = document.createElement("script");
theNewScript.type = "text/javascript";
theNewScript.src = "hra.validation.js";

function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
}

function loadContentEmployee() {
	$("#mainContent").load("manageEmployee.jsp");
}

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
}
function loadContentqualifications() {
	$("#modelrest").load("employeeDetails/educationalDetails.jsp");
}
function loadViewEmployee() {
	$("#mainContent").load("ViewemployeeDetails/viewEmployeeDetails.jsp");
	loademployeeDetails();

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

// Get Departments for Add Employee Form
function getDepartment() {
	$.get('EmployeeController', {}, function(data) {
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
// ////load more edit Employeee Detail///////////////

function loadEditContentqualifications() {
	$("#Editmodelrest").load("\EditemployeeDetails/EditeducationalDetails.jsp");

}

function loadEditemployementhistory() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemployementHistory.jsp");
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("EditemployeeDetails/EditstudyPrograms.jsp");

}

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}

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

	var emptyfield = isEmptyfield(fmemployeeId);
	var emptydropdown = isEmptyfield(relationship);

	alert(emptyfield + emptydropdown);

}

function clearFamilydetails() {
	$("#fmemployeeId").val();
	$("#relationDateofbirth").val();
	$("#relationName").val();
	$("#occupation").val();
	$("#workingPlace").val();
}

// ////Add Education Details /////////

function AddEducationDetails() {
	var employeeId = $("#employeeId").val();
	var qualificationName = $("#qualificationName").val();
	var educatedPlace = $("#educatedPlace").val();
	var mediumStudied = $("#mediumStudied").val();
	var startedOn = $("#startedOn").val();
	var compleatedOn = $("#compleatedOn").val();
	var studyTime = checkStudyTime();

	var EducationData = {
		"employeeEpf" : employeeId,
		"eduQualification" : qualificationName,
		"eduUniversity" : educatedPlace,
		"eduMedium" : mediumStudied,
		"eduStartedon" : startedOn,
		"eduCompltedon" : compleatedOn,
		"eduStudytime" : studyTime

	};
	alert(JSON.stringify(EducationData));

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(EducationData),
			task : "ADD"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
				clearAddeducationform();
				// document.getElementById("moredetails").disabled = false;
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}

function clearAddeducationform() {
	$("#employeeId").val("");
	$("#qualificationName").val("");
	$("#educatedPlace").val("");
	$("#mediumStudied").val("");
	$("#startedOn").val("");
	$("#compleatedOn").val("");
	$("#institution").val("");
	$("#courseType").val("");
	$("#admissionDate").val("");
	$("#duration").val("");
	$("#weekdays").attr('checked', false);
	$("#weekends").attr('checked', false);

}
// Check Study time
function checkStudyTime() {
	if ((document.getElementById('weekdays').checked)
			&& (document.getElementById('weekends').checked)) {
		return 1;
	} else if (document.getElementById('weekends').checked) {
		return 2;
	} else if (document.getElementById('weekdays').checked) {
		return 3;
	} else {
		return 4;
	}
}

// ///Load data to edit Educational Details

function loadDataEducationalDetails() {

	var jsonData = "1";
	$.getJSON('EmployeeController', {
		jsonData : JSON.stringify(jsonData),
		task : "FIND"
	}, function(data) {
		json = JSON.parse(data);
		$("#employeeId").val(json.employeeEpf);
		$("#qualificationName").val(json.eduQualification);
		$("#educatedPlace").val(json.eduUniversity);
		$("#mediumStudied").val(json.eduMedium);
		$("#startedOn").val(json.eduStartedon);
		$("#compleatedOn").val(json.eduCompltedon);

		if (json.eduStudytime == 1) {
			document.getElementById("weekdays").checked;
			document.getElementById("weekends").checked;
		} else if (json.eduStudytime == 2) {
			document.getElementById("weekdays").checked;
		} else if (json.eduStudytime == 3) {
			document.getElementById("weekends").checked;
		} else {
			// do nothing
		}
	});

}

// /////Edit Educational Details ////////
function EditEducationDetails() {
	var employeeId = $("#employeeId").val();
	var qualificationName = $("#qualificationName").val();
	var educatedPlace = $("#educatedPlace").val();
	var mediumStudied = $("#mediumStudied").val();
	var startedOn = $("#startedOn").val();
	var compleatedOn = $("#compleatedOn").val();
	var studyTime = checkStudyTime();

	var EducationData = {
		"employeeEpf" : employeeId,
		"eduQualification" : qualificationName,
		"eduUniversity" : educatedPlace,
		"eduMedium" : mediumStudied,
		"eduStartedon" : startedOn,
		"eduCompltedon" : compleatedOn,
		"eduStudytime" : studyTime
	};
	// alert(JSON.stringify(EducationData));

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(EducationData),
			task : "UPDATE"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details Updated successfully.") {
				clearAddeducationform();
				// document.getElementById("moredetails").disabled = false;
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}
// ///////////////// load employee details//////////////////////

function loademployeeDetails() {

	var serchContent = "1";

	var jsonData = {
		"serchContent" : serchContent
	};

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "GETBASIC"
		},
		dataType : "json",
		success : function(responseText) {
			// alert("ajax" + responseText);
			json = JSON.parse(responseText);
			// alert(responseText);
			$("#employee_id").text(json.employeeEpf);
			$("#name").text(json.employeeName);
			$("#mobilenumber").text(json.employeeMobile);
			$("#landnumber").text(json.employeeTelephone);
			$("#mobilenumber1").text(json.employeeMobile);
			$("#landnumber1").text(json.employeeTelephone);
			$("#work_email").text(json.employeeEmail);
			$("#work_email1").text(json.employeeEmail);
			$("#nic_num").text(json.employeeNic);
			$("#nic_num1").text(json.employeeNic);
			$("#birthday").val(json.employeeDateofbirth);
			// $("#gender").text(json.employeeGender);

			if (json.employeeGender == 'M') {
				$("#gender").text('Male');
			} else {
				$("#gender").text('Female');
			}

			$("#marital_status").text(json.employeeMaritalstatus);
			$("#address1").text(json.employeePermenetaddress);
			$("#address2").text(json.employeeTemporaryaddress);
			$("#job_title").text(json.employeeDesignation);
			$("#department_Name").text(json.employeeDepartment);
			$("#bassis").text(json.employeeBasis);
			$("#joindate").text(json.employeeJoindate);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}
// /////////////// load employee education details///////////////

function loadEducationDetails() {

	var serchContent = "1";

	var jsonData = {
		"serchContent" : serchContent
	};
	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "GETEDUCATION"
		},
		dataType : "json",
		success : function(responseText) {
			// alert("ajax" + responseText);
			json = JSON.parse(responseText);
			// alert(responseText + " " + json.eduUniversity + " "
			// + json.eduMedium + " " + json.eduStartedon + " "
			// + json.eduCompltedon);
			$("#employeeId").text(json.employeeEpf);
			$("#qualificationName").text(json.eduQualification);
			$("#educatedPlace").text(json.eduUniversity);
			$("#mediumStudied").text(json.eduMedium);
			$("#startedOn").text(json.eduStartedon);
			$("#compleatedOn").text(json.eduCompltedon);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}

// /////load family Details//////

function loadFamilyDetails() {
	var serchContent = "1";

	var jsonData = {
		"serchContent" : serchContent
	};
	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "GETFAMILY"
		},
		dataType : "json",
		success : function(responseText) {

			json = JSON.parse(responseText);

			$("#relationship").text(json.fmRelationship);
			$("#relationDateofbirth").text(json.fmDateofbirth);
			$("#relationName").text(json.fmName);
			$("#occupation").text(json.fmOccupation);
			$("#workingPlace").text(json.fmWorkingplace);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}
