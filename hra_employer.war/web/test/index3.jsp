
<!-- Importing hra.helper.js file -->
<script src="dist/js/jasny-bootstrap-js/jasny-bootstrap.js"></script>
<script src="dist/js/jasny-bootstrap-js/jasny-bootstrap.min.js"></script>
<script src="dist/js/jasny-bootstrap-js/jquery.form.js"></script>

<!-- Styles for this template -->
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.css" rel="stylesheet">
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.css.map" rel="stylesheet">
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.min.css" rel="stylesheet">


<br/><br/><br/><br/><br/>
<input id="avatar" type="file" name="avatar" />
<br/><br/><br/><br/><br/>
<button id="upload" value="Upload">UPLOAD IMAGE</button>
<br/><br/><br/><br/><br/>


<script>
	$(document).on("click", "#upload", function() {
		var file_data = $("#avatar").prop("files")[0]; // Getting the properties of file from file field
		var form_data = new FormData(); // Creating object of FormData class
		form_data.append("file", file_data); // Appending parameter named file with properties of file_field to form_data
		form_data.append("user_id", 123); // Adding extra parameters to form_data
		form_data.append("task", "AMH"); // Adding extra parameters to form_data
		$.ajax({
			url : "/upload",
			dataType : 'scrpt',
			cache : false,
			contentType : false,
			processData : false,
// 			data : {
// 				jsonData : JSON.stringify(form_data),
// 				task1 : "AMH"
// 			},
			data : form_data, // Setting the data attribute of ajax with file_data
			type : 'post'
		})
	});
</script>

