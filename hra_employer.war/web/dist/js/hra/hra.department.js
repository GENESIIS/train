/**
 * file - hra.department.js
 * 
 * @auther -@TR
 * @git branch used - hra-2,3-add-department--details-pn
 * @created on- 2016-06-07
 */

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
}

function getDepartment() {
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
			var select = $('#employeeDepartment');
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
	var departmentCode = $("#departmentCode").val();
	var departmentNameerror = $("#departmentNameerror").text();
	var departmentHeaderror = $("#departmentHeaderror").text();

	var jsonData = {
		"departmentName" : departmentName,
		"departmentLocation" : departmentLocation,
		"departmentHead" : departmentHead,
		"departmentCode" : departmentCode
	};

	if ((departmentName == "") || (departmentHead == "")|| (departmentCode == "")) {
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
	$("#departmentCode").val("");
	getManager();
	$("#departmentNameerror").text("");
	$("#departmentHeaderror").text("");

}

// Get Employees for Add Department Form
function getManager() {
	var jsonData = {};
	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "GMN"
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
