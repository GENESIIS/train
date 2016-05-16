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
	document.getElementById("moredetails").disabled = false;
	alert("Data Added Successfully.");
}

function updatedAlert(){
	alert("Data Updated Successfully.");
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
			$(".modal-body #userid").val( json.employeeEpf);
			$(".modal-body #tempAddresid").val( json.employeeTemporaryaddress);			
			$(".panel-body #doj").text(json.employeeJoindate);
			$(".modal-body #maritalstatusid").val( json.employeeMaritalstatus);
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
