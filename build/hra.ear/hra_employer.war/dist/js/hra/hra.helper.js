/**
 * 20160407 PN HRA-1 created hra.helper.js class. 20160415 PN HRA-1 Modified
 * addEmployeeDetails() Function. 20160429 PN HRA-3 addDepartmentDetails()
 * function Modified. 20160505 PN HRA-2 clearAddemployeeform() function
 * modified. 20160509 addEducationDetails() Function
 */

var theNewScript = document.createElement("script");
theNewScript.type = "text/javascript";
theNewScript.src = "hra.validation.js";

function loadContentDashboard() {
	$("#mainContent").load("hraDashboard.jsp");
}

function loadContentEmployee() {
	$("#mainContent").load("manageEmployee.jsp");
}

function loadContentDepartment() {
	$("#mainContent").load("manageDepartment.jsp");
}
function loadContentqualifications() {
	$("#modelrest").load("employeeDetails/educationalDetails.jsp");
}
function loadViewEmployee() {
	$("#mainContent").load("ViewemployeeDetails/viewEmployeeDetails.jsp");
	loademployeeDetails();

<<<<<<< HEAD
function loadBasicTable() {
	$("#basicTable").load("TableDetail/serchBasic.jsp");
}

// Only for Sprint -1 demo.
function deleteAlert() {
	alert("Data Deleted Successfully.");
}
=======
}
// Load more details contents
function loadfamilydetails() {
	$("#modelrest").load("employeeDetails/familyDetails.jsp");
}
// load more edit Employeee Detail

function loadEditContentqualifications() {
	$("#Editmodelrest").load("EditemployeeDetails/EditeducationalDetails.jsp");

}

function loadEditemployementhistory() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemployementHistory.jsp");
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("EditemployeeDetails/EditstudyPrograms.jsp");
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b

}

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}

// Only for Sprint -1 demo.
function addedAlert() {
	// document.getElementById("moredetails").disabled = false;
<<<<<<< HEAD
	document.getElementById("moredetails").disabled = false;
	alert("Data Added Successfully.");
}

function updatedAlert() {
	alert("Data Updated Successfully.");
}
// Get Employees for Add Department Form
function getManager() {
	$.getJSON('DepartmentController', {
		task : "FIND"
	}, function(data) {
		var select = $('#departmentHead');
		select.find('option').remove();
		$('<option>').val("").text("--Select--").appendTo(select);
		$.each(data, function(index, value) {
			var result = value.split("#");
			$('<option>').val(result[0]).text(result[1]).appendTo(select);
		});
	});
}
function addedAlert() {
	alert("Data Added Successfully.");
=======
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
	document.getElementById("moredetails").disabled = false;
	alert("Data Added Successfully.");
}

function updatedAlert() {
	alert("Data Updated Successfully.");
}

// Get Employees for Add Department Form
function getManager() {
	var jsonData = {};
	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "GMN"
		},
		dataType : "json",
		success : function(data) {
			var select = $('#departmentHead');
			select.find('option').remove();
			$('<option>').val("").text("--Select--").appendTo(select);
			$.each(JSON.parse(data), function(index, value) {
				var result = value.split("#");
				$('<option>').val(result[0]).text(result[1]).appendTo(select);
			});
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

function getDepartment() {
<<<<<<< HEAD
	$.get('EmployerController', {
		task : "FIND"
	}, function(data) {
		var select = $('#employeeDepartment');
		select.find('option').remove();
		$('<option>').val("").text("--Select--").appendTo(select);
		$.each(data, function(index, value) {
			var result = value.split("#");
			$('<option>').val(result[0]).text(result[1]).appendTo(select);
		});
	});
}

=======
	var jsonData = {};
	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "GDP"
		},
		dataType : "json",
		success : function(data) {
			var select = $('#employeeDepartment');
			select.find('option').remove();
			$('<option>').val("").text("--Select--").appendTo(select);
			$.each(JSON.parse(data), function(index, value) {
				var result = value.split("#");
				$('<option>').val(result[0]).text(result[1]).appendTo(select);
			});
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

// Get data and sent to DepartmentController.java.
function addDepartmentDetails() {
	var departmentName = $("#departmentName").val();
	var departmentLocation = $("#departmentLocation").val();
	var departmentHead = $("#departmentHead").val();

	var departmentNameerror = $("#departmentNameerror").text();
	var departmentHeaderror = $("#departmentHeaderror").text();

	var jsonData = {
		"departmentName" : departmentName,
		"departmentLocation" : departmentLocation,
		"departmentHead" : departmentHead
	};

	if ((departmentName == "") || (departmentHead == "")) {
		alert("Please fill the Empty fields.");
	} else if ((departmentNameerror != "") || (departmentHeaderror)) {
		alert("Please fill the details correctly.");
	} else {
		$.ajax({
			type : "POST",
			url : 'DepartmentController',
			data : {
				jsonData : JSON.stringify(jsonData),
				task : "ADP"
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

// Get data and sent to DepartmentController.java.
function deleteDepartmentDetails() {

}

function clearDepartmentform() {
	$("#departmentName").val("");
	$("#departmentLocation").val("");
	getManager();
	$("#departmentNameerror").text("");
	$("#departmentHeaderror").text("");
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function isLetter(evt) {
	var inputValue = evt.charCode;
	if (!(inputValue >= 65 && inputValue <= 120)
			&& (inputValue != 32 && inputValue != 0)) {
		evt.preventDefault();
	}
}

>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
// Get data and sent to EmployerController.java.
function addEmployeeDetails() {
	var fname = $("#employeeFirstname").val();
	var mname = $("#employeeMiddlename").val();
	var lname = $("#employeeLastname").val();

	var employeeFirstname = fname + "," + mname + "," + lname;
	var employeeDateofbirth = $("#employeeDateofbirth").val();
	var employeeNic = $("#employeeNic").val();
	var employeeGender = $("#employeeGender").val();
	var employeeMaritalstatus = $("#employeeMaritalstatus").val();
	var employeeEpf = $("#employeeEpf").val();
	var employeeBasis = $("#employeeBasis").val();
	var employeeDesignation = $("#employeeDesignation").val();
	var employeeDepartment = $("#employeeDepartment").val();
	var employeePermenetaddress = $("#employeePermenetaddress").val();
	var employeeTemporaryaddress = $("#employeeTemporaryaddress").val();
	var employeeTelephone = $("#employeeTelephone").val();
	var employeeMobile = $("#employeeMobile").val();
	var employeeEmail = $("#employeeEmail").val();
	var employeeJoindate = $("#employeeJoindate").val();

	var employeeFirstnameerror = $("#employeeFirstnameerror").text();
	var employeeMiddlenameerror = $("#employeeMiddlenameerror").text();
	var employeeLastnameerror = $("#employeeLastnameerror").text();
	var employeeNicerror = $("#employeeNicerror").text();
	var employeeEpferror = $("#employeeEpferror").text();
	var employeeDesignationerror = $("#employeeDesignationerror").text();

	var employeeData = {
		"employeeName" : employeeFirstname,
		"employeeDateofbirth" : employeeDateofbirth,
		"employeeNic" : employeeNic,
		"employeeGender" : employeeGender,
		"employeeMaritalstatus" : employeeMaritalstatus,
		"employeeEpf" : employeeEpf,
		"employeeBasis" : employeeBasis,
		"employeeDesignation" : employeeDesignation,
		"employeeDepartment" : employeeDepartment,
		"employeePermenetaddress" : employeePermenetaddress,
		"employeeTemporaryaddress" : employeeTemporaryaddress,
		"employeeTelephone" : employeeTelephone,
		"employeeMobile" : employeeMobile,
		"employeeEmail" : employeeEmail,
		"employeeJoindate" : employeeJoindate,
	};

<<<<<<< HEAD
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(employeeData),
			task : "ADD"
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			document.getElementById("moredetails").disabled = false;
			if (data == "Details added successfully.") {
				clearAddemployeeform();
				document.getElementById("moredetails").disabled = false;
=======
	if ((fname == "") || (mname == "") || (lname == "") || (employeeNic == "")
			|| (employeeEpf == "") || (employeeDesignation == "")) {
		alert("Please fill the Empty fields.");
	} else if ((employeeFirstnameerror != "")
			|| (employeeMiddlenameerror != "") || (employeeLastnameerror != "")
			|| (employeeNicerror != "") || (employeeEpferror != "")
			|| (employeeDesignationerror != "")) {
		alert("Please fill the details correctly.");
	} else {
		$.ajax({
			type : "POST",
			url : 'EmployerController',
			data : {
				jsonData : JSON.stringify(employeeData),
				task : "AEB"
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearAddemployeeform();
					document.getElementById("moredetails").disabled = false;
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
			}
		});
	}
}


function clearAddemployeeform() {
	$("#employeeFirstname").val("");
	$("#employeeMiddlename").val("");
	$("#employeeLastname").val("");
	$("#employeeDateofbirth").val("");
	$("#employeeNic").val("");
	$("#employeeGender").val("");
	$("#employeeMaritalstatus").val("");
	$("#employeeEpf").val("");
	$("#employeeBasis").val("");
	$("#employeeDesignation").val("");
	$("#employeePermenetaddress").val("");
	$("#employeeTemporaryaddress").val("");
	$("#employeeTelephone").val("");
	$("#employeeMobile").val("");
	$("#employeeEmail").val("");
	$("#employeeJoindate").val("");
<<<<<<< HEAD
	$("#employeeNumber").val("");	
=======
	$("#employeeFirstnameerror").text("");
	$("#employeeMiddlenameerror").text("");
	$("#employeeLastnameerror").text("");
	$("#employeeNicerror").text("");
	$("#employeeEpferror").text("");
	$("#employeeDesignationerror").text("");
	getDepartment();
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
}

// load data to edit emplyee details no changed
$(document).on("click", "#ebutton", function() {
	$.get("EmployerController", function(data, status) {

		alert(data);
		json = JSON.parse(data);
		$(".modal-body #employeeNumberEdit").val(json.ID);
		$(".modal-body #employeeNameEdit").val(json.NAME);
		$(".modal-body #employeeDesignationEdit").val(json.DESIGNATION);
		// (".modal-body #employeeDateofBothEdit").val( json.Salary);
		$(".modal-body #employeeEmailEdit").val(json.EMAIL);
		$(".modal-body #employeeDateofBothEdit").val(json.DOB);
		$(".modal-body #employeeNICEdit").val(json.NIC);
		$(".modal-body #employeeGenderEdit").val(json.GENDER);
		$(".modal-body #employeeAddressEdit").val(json.PERMENENTADDRESS);
		$(".modal-body #employeeMobileNumberEdit").val(json.MOBILENO);
		$(".modal-body #employeeOtherNumberEdit").val(json.OTHERNO);
		$(".modal-body #employeeDepartmentEdit").val(json.DEPTID);
		$(".modal-body #employeeJoinDateEdit").val(json.DATEOFJOIN);
		$(".modal-body #employeeMaritalEdit").val(json.MARITALSTATUS);
		$(".modal-body #employeeEPFEdit").val(json.EPF);
		$(".modal-body #employeeTempADDEdit").val(json.TEMPORARYADDRESS);

	});

});
// ajax Json parsing
function updateEmployeeDetails() {
	var employeeNumber = $("#employeeNumberEdit").val();
	var employeeName = $("#employeeNameEdit").val();
	var employeeDesignation = $("#employeeDesignationEdit").val();
	var employeeDateofBoth = $("#employeeDateofBothEdit").val();
	var employeeGender = $("#employeeGenderEdit").val();
	var employeeAddress = $("#employeeAddressEdit").val();
	var employeeMobileNumber = $("#employeeMobileNumberEdit").val();
	var employeeOtherNumber = $("#employeeOtherNumberEdit").val();
	var employeeEmail = $("#employeeEmailEdit").val();
	var employeeDepartment = $("#employeeDepartmentEdit").val();
	var employeeJoinDate = $("#employeeJoinDateEdit").val();
	var MARITALSTATUS = $("employeeMaritalEdit").val;
	var MODBY = null;
	var MODON = null;
	var EPF = $("employeeEPFEdit").val;
	var BASIS = null;

	var employeeData = {

		"ID" : employeeNumber,
		"NAME" : employeeName,
		"DESIGNATION" : employeeDesignation,
		"DOB" : employeeDateofBoth,
		"GENDER" : employeeGender,
		"PERMENENTADDRESS" : employeeAddress,

		"MOBILENO" : employeeMobileNumber,
		"OTHERNO" : employeeOtherNumber,
		"EMAIL" : employeeEmail,
		"DEPTID" : employeeDepartment,
		"DATEOFJOIN" : employeeJoinDate,
		"MARITALSTATUS" : MARITALSTATUS,
		"MODBY" : MODBY,
		"MODON" : MODON,
		"EPF" : EPF,
		"BASIS" : BASIS
	};

	alert(JSON.stringify(employeeData));
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			Data : JSON.stringify(employeeData)
		},
		dataType : "json",
		success : function(data) {
			alert(data);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}

<<<<<<< HEAD
function isLetter(evt) {
	var inputValue = evt.charCode;
	if (!(inputValue >= 65 && inputValue <= 120)
			&& (inputValue != 32 && inputValue != 0)) {
		evt.preventDefault();
	}

}

// load data to edit
///////////////Edit Button click event//////////////
/*$('#employeeDetails tbody').on( 'click', '#edit', function () {
       var data = eTable.row( $(this).parents('tr') ).data();
       $.get("EmployerController", function(data, status) {

    		alert(data);
    		json = JSON.parse(data);
    		$(".modal-body #employeeNumberEdit").val( json.employeeId);
    		$(".modal-body #employeeNameEdit").val( json.employeeName);
    		$(".modal-body #employeeDesignationEdit").val( json.employeeDesignation);
    		$(".modal-body #employeeEmailEdit").val( json.employeeEmail);
    		$(".modal-body #employeeDateofBothEdit").val( json.employeeDateofbirth);
    		$(".modal-body #employeeNICEdit").val( json.employeeNic);
    		$(".modal-body #employeeGenderEdit").val( json.employeeGender);
    		$(".modal-body #employeeAddressEdit").val( json.employeePermenetaddress);
    		$(".modal-body #employeeTempADDEdit").val( json.employeeTemporaryaddress);
    		$(".modal-body #employeeMobileNumberEdit").val( json.employeeMobile);
    		$(".modal-body #employeeOtherNumberEdit").val( json.employeeTelephone);
    		$(".modal-body #employeeDepartmentEdit").val( json.employeeDepartment);
    		$(".modal-body #employeeJoinDateEdit").val( json.employeeJoindate);
    		$(".modal-body #employeeMaritalEdit").val( json.employeeMaritalstatus);
    		$(".modal-body #employeeEPFEdit").val( json.employeeEpf);   		
   	});
  });*/
//ajax Json parsing
function updateEmployeeDetails(){
	var employeeNumber = $("#employeeNumberEdit").val();
	var employeeName = $("#employeeNameEdit").val();
	var employeeDesignation = $("#employeeDesignationEdit").val();
	var employeeDateofBoth = $("#employeeDateofBothEdit").val();
	var employeeNic =$("#employeeNICEdit").val();
	var employeeGender = $("#employeeGenderEdit").val();
	var employeeAddress = $("#employeeAddressEdit").val();
	var employeeTemAddress = $("#employeeAddressEdit").val();
	var employeeMobileNumber = $("#employeeMobileNumberEdit").val();
	var employeeOtherNumber = $("#employeeOtherNumberEdit").val();
	var employeeEmail = $("#employeeEmailEdit").val();
	var employeeDepartment = $("#employeeDepartmentEdit").val();
	var employeeJoinDate ="2011-10-06";
	var employeeMaritslStatus =$("#employeeMaritalEdit").val();
	var employeeEpf = $("#employeeEPFEdit").val();
	var employeeBasis ="Permernent";
	
	var employeeData = {
            
                "employeeId": employeeNumber,
                "employeeName": employeeName,
                "employeeDesignation": employeeDesignation,
                "employeeDateofbirth": employeeDateofBoth,
                "employeeGender": employeeGender,
                "employeePermenetaddress": employeeAddress,
                "employeeNic" : employeeNic,
                "employeeTemporaryaddress" : employeeTemAddress,
                "employeeMobile": employeeMobileNumber,
                "employeeTelephone": employeeOtherNumber,
                "employeeEmail": employeeEmail,
                "employeeDepartment": employeeDepartment,
                "employeeJoindate": employeeJoinDate,
                "employeeMaritalstatus" : employeeMaritslStatus,
                "employeeEpf" : employeeEpf,
                "employeeBasis" : employeeBasis
           
	    };
	alert(JSON.stringify(employeeData));
        
	
	$.ajax({
        type: "POST",
        url: 'EmployerController',
        data: {
        	
        	jsonData: JSON.stringify(employeeData) ,
        	task : "UEB"
        },
        dataType: "json",
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            //alert("Error "+e);
            console.log(e);
        }
    });
}

// Get data and sent to DepartmentController.java.
function addDepartmentDetails() {
	var departmentNumber = $("#departmentNumber").val();
	var departmentName = $("#departmentName").val();
	var departmentLocation = $("#departmentLocation").val();
	var departmentHead = $("#departmentHead").val();

	var jsonData = {
		"departmentNumber" : departmentNumber,
		"departmentName" : departmentName,
		"departmentLocation" : departmentLocation,
		"departmentHead" : departmentHead
	};

	$.ajax({
		type : "POST",
		url : 'DepartmentController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "ADD"
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

// Get data and sent to DepartmentController.java.
function deleteDepartmentDetails() {

}

function clearDepartmentform() {
	$("#departmentNumber").val("");
	$("#departmentName").val("");
	$("#departmentLocation").val("");
	getManager();
}

//////load more edit Employeee Detail///////////////

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}
// ///////////////////////////////////////////////

$("#buttonAddemployee").click(function() {
	alert(this.id);
});


// ////load more edit Employeee Detail///////////////
/////////////////////////////////////////////////
$(document).on("click", "#vbutton", function() {

	$.get("EmployerController", function(data, status) {

		$("#view").load("viewEmployee.jsp", function(datatl) {
			json = JSON.parse(data);
			$("#userid").text(json.ID);
			$(".panel-body #username").text(json.NAME);
			$(".panel-body #disignation").text(json.DESIGNATION);
			// $(".panel-body #salary").text( json.Salary);
			$(".panel-body #email").text(json.EMAIL);
			$(".panel-body #dob").text(json.DOB);
			$(".panel-body #Nic").text(json.NIC);
			$(".panel-body #gender").text(json.GENDER);
			$(".panel-body #adress").text(json.PERMENENTADDRESS);
			$(".panel-body #MobNumber").text(json.MOBILENO);
			$(".panel-body #OthNumber").text(json.OTHERNO);
			$(".panel-body #depid").text(json.DEPTID);
			$(".panel-body #doj").text(json.DATEOFJOIN);
			$(".modal-body #userid").val(json.EPF);
			$(".modal-body #userid").val(json.TEMPORARYADDRESS);

			$(".panel-body #doj").text(json.MARITALSTATUS);
			// $(".modal-body #userid").val( json.EPF);
			// $(".modal-body #userid").val( json.TEMPORARYADDRESS);

			alert(data);
		});
	});
});

// ///load more employee views/////////////////////////////////////
/*****************START Add Family Details*************************/
=======
// ///Familydetails
// //Add Family Details
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
function addFamilyDetails() {
	var fmemployeeId = $("#fmemployeeId").val();
	var relationship = $("#relationship").val();
	var relationDateofbirth = $("#relationDateofbirth").val();
	var relationName = $("#relationName").val();
	var occupation = $("#occupation").val();
	var workingPlace = $("#workingPlace").val();

	var employeeIdtb = isEmptyfield(fmemployeeId);
	var relationshiptb = isEmptyfield(relationship);
	var relationDateofbirthtb = isPastdate(relationDateofbirth);
	var relationNametb = isEmptyfield(relationName);

	if (employeeIdtb == false) {
		document.getElementById('fmemployeeidError').innerHTML = "** Invalid EPF Number.";
	}
	if (relationshiptb == false) {
		document.getElementById('relationshipError').innerHTML = "** Relationship can not be Empty.";
	}
	if (relationDateofbirthtb == false) {
		document.getElementById('relationbirthdateError').innerHTML = "** Invalid Birth Date.";
	}
	if (relationNametb == false) {
		document.getElementById('relationnameError').innerHTML = "** Name cannot be Empty.";
	}

<<<<<<< HEAD
	if ((employeeIdtb == true) && (relationshiptb == true) && (relationDateofbirthtb == true) && (relationNametb == true)) {
=======
	if ((employeeIdtb == true) && (relationshiptb == true)
			&& (relationDateofbirthtb == true) && (relationNametb == true)) {
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
		var jsonData = {
			"employeeEpf" : fmemployeeId,
			"fmRelationship" : relationship,
			"fmDateofbirth" : relationDateofbirth,
			"fmName" : relationName,
			"fmOccupation" : occupation,
			"fmWorkingplace" : workingPlace
		};

		$.ajax({
			type : "POST",
			url : 'EmployerController',
			data : {
				jsonData : JSON.stringify(jsonData),
<<<<<<< HEAD
				task : "ADD"
=======
				task : "AFM"
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
			},
			dataType : "json",
			success : function(data) {
				alert(data);
				if (data == "Details added successfully.") {
					clearFamilydetails();
				}
			},
			error : function(e) {
				alert("Error " + e);
				console.log(e);
			}
		});
	}
<<<<<<< HEAD

}

/*****************END Add Family Details*************************/
=======
}

function resetLabels() {
	var fmemployeeId = $("#fmemployeeId").val();
	var relationship = $("#relationship").val();
	var relationDateofbirth = $("#relationDateofbirth").val();
	var relationName = $("#relationName").val();

	var employeeIdtb = isEmptyfield(fmemployeeId);
	var relationshiptb = isEmptyfield(relationship);
	var relationDateofbirthtb = isPastdate(relationDateofbirth);
	var relationNametb = isEmptyfield(relationName);

	if (employeeIdtb == false) {
		document.getElementById('fmemployeeidError').innerHTML = "** Invalid EPF Number.";
	} else {
		document.getElementById('fmemployeeidError').innerHTML = "";
	}
	if (relationshiptb == false) {
		document.getElementById('relationshipError').innerHTML = "** Relationship can not be Empty.";
	} else {
		document.getElementById('relationshipError').innerHTML = "";
	}
	if (relationDateofbirthtb == false) {
		document.getElementById('relationbirthdateError').innerHTML = "** Invalid Birth Date.";
	} else {
		document.getElementById('relationbirthdateError').innerHTML = "";
	}
	if (relationNametb == false) {
		document.getElementById('relationnameError').innerHTML = "** Name cannot be Empty.";
	} else {
		document.getElementById('relationnameError').innerHTML = "";
	}
}

>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
function clearFamilydetails() {
	$("#relationDateofbirth").val("");
	$("#relationName").val("");
	$("#occupation").val("");
	$("#workingPlace").val("");
	$("#fmemployeeidError").text("");
	$("#relationshipError").text("");
	$("#relationbirthdateError").text("");
	$("#relationnameError").text("");
	$('#relationship option').prop('selected', function() {
		return this.defaultSelected;
	});

}

<<<<<<< HEAD

function loadEditContentqualifications() {
	$("#Editmodelrest").load("EditemployeeDetails/EditeducationalDetails.jsp");
}

function loadEditemployementhistory() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemployementHistory.jsp");
}

function loadEditContentstudyprograms() {
	$("#Editmodelrest").load("EditemployeeDetails/EditstudyPrograms.jsp");
}

function loadEditlanguages() {
	$("#Editmodelrest").load("EditemployeeDetails/EditlanguageProficiency.jsp");
}
=======
// ///////////////////////////////////////////////
$(document).on("click", "#vbutton", function() {

	$.get("EmployerController", function(data, status) {

		$("#view").load("viewEmployee.jsp", function(datatl) {
			json = JSON.parse(data);
			$("#userid").text(json.ID);
			$(".panel-body #username").text(json.NAME);
			$(".panel-body #disignation").text(json.DESIGNATION);
			// $(".panel-body #salary").text( json.Salary);
			$(".panel-body #email").text(json.EMAIL);
			$(".panel-body #dob").text(json.DOB);
			$(".panel-body #Nic").text(json.NIC);
			$(".panel-body #gender").text(json.GENDER);
			$(".panel-body #adress").text(json.PERMENENTADDRESS);
			$(".panel-body #MobNumber").text(json.MOBILENO);
			$(".panel-body #OthNumber").text(json.OTHERNO);
			$(".panel-body #depid").text(json.DEPTID);
			$(".panel-body #doj").text(json.DATEOFJOIN);
			$(".modal-body #userid").val(json.EPF);
			$(".modal-body #userid").val(json.TEMPORARYADDRESS);

			$(".panel-body #doj").text(json.MARITALSTATUS);
			// $(".modal-body #userid").val( json.EPF);
			// $(".modal-body #userid").val( json.TEMPORARYADDRESS);

			alert(data);
		});
	});
});

// ///load more employee views/////////////////////////////////////
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b

function loadviewqlifications() {
	$("#viewmodelrest").load("viewemployeeDetails/vieweducationalDetails.jsp");
}

function loadviewemployementhistory() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemployementHistory.jsp");
}

function loadviewstudyprograms() {
	$("#viewmodelrest").load("viewemployeeDetails/viewstudyPrograms.jsp");
}

function loadviewlanguages() {
	$("#viewmodelrest").load("viewemployeeDetails/viewlanguageProficiency.jsp");
}

function loadviewloandetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewloanDetails.jsp");
}
function loadviewfamilydetails() {
	$("#viewmodelrest").load("viewemployeeDetails/viewfamilyDetails.jsp");
}
function loadviewemergencycontacts() {
	$("#viewmodelrest").load("viewemployeeDetails/viewemergencyContacts.jsp");
}

function loadEditContentloandetails() {
<<<<<<< HEAD
	$("#Editmodelrest").load("EditemployeeDetails/EditloanDetails.jsp", function(datatl) {
		var employeeEpf = $("#employeeEPFEdit").val();
	$.get("EmployerController",
			{
	          serchVlaue : employeeEpf,
	          task : "GL"
		    },  
			function(data, status) {
		alert(data);
		json = JSON.parse(JSON.parse(data));
		$("#employeeEPFEdit").val(json.employeeEpf);
		$("#totalOutstandingEdit").val(json.loanAmount);
		$("#guaranter1Edit").val(json.loanGuarantor1);	
		$("#guaranter2Edit").val(json.loanGuarantor2);	
		$("#monthlyPaymentEdit").val(json.loanmonthlyPayment);
		$("#dueDateEdit").val(json.loanDueDate);
		$("#endDateEdit").val(json.loanEndDate);
		
		});
	});
}	
	
=======
	$("#Editmodelrest").load("EditemployeeDetails/EditloanDetails.jsp");
}
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
function loadEditContentfamilydetails() {
	$("#Editmodelrest").load("EditemployeeDetails/EditfamilyDetails.jsp");
}
function loadEditemergencycontacts() {
	$("#Editmodelrest").load("EditemployeeDetails/EditemergencyContacts.jsp");
}

<<<<<<< HEAD
function loadlonedetails() {
	$("#modelrest").load("employeeDetails/loanDetails.jsp");
}


/////////////////////add Loan Detaile///////////////////
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
		"loanDueDate" : loanDueDate ,
		"loanEndDate" : loanEndDate
	};
    
	alert(JSON.stringify(jsonData));
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "RL"
=======
function disableButton() {
	// document.getElementById("moredetails").disabled = true;
}

// ////Add Education Details /////////

function AddEducationDetails() {
	var employeeId = $("#employeeId").val();
	var qualificationName = $("#qualificationName").val();
	var educatedPlace = $("#educatedPlace").val();
	var mediumStudied = $("#mediumStudied").val();
	var startedOn = $("#startedOn").val();
	var compleatedOn = $("#compleatedOn").val();
	var studyTime = checkStudyTime();

	var EducationData = {
		"employeeEpf" : employeeId,
		"eduQualification" : qualificationName,
		"eduUniversity" : educatedPlace,
		"eduMedium" : mediumStudied,
		"eduStartedon" : startedOn,
		"eduCompltedon" : compleatedOn,
		"eduStudytime" : studyTime

	};
	alert(JSON.stringify(EducationData));

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(EducationData),
			task : "AED"
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
		},
		dataType : "json",
		success : function(data) {
			alert(data);
			if (data == "Details added successfully.") {
<<<<<<< HEAD
				clearLoanDetails();
			}
		},
		error : function(e) {
			//alert("Error " + e);
			console.log(e);
		}		
	});
	
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
	

/////Update Loan Detaile////////////////////////////////////////////////////////////////////////////////////////////////////////

function updateLoanDetailes() {
	
	var employeeEpf = $("#employeeEPFEdit").val();
	var loanAmount = $("#totalOutstandingEdit").val();
	var loanGuarantor1= $("#guaranter1Edit").val();
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
		"loanEndDate" : loanEndDate
	};
	alert(JSON.stringify(jsonData));
	$.ajax({
		type : "POST",
		url : 'EmployerController',
		data : {
			jsonData : JSON.stringify(jsonData),
			task : "UL",
			serchVlaue : employeeEpf
=======
				clearAddeducationform();
				// document.getElementById("moredetails").disabled = false;
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

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
// Check Study time
function checkStudyTime() {
	if ((document.getElementById('weekdays').checked)
			&& (document.getElementById('weekends').checked)) {
		return 1;
	} else if (document.getElementById('weekends').checked) {
		return 2;
	} else if (document.getElementById('weekdays').checked) {
		return 3;
	} else {
		return 4;
	}
}

// ///Load data to edit Educational Details

function loadDataEducationalDetails() {

	var jsonData = "1";
	$.getJSON('EmployeeController', {
		jsonData : JSON.stringify(jsonData),
		task : "FIND"
	}, function(data) {
		json = JSON.parse(data);
		$("#employeeId").val(json.employeeEpf);
		$("#qualificationName").val(json.eduQualification);
		$("#educatedPlace").val(json.eduUniversity);
		$("#mediumStudied").val(json.eduMedium);
		$("#startedOn").val(json.eduStartedon);
		$("#compleatedOn").val(json.eduCompltedon);

		if (json.eduStudytime == 1) {
			document.getElementById("weekdays").checked;
			document.getElementById("weekends").checked;
		} else if (json.eduStudytime == 2) {
			document.getElementById("weekdays").checked;
		} else if (json.eduStudytime == 3) {
			document.getElementById("weekends").checked;
		} else {
			// do nothing
		}
	});

}

// /////Edit Educational Details ////////
function EditEducationDetails() {
	var employeeId = $("#employeeId").val();
	var qualificationName = $("#qualificationName").val();
	var educatedPlace = $("#educatedPlace").val();
	var mediumStudied = $("#mediumStudied").val();
	var startedOn = $("#startedOn").val();
	var compleatedOn = $("#compleatedOn").val();
	var studyTime = checkStudyTime();

	var EducationData = {
		"employeeEpf" : employeeId,
		"eduQualification" : qualificationName,
		"eduUniversity" : educatedPlace,
		"eduMedium" : mediumStudied,
		"eduStartedon" : startedOn,
		"eduCompltedon" : compleatedOn,
		"eduStudytime" : studyTime
	};
	// alert(JSON.stringify(EducationData));

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(EducationData),
			task : "UPDATE"
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b
		},
		dataType : "json",
		success : function(data) {
			alert(data);
<<<<<<< HEAD
			if (data == "Details added successfully.") {
				clearLoanDetails();
			}
		},
		error : function(e) {
			//alert("Error " + e);
			console.log(e);
		}		
	});
}
	


=======
			if (data == "Details Updated successfully.") {
				clearAddeducationform();
				// document.getElementById("moredetails").disabled = false;
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}
// ///////////////// load employee details//////////////////////

function loademployeeDetails() {

	var serchContent = "1";

	var jsonData = {
		"serchContent" : serchContent
	};

	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "GETBASIC"
		},
		dataType : "json",
		success : function(responseText) {
			// alert("ajax" + responseText);
			json = JSON.parse(responseText);
			// alert(responseText);
			$("#employee_id").text(json.employeeEpf);
			$("#name").text(json.employeeName);
			$("#mobilenumber").text(json.employeeMobile);
			$("#landnumber").text(json.employeeTelephone);
			$("#mobilenumber1").text(json.employeeMobile);
			$("#landnumber1").text(json.employeeTelephone);
			$("#work_email").text(json.employeeEmail);
			$("#work_email1").text(json.employeeEmail);
			$("#nic_num").text(json.employeeNic);
			$("#nic_num1").text(json.employeeNic);
			$("#birthday").val(json.employeeDateofbirth);
			// $("#gender").text(json.employeeGender);

			if (json.employeeGender == 'M') {
				$("#gender").text('Male');
			} else {
				$("#gender").text('Female');
			}

			$("#marital_status").text(json.employeeMaritalstatus);
			$("#address1").text(json.employeePermenetaddress);
			$("#address2").text(json.employeeTemporaryaddress);
			$("#job_title").text(json.employeeDesignation);
			$("#department_Name").text(json.employeeDepartment);
			$("#bassis").text(json.employeeBasis);
			$("#joindate").text(json.employeeJoindate);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}
// /////////////// load employee education details///////////////

function loadEducationDetails() {

	var serchContent = "1";

	var jsonData = {
		"serchContent" : serchContent
	};
	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "GED"
		},
		dataType : "json",
		success : function(responseText) {
			// alert("ajax" + responseText);
			json = JSON.parse(responseText);
			// alert(responseText + " " + json.eduUniversity + " "
			// + json.eduMedium + " " + json.eduStartedon + " "
			// + json.eduCompltedon);
			$("#employeeId").text(json.employeeEpf);
			$("#qualificationName").text(json.eduQualification);
			$("#educatedPlace").text(json.eduUniversity);
			$("#mediumStudied").text(json.eduMedium);
			$("#startedOn").text(json.eduStartedon);
			$("#compleatedOn").text(json.eduCompltedon);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});

}

// /////load family Details//////

function loadFamilyDetails() {
	var serchContent = "1";

	var jsonData = {
		"serchContent" : serchContent
	};
	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "GETFAMILY"
		},
		dataType : "json",
		success : function(responseText) {

			json = JSON.parse(responseText);

			$("#relationship").text(json.fmRelationship);
			$("#relationDateofbirth").text(json.fmDateofbirth);
			$("#relationName").text(json.fmName);
			$("#occupation").text(json.fmOccupation);
			$("#workingPlace").text(json.fmWorkingplace);

		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}
>>>>>>> 5865b028598a2885b290118a301afec6bac98d9b