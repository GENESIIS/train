/**
 * file - hra.medicalScheme.js
 * 
 */

$(document).on("click", "#billUpload", function() {

	var noError = true;
	var message = "";

	var billDescription = $("#billDescription").val();
	var ehReferencecrtby = $("#ehReferencecrtby").val();
	var employeeId = $("#employeeId").val();

	// Getting the properties of file from file field
	var reportUpload = $("#avatar").prop("files")[0];

	// Creating object of FormData class
	// and appending every attributes
	var formData = new FormData();
	formData.append("file", reportUpload);
	formData.append("billDescription", billDescription);
	formData.append("task", "AMB");
	formData.append("ehReferencecrtby", ehReferencecrtby);
	formData.append("employeeId", employeeId);

	var hasBilldescription = isEmpty(billDescription);
	var hasBillload = isValidImage();

	if (hasBilldescription) {
		message = "Bill description cannot be empty";
		noError = false;
		alert(message);
	} else if (hasBillload) {
		message = "Please upload your file(s)";
		noError = false;
		alert(message);
	}

	if (noError) {

		// var formData2 = {
		// "reportDescription" : reportDescription,
		// "task" : "AMR",
		// "medicalHistorymodby" : ehReferencemodby,
		// "medicalHistorycrtby" : ehReferencemodby,
		// "employeeId" : employeeId,
		// };
		$.ajax({
			type : "POST",
			url : "EmployerController",
			data : {
				jsonData : JSON.stringify(formData),
				task : "AMB",
				reportUpload : reportUpload,
			},
			data : formData, // Setting the data attribute of ajax with
			// file_data
			cache : false,
			contentType : false,
			processData : false,
			dataType : "JSON",
			success : function(data) {
				alert(data);

				clearMedicalHisory();

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

function clearMedicalHisory() {
	$('.fileinput').fileinput('reset');

	$("#billDescription").val("");

}
