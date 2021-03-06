/**
 * file - hra.employeehistory.js
 * 
 * @auther -@TR
 * @git branch used - hra-12-add-employee-history-details-tr
 * @created on- 2016-05-25
 */
var doUpdateEnable = true;
var doAddEnable = false;

$(document).ready(function() {
	
});

// field empty check
function isEmpty(value) {
	return (value == null || value.length === 0);
}



// field number check
function isNumber(evt) {
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}

function checkEmail(value) {

	var email = value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	if (!filter.test(email.value)) {
		alert('Please provide a valid email address');
		email.focus;
		return false;
	}
}

/*******************************************************************************
 * @TR - Get data and sent to EmployeeController.java Employee > new employee >
 *     more details > add new in EMPLOYEE HISTORY > SAVE
 ******************************************************************************/
/** ***************START addEmployeeHistoryDetails************************ */
function addEmployeeHistoryDetails() {

	var noError = true;

	var employeeId = $("#employeeId").val();
	var employer = $("#employer").val();
	var designation = $("#designation").val();
	var basis = $("#basis").val();
	var ehEmail = $("#ehEmail").val();
	var ehComments = $("#ehComments").val();
	var ehReferencemodby = $("#ehReferencemodby").val();
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
	var ehReferencetwodesignation = $("#ehReferencetwodesignation").val();

	if (isEmpty(employer)) {
		noError = false;
		alert("Employer name invalid");
	} else if (isEmpty(designation)) {
		noError = false;
		alert("Employer designation invalid");
	} else if (isEmpty(basis)) {
		noError = false;
		alert("Employment basis invalid");
	} else if (isEmpty(ehEmail)) {
		noError = false;
		alert("Employee email invalid");
	} else if (isEmpty(ehComments)) {
		noError = false;
		alert("Employee comment invalid");
	} else if (isEmpty(ehReferencemodby)) {
		noError = false;
		alert("Invalid user");
	} else if (isEmpty(startedOn)) {
		noError = false;
		alert("Employee started on invalid");
	} else if (isEmpty(compleatedOn)) {
		noError = false;
		alert("Employee compleated on invalid");
	}

	else if (isEmpty(ehReferenceonename)) {
		noError = false;
		alert("First reference name invalid");
	} else if (isEmpty(ehReferenceonecomments)) {
		noError = false;
		alert("First reference comment invalid");
	} else if (isEmpty(ehReferenceonephone)) {
		noError = false;
		alert("First reference phone invalid");
	} else if (isEmpty(ehReferenceonemobile)) {
		noError = false;
		alert("First reference mobile invalid");
	} else if (isEmpty(ehReferenceoneaddress)) {
		noError = false;
		alert("First reference address invalid");
	} else if (isEmpty(ehReferenceonedesignation)) {
		noError = false;
		alert("First reference designation invalid");
	}

	else if (isEmpty(ehReferencetwoname)) {
		noError = false;
		alert("Second reference name invalid");
	} else if (isEmpty(ehReferencetwocomments)) {
		noError = false;
		alert("Second reference comment invalid");
	} else if (isEmpty(ehReferencetwophone)) {
		noError = false;
		alert("Second reference phone invalid");
	} else if (isEmpty(ehReferencetwomobile)) {
		noError = false;
		alert("Second reference mobile invalid");
	} else if (isEmpty(ehReferencetwoaddress)) {
		noError = false;
		alert("Second reference address invalid");
	} else if (isEmpty(ehReferencetwodesignation)) {
		noError = false;
		alert("Second reference designation invalid");
	}

	if (noError) {

		var employeeData = {

			"ehEmployeeid" : employeeId,
			"ehEmployername" : employer,
			"ehDesignation" : designation,
			"ehBasis" : basis,
			"ehComments" : ehComments,
			"ehEmail" : ehEmail,
			"ehStartdate" : startedOn,
			"ehEnddate" : compleatedOn,

			"ehReferenceonename" : ehReferenceonename,
			"ehReferenceonecomments" : ehReferenceonecomments,
			"ehReferenceonephone" : ehReferenceonephone,
			"ehReferenceonemobile" : ehReferenceonemobile,
			"ehReferenceoneaddress" : ehReferenceoneaddress,
			"ehReferenceonedesignation" : ehReferenceonedesignation,

			"ehReferencetwoname" : ehReferencetwoname,
			"ehReferencetwocomments" : ehReferencetwocomments,
			"ehReferencetwophone" : ehReferencetwophone,
			"ehReferencetwomobile" : ehReferencetwomobile,
			"ehReferencetwoaddress" : ehReferencetwoaddress,
			"ehReferencetwodesignation" : ehReferencetwodesignation,
			"ehReferencemodby" : ehReferencemodby,
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
					clearEmploymentHisory();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
}
/** ***************END addEmployeeHistoryDetails************************ */

/** ***************START clearEmploymentHisory************************ */
function clearEmploymentHisory() {

	$("#employer").val("");
	$("#designation").val("");
	$("#basis").val("");
	$("#ehEmail").val("");
	$("#ehComments").val("");

	$("#startedOn").val("");
	$("#compleatedOn").val("");

	$("#ehReferenceonename").val("");
	$("#ehReferenceonecomments").val("");
	$("#ehReferenceonephone").val("");
	$("#ehReferenceonemobile").val("");
	$("#ehReferenceoneaddress").val("");
	$("#ehReferenceonedesignation").val("");

	$("#ehReferencetwoname").val("");
	$("#ehReferencetwocomments").val("");
	$("#ehReferencetwophone").val("");
	$("#ehReferencetwomobile").val("");
	$("#ehReferencetwoaddress").val("");
	$("#ehReferencetwodesignation").val("");

	$('#basis option').prop('selected', function() {
		return this.defaultSelected;
	});
}
/** ***************END clearEmployeementHisory************************ */

/** ***************START EDIT EMPLOYEE HISTORY Details************************ */
function loadEditContentEmployeeHistoryDetails() {


	
	$("#employeeIdhidden").val(empEpf);

	// var employeeId = $("#employeeId").val();
	$("#employeeId").val(empEpf);
	
	var employeeData = {
		"ehEmployeeid" : empEpf,
	};

	$.ajax({
				type : "POST",
				url : 'EmployerController',
				data : {
					inputValue : empEpf,
					jsonData : JSON.stringify(employeeData),
					task : "GEH"
				},
				dataType : "json",
				success : function(data) {

					json = JSON.parse(data);
					$("#employeeId").val(empEpf);
					$("#employer").val(json.ehEmployername);
					$("#designation").val(json.ehDesignation);
					$("#ehComments").val(json.ehComments);
					$("#ehEmail").val(json.ehEmail);
					$("#basis").val(json.ehBasis);
					$("#ehReferenceonename").val(json.ehReferenceonename);
					$("#ehReferenceonecomments").val(
							json.ehReferenceonecomments);
					$("#ehReferenceonephone").val(json.ehReferenceonephone);
					$("#ehReferenceonemobile").val(json.ehReferenceonemobile);
					$("#ehReferenceoneaddress").val(json.ehReferenceoneaddress);
					$("#ehReferenceonedesignation").val(
							json.ehReferenceonedesignation);

					$("#ehReferencetwoname").val(json.ehReferencetwoname);
					$("#ehReferencetwocomments").val(
							json.ehReferencetwocomments);
					$("#ehReferencetwophone").val(json.ehReferencetwophone);
					$("#ehReferencetwomobile").val(json.ehReferencetwomobile);
					$("#ehReferencetwoaddress").val(json.ehReferencetwoaddress);
					$("#ehReferencetwodesignation").val(
							json.ehReferencetwodesignation);

					$("#startedOn").val(json.ehStartdate);
					$("#compleatedOn").val(json.ehEnddate);
					
//					if (!$.trim(data)){   
//					    alert("What follows is blank: " + data);
//					}
//					else{   
//					    alert("What follows is not blank: " + data);
//					}
					
					
					 $("#btnSaveeditEmpHistory").hide();
				},
				error : function(e) {
					alert("Error " + e);
					console.log(e);
				}
			});

}
/** ***************END EDIT EMPLOYEE HISTORY Details************************ */

/*******************************************************************************
 * @TR - Get data and sent to EmployeeController.java Employee > new employee >
 *     more details > EDIT in EMPLOYEE HISTORY > SAVE
 ******************************************************************************/
/** ***************START EDIT Employee History************************ */
function updateEmployeeHistoryDetails() {

	// var employeeId = $("#employeeId").val();
	var employer = $("#employer").val();
	var designation = $("#designation").val();
	var basis = $("#basis").val();
	var ehEmail = $("#ehEmail").val();
	var ehComments = $("#ehComments").val();

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
	var ehReferencetwodesignation = $("#ehReferencetwodesignation").val();
	var ehReferencemodby = $("#ehReferencemodby").val();

	var employeeData = {

		"ehEmployername" : employer,
		"ehDesignation" : designation,
		"ehBasis" : basis,
		"ehComments" : ehComments,
		"ehEmail" : ehEmail,

		"ehStartdate" : startedOn,
		"ehEnddate" : compleatedOn,

		"ehReferenceonename" : ehReferenceonename,
		"ehReferenceonecomments" : ehReferenceonecomments,
		"ehReferenceonephone" : ehReferenceonephone,
		"ehReferenceonemobile" : ehReferenceonemobile,
		"ehReferenceoneaddress" : ehReferenceoneaddress,
		"ehReferenceonedesignation" : ehReferenceonedesignation,

		"ehReferencetwoname" : ehReferencetwoname,
		"ehReferencetwocomments" : ehReferencetwocomments,
		"ehReferencetwophone" : ehReferencetwophone,
		"ehReferencetwomobile" : ehReferencetwomobile,
		"ehReferencetwoaddress" : ehReferencetwoaddress,
		"ehReferencetwodesignation" : ehReferencetwodesignation,
		"ehReferencemodby" : ehReferencemodby,
	};

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			inputValue : empEpf,
			jsonData : JSON.stringify(employeeData),
			task : "UEH"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details updated successfully.") {
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

/** ***************END EDIT Employee History************************ */

function clearEmployeeHistoryDetails() {

	$("#employer").val("");
	$("#designation").val("");
	$("#ehComments").val("");
	$("#ehEmail").val("");

	$("#ehReferenceonename").val("");
	$("#ehReferenceonecomments").val("");
	$("#ehReferenceonephone").val("");
	$("#ehReferenceonemobile").val("");
	$("#ehReferenceoneaddress").val("");
	$("#ehReferenceonedesignation").val("");

	$("#ehReferencetwoname").val("");
	$("#ehReferencetwocomments").val("");
	$("#ehReferencetwophone").val("");
	$("#ehReferencetwomobile").val("");
	$("#ehReferencetwoaddress").val("");
	$("#ehReferencetwodesignation").val("");

	$("#startedOn").val("");
	$("#compleatedOn").val("");

	$('#basis option').prop('selected', function() {
		return this.defaultSelected;
	});

}
