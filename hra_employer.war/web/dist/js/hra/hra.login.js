/**
 * 2016/06/28 AS created for login HRA-44
 */

function userLogin() {
	var userName = $("#inputUserName").val();
	var password = $("#inputPassword").val();

	var uname = isEmptyfield(userName);
	var pass = isEmptyfield(password);

	if (uname == false) {
		document.getElementById('inputUserNameError').innerHTML = "** Invalid User Name.";
	}
	if (pass == false) {
		document.getElementById('inputPasswordError').innerHTML = "** Invalid Password.";
	}

	if ((uname == true) && (pass == true)) {
		var jsonData = {
			"username" : userName,
			"pasword" : password
		};
	}

	$.ajax({
		type : "POST",
		url : 'LoginController',
		data : {
			jsonData : JSON.stringify(jsonData)
			
			 
		},
		dataType : "json",
		success : function(responseText) {
			alert(responseText);
			if(responseText == "Successfully loged"){
				$( "#result" ).load( "login.jsp" );
			}
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
}