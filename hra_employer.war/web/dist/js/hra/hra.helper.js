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
			$("#userid").text(json.ID);
			$(".panel-body #username").text(json.NAME);
			$(".panel-body #disignation").text( json.DESIGNATION);
			//$(".panel-body #salary").text( json.Salary);
			$(".panel-body #email").text( json.EMAIL);
			$(".panel-body #dob").text( json.DOB);
			$(".panel-body #Nic").text( json.NIC);
			$(".panel-body #gender").text(json.GENDER);
			$(".panel-body #adress").text(json.PERMENENTADDRESS);
			$(".panel-body #MobNumber").text( json.MOBILENO);
			$(".panel-body #OthNumber").text(  json.OTHERNO);
			$(".panel-body #depid").text(  json.DEPTID);
			$(".panel-body #doj").text(json.DATEOFJOIN);
			$(".modal-body #userid").val( json.EPF);
			$(".modal-body #userid").val( json.TEMPORARYADDRESS);
			
			$(".panel-body #doj").text(json.MARITALSTATUS);
			//$(".modal-body #userid").val( json.EPF);
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
