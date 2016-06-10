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




//@AS
function loadContentqualifications() {
	$("#modelrest").load("employeeDetails/educationalDetails.jsp");
}
//@AS - load more edit Employeee Detail
//function loadEditContentqualifications() {
//	$("#Editmodelrest").load("editEmployeeDetails/editEducationalDetails.jsp");
//	//loadeditEducationalDetails();
//}
function loadEditContentqualifications1() {
$("#Editmodelrest").load("newfolder/editStudyPrograms.jsp");
//loadeditEducationalDetails();
}

//@PC
function loadBasicTable() {
	$("#basicTable").load("TableDetail/serchBasic.jsp");
}
//@PC
function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("editEmployeeDetails/editStudyPrograms.jsp");
}

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
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
	alert("Data Added Successfully.");
}

function updatedAlert() {
	alert("Data Updated Successfully.");
}
	
// ////load more edit Employeee Detail///////////////

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
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

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("editEmployeeDetails/editStudyPrograms.jsp");
}

function loadEditlanguages() {
	$("#Editmodelrest").load("editEmployeeDetails/EditlanguageProficiency.jsp");
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


function loadEditemergencycontacts() {
	$("#Editmodelrest").load("editEmployeeDetails/editEmergencyContacts.jsp");
}
