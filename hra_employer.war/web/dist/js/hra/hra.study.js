function loadAddStudyProgramsDetails() {
	$("#modelrest").load("employeeDetails/addStudyPrograms.jsp");
}

function loadViewStudyProgramsDetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}

// View Study details
function viewStudyDetails() {

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify("1"),
			serchVlaue : empEpf,
			task : "GSP"
		},
		dataType : "json",
		success : function(responseText) {
			// alert("ajax" + responseText);
			json = JSON.parse(responseText);
			$("#Institution").text(json.institution);
			$("#CourseType").text(json.typofCourse);
			$("#AdmissionDate").text(json.admissionDate);
			$("#ProgramEndDate").text(json.ProgramEndDate);
			$("#Duration").text(json.duration);

			if (json.studyTime == '1') {
				document.getElementById("StWeekdays").checked = true;
				document.getElementById("StWeekends").checked = true;
			} else if (json.studyTime == '2') {
				document.getElementById("StWeekdays").checked = true;
			} else if (json.studyTime == '3') {
				document.getElementById("StWeekends").checked = true;
			} else {
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}