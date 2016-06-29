/**
 * file - hra.medicalScheme.js 20160627
 * 
 * @JH
 * 
 */

// check the file fo null value
function isValidImage() {
	if (document.getElementById("avatar").files.length == 0) {
		return true;
	}
}

//check the bill description is empty
function isEmpty(value) {
	return (value == null || value.length === 0);
}

$(document).on("click", "#uploadBill", function() {

	var noError = true;
	var message = "";

	var billDescription = $("#billDescription").val();
	var ehReferencemodby = $("#ehReferencemodby").val();
	var employeeId = $("#employeeId").val();

	// Getting the properties of file from file field
	var billUpload = $("#avatar").prop("files")[0];

	// Creating object of FormData class
	// and appending every attributes
	var formData = new FormData();
	formData.append("file", billUpload);
	formData.append("billDescription", billDescription);
	formData.append("task", "AMB");
	formData.append("ehReferencemodby", ehReferencemodby);
	formData.append("employeeId", employeeId);

	var hasBilldescription = isEmpty(billDescription);
	var hasBillupload = isValidImage();

	if (hasBilldescription) {
		message = "Bill description cannot be empty.";
		noError = false;
		alert(message);
	} else if (hasBillupload) {
		message = "Please upload your file(s)";
		noError = false;
		alert(message);
	}

	if (noError) {
		$.ajax({
			type : "POST",
			url : "EmployerController",
			// task : "AMB",
			data : formData, // Setting the data attribute of ajax with
			// file_data
			cache : false,
			contentType : false,
			processData : false,
			dataType : "JSON",
			success : function(data) {
				alert(data);

				clearMedicalHisory();
				if (data == "File uploaded successfully.") {
					// clearMedicalBills();
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
