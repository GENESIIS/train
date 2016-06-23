function loadlonedetails() {
	$("#modelrest").load("employeeDetail/addLoanDetails.jsp");
}

function loadviewloandetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}

function clearLoanDetails() { 
	$("#employeeId").val("");
	$("#totalOutstanding").val("");
	$("#guarantor1").val("");
	$("#guarantor2").val("");
	$("#monthlyPayment").val("");
	$("#dueDate").val("");
	$("#endDate").val("");
}

function clearAddeducationform() {
	$("#employeeId").val("");
	$("#qualificationName").val("");
	$("#educatedPlace").val("");
	$("#mediumStudied").val("");
	$("#startedOn").val("");
	$("#compleatedOn").val("");
	$("#institution").val("");
	$("#courseType").val("");
	$("#admissionDate").val("");
	$("#duration").val("");
	$("#weekdays").attr('checked', false);
	$("#weekends").attr('checked', false);

}

// add Loan Details
function addLoanDetailes() {

	var employeeEpf = $("#employeeId").val();
	var loanAmount = $("#totalOutstanding").val();
	var loanGuarantor1 = $("#guarantor1").val();
	var loanGuarantor2 = $("#guarantor2").val();
	var loanmonthlyPayment = $("#monthlyPayment").val();
	var loanDueDate = $("#dueDate").val();
	var loanEndDate = $("#endDate").val();

	var jsonData = {
		"employeeEpf" : employeeEpf,
		"loanAmount" : loanAmount,
		"loanGuarantor1" : loanGuarantor1,
		"loanGuarantor2" : loanGuarantor2,
		"loanmonthlyPayment" : loanmonthlyPayment,
		"loanDueDate" : loanDueDate,
		"loanEndDate" : loanEndDate,
	};

	alert(JSON.stringify(jsonData));
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "RL",
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
				clearAddeducationform();
			} else {
				alert(data);
			}
			;
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		},
	});

};

// add Loan Details
function updateLoanDetailes() {

	var employeeEpf = $("#employeeEPFEdit").val();
	var loanAmount = $("#totalOutstandingEdit").val();
	var loanGuarantor1 = $("#guaranter1Edit").val();
	var loanGuarantor2 = $("#guaranter2Edit").val();
	var loanmonthlyPayment = $("#monthlyPaymentEdit").val();
	var loanDueDate = $("#dueDateEdit").val();
	var loanEndDate = $("#endDateEdit").val();

	var jsonData = {
		"employeeEpf" : employeeEpf,
		"loanAmount" : loanAmount,
		"loanGuarantor1" : loanGuarantor1,
		"loanGuarantor2" : loanGuarantor2,
		"loanmonthlyPayment" : loanmonthlyPayment,
		"loanDueDate" : loanDueDate,
		"loanEndDate" : loanEndDate,
	};

	alert(JSON.stringify(jsonData));
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "UL",
			inputValue : employeeEpf,
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
				clearAddeducationform();
			} else {
				alert(data);
			}
			;
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		},
	});

};

function loadEditContentloandetails() {

	$("#Editmodelrest").load("employeeDetailEdit/editLoanDetails.jsp",

			function(datatl) {
				var employeeEpf = empEpf;
				$.get("EmployerController", {
					inputValue : employeeEpf,
					task : "GL"
				}, function(data, status) {
					alert(data);
					json = JSON.parse(JSON.parse(data));
					$("#employeeEPFEdit").val(empEpf);
					$("#totalOutstandingEdit").val(json.loanAmount);
					$("#guaranter1Edit").val(json.loanGuarantor1);
					$("#guaranter2Edit").val(json.loanGuarantor2);
					$("#monthlyPaymentEdit").val(json.loanmonthlyPayment);
					$("#dueDateEdit").val(json.loanDueDate);
					$("#endDateEdit").val(json.loanEndDate);

				});
			});
}

// load loan details

function loadLoanDetails() {

	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify("1"),
			inputValue : empEpf,
			task : "GL"
		},
		dataType : "json",
		success : function(responseText) {
			// alert("ajax" + responseText);
			json = JSON.parse(responseText);
			// alert(responseText);
			// $("#employee_id").text(json.employeeEpf);
			$("#amount").text(json.loanAmount);
			$("#guarantor1").text(json.loanGuarantor1);
			$("#guarantor2").text(json.loanGuarantor2);
			$("#payment").text(json.loanmonthlyPayment);
			$("#dueDate").text(json.loanDueDate);
			$("#endDate").text(json.loanEndDate);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}