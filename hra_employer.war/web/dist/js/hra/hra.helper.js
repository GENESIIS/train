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

function addedAlert() {
	//document.getElementById("moredetails").disabled = false;
	alert("Data Added Successfully.");
}

function updatedAlert(){
	alert("Data Updated Successfully.");
}

//load data to edit
$(document).on("click", "#ebutton", function () {
$.get("EmployerController", function(data, status){
	
	alert(data);
	json = JSON.parse(data);
	$(".modal-body #employeeNumberEdit").val( json.employeeId);
	$(".modal-body #employeeNameEdit").val( json.employeeName);
	$(".modal-body #employeeDesignationEdit").val( json.employeeDesignation);
	$(".modal-body #employeeEmailEdit").val( json.employeeEmail);
	$(".modal-body #employeeDateofBothEdit").val( json.employeeDateofbirth);
	$(".modal-body #employeeNICEdit").val( json.employeeNic);
	$(".modal-body #employeeGenderEdit").val( json.employeeGender);
	$(".modal-body #employeeAddressEdit").val( json.employeePermenetaddress);
	$(".modal-body #employeeTempADDEdit").val( json.employeeTemporaryaddress);
	$(".modal-body #employeeMobileNumberEdit").val( json.employeeMobile);
	$(".modal-body #employeeOtherNumberEdit").val( json.employeeTelephone);
	$(".modal-body #employeeDepartmentEdit").val( json.employeeDepartment);
	$(".modal-body #employeeJoinDateEdit").val( json.employeeJoindate);
	$(".modal-body #employeeMaritalEdit").val( json.employeeMaritalstatus);
	$(".modal-body #employeeEPFEdit").val( json.employeeEpf);

	
});

 
});
//ajax Json parsing
function updateEmployeeDetails(){
	var employeeNumber = $("#employeeNumberEdit").val();
	var employeeName = $("#employeeNameEdit").val();
	var employeeDesignation = $("#employeeDesignationEdit").val();
	var employeeDateofBoth = $("#employeeDateofBothEdit").val();
	var employeeNic =$("#employeeNICEdit").val();
	var employeeGender = $("#employeeGenderEdit").val();
	var employeeAddress = $("#employeeAddressEdit").val();
	var employeeTemAddress = $("#employeeAddressEdit").val();
	var employeeMobileNumber = $("#employeeMobileNumberEdit").val();
	var employeeOtherNumber = $("#employeeOtherNumberEdit").val();
	var employeeEmail = $("#employeeEmailEdit").val();
	var employeeDepartment = $("#employeeDepartmentEdit").val();
	var employeeJoinDate ="2011-10-06";
	var employeeMaritslStatus =$("#employeeMaritalEdit").val();
	var employeeModon ="mod" ;
	var employeeEpf = $("#employeeEPFEdit").val();
	var employeeBasis ="Permernent";
	
	var employeeData = {
            
                "employeeId": employeeNumber,
                "employeeName": employeeName,
                "employeeDesignation": employeeDesignation,
                "employeeDateofbirth": employeeDateofBoth,
                "employeeGender": employeeGender,
                "employeePermenetaddress": employeeAddress,
                "employeeNic" : employeeNic,
                "employeeTemporaryaddress" : employeeTemAddress,
                "employeeMobile": employeeMobileNumber,
                "employeeTelephone": employeeOtherNumber,
                "employeeEmail": employeeEmail,
                "employeeDepartment": employeeDepartment,
                "employeeJoindate": employeeJoinDate,
                "employeeMaritalstatus" : employeeMaritslStatus,
               // "MODBY" : employeeModby,
               /// "MODON" : employeeModon,
                "employeeEpf" : employeeEpf,
                "employeeBasis" : employeeBasis
           
	    };
	alert(JSON.stringify(employeeData));
        
	
	$.ajax({
        type: "POST",
        url: 'EmployerController',
        data: {
        	
        	jsonData: JSON.stringify(employeeData) ,
        	task : "UPDATE"
        },
        dataType: "json",
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            //alert("Error "+e);
            console.log(e);
        }
    });
}
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







