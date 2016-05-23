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
	var textField1 = $('"' + textFieldname1 + '"').val();
	var textField2 = $('"' + textFieldname2 + '"').val();

	if (isLarge(textField1, textField2)) {
		document.getElementById('"' + errorSpanname + '"').innerHTML = "";
	} else {
		document.getElementById('"' + errorSpanname + '"').innerHTML = "MIN value can not be larger than MAX value.";
	}
}
