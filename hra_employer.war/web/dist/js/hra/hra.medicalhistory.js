/**
 * file - hra.medicalhistory.js
 * 
 * @auther -@TR
 * @git branch used - hra-15-add-medical-history-details-tr
 * @created on- 2016-05-25
 */

// ready function
$(document).on('ready', function() {
	$('#upload').prop('disabled', true);
	$('#uploadMedicalReportEdit').prop('disabled', true);
});

// number cheker
function isNumber(evt) {
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}

function isEmpty(value) {
	return (value == null || value.length === 0);
}

function isValidImage() {
	if (document.getElementById("avatar").files.length == 0) {
		return true;
	}
}

function isValidMedicalreportImage() {
	if (document.getElementById("avatarMedicalReportEdit").files.length == 0) {
		return true;
	}
}
/*******************************************************************************
 * START ADD MEDICAL HISTORY thumeera Get data and sent to
 * EmployeeController.java MedicalHistory > new MedicalHistory > more details >
 * add new in MedicalHistory > SAVE
 ******************************************************************************/

function addMedicalhistorydetails() {

	var noError = true;
	var message = "";

	var employeeId = $("#employeeId").val();
	var employeeAilment = $("#employeeAilment").val();
	var ailmentDescription = $("#ailmentDescription").val();

	var ehReferencemodby = $("#ehReferencemodby").val();

	var hasEmptyemployeeid = isEmpty(employeeId);
	var hasEmptyemployeeailment = isEmpty(employeeAilment);
	var hasEmptyailmentDescription = isEmpty(ailmentDescription);

	var hasEmptyehReferencemodby = isEmpty(ehReferencemodby);

	if (hasEmptyemployeeid) {
		message = "Employee id cannot be empty";
		noError = false;
		alert(message);
	} else if (hasEmptyemployeeailment) {
		message = "Ailment cannot be empty";
		noError = false;
		alert(message);
	} else if (hasEmptyailmentDescription) {
		message = "Ailment Description cannot be empty";
		noError = false;
		alert(message);
	} else if (hasEmptyehReferencemodby) {
		message = "User authentication fails";
		noError = false;
		alert(message);
	}

	if (noError) {
		var formData = {
			"medicalHistoryemployeeid" : employeeId,
			"medicalHistoryailment" : employeeAilment,
			"medicalHistorydescription" : ailmentDescription,
			"medicalHistorymodby" : ehReferencemodby,
			"medicalHistorycrtby" : ehReferencemodby,
		};

		$.ajax({
			type : "POST",
			url : 'EmployerController',
			data : {
				jsonData : JSON.stringify(formData),
				task : "AMH"
			},
			dataType : "JSON",
			success : function(data) {

				alert(data);
				$('#save').prop('disabled', true);
				$('#upload').prop('disabled', false);

				$('#employeeId').attr('disabled', true);
				$('#employeeAilment').attr('disabled', true);
				$('#ailmentDescription').attr('disabled', true);

				if (data == "Details added successfully.") {
					// clearMedicalHisory();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}

}

/*******************************************************************************
 * END ADD MEDICAL HISTORY
 ******************************************************************************/

$(document).on("click", "#upload", function() {

	var noError = true;
	var message = "";

	var reportDescription = $("#reportDescription").val();
	var ehReferencemodby = $("#ehReferencemodby").val();
	var employeeId = $("#employeeId").val();

	// Getting the properties of file from file field
	var reportUpload = $("#avatar").prop("files")[0];
	// Creating object of FormData class
	// and appending every attributes
	var formData = new FormData();
	formData.append("file", reportUpload);
	formData.append("reportDescription", reportDescription);
	formData.append("task", "AMR");
	formData.append("ehReferencemodby", ehReferencemodby);
	formData.append("employeeId", employeeId);

	var hasReportdescription = isEmpty(reportDescription);
	var hasReportupload = isValidImage();

	if (hasReportdescription) {
		message = "Report description cannot be empty";
		noError = false;
		alert(message);
	} else if (hasReportupload) {
		message = "Please upload your file(s)";
		noError = false;
		alert(message);
	}

	if (noError) {

		$.ajax({
			type : "POST",
			url : "EmployerController",

			data : formData, // Setting the data attribute of ajax with
			// file_data
			cache : false,
			contentType : false,
			processData : false,
			dataType : "JSON",
			success : function(data) {
				alert(data);

				clearMedicalHisory();

				$('#save').prop('disabled', false);
				$('#upload').prop('disabled', true);

				$('#employeeId').attr('disabled', false);
				$('#employeeAilment').attr('disabled', false);
				$('#ailmentDescription').attr('disabled', false);

				if (data == "Details added successfully.") {
					// clearMedicalReports();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
});

/*******************************************************************************
 * Start Clear medical history data
 ******************************************************************************/

function clearMedicalHisory() {
	$('.fileinput').fileinput('reset');

	$("#employeeId").val("");
	$("#employeeAilment").val("");
	$("#ailmentDescription").val("");

	$('#employeeAilment option').prop('selected', function() {
		return this.defaultSelected;
	});

	$("#reportDescription").val("");

	$('#upload').prop('disabled', true);

}
/*******************************************************************************
 * End Clear medical history data
 ******************************************************************************/
var medicalCode;
var medicalEmployeeid;
var medicalAilment;
var medicalDescription;
var employeeAilment;

function loadeditMedicalHIstoryDetails() {

	var employeeData = {
		"employeeIdEdit" : empEpf,
	};

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			inputValue : empEpf,
			jsonData : JSON.stringify(employeeData),
			task : "GMH"
		},
		dataType : "json",
		success : function(data) {

			json = JSON.parse(data);

			if (json.medicalHistoryailment == 'undefined') {
				isedit = false;
			}
			// alert("Employee id:"+json.medicalHistoryemployeeid);
			// alert("Code:"+json.medicalHistorycode);
			// alert("Ailment:"+json.medicalHistoryailment);
			alert("Description:" + json.medicalHistorydescription);
			//

			medicalCode = json.medicalHistorycode;
			medicalEmployeeid = json.medicalHistoryemployeeid;
			medicalAilment = json.medicalHistoryailment;
			medicalDescription = json.medicalHistorydescription;
			employeeAilment = json.medicalHistoryailment;

			$("#codeEdit").val(json.medicalHistorycode);
			$("#employeeIdEdit").val(json.medicalHistoryemployeeid);
			$("#employeeAilmentedit").val(json.medicalHistoryailment);
			$("#ailmentDescriptionedit").val(json.medicalHistorydescription);

			loadeditMedicalReportDetails();

			// $("#btnSaveeditEmpHistory").hide();
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}

function loadeditMedicalReportDetails() {

	alert("Code:" + medicalCode);

	var employeeData = {
		"medicalCode" : medicalCode,
	};

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			inputValue : medicalCode,
			jsonData : JSON.stringify(employeeData),
			task : "GMR"
		},
		dataType : "json",
		success : function(data) {

			json = JSON.parse(data);

			var description = json.reportDescription;
			var path = json.reportPath;
			path = "http://localhost/hras" + path;
			alert("path:" + path + " description:" + description);
			$("#reportDescriptionEdit").val(description);

			// medical history load
			$("#codeEdit").val(medicalCode);
			$("#employeeIdEdit").val(medicalEmployeeid);
			$("#employeeAilmentedit").val(medicalAilment);
			$("#ailmentDescriptionedit").val(medicalDescription);

			// $(this).attr('src', path);
			$('.changesrc').attr('src', path);
			// $("#reportDescriptionEdit").val(path);

			// $("#btnSaveeditEmpHistory").hide();
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}

// update medical Details
function updateMedicalHistoryDetails() {

	var noError = true;
	var message = "";

	var employeeId = $("#employeeIdEdit").val();
	var employeeAilment = $("#employeeAilmentedit").val();
	var ailmentDescription = $("#ailmentDescriptionedit").val();

	var ehReferencemodby = $("#ehReferencemodby").val();

	var hasEmptyemployeeid = isEmpty(employeeId);
	var hasEmptyemployeeailment = isEmpty(employeeAilment);
	var hasEmptyailmentDescription = isEmpty(ailmentDescription);

	var hasEmptyehReferencemodby = isEmpty(ehReferencemodby);

	if (hasEmptyemployeeid) {
		message = "Employee id cannot be empty";
		noError = false;
		alert(message);
	} else if (hasEmptyemployeeailment) {
		message = "Ailment cannot be empty";
		noError = false;
		alert(message);
	} else if (hasEmptyailmentDescription) {
		message = "Ailment Description cannot be empty";
		noError = false;
		alert(message);
	} else if (hasEmptyehReferencemodby) {
		message = "User authentication fails";
		noError = false;
		alert(message);
	}

	if (noError) {
		var formData = {
			"medicalHistoryemployeeid" : employeeId,
			"medicalHistoryailment" : employeeAilment,
			"medicalHistorydescription" : ailmentDescription,
			"medicalHistorymodby" : ehReferencemodby,
			"medicalHistorycrtby" : ehReferencemodby,
		};

		$.ajax({
			type : "POST",
			url : 'EmployerController',
			data : {
				inputValue : employeeId,
				jsonData : JSON.stringify(formData),
				task : "UMH"
			},
			dataType : "JSON",
			success : function(data) {

				alert(data);
				$('#save').prop('disabled', true);
				$('#uploadMedicalReportEdit').prop('disabled', false);

				$('#employeeAilment').attr('disabled', true);
				$('#ailmentDescription').attr('disabled', true);

				if (data == "Details added successfully.") {
					// clearMedicalHisory();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}

}

$(document).on("click", "#uploadMedicalReportEdit", function() {

	//alert(1);

	var noError = true;
	var message = "";

	var reportDescription = $("#reportDescriptionEdit").val();
	var ehReferencemodby = $("#ehReferencemodby").val();
	var employeeId = $("#medicalHistoryemployeeid").val();

	// Getting the properties of file from file field
	var reportUpload = $("#avatarMedicalReportEdit").prop("files")[0];
	// Creating object of FormData class
	// and appending every attributes
	var formData = new FormData();
	formData.append("file", reportUpload);
	formData.append("reportDescription", reportDescription);
	formData.append("task", "UMR");
	formData.append("ehReferencemodby", ehReferencemodby);
	formData.append("employeeId", employeeId);
	formData.append("inputValue", medicalCode);

	var hasReportdescription = isEmpty(reportDescription);
	var hasReportupload = isValidMedicalreportImage();

	if (hasReportdescription) {
		message = "Report description cannot be empty";
		noError = false;
		alert(message);
	} else if (hasReportupload) {
		message = "Please upload your file(s)";
		noError = false;
		alert(message);
	}

	if (noError) {

		$.ajax({
			type : "POST",
			url : "EmployerController",

			data : formData, // Setting the data attribute of ajax with
			// file_data
			cache : false,
			contentType : false,
			processData : false,
			dataType : "JSON",
			success : function(data) {
				alert(data);

				clearMedicalHisory();

				$('#save').prop('disabled', false);
				$('#upload').prop('disabled', true);

				$('#employeeAilmentedit').attr('disabled', false);
				$('#ailmentDescriptionedit').attr('disabled', false);

			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
});
