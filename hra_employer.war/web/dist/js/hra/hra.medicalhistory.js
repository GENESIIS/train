/**
 * file - hra.medicalhistory.js
 * 
 * @auther -@TR
 * @git branch used - hra-15-add-medical-history-details-tr
 * @created on- 2016-05-25
 */
// ready function
// $(document).on('ready', function() {
// $("#input-6").fileinput({
// showUpload : false,
// maxFileCount : 10,
// mainClass : "input-group-lg"
// });
// });
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

function loadTestDetails() {
	$("#modelrest").load("test/index.jsp");
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
			url : 'EmployeeController',
			data : {
				jsonData : JSON.stringify(formData),
				task : "AMH"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearMedicalHisory();
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

function addMedicalreportdetails() {

	var noError = true;
	var message = "";

	var reportDescription = $("#reportDescription").val();
	var reportUpload = $("#input-6").val();
	var ehReferencemodby = $("#ehReferencemodby").val();

	var hasReportdescription = isEmpty(reportDescription);
	var hasReportupload = isEmpty(reportUpload);
	var hasReferencemodby = isEmpty(ehReferencemodby);

	if (hasReportdescription) {
		message = "Report description cannot be empty";
		noError = false;
		alert(message);
	} else if (hasReportupload) {
		message = "Report upload be empty";
		noError = false;
		alert(message);
	} else if (hasReferencemodby) {
		message = "User authentication fails";
		noError = false;
		alert(message);
	}

	if (noError) {

		var formData = {
			"reportDescription" : reportDescription,
			"reportUpload" : reportUpload,
			"medicalHistorymodby" : ehReferencemodby,
			"medicalHistorycrtby" : ehReferencemodby,
		};

		$.ajax({
			type : "POST",
			url : 'EmployeeController',
			data : {
				jsonData : JSON.stringify(formData),
				jsonData2 : JSON.stringify(formData2),
				task : "ADD_MEDICAL_HISTORY",
				task2 : "ADD_MEDICAL_HISTORY"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearMedicalHisory();
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
 * Start Clear medical history data
 */
function clearMedicalHisory() {
	$("#medicalHistoryailment").val("");
	$("#medicalHistorydescription").val("");
	$("#medicalHistoryailment").val("");
	$("#medicalHistorydescription").val("");
	$("#input-6").val("");
}
/*******************************************************************************
 * End Clear medical history data
 */

/**
 * beforeSend : this function called before form submission uploadProgress :
 * this function called when the upload is in progress success : this function
 * is called when the form upload is successful. complete: this function is
 * called when the form upload is completed.
 */

// $(document).ready(function() {
// var options = {
// beforeSend : function() {
// $("#progressbox").show();
// // clear everything
// $("#progressbar").width('0%');
// $("#message").empty();
// $("#percent").html("0%");
// },
// uploadProgress : function(event, position, total, percentComplete) {
// $("#progressbar").width(percentComplete + '%');
// $("#percent").html(percentComplete + '%');
//
// // change message text to red after 50%
// if (percentComplete > 50) {
// $("#message").html("<font color='red'>File Upload is in progress</font>");
// }
// },
// success : function() {
// $("#progressbar").width('100%');
// $("#percent").html('100%');
// },
// complete : function(response) {
// $("#message").html("<font color='blue'>Your file has been uploaded!</font>");
// },
// error : function() {
// $("#message").html("<font color='red'> ERROR: unable to upload
// files</font>");
// }
// };
// //$("#UploadForm").ajaxForm(options);
// });




