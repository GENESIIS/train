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

function updateStudyProgram(){
	
	var employeeEpf = empEpf;
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
			task : "USP",
			inputValue : empEpf,
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
function loadEditContentStudyProgram(){
	
	$.get("EmployerController", {
		serchVlaue : data.employeeEpf,
		task : "GSP"
	},
			function(data, status) {

				alert(data);
				json1 = JSON.parse(data);
				json = JSON.parse(json1);
				$(".modal-body #employeeNumberEdit").val(
						json.employeeEpf);
				$(".modal-body #employeeNameEdit").val(
						json.institution);
				$(".modal-body #employeeDesignationEdit").val(
						json.typofCourse);
				$(".modal-body #employeeEmailEdit").val(
						json.admissionDate);
				$(".modal-body #employeeDateofBothEdit").val(
						json.ProgramEndDate);
				$(".modal-body #employeeNICEdit").val(
						json.duration);
				$(".modal-body #employeeNICEdit").val(
						json.employeeNic);


				if (json.employeeGender == 'M') {
					$(".modal-body #employeeGenderEdit")
							.val('Male');
				} else {
					$(".modal-body #employeeGenderEdit").val(
							'Female');
				}

				$(".modal-body #employeeAddressEdit").val(
						json.employeePermenetaddress);
				$(".modal-body #employeeTempADDEdit").val(
						json.employeeTemporaryaddress);
				$(".modal-body #employeeMobileNumberEdit").val(
						json.employeeMobile);
				$(".modal-body #employeeOtherNumberEdit").val(
						json.employeeTelephone);
				$(".modal-body #employeeDepartmentEdit").val(
						json.employeeDepartment);
				$(".modal-body #employeeJoinDateEdit").val(
						json.employeeJoindate);
				$(".modal-body #employeeMaritalEdit").val(
						json.employeeMaritalstatus);
				$(".modal-body #employeeEPFEdit").val(
						json.employeeEpf);
			});
}
function loadViewStudyProgramsDetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}