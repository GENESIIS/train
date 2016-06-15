function isValidEmployeeImage() {
	if (document.getElementById("avatarEmployee").files.length == 0) {
		return true;
	}
}

// Get data and sent to EmployerController.java.
function addEmployeeDetails() {
	var fname = $("#employeeFirstname").val();
	var mname = $("#employeeMiddlename").val();
	var lname = $("#employeeLastname").val();

	var employeeFirstname = fname + "," + mname + "," + lname;
	var employeeDateofbirth = $("#employeeDateofbirth").val();
	var employeeNic = $("#employeeNic").val();
	var employeeGender = $("#employeeGender").val();
	var employeeMaritalstatus = $("#employeeMaritalstatus").val();
	var employeeEpf = $("#employeeEpf").val();
	var employeeBasis = $("#employeeBasis").val();
	var employeeDesignation = $("#employeeDesignation").val();
	var employeeDepartment = $("#employeeDepartment").val();
	var employeePermenetaddress = $("#employeePermenetaddress").val();
	var employeeTemporaryaddress = $("#employeeTemporaryaddress").val();
	var employeeTelephone = $("#employeeTelephone").val();
	var employeeMobile = $("#employeeMobile").val();
	var employeeEmail = $("#employeeEmail").val();
	var employeeJoindate = $("#employeeJoindate").val();

	var employeeFirstnameerror = $("#employeeFirstnameerror").text();
	var employeeMiddlenameerror = $("#employeeMiddlenameerror").text();
	var employeeLastnameerror = $("#employeeLastnameerror").text();
	var employeeNicerror = $("#employeeNicerror").text();
	var employeeEpferror = $("#employeeEpferror").text();
	var employeeDesignationerror = $("#employeeDesignationerror").text();

	var employeeData = {
		"employeeName" : employeeFirstname,
		"employeeDateofbirth" : employeeDateofbirth,
		"employeeNic" : employeeNic,
		"employeeGender" : employeeGender,
		"employeeMaritalstatus" : employeeMaritalstatus,
		"employeeEpf" : employeeEpf,
		"employeeBasis" : employeeBasis,
		"employeeDesignation" : employeeDesignation,
		"employeeDepartment" : employeeDepartment,
		"employeePermenetaddress" : employeePermenetaddress,
		"employeeTemporaryaddress" : employeeTemporaryaddress,
		"employeeTelephone" : employeeTelephone,
		"employeeMobile" : employeeMobile,
		"employeeEmail" : employeeEmail,
		"employeeJoindate" : employeeJoindate,
	};

	if ((fname == "") || (mname == "") || (lname == "") || (employeeNic == "")
			|| (employeeEpf == "") || (employeeDesignation == "")) {
		alert("Please fill the Empty fields.");
	} else if ((employeeFirstnameerror != "")
			|| (employeeMiddlenameerror != "") || (employeeLastnameerror != "")
			|| (employeeNicerror != "") || (employeeEpferror != "")
			|| (employeeDesignationerror != "")) {
		alert("Please fill the details correctly.");
	} else {
		$.ajax({
			type : "POST",
			url : 'EmployerController',
			data : {
				jsonData : JSON.stringify(employeeData),
				task : "AEB"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearAddemployeeform();
					document.getElementById("moredetails").disabled = false;
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
}

$(document).on(
		"click",
		"#btnupload",
		function() {

			var isEmployeeEpfFound = true;
			var employeeId = $("#employeeEpf").val();
			var ehReferencemodby = $("#ehReferencemodby").val();
			
			
			alert("employeeId"+employeeId);
			
			if (employeeId == "") {
				isEmployeeEpfFound = false;
			}

			if (isEmployeeEpfFound) {
				// Getting the properties of file from file field
				var reportUpload = $("#avatarEmployee").prop("files")[0];
				var fileName1 = reportUpload.name;
				var fileSize1 = reportUpload.size;
				alert("reportUpload: " + reportUpload + " @ " + "Uploading: "
						+ fileName1 + " @ " + fileSize1 + "bytes");

				// Creating object of FormData class
				// and appending every attributes
				var formData = new FormData();
				formData.append("file", reportUpload);
				formData.append("task", "AEID");
				formData.append("modBy", ehReferencemodby);
				formData.append("crtBy", ehReferencemodby);
				formData.append("employeeId", employeeId);

				alert(formData);

				$.ajax({
					type : "POST",
					url : "EmployerController",

					data : formData, // Setting the data attribute of ajax
										// with file_data
					cache : false,
					contentType : false,
					processData : false,
					dataType : "JSON",
					success : function(data) {
						alert(data);

						// clearMedicalHisory();

						$('#save').prop('disabled', false);
						$('#upload').prop('disabled', true);

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
			}else{
				alert("Please fill the Employee EPF.");
			}
		});

function clearAddemployeeform() {
	$("#employeeFirstname").val("");
	$("#employeeMiddlename").val("");
	$("#employeeLastname").val("");
	$("#employeeDateofbirth").val("");
	$("#employeeNic").val("");
	$("#employeeGender").val("");
	$("#employeeMaritalstatus").val("");
	$("#employeeEpf").val("");
	$("#employeeBasis").val("");
	$("#employeeDesignation").val("");
	$("#employeePermenetaddress").val("");
	$("#employeeTemporaryaddress").val("");
	$("#employeeTelephone").val("");
	$("#employeeMobile").val("");
	$("#employeeEmail").val("");
	$("#employeeJoindate").val("");
	$("#employeeFirstnameerror").text("");
	$("#employeeMiddlenameerror").text("");
	$("#employeeLastnameerror").text("");
	$("#employeeNicerror").text("");
	$("#employeeEpferror").text("");
	$("#employeeDesignationerror").text("");
	getDepartment();
}

// ajax Json parsing
function updateEmployeeDetails() {
	var employeeNumber = $("#employeeNumberEdit").val();
	var employeeName = $("#employeeNameEdit").val();
	var employeeDesignation = $("#employeeDesignationEdit").val();
	var employeeDateofBoth = $("#employeeDateofBothEdit").val();
	var employeeNic = $("#employeeNICEdit").val();
	var employeeGender = $("#employeeGenderEdit").val();
	var employeeAddress = $("#employeeAddressEdit").val();
	var employeeTemAddress = $("#employeeAddressEdit").val();
	var employeeMobileNumber = $("#employeeMobileNumberEdit").val();
	var employeeOtherNumber = $("#employeeOtherNumberEdit").val();
	var employeeEmail = $("#employeeEmailEdit").val();
	var employeeDepartment = $("#employeeDepartmentEdit").val();
	var employeeJoinDate = "2011-10-06";
	var employeeMaritslStatus = $("#employeeMaritalEdit").val();
	var employeeEpf = $("#employeeEPFEdit").val();
	var employeeBasis = "Permernent";

	var employeeData = {

		"employeeId" : employeeNumber,
		"employeeName" : employeeName,
		"employeeDesignation" : employeeDesignation,
		"employeeDateofbirth" : employeeDateofBoth,
		"employeeGender" : employeeGender,
		"employeePermenetaddress" : employeeAddress,
		"employeeNic" : employeeNic,
		"employeeTemporaryaddress" : employeeTemAddress,
		"employeeMobile" : employeeMobileNumber,
		"employeeTelephone" : employeeOtherNumber,
		"employeeEmail" : employeeEmail,
		"employeeDepartment" : employeeDepartment,
		"employeeJoindate" : employeeJoinDate,
		"employeeMaritalstatus" : employeeMaritslStatus,
		"employeeEpf" : employeeEpf,
		"employeeBasis" : employeeBasis

	};
	alert(JSON.stringify(employeeData));

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {

			jsonData : JSON.stringify(employeeData),
			task : "UEB",
			inputValue : empEpf
		},
		dataType : "json",
		success : function(data) {
			alert(data);
		},
		error : function(e) {
			// alert("Error "+e);
			console.log(e);
		}
	});
}

// //////////////view basic details /////////////////////////////////
$(document).on("click", "#vbutton", function() {

	$.get("EmployerController", function(data, status) {

		$("#view").load("viewEmployee.jsp", function(datatl) {
			json = JSON.parse(data);
			$("#userid").text(json.ID);
			$(".panel-body #username").text(json.NAME);
			$(".panel-body #disignation").text(json.DESIGNATION);
			// $(".panel-body #salary").text( json.Salary);
			$(".panel-body #email").text(json.EMAIL);
			$(".panel-body #dob").text(json.DOB);
			$(".panel-body #Nic").text(json.NIC);
			$(".panel-body #gender").text(json.GENDER);
			$(".panel-body #adress").text(json.PERMENENTADDRESS);
			$(".panel-body #MobNumber").text(json.MOBILENO);
			$(".panel-body #OthNumber").text(json.OTHERNO);
			$(".panel-body #depid").text(json.DEPTID);
			$(".panel-body #doj").text(json.DATEOFJOIN);
			$(".modal-body #userid").val(json.EPF);
			$(".modal-body #userid").val(json.TEMPORARYADDRESS);

			$(".panel-body #doj").text(json.MARITALSTATUS);
			// $(".modal-body #userid").val( json.EPF);
			// $(".modal-body #userid").val( json.TEMPORARYADDRESS);

			alert(data);
		});
	});
});

// ///////////////// load employee details//////////////////////

function loademployeeDetails() {

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify("1"),
			inputValue : empEpf,
			task : "GEB"
		},
		dataType : "json",
		success : function(responseText) {
			// alert("ajax" + responseText);
			json = JSON.parse(responseText);
			// alert(responseText);
			$("#employee_id").text(json.employeeEpf);
			$("#name").text(json.employeeName);
			$("#mobilenumber").text(json.employeeMobile);
			$("#landnumber").text(json.employeeTelephone);
			$("#mobilenumber1").text(json.employeeMobile);
			$("#landnumber1").text(json.employeeTelephone);
			$("#work_email").text(json.employeeEmail);
			$("#work_email1").text(json.employeeEmail);
			$("#nic_num").text(json.employeeNic);
			$("#nic_num1").text(json.employeeNic);
			$("#birthday").val(json.employeeDateofbirth);
			// $("#gender").text(json.employeeGender);

			if (json.employeeGender == 'M') {
				$("#gender").text('Male');
			} else {
				$("#gender").text('Female');
			}

			$("#marital_status").text(json.employeeMaritalstatus);
			$("#address1").text(json.employeePermenetaddress);
			$("#address2").text(json.employeeTemporaryaddress);
			$("#job_title").text(json.employeeDesignation);
			$("#department_Name").text(json.employeeDepartment);
			$("#bassis").text(json.employeeBasis);
			$("#joindate").text(json.employeeJoindate);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}
