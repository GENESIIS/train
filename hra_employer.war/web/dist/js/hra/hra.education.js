/**
 * @auther -AS
 * @git HRA-11 HRA-24 add-edit-educationdetails
 * @created 2016/06/07
 * 
 */

// Add Education Details
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
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(EducationData),
			task : "AED"
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
// Clear Function Education Details
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
// Check study time and returns Value
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

// Load data to edit Educational Details
function loadeditEducationalDetails() {

	var jsonData = "1";
	$.getJSON('EmployerController', {
		jsonData : JSON.stringify(jsonData),
		inputValue : empEpf,
		task : "GED"
	}, function(data) {
		json = JSON.parse(data);
		alert(data + "		" + json);

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
	alert(JSON.stringify(EducationData));

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(EducationData),
			task : "UED"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
				clearLoanDetails();
			}
		},
		error : function(e) {
			// alert("Error " + e);
			console.log(e);
		}
	});
}

// /////////////// load employee education details///////////////
function loadDataEducationalDetails() {

	var serchContent = "1";

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(1),
			inputValue : empEpf,
			task : "GED"
		},
		dataType : "json",
		success : function(responseText) {
			json = JSON.parse(responseText);
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
		},
	});

}
