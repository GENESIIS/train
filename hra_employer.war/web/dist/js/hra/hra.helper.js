/**
 * <!-- 20160407 PN HRA-1 created hra.helper.js class -->
 * <!-- 20160415 PN HRA-1 Modified addEmployeeDetails() Function -->
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

//Only for Sprint -1 demo.
function deleteAlert(){
	alert("Data Deleted Successfully.");
}

function addedAlert(){
	alert("Data Added Successfully.");
}

function updatedAlert(){
	alert("Data Updated Successfully.");
}

//Get data to sent to Servlet
function addEmployeeDetails(){
	var employeeNumber = $("#employeeNumber").val();
	var employeeName = $("#employeeName").val();
	var employeeDesignation = $("#employeeDesignation").val();
	var employeeDateofBoth = $("#employeeDateofBoth").val();
	var employeeGender = $("#employeeGender").val();
	var employeeAddress = $("#employeeAddress").val();
	var employeeMobileNumber = $("#employeeMobileNumber").val();
	var employeeOtherNumber = $("#employeeOtherNumber").val();
	var employeeEmail = $("#employeeEmail").val();
	var employeeDepartment = $("#employeeDepartment").val();
	var employeeJoinDate = $("#employeeJoinDate").val();
	
	var employeeData = {
            "employeedata": {
                "employeeNumber": employeeNumber,
                "employeeName": employeeName,
                "employeeDesignation": employeeDesignation,
                "employeeDateofBoth": employeeDateofBoth,
                "employeeGender": employeeGender,
                "employeeAddress": employeeAddress,
                "employeeMobileNumber": employeeMobileNumber,
                "employeeOtherNumber": employeeOtherNumber,
                "employeeEmail": employeeEmail,
                "employeeDepartment": employeeDepartment,
                "employeeJoinDate": employeeJoinDate
            }
        };

	$.ajax({
        type: "POST",
        url: 'EmployerController',
        data: {
        	jsonData: JSON.stringify(employeeData)
        },
        dataType: "json",
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            alert("Error "+e);
            console.log(e);
        }
    });
}
/////////////////////////////////////////////////
$(document).on("click", "#vbutton", function () {
	
	$.get("EmployerController", function(data, status){
		
		alert(data);
		json = JSON.parse(data);
		$(".modal-body #userid").val( json.employeeId);
		$(".modal-body #username").val( json.employeeName);
		$(".modal-body #disignation").val( json.employeeDesignation);
		$(".modal-body #salary").val( json.employeeSalary);
		$(".modal-body #userid").val( json.employeeEmail);
		$(".modal-body #userid").val( json.employeeDob);
		$(".modal-body #userid").val( json.employeeNic);
		$(".modal-body #userid").val( json.employeeGender);
		$(".modal-body #userid").val( json.employeeAddress);
		$(".modal-body #userid").val( json.employeeMobileno);
		$(".modal-body #userid").val( json.employeeOtherno);
		$(".modal-body #userid").val( json.departmentId);
		$(".modal-body #userid").val( json.dateOfjoin);
		$(".modal-body #userid").val( json.modOn);
		$(".modal-body #userid").val( json.modBy);
		
	});

     
});
$(document).on("click", "#ebutton", function () {
$.get("EmployerController", function(data, status){
	
	alert("awa");
	json = JSON.parse(data);
	$(".modal-body #employeeNumberEdit").val( json.employeeId);
	$(".modal-body #employeeNameEdit").val( json.employeeName);
	$(".modal-body #employeeDesignationEdit").val( json.employeeDesignation);
	//$(".modal-body #employeeDateofBothEdit").val( json.employeeSalary);
	$(".modal-body #employeeEmailEdit").val( json.employeeEmail);
	$(".modal-body #employeeDateofBothEdit").val( json.employeeDob);
	//$(".modal-body #employeeMobileNumber").val( json.employeeNic);
	$(".modal-body #employeeGenderEdit").val( json.employeeGender);
	$(".modal-body #employeeAddressEdit").val( json.employeeAddress);
	$(".modal-body #employeeMobileNumberEdit").val( json.employeeMobileno);
	$(".modal-body #employeeOtherNumberEdit").val( json.employeeOtherno);
	$(".modal-body #employeeDepartmentEdit").val( json.departmentId);
	$(".modal-body #employeeJoinDateEdit").val( json.dateOfjoin);
	//$(".modal-body #userid").val( json.modOn);
	//$(".modal-body #userid").val( json.modBy);
	
});

 
});

function updateEmployeeDetails(){
	var employeeNumber = $("#employeeNumberEdit").val();
	var employeeName = $("#employeeNameEdit").val();
	var employeeDesignation = $("#employeeDesignationEdit").val();
	var employeeDateofBoth = $("#employeeDateofBothEdit").val();
	var employeeGender = $("#employeeGenderEdit").val();
	var employeeAddress = $("#employeeAddressEdit").val();
	var employeeMobileNumber = $("#employeeMobileNumberEdit").val();
	var employeeOtherNumber = $("#employeeOtherNumberEdit").val();
	var employeeEmail = $("#employeeEmailEdit").val();
	var employeeDepartment = $("#employeeDepartmentEdit").val();
	var employeeJoinDate = $("#employeeJoinDateEdit").val();
	
	var employeeData = {
            "employeedata": {
                "employeeNumber": employeeNumber,
                "employeeName": employeeName,
                "employeeDesignation": employeeDesignation,
                "employeeDateofBoth": employeeDateofBoth,
                "employeeGender": employeeGender,
                "employeeAddress": employeeAddress,
                "employeeMobileNumber": employeeMobileNumber,
                "employeeOtherNumber": employeeOtherNumber,
                "employeeEmail": employeeEmail,
                "employeeDepartment": employeeDepartment,
                "employeeJoinDate": employeeJoinDate
            }
        };
	String update = "true";
	$.ajax({
        type: "POST",
        url: 'EmployerController',
        data: {
        	update : update ,
        	jsonData: JSON.stringify(employeeData) 
        },
        dataType: "json",
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            alert("Error "+e);
            console.log(e);
        }
    });
}


$(document).ready(function() {
		$('#employeeDetails').DataTable();
		
});





