/**
 * 20160407 PN HRA-1 created hra.helper.js class. 20160415 PN HRA-1 Modified
 * addEmployeeDetails() Function. 20160429 PN HRA-3 addDepartmentDetails()
 * function Modified.
 */

function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
}

function loadContentEmployee() {
	$("#mainContent").load("manageEmployee.jsp");
}

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
}

// Only for Sprint -1 demo.

function addedAlert() {
	alert("Data Added Successfully.");
	document.getElementById("moredetails").disabled = false;
}

// Get Departments for Add Employee Form
function getDepartment() {
	$.get('EmployeeController', {}, function(data) {
		var select = $('#employeeDepartment');
		select.find('option').remove();
		$('<option>').val("").text("--Select--").appendTo(select);
		$.each(data, function(index, value) {
			var result = value.split("#");
			$('<option>').val(result[0]).text(result[1]).appendTo(select);
		});
	});
}

// Get data and sent to EmployeeController.java.
function addEmployeeDetails() {
	var employeeFirstname = $("#employeeFirstname").val() + ","
			+ $("#employeeMiddlename").val() + ","
			+ $("#employeeLastname").val();
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
	var employeeNumber = $("#employeeNumber").val();

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
		"employeeId" : employeeNumber
	};

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(employeeData),
			task : "ADD"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Data Added Successfully") {
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

// Get data and sent to DepartmentController.java.
function addDepartmentDetails() {
	var departmentNumber = $("#departmentNumber").val();
	var departmentName = $("#departmentName").val();
	var departmentLocation = $("#departmentLocation").val();
	var departmentHead = $("#departmentHead").val();

	var jsonData = {
		"departmentNumber" : departmentNumber,
		"departmentName" : departmentName,
		"departmentLocation" : departmentLocation,
		"departmentHead" : departmentHead
	};

	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "ADD"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Data Added Successfully") {
				clearAddemployeeform();
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
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
	$("#employeeNumber").val("");
	getDepartment();
}
