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


/////////////////////////////////////////////////
$(document).on("click", "#vbutton", function () {
	
	$.get("EmployerController", function(data, status){
		
		$("#view").load("viewEmployee.jsp",function(datatl){
			json = JSON.parse(data);
			$(".panel-body #userid").text(json.employeeId);
			$(".panel-body #username").text(json.employeeName);
			$(".panel-body #disignation").text( json.employeeDesignation);
			$(".panel-body #email").text( json.employeeEmail);
			$(".panel-body #dob").text( json.employeeDateofbirth);
			$(".panel-body #Nic").text( json.employeeNic);
			$(".panel-body #gender").text(json.employeeGender);
			$(".panel-body #adress").text(json.employeePermenetaddress);
			$(".panel-body #MobNumber").text( json.employeeMobile);
			$(".panel-body #OthNumber").text(  json.employeeTelephone);
			$(".panel-body #depid").text(  json.employeeDepartment);
			$(".panel-body #doj").text(json.employeeJoindate);
			$(".modal-body #userid").text( json.employeeEpf);
			$(".modal-body #tempAddresid").text( json.employeeTemporaryaddress);			
			$(".panel-body #doj").text(json.employeeJoindate);
			$(".modal-body #maritalstatusid").text( json.employeeMaritalstatus);
			//$(".modal-body #userid").val( json.TEMPORARYADDRESS);
			
			alert(data);
		});		
	});	
});

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
