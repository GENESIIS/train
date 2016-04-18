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
