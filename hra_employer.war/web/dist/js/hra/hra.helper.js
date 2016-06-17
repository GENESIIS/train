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

//@PN
function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
};
//@PN
function loadContentEmployee() {
	$("#mainContent").load("manageEmployee.jsp");
};
//@PN
function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
};
//@AS
function loadViewEmployee() {
	$("#mainContent").load("ViewemployeeDetails/viewEmployeeDetails.jsp");
	loademployeeDetails();
}


//Load more details contents
function loadfamilydetails() {
	$("#modelrest").load("employeeDetail/addFamilyDetails.jsp");
}
//@TR
function loadAddEmployementHIstoryDetails() {
	$("#modelrest").load("employeeDetail/addEmployeeHistory.jsp");
}
//@AS
function loadContentqualifications() {
	$("#modelrest").load("employeeDetail/educationalDetails.jsp");
}
//@TR - Employee > new employee > more details > add Medical history details 
function loadAddMedicalHIstoryDetails() {
	$("#modelrest").load("employeeDetail/addMedicalHistory.jsp");
}
function loadAddStudyProgramsDetails() {
	$("#modelrest").load("employeeDetail/addStudyPrograms.jsp");
}



//@PC
function loadBasicTable() {
	$("#basicTable").load("TableDetail/serchBasic.jsp");
}





// Only for Sprint -1 demo.
function deleteAlert() {
	alert("Data Deleted Successfully.");
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
}

function updatedAlert() {
	alert("Data Updated Successfully.");
}
	
// ////load more edit Employeee Detail///////////////

function loadEditlanguages() {
	$("#Editmodelrest").load("employeeDetailEdit/EditlanguageProficiency.jsp");
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("employeeDetailEdit/editStudyPrograms.jsp");
}

function loadEditemergencycontacts() {
	$("#Editmodelrest").load("employeeDetailEdit/editEmergencyContacts.jsp");
}
//@PC
function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("employeeDetailEdit/editStudyPrograms.jsp");
}
//@TR
function loadEditlanguages() {
	$("#Editmodelrest").load("employeeDetailEdit/editLanguageProficiency.jsp");
}
//@PN
function loadEditContentfamilydetails() {
	alert("loadEditContentfamilydetails");
	getEmployeetoupdate();
	$("#Editmodelrest").load("employeeDetailEdit/editFamilyDetails.jsp");
}
//@TR
function loadEditEmployementHIstoryDetails() {
	$("#Editmodelrest").load("employeeDetailEdit/editEmployeeHistory.jsp");
	loadEditContentEmployeeHistoryDetails();
}
//@AS - load more edit Employeee Detail
function loadEditContentqualifications() {
	$("#Editmodelrest").load("employeeDetailEdit/editEducationalDetails.jsp");
	loadeditEducationalDetails();
}
// @TR - Employee > edit employee > more details > edit medical history details 
function loadEditMedicalHIstoryDetails() {
	var isedit=true;
	loadeditMedicalHIstoryDetails();
	
	if(isedit){
		$("#Editmodelrest").load("employeeDetailEdit/editMedicalHistory.jsp");
	}
	else{
		alert("Previously you dont have  medical history Please Add it here!");
		$("#Editmodelrest").load("employeeDetail/addMedicalHistory.jsp");
	}
	
	
	
}





// ///////////////////////////////////////////////

$("#buttonAddemployee").click(function() {
	alert(this.id);
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
//@AS
function loadviewemployementhistory() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemployementHistory.jsp");
}
function loadViewStudyProgramsDetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}
