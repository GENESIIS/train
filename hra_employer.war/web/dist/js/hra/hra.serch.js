/**
 * 20160518 PC HRA-30 created hra.anguleruse.js
 */

function serchEmployee() {
	var serchContent = $("#serchEmployeeText").val();
	var jsonData = {
		"serchContent" : serchContent
	};
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(jsonData),
			inputValue : serchContent,
			task : "SE"
		},
		dataType : "json",
		success : function(responseText) {
			alert(responseText);
			listEmployee(responseText);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		} 
	});
}

function listEmployee(empData) {

	json = JSON.parse(empData);
	jsonData: JSON.stringify(empData);
	// ////Check whether Table is Initialize or not
	if ($.fn.dataTable.isDataTable('#employeeDetails')) {
		// //////Destroy table
		eTable.destroy();
	}
	eTable = $('#employeeDetails')
			.DataTable(
					{
						data : json,
						"aoColumns" : [
								{
									"mDataProp" : "employeeEpf",
									className : "center"
								},
								{
									"mDataProp" : "employeeName",
									className : "center"
								},

								{
									"mDataProp" : "employeeDesignation",
									className : "center"
								},
								{
									"mDataProp" : "employeeMobile",
									className : "center"
								},

								{
									"name" : "Add",
									className : "center",
									defaultContent : '<button type="button" class="btn btn-info" '
											+ 'data-toggle="modal" id = "add" ><i class="glyphicon glyphicon-modal-window"></i></button>'
								},
								{
									"name" : "Edit",
									className : "center",
									defaultContent : '<button type="button" class="btn btn-warning" '
											+ 'data-toggle="modal" id = "edit" data-target="#editEmployeeDetailsForm" ><i class="glyphicon glyphicon-edit"></i></button>'
								},
								{
									"name" : "Delete",
									className : "center",
									defaultContent : '<button type="button" class="btn btn-danger" '
											+ 'data-toggle="modal" id = "delete"><i class="glyphicon glyphicon-trash"></i></button>'
								} ]

					});

	$("#employeeDetails_filter").css("display", "none"); // hiding Search box
	// search box
	eTable = $('#employeeDetails').DataTable();
	$('#serchEmployeeText').keyup(function() {
		eTable.search($(this).val()).draw();
	});

	// /////////////view Button click event//////////////
	$('#employeeDetails tbody').on('click', '#add', function() {
		var data = eTable.row($(this).parents('tr')).data();
		// eTable.row( $(this).parents('tr') ).remove().draw();
		empEpf = data.employeeEpf;
		loadViewEmployee();
	});

	// /////////////Edit Button click event//////////////
	$('#employeeDetails tbody').on(
			'click',
			'#edit',
			function() {
				var data = eTable.row($(this).parents('tr')).data();
				empEpf = data.employeeEpf;
				$.get("EmployerController", {
					inputValue : data.employeeEpf,
					task : "GEB"
				},
						function(data, status) {

							alert(data);
							json1 = JSON.parse(data);
							json = JSON.parse(json1);
							$(".modal-body #employeeNumberEdit").val(
									json.employeeId);
							$(".modal-body #employeeNameEdit").val(
									json.employeeName);
							$(".modal-body #employeeDesignationEdit").val(
									json.employeeDesignation);
							$(".modal-body #employeeEmailEdit").val(
									json.employeeEmail);
							$(".modal-body #employeeDateofBothEdit").val(
									json.employeeDateofbirth);
							$(".modal-body #employeeNICEdit").val(
									json.employeeNic);

							if (json.employeeGender == 'M') {
								$(".modal-body #employeeGenderEdit")
										.val('Male');
							} else {
								$(".modal-body #employeeGenderEdit").val(
										'Female');
							}

							$(".modal-body #employeeAddressEdit").val(
									json.employeePermenetaddress);
							$(".modal-body #employeeTempADDEdit").val(
									json.employeeTemporaryaddress);
							$(".modal-body #employeeMobileNumberEdit").val(
									json.employeeMobile);
							$(".modal-body #employeeOtherNumberEdit").val(
									json.employeeTelephone);
							$(".modal-body #employeeDepartmentEdit").val(
									json.employeeDepartment);
							$(".modal-body #employeeJoinDateEdit").val(
									json.employeeJoindate);
							$(".modal-body #employeeMaritalEdit").val(
									json.employeeMaritalstatus);
							$(".modal-body #employeeEPFEdit").val(
									json.employeeEpf);
						});
			});

	// /////////////Delete Button click event//////////////
	$('#employeeDetails tbody').on('click', '#delete', function() {
		var data = eTable.row($(this).parents('tr')).data();
		eTable.row($(this).parents('tr')).remove().draw();
		alert('Delete button click' + data.employeeName);
	});

}
