/**
 * 2016/06/28 AS created for login HRA-44
 */

function serchEmployee() {
	var serchContent = $("#serchEmployeeText").val();
	var jsonData = {
		"serchContent" : serchContent
	};
	$.ajax({
		type : "POST",
		url : 'LoginController',
		data : {
			jsonData : JSON.stringify(jsonData),
			inputValue : serchContent,
			task : "SE"
		},
		dataType : "json",
		success : function(responseText) {
			listSeEmployee(responseText);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		} 
	});
}