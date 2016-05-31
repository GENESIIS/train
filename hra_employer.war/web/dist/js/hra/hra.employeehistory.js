


//To load the Datatable
$(document).ready(function() {

	$("#btn3").click(function() {

		$("#employeeId").val("2");
		$("#employer").val("employer name");
		$("#designation").val("designation");
		$("#ehComments").val("ehComments");
		$("#ehEmail").val("ehEmail@gmail.com");
		
		$("#ehReferenceonename").val("Referenceonename 1");
		$("#ehReferenceonecomments").val("Referenceonecomments1");
		$("#ehReferenceonephone").val("Referenceonephone 1");
		$("#ehReferenceonemobile").val("Referenceonemobile1");
		$("#ehReferenceoneaddress").val("Referenceoneaddress1");
		$("#ehReferenceonedesignation").val("Referenceonedesignation1");

		$("#ehReferencetwoname").val("Referenceonename2");
		$("#ehReferencetwocomments").val("Referencetwocomments2");
		$("#ehReferencetwophone").val("Referencetwophone2");
		$("#ehReferencetwomobile").val("referenceTwocomments 22222");
		$("#ehReferencetwoaddress").val("referenceTwo 22222");
		$("#ehReferencetwodesignation").val("referenceTwocomments 22222");

		$("#ehReferencemodby").val("ADMIN_USER_TR");
	});

	
});


// @thumeera - Employee > new employee > more details > add Employeement details 
function loadAddEmployementHIstoryDetails() {
	$("#modelrest").load("employeeHistory/addEmployeeHistory.jsp");
}



function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}


/**
 * thumeera
 * Get data and sent to EmployeeController.java
 * Employee > new employee > more details > add new in EMPLOYEE HISTORY > SAVE 
 * **/
/*****************START Employee History*************************/
function addEmployeeHistoryDetails() {
	
	var employeeId = $("#employeeId").val();
	var employer= $("#employer").val();
	var designation = $("#designation").val();
	var basis= $("#basis").val();
	var ehEmail = $("#ehEmail").val();
	var ehComments= $("#ehComments").val();
	var ehReferencemodby= $("#ehReferencemodby").val();
	var startedOn = $("#startedOn").val();
	var compleatedOn = $("#compleatedOn").val();
	
	var ehReferenceonename = $("#ehReferenceonename").val();
	var ehReferenceonecomments = $("#ehReferenceonecomments").val();
	var ehReferenceonephone = $("#ehReferenceonephone").val();
	var ehReferenceonemobile = $("#ehReferenceonemobile").val();
	var ehReferenceoneaddress = $("#ehReferenceoneaddress").val();
	var ehReferenceonedesignation = $("#ehReferenceonedesignation").val();
	
	var ehReferencetwoname = $("#ehReferencetwoname").val();
	var ehReferencetwocomments = $("#ehReferencetwocomments").val();
	var ehReferencetwophone = $("#ehReferencetwophone").val();
	var ehReferencetwomobile = $("#ehReferencetwomobile").val();
	var ehReferencetwoaddress = $("#ehReferencetwoaddress").val();
	var ehReferencetwodesignation= $("#ehReferencetwodesignation").val();
	
	var x = parseInt(employeeId, 10);
	
	var employeeData = {
			
		"ehEmployeeid" 			: x,
		"ehEmployername" 		: employer,
		"ehDesignation" 		: designation,
		"ehBasis" 				: basis,
		"ehComments" 			: ehComments,
		"ehEmail" 				: ehEmail,
		"ehStartdate" 			: startedOn,
		"ehEnddate" 			: compleatedOn,
		
		"ehReferenceonename" 	: ehReferenceonename,
		"ehReferenceonecomments": ehReferenceonecomments,
		"ehReferenceonephone" 	: ehReferenceonephone,
		"ehReferenceonemobile"	: ehReferenceonemobile,
		"ehReferenceoneaddress" : ehReferenceoneaddress,
		"ehReferenceonedesignation"	: ehReferenceonedesignation,
		
		"ehReferencetwoname" 	: ehReferencetwoname,
		"ehReferencetwocomments": ehReferencetwocomments,
		"ehReferencetwophone" 	: ehReferencetwophone,
		"ehReferencetwomobile"	: ehReferencetwomobile,
		"ehReferencetwoaddress" : ehReferencetwoaddress,
		"ehReferencetwodesignation"	: ehReferencetwodesignation,
		"ehReferencemodby"		: ehReferencemodby,
	};

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(employeeData),
			task : "AEH"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
				clearEmployeementHisory();
//				document.getElementById("moredetails").disabled = false;
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

/*****************END Employee History*************************/
