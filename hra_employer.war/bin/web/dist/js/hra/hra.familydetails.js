// Load more details contents
function loadfamilydetails() {
	$("#modelrest").load("familyDetails/familyDetails.jsp");
}

function loadEditContentfamilydetails() {
	$("#Editmodelrest").load("familyDetails/editfamilyDetails.jsp");
	getEmployeetoupdate();
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
	var fmemployeeId = 2;

	var jsonData = {
			"employeeEpf" : fmemployeeId,
		};
	
	// $.getJSON('EmployeeController', {
	// // 'jsonData' : jsonData
	// }, function(response) {
	// alert(response);
	// });

	alert("gone");
	
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