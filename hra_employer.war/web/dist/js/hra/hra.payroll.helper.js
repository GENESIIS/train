/**
 * 20160520 PN HRA-31 created hra.payroll.helper.js class. All the JS functions
 * related to payroll section listed under here.
 */

/*******************************************************************************
 * To load the Salary component page.
 ******************************************************************************/
function loadSalarycomponentdetails() {
	$("#mainContent").load("payroll/salaryComponent.jsp");
}

function loadSalaryschemedetails() {
	$("#mainContent").load("payroll/salaryScheme.jsp");
}

function setEmptyerrormessage(textFieldname, errorSpanname, message) {
	var textField = $(textFieldname).val();
	if (isEmptyfield(textField)) {
		document.getElementById(errorSpanname).innerHTML = "";
	} else {
		document.getElementById(errorSpanname).innerHTML = message
				+ " Field can not be Empty.";
	}
}

function setLargevalueerror(textFieldname1, textFieldname2, errorSpanname) {
	var textField1 = $(textFieldname1).val();
	var textField2 = $(textFieldname2).val();

	var largeValue = Math.max(textField1, textField2);
	
	if (largeValue == textField2) {
		document.getElementById(errorSpanname).innerHTML = "";
	} else {
		document.getElementById(errorSpanname).innerHTML = "MIN value can not be larger than MAX value.";
	}
}

// //Add salary component
function addSalarycomponent() {
	var salaryComponenttype = $("#salaryComponenttype").val();
	var salaryComponenttitle = $("#salaryComponenttitle").val();
	var salaryComponentdescription = $("#salaryComponentdescription").val();
	var salaryComponentamount = $('input[name="salaryComponentamount"]:checked').val()
	var salaryComponentmin = $("#salaryComponentmin").val();
	var salaryCurrency = $("#salaryCurrency").val();
	var salaryComponentmax = $("#salaryComponentmax").val();

	var jsonData = {
		"componentType" : salaryComponenttype,
		"componentName" : salaryComponenttitle,
		"description" : salaryComponentdescription,
		"rate" : salaryComponentamount,
		"minAmount" : salaryComponentmin,
		"maxAmount" : salaryComponentmax,
		"currency" : salaryCurrency
	};

	
	$.ajax({
		type : "POST",
		url : 'PayrollController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "11"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}