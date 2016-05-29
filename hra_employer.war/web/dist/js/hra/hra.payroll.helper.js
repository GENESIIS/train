/**
 * 20160520 PN HRA-31 created hra.payroll.helper.js class. All the JS functions
 * related to payroll section listed under here.
 */

/*******************************************************************************
 * To load the Salary component page.
 ******************************************************************************/
var arr = [];
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
			.val();
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
		"description" : salarySchemedescription,
		"componentCodetemp" : arr
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
				arr = [];
				clearSalaryscheme();
			}
			clearComponent();
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

function clearComponent() {
	// CLear dropdown
	$('#salaryCurrency option').prop('selected', function() {
		return this.defaultSelected;
	});
	$('#salaryComponenttype option').prop('selected', function() {
		return this.defaultSelected;
	});

	$("#salaryComponenttitle").val("");
	$("#salaryComponentdescription").val("");
	$('input[name="salaryComponentamount"]:checked').val()
	$("#salaryComponentmin").val("");
	$("#salaryComponentmax").val("");
	$("#salaryComponenttitleerror").text("");
	$("#salaryComponenttypeerror").text("");
	$("#salaryCurrencyerror").text("");
	$("#salaryComponentamounterror").text("");
	$("#salaryComponentminerror").text("");
	$("#salaryComponentmaxerror").text("");
}

function clearSalaryscheme() {
	$("#salarySchemetitle").val("");
	$('#salaryCriteria option').prop('selected', function() {
		return this.defaultSelected;
	});
	$("#salarySchemedescription").val("");

	var table = document.getElementById("salarySchemetbl");
	var tblsize = table.rows.length;
	for (var int = 0; int < tblsize; int++) {
		if (int != 0) {
			deleteRow(table.rows[int]);
		}
	}

}

// Table related functions

function addRow() {
	var table = document.getElementById("salarySchemetbl");
	var salaryComponenttype = document.getElementById("salaryComponenttype");
	var salaryComponenttitle = document.getElementById("salaryComponenttitle");
	var salaryComponentdescription = document
			.getElementById("salaryComponentdescription");
	var salaryComponentamount = document
			.getElementById("salaryComponentamount");
	var salaryComponentmin = document.getElementById("salaryComponentmin");
	var salaryComponentmax = document.getElementById("salaryComponentmax");
	var salaryCurrency = document.getElementById("salaryCurrency");

	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);

	var x = document.getElementById("salarySchemetbl").rows.length;

	var td0 = row.insertCell(0);
	td0.innerHTML = salaryComponenttype.value;
	td0.id = "nr" + (x);

	var td1 = row.insertCell(1);
	td1.innerHTML = salaryComponenttitle.value;

	var td2 = row.insertCell(2);
	td2.innerHTML = salaryCurrency.value;

	var td3 = row.insertCell(3);
	td3.innerHTML = salaryComponentdescription.value;

	var td4 = row.insertCell(4);
	td4.innerHTML = salaryComponentamount.value;

	var td5 = row.insertCell(5);
	td5.innerHTML = salaryComponentmin.value;

	var td6 = row.insertCell(6);
	td6.innerHTML = salaryComponentmax.value;

	var td7 = row.insertCell(7);
	td7.innerHTML = '<button type="button" class="btn btn-danger" onClick="Javacsript:deleteRow(this)"><i class="glyphicon glyphicon-trash"></i></button>';

	if (table != null) {
		for (var i = 0; i < table.rows.length; i++) {
			if (i > 0) {
				var ce = table.rows[i].cells[1];
				arr.push(ce.innerHTML);
			}
		}
	}
}

function deleteRow(obj) {
	var index = obj.parentNode.parentNode.rowIndex;
	var table = document.getElementById("salarySchemetbl");
	table.deleteRow(index);
}

function addTable() {
	var myTableDiv = document.getElementById("myDynamicTable");

	var table = document.createElement('TABLE');
	table.border = '1';

	var tableBody = document.createElement('TBODY');
	table.appendChild(tableBody);

	for (var i = 0; i < 3; i++) {
		var tr = document.createElement('TR');
		tableBody.appendChild(tr);

		for (var j = 0; j < 4; j++) {
			var td = document.createElement('TD');
			td.width = '75';
			td.appendChild(document.createTextNode("Cell " + i + "," + j));
			tr.appendChild(td);
		}
	}
	myTableDiv.appendChild(table);
}