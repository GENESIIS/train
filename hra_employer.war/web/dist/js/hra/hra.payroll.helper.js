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

	var largeValue = Math.max(Number(textField1), Number(textField2));
	alert(largeValue);
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
	var salaryComponentamount = $('input[name="salaryComponentamount"]:checked')
			.val()
	var salaryComponentmin = $("#salaryComponentmin").val();
	var salaryCurrency = $("#salaryCurrency").val();
	var salaryComponentmax = $("#salaryComponentmax").val();

	var salaryComponenttitleerror = $("#salaryComponenttitleerror").text();
	var salaryComponenttypeerror = $("#salaryComponenttypeerror").text();
	var salaryCurrencyerror = $("#salaryCurrencyerror").text();
	var salaryComponentamounterror = $("#salaryComponentamounterror").text();
	var salaryComponentminerror = $("#salaryComponentminerror").text();
	var salaryComponentmaxerror = $("#salaryComponentmaxerror").text();

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
			task : "ASC"
		},
		dataType : "json",
		success : function(data) {
			if (data == "Details added successfully.") {
				alert(data);
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}

function addSalaryscheme() {
	var salarySchemetitle = $("#salarySchemetitle").val();
	var salaryCriteria = $("#salaryCriteria").val();
	var salarySchemedescription = $("#salarySchemedescription").val();

	var jsonData = {
		"title" : salarySchemetitle,
		"criteria" : salaryCriteria,
		"description" : salarySchemedescription
	};

	$.ajax({
		type : "POST",
		url : 'PayrollController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "ASL"
		},
		dataType : "json",
		success : function(data) {
			if (data == "Details added successfully.") {
				alert(data);
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

function loadModel() {
	var salaryComponent = $("#salaryComponent").val();
	if (salaryComponent == "Not Found") {
		document.getElementById("componentLink").innerHTML = '<p><a href="" data-toggle="modal" data-target="#addSalarycomponent"><i class="glyphicon glyphicon-plus"></i> New Component</a>';
	} else if (salaryComponent == "Found") {
		document.getElementById("componentLink").innerHTML = '<p><a href="" ><i class="glyphicon glyphicon-ok"></i> Add to Scheme</a>';
	} else {
		document.getElementById("componentLink").innerHTML = '<p><a href="" data-toggle="modal" data-target="#addSalarycomponent"><i class="glyphicon glyphicon-plus"></i> New Component</a>';
	}
}