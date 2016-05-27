

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
					$(document).on("click", "#upload", function() {
						var file_data = $("#avatar").prop("files")[0]; // Getting the properties of file from file field
						var reportDescription = $("#reportDescription").val();
						var employeeId = $("#employeeId").val();
						var form_data = new FormData(); // Creating object of FormData class
						form_data.append("file", file_data);
						form_data.append("reportDescription", reportDescription);// Appending parameter named reportDescription with properties of file_field to form_data
						form_data.append("employeeId", employeeId);// Appending parameter named file with properties of file_field to form_data
						form_data.append("task", "AMR"); // Adding extra parameters to form_data
						$.ajax({
							url : "EmployeeController",
							dataType : 'scrpt',
							cache : false,
							contentType : false,
							processData : false,
							data : form_data, // Setting the data attribute of ajax with file_data
							type : 'post'
						});
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
										
												<div class="fileinput fileinput-new" data-provides="fileinput">
												  
														  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
														    <img data-src="holder.js/100%x100%" alt="...">
														  </div>
														  
														  <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
														  
														  <div>
															    <span class="btn btn-default btn-file">
															    			<span class="fileinput-new">Select image</span>
															    			<span class="fileinput-exists">Change</span>
																			<input type="file"  id="avatar" name="file">
																</span>
																
														   		<a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
														   		
														   		<button class="btn btn-default" id="upload" value="Upload">Upload</button>
													  	  </div>

<!-- 															<div id="progressbox"> -->
<!-- 																<div id="progressbar"></div> -->
<!-- 																<div id="percent">0%</div> -->
<!-- 															</div> -->
															
<!-- 															<br/> -->
															
<!-- 															<div id="message"></div> -->
											       
											    </div>

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


