/**
 * <!-- 20160407 PN HRA-1 created hra.helper.js class -->
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
function addEmployeeDetailsA(){
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
	
	alert(employeeNumber);
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
        type: "GET",
        url: 'AddEmployeeDetails',
        data: {
            jsonData: JSON.stringify(employeeData)
        },
        dataType: "json",
        //if received a response from the server
        success: function (json) {
            //our country code was correct so we have some information to display
            console.log(json);
            //var json = JSON.parse(data);
            alert(json.data);
            /*document.getElementById('number1').value = data.*/
        }
    });
	
}
