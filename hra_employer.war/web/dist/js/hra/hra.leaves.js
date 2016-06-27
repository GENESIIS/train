/**
 * 20160627 CM HRA-45 created hra.leaves.js class. All the JS functions
 * related to leaves section listed under here.
 */

/*******************************************************************************
 * To load the leaves page.
 ******************************************************************************/

var arr = [];
function loadleaveTypesdetails() {
	$("#mainContent").load("leaves/addleaveTypes.jsp");
}


// Get data and sent to leaveController.java.
function addLeaveTypesDetails() {
	var leaveTypenumber = $("#leavetypenumber").val();
	var leaveTypename = $("#leavetypename").val();
	var leaverPeryear = $("#leavesperyear").val();
	var checkWithyayOrNopay = checkWithpayOrNopay();

	
	var leaveTypenumbererror = $("#leaveTypenumbererror").text();
	var leaveTypenameerror = $("#leaveTypenameerror").text();

	var jsonData = {
		"leaveTypenumber" : leaveTypenumber,
		"leaveTypename" : leaveTypename,
		"leaverPeryear" : leaverPeryear
		
	};

	if ((leaveTypenumber == "") || (leaveTypename == "")) {
		alert("Please fill the Empty fields.");
	} else if ((leaveTypenumbererror != "") || (leaveTypenameerror)) {
		alert("Please fill the details correctly.");
	} else {
		$.ajax({
			type : "POST",
			url : 'LeaveController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "ALT"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearDepartmentform();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
}

//Check with pay or no pay and returns Value
function checkWithpayOrNopay() {
	 if (document.getElementById('leavePay').checked) {
		return 1;
	} else if (document.getElementById('leaveNoPay').checked) {
		return 2;
	} else {
		return 3;
	}
}
