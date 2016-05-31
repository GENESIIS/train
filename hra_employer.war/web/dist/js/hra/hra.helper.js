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
function deleteAlert() {
	alert("Data Deleted Successfully.");
}

function addedAlert() {
	alert("Data Added Successfully.");
}

function updatedAlert() {
	alert("Data Updated Successfully.");
}

// Get Employees for Add Department Form
function getManager() {
	var jsonData = {};
	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "GDP"
		},
		dataType : "json",
		success : function(data) {
			var select = $('#departmentHead');
			select.find('option').remove();
			$('<option>').val("").text("--Select--").appendTo(select);
			$.each(JSON.parse(data), function(index, value) {
				var result = value.split("#");
				$('<option>').val(result[0]).text(result[1]).appendTo(select);
			});
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

// Get data and sent to DepartmentController.java.
function addDepartmentDetails() {
	var departmentName = $("#departmentName").val();
	var departmentLocation = $("#departmentLocation").val();
	var departmentHead = $("#departmentHead").val();

	var departmentNameerror = $("#departmentNameerror").text();
	var departmentHeaderror = $("#departmentHeaderror").text();

	var jsonData = {
		"departmentName" : departmentName,
		"departmentLocation" : departmentLocation,
		"departmentHead" : departmentHead
	};

	if ((departmentName == "") || (departmentHead == "")) {
		alert("Please fill the Empty fields.");
	} else if ((departmentNameerror != "") || (departmentHeaderror)) {
		alert("Please fill the details correctly.");
	} else {
		$.ajax({
			type : "POST",
			url : 'DepartmentController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "ADP"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearDepartmentform();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
}

// Get data and sent to DepartmentController.java.
function deleteDepartmentDetails() {

}

function clearDepartmentform() {
	$("#departmentName").val("");
	$("#departmentLocation").val("");
	getManager();
	$("#departmentNameerror").text("");
	$("#departmentHeaderror").text("");
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function isLetter(evt) {
	var inputValue = evt.charCode;
	if (!(inputValue >= 65 && inputValue <= 120)
			&& (inputValue != 32 && inputValue != 0)) {
		evt.preventDefault();
	}
}
