function loadContentEmployee() {
	$("#mainContent").load("manageEmployee.jsp");
}





//Get data and sent to EmployerController.java.
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

