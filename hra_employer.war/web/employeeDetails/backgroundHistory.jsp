

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.genesiis.hra.validation.AilmentEnum"%>

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
				
<style>
th#tbledit {
	text-align: center;
}
th#tbldelete {
	text-align: center;
}
</style>


<!--Edit Employee History Modal -->	
<div>
	<div>
		<!-- Modal content-->
		<div class="modal-body">

			<div>
				<label><h3 class="modal-title">
						<i class="glyphicon glyphicon-check"></i>Add Medical History
					</h3></label>
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="employeeId">Employee ID</label> 
						<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="" maxlength="10" value="2" readonly >
					</div>
				</div>
				
			
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
								<label for="employeeAilment">Ailment</label> 
								<select class="form-control" id="employeeAilment" name="employeeAilment" >
									<option value="">--Select--</option>
									<c:forEach items="<%=AilmentEnum.values()%>" var="entry">
									    <option>${entry.key}</option>
									</c:forEach>
								</select>
							</div>
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="ailmentDescription">Description</label> 
						<input type="text"	class="form-control" id="ailmentDescription" name="ailmentDescription" placeholder="" maxlength="100" >
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="reportDescription">Report Description</label> 
						<input type="text" class="form-control" id="reportDescription" name="reportDescription" placeholder="Report Description" >
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label" for="reportUpload">Report Upload</label>
						
							<form id="UploadForm" action="EmployeeController" method="post" enctype="multipart/form-data">
							
								<div class="fileinput fileinput-new" data-provides="fileinput">
								  
								  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
								    <img data-src="holder.js/100%x100%" alt="...">
								  </div>
								  
								  <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
								  
								  <div>
								    <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span>
								    <span class="fileinput-exists">Change</span> <input type="file" size="60" id="myfile" name="myfile"> </span>
							   			 <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
							   			 <input class="btn btn-default fileinput-exists"  type="submit" value="Ajax File Upload">
							  	  </div>
							  	  
							  		
							      
							       <div id="progressbox">
							         <div id="progressbar"></div>
							         <div id="percent">0%</div>
							       </div>
							       
							    </div>
							    
							</form>
				
					</div>
				</div>
			</div>
			
			<div class="modal-footer">
			
				<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" value="ADMIN_USER_TR" >
				
				<!-- SAVE -->
				<button type="button" class="btn btn-success full pull-right" onclick="addMedicalhistorydetails(); ">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save 
				</button>
				
				<!-- SAVE 2-->
				<button type="button" class="btn btn-success full pull-right" onclick="loadTestDetails(); ">
					<i class="glyphicon glyphicon-floppy-disk"></i> TEST Save 
				</button>
				
				<!-- CLEAR -->
				<button type="button" class="btn btn-warning pull-left"	onclick="clearMedicalHisory()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				
				<!-- CANCEL -->
				<button type="button" id="buttonCancelemployee"	class="btn btn-danger pull-left" data-dismiss="modal" onclick="clearMedicalHisory()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
				
			</div>
			
		</div>

	</div>

</div>


