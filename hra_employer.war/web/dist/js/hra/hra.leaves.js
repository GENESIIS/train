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
	var leaveType = $("#leavetypename").val();
	var leaveDuration = $("#leavesduration").val();
	var leavescount = $("#leavescount").val();
	
	var leavePayment = checkWithyayOrNopay();

	
	/*var leaveTypenumbererror = $("#leaveTypenumbererror").text();
	var leaveTypenameerror = $("#leaveTypenameerror").text();*/
	
	var jsonData = {
			
		"leaveType" : leaveType,
		"leaveDuration" : leaveDuration,
		"leaveCount" : leavescount,
		"leavePayment" : leavePayment
	};
	if ((leaveType == "") || (leaveDuration == "")|| (leavescount == "")) {
		alert("Please fill the Empty fields.");
		/*} else if ((leaveTypenumbererror != "") || (leaveTypenameerror)) {
		alert("Please fill the details correctly.");*/
	}else if(!$('input[name=leavePay]:checked').val()){
		alert("Please check radio button.");
		
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
					clearLeaveTypeform();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
}

function clearLeaveTypeform() {
	$("#leavetypename").val("");
	$("#leavesduration").val("");
	$("#leavescount").val("");
	$('#leaveNoPay').removeAttr('checked');
	$('#leavePay').removeAttr('checked');
}

//Check with pay or no pay and returns Value
function checkWithyayOrNopay() {
	
	 if (document.getElementById('leavePay').checked) {
	
		return 1;
	} else if (document.getElementById('leaveNoPay').checked) {
		
		return 2;
	} else {
	
		return 3;
	}
}
