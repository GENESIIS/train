<form action="upload" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>

<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> -->
<!-- <script src="http://malsup.github.com/jquery.form.js"></script> -->

<script>
 	$(function() {
 		alert("ajax");
 		$(document).on("#upload-button", "click", function() {
 		    $.ajax({
 		        type: "POST",
 		        url: "UploadFiles",
 		        async: true,
 		        data: $(".upload-box").serialize(),
 		        contentType: "multipart/form-data",
 		        processData: false,
 		        success: function(msg) {
 		            alert("File has been uploaded successfully");
 		        },
 		        error:function(msg) {
 		            $("#upload-error").html("Couldn't upload file");
 		        }
 		    });
 		});
 	});
</script>