
<title>Asynchronous file Upload in Java Web Application</title>

<!-- Importing hra.helper.js file -->
<script src="dist/js/jasny-bootstrap-js/jasny-bootstrap.js"></script>
<script src="dist/js/jasny-bootstrap-js/jasny-bootstrap.min.js"></script>
<script src="dist/js/jasny-bootstrap-js/jquery.form.js"></script>

<!-- Styles for this template -->
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.css" rel="stylesheet">
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.css.map" rel="stylesheet">
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.min.css" rel="stylesheet">

<script>
$(document).ready(function() {
	var options = {
	        beforeSend : function() {
	                $("#progressbox").show();
	                // clear everything
	                $("#progressbar").width('0%');
	                $("#message").empty();
	                $("#percent").html("0%");
	        },
	        uploadProgress : function(event, position, total, percentComplete) {
	                $("#progressbar").width(percentComplete + '%');
	                $("#percent").html(percentComplete + '%');

	                // change message text to red after 50%
	                if (percentComplete > 50) {
	                $("#message").html("<font color='red'>File Upload is in progress</font>");
	                }
	        },
	        success : function() {
	                $("#progressbar").width('100%');
	                $("#percent").html('100%');
	        },
	        complete : function(response) {
	        $("#message").html("<font color='blue'>Your file has been uploaded!</font>");
	        },
	        error : function() {
	        $("#message").html("<font color='red'> ERROR: unable to upload files</font>");
	        }
	};
	$("#UploadForm").ajaxForm(options);
	});
</script>

<!-- <form id="UploadForm" action="UploadFile" method="post" enctype="multipart/form-data"> -->
<!--     <input type="file" size="60" id="myfile" name="myfile">  -->
<!--      <input type="submit" value="Ajax File Upload"> -->
<!--        <div id="progressbox"> -->
<!--          <div id="progressbar"></div> -->
<!--          <div id="percent">0%</div> -->
<!--        </div> -->
<!--  <br /> -->
<!-- <div id="message"></div> -->
<!-- </form> -->


<form id="UploadForm" action="UploadFile" method="post" enctype="multipart/form-data">

	<div class="fileinput fileinput-new" data-provides="fileinput">
	  
	  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
	    <img data-src="holder.js/100%x100%" alt="...">
	  </div>
	  
	  <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
	  
	  <div>
	    <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span>
	    <span class="fileinput-exists">Change</span> <input type="file" size="60" id="myfile" name="myfile"> </span>
   			 <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
  	  </div>
<!--   		<button id="up_btn">Upload</button> -->
  		<input type="submit" value="Ajax File Upload">
      
       <div id="progressbox">
         <div id="progressbar"></div>
         <div id="percent">0%</div>
       </div>
       
    </div>
    
</form>

