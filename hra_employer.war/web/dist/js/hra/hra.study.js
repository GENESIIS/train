function loadAddStudyProgramsDetails() {
	$("#modelrest").load("employeeDetails/addStudyPrograms.jsp");
}

// Check study time and returns Value
function checkStudyTime() {
	if ((document.getElementById('stWeekdays').checked)
			&& (document.getElementById('stWeekends').checked)) {
		return 1;
	} else if (document.getElementById('stWeekends').checked) {
		return 2;
	} else if (document.getElementById('stWeekdays').checked) {
		return 3;
	} else {
		return 4;
	}
}

function addStudyProgram(){
	
	var employeeEpf = $("#employeEpf").val();
	var institution = $("#institution").val();
	var typofCourse = $("#courseType").val();
	var admissionDate = $("#admissionDate").val();
	var ProgramEndDate = $("#ProgramEndDate").val();
	var duration = $("#duration").val();
	var studyTime = checkStudyTime();	

	var jsonData = {
		"employeeEpf" : employeeEpf,
		"institution" : institution,
		"typofCourse" : typofCourse,
		"admissionDate" : admissionDate,
		"ProgramEndDate" : ProgramEndDate,
		"duration" : duration,
		"studyTime" : studyTime,
	};

	alert(jsonData);
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "ASP",
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
				clearAddeducationform();
			} else {
				alert(data);
			};
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		},
	});
}

function loadViewStudyProgramsDetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}