/**
 * <!-- 20160407 PN HRA-1 created hra.helper.js class -->
 * <!-- 20160415 PN HRA-1 Modified addEmployeeDetails() Function -->
 */

function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
}

function loadContentEmployee() {
	$("#mainContent").load("createEmployee.jsp");
}

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
}

//Only for Sprint -1 demo.
function deleteAlert(){
	alert("Data Deleted Successfully.");
}

function addedAlert() {
	//document.getElementById("moredetails").disabled = false;
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
		
		$("#view").load("viewEmployee.jsp",function(datatl){
			json = JSON.parse(data);
			$("#userid").text(json.EmployeeId);
			$(".panel-body #username").text(json.FirstName);
			$(".panel-body #disignation").text( json.Designation);
			$(".panel-body #salary").text( json.Salary);
			$(".panel-body #email").text( json.Email);
			$(".panel-body #dob").text( json.DoB);
			$(".panel-body #Nic").text( json.NIC);
			$(".panel-body #gender").text(json.Gender);
			$(".panel-body #adress").text(json.Address);
			$(".panel-body #MobNumber").text( json.MobNumber);
			$(".panel-body #OthNumber").text(  json.OtherNumber);
			$(".panel-body #depid").text(  json.Department);
			$(".panel-body #doj").text(json.DoJ);
			//$(".modal-body #userid").val( json.modOn);
			//$(".modal-body #userid").val( json.modBy);
			
			alert(data);
		});
		
		
	});
	
	
});
$(document).on("click", "#ebutton", function () {
$.get("EmployerController", function(data, status){
	
	//alert("awa");
	json = JSON.parse(data);
	$(".modal-body #employeeNumberEdit").val( json.EmployeeId);
	$(".modal-body #employeeNameEdit").val( json.FirstName);
	$(".modal-body #employeeDesignationEdit").val( json.Designation);
	//$(".modal-body #employeeDateofBothEdit").val( json.Salary);
	$(".modal-body #employeeEmailEdit").val( json.Email);
	$(".modal-body #employeeDateofBothEdit").val( json.DoB);
	//$(".modal-body #employeeMobileNumber").val( json.NIC);
	$(".modal-body #employeeGenderEdit").val( json.Gender);
	$(".modal-body #employeeAddressEdit").val( json.Address);
	$(".modal-body #employeeMobileNumberEdit").val( json.MobNumber);
	$(".modal-body #employeeOtherNumberEdit").val( json.OtherNumber);
	$(".modal-body #employeeDepartmentEdit").val( json.Department);
	$(".modal-body #employeeJoinDateEdit").val( json.DoJ);
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

/////load more employee views/////////////////////////////////////

function loadviewqlifications() {
	$("#viewmodelrest").load("viewemployeeDetails/vieweducationalDetails.jsp");
}

function loadviewemployementhistory() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemployementHistory.jsp");
}

function loadviewstudyprograms() {
	$("#viewmodelrest").load("viewemployeeDetails/viewstudyPrograms.jsp");
}

function loadviewlanguages() {
	$("#viewmodelrest").load("viewemployeeDetails/viewlanguageProficiency.jsp");
}

function loadviewloandetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}
function loadviewfamilydetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewfamilyDetails.jsp");
}
function loadviewemergencycontacts() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemergencyContacts.jsp");
}

////////////////////////////////////////////////

//////load more edit Employeee Detail///////////////

function loadEditContentqualifications() {
	$("#Editmodelrest").load("EditemployeeDetails/EditeducationalDetails.jsp");
}

function loadEditemployementhistory() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemployementHistory.jsp");
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("EditemployeeDetails/EditstudyPrograms.jsp");
}

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}

function loadEditContentloandetails() {
	$("#Editmodelrest").load("EditemployeeDetails/EditloanDetails.jsp");
}
function loadEditContentfamilydetails() {
	$("#Editmodelrest").load("EditemployeeDetails/EditfamilyDetails.jsp");
}
function loadEditemergencycontacts() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemergencyContacts.jsp");
}

//////////////////////////////////////////////////////////
$(document).ready(function() {
		$('#employeeDetails').DataTable();
		
});





