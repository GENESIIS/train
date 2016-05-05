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

//load data to edit
$(document).on("click", "#ebutton", function () {
$.get("EmployerController", function(data, status){
	
	alert(data);
	json = JSON.parse(data);
	$(".modal-body #employeeNumberEdit").val( json.ID);
	$(".modal-body #employeeNameEdit").val( json.NAME);
	$(".modal-body #employeeDesignationEdit").val( json.DESIGNATION);
	//(".modal-body #employeeDateofBothEdit").val( json.Salary);
	$(".modal-body #employeeEmailEdit").val( json.EMAIL);
	$(".modal-body #employeeDateofBothEdit").val( json.DOB);
	$(".modal-body #employeeNICEdit").val( json.NIC);
	$(".modal-body #employeeGenderEdit").val( json.GENDER);
	$(".modal-body #employeeAddressEdit").val( json.PERMENENTADDRESS);
	$(".modal-body #employeeMobileNumberEdit").val( json.MOBILENO);
	$(".modal-body #employeeOtherNumberEdit").val( json.OTHERNO);
	$(".modal-body #employeeDepartmentEdit").val( json.DEPTID);
	$(".modal-body #employeeJoinDateEdit").val( json.DATEOFJOIN);
	$(".modal-body #employeeMaritalEdit").val( json.MARITALSTATUS);
	$(".modal-body #employeeEPFEdit").val( json.EPF);
	$(".modal-body #employeeTempADDEdit").val( json.TEMPORARYADDRESS);
	
});

 
});
//ajax Json parsing
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
	var MARITALSTATUS =$("employeeMaritalEdit").val;
	var MODBY =null;
	var MODON =null ;
	var EPF =$("employeeEPFEdit").val;
	var BASIS =null;
	
	var employeeData = {
            
                "ID": employeeNumber,
                "NAME": employeeName,
                "DESIGNATION": employeeDesignation,
                "DOB": employeeDateofBoth,
                "GENDER": employeeGender,
                "PERMENENTADDRESS": employeeAddress,
                
                "MOBILENO": employeeMobileNumber,
                "OTHERNO": employeeOtherNumber,
                "EMAIL": employeeEmail,
                "DEPTID": employeeDepartment,
                "DATEOFJOIN": employeeJoinDate,
                "MARITALSTATUS" : MARITALSTATUS,
                "MODBY" : MODBY,
                "MODON" : MODON,
                "EPF" : EPF,
                "BASIS" : BASIS
           
	    };
	alert(JSON.stringify(employeeData));
        
	
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







