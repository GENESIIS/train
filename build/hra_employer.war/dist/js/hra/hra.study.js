function loadAddStudyProgramsDetails() {
	$("#modelrest").load("employeeDetails/addStudyPrograms.jsp");
}
function loadEditStudyProgramsDetails() {
	loadEditContentStudyProgram();
	$("#Editmodelrest").load("editEmployeeDetails/editStudyPrograms.jsp");
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

//Check study time and returns Value for edit
function checkEditedStudyTime() {
	if ((document.getElementById('editStWeekdays').checked)
			&& (document.getElementById('editStWeekends').checked)) {
		return 1;
	} else if (document.getElementById('editStWeekdays').checked) {
		return 2;
	} else if (document.getElementById('editStWeekends').checked) {
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
				clearAddStudyProgramform();
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

function updateStudyProgram(){
	
	var employeeEpf = empEpf;
	var institution = $("#editInstitution").val();
	var typofCourse = $("#editCourseType").val();
	var admissionDate = $("#editAdmissionDate").val();
	var ProgramEndDate = $("#editProgramEndDate").val();
	var duration = $("#editDuration").val();
	var studyTime = checkEditedStudyTime();	

	var jsonData = {
		"employeeEpf" : employeeEpf,
		"institution" : institution, 
		"typofCourse" : typofCourse,
		"admissionDate" : admissionDate,
		"ProgramEndDate" : ProgramEndDate,
		"duration" : duration,
		"studyTime" : studyTime,
	}; 

	alert( JSON.stringify(jsonData));
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "USP",
			inputValue : empEpf,
		},
		dataType : "json",
		success : function(data) {			
			if (data == "Details added successfully.") {
				clearEditStudyProgramform();
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
function loadEditContentStudyProgram(){
	
	$.get("EmployerController", {
		inputValue : empEpf,
		task : "GSP"
	},
			function(data, status) {

				alert(data);
				json = JSON.parse(JSON.parse(data));
				$("#editEmployeEpf").val(
						json.employeeEpf);
				$("#editInstitution").val(
						json.institution);
				$("#editCourseType").val(
						json.typofCourse);
				$("#editAdmissionDate").val(
						json.admissionDate);
				$("#editProgramEndDate").val(
						json.ProgramEndDate);
				$("#editDuration").val(
						json.duration);
				
				if (json.studyTime == '1') {
					document.getElementById("editStWeekdays").checked = true;
					document.getElementById("editStWeekends").checked = true;
				} else if (json.studyTime == '2') {
					document.getElementById("editStWeekdays").checked = true;
				} else if (json.studyTime == '3') {
					document.getElementById("editStWeekends").checked = true;
				} else {
				}				
			});
}

//Clear Function Education Details
function clearAddStudyProgramform() {
	$("#editInstitution").val("");
	$("#editCourseType").val("");
	$("#editAdmissionDate").val("");
	$("#editProgramEndDate").val("");
	$("#editDuration").val("");	
	$("#editStWeekdays").attr('checked', false);
	$("#editStWeekends").attr('checked', false);

}
function clearEditStudyProgramform() {
	$("#institution").val("");
	$("#courseType").val("");
	$("#admissionDate").val("");
	$("#ProgramEndDate").val("");
	$("#duration").val("");	
	$("#stWeekdays").attr('checked', false);
	$("#stWeekends").attr('checked', false);

}
