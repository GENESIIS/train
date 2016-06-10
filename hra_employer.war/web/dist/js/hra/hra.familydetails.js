// Load more details contents
//function loadfamilydetails() {
//	$("#modelrest").load("employeeDetails/addFamilyDetails.jsp");
//}

//function loadEditContentfamilydetails() {
//	getEmployeetoupdate();
//	$("#Editmodelrest").load("editEmployeeDetails/editFamilyDetails.jsp");
//}


//@TR - Load more details contents
function loadfamilydetails() {
	$("#modelrest").load("employeeDetails/addFamilyDetails.jsp");
}

//@TR
function loadEditContentfamilydetails() {
	$("#Editmodelrest").load("editEmployeeDetails/editFamilyDetails.jsp");
}


// ///Familydetails
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
			url : 'EmployerController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "AFM"
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
			url : 'EmployerController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "UFM"
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

function resetFieldsadd() {
	var fmemployeeId = $("#editfmemployeeId").val();
	var relationship = $("#editrelationship").val();
	var relationDateofbirth = $("#editrelationDateofbirth").val();
	var relationName = $("#editrelationName").val();

	var employeeIdtb = isEmptyfield(fmemployeeId);
	var relationshiptb = isEmptyfield(relationship);
	var relationDateofbirthtb = isPastdate(relationDateofbirth);
	var relationNametb = isEmptyfield(relationName);

	if (employeeIdtb == false) {
		document.getElementById('editfmemployeeidError').innerHTML = "** Invalid EPF Number.";
	} else {
		document.getElementById('editfmemployeeidError').innerHTML = "";
	}
	if (relationshiptb == false) {
		document.getElementById('editrelationshipError').innerHTML = "** Relationship can not be Empty.";
	} else {
		document.getElementById('editrelationshipError').innerHTML = "";
	}

	if (relationDateofbirthtb == false) {
		document.getElementById('editrelationbirthdateError').innerHTML = "** Invalid Birth Date.";
	} else {
		document.getElementById('editrelationbirthdateError').innerHTML = "";
	}
	if (relationNametb == false) {
		document.getElementById('editrelationnameError').innerHTML = "** Name cannot be Empty.";
	} else {
		document.getElementById('editrelationnameError').innerHTML = "";
	}
}

function getEmployeetoupdate() {
	
	alert(empEpf);
	
	var fmemployeeId = 2;

	var jsonData = {
		"employeeEpf" : fmemployeeId,
	};

	// $.getJSON('EmployeeController', {
	// // 'jsonData' : jsonData
	// }, function(response) {
	// alert(response);
	// });

	$.getJSON('EmployerController', {
		jsonData : JSON.stringify(jsonData),
		task : "GFM"
	}, function(data) {
		json = JSON.parse(data);
		$("#editfmemployeeId").val(json.employeeEpf);
		$("#editrelationDateofbirth").val(json.fmDateofbirth);
		$("#editrelationName").val(json.fmName);
		$("#editoccupation").val(json.fmOccupation);
		$("#editworkingPlace").val(json.fmWorkingplace);
		$("#editrelationship").val(json.fmRelationship);
	});

}

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

// ///load family Details//////

function loadFamilyDetails() {

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify("1"),
			serchVlaue : empEpf,
			task : "GF"
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