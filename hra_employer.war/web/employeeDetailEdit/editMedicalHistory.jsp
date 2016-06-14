<style>
<!--
-->
.btn-space {
    margin-right: 5px;
}
</style>


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

				<!--Add Medical History Modal -->	
				<div>
					<div>
						<!-- Modal content-->
						<div class="modal-body">

							<div>
								<h3 class="modal-title">
									<label>
										<i class="glyphicon glyphicon-check"></i> Edit Medical History
									</label>
								</h3>
							</div>
				
					
							<div class="well">
							
									<div class="row">
						
										<div class="col-md-6">
											<div class="form-group">
												<label for="employeeId">Employee EPF</label> 
												<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="" maxlength="10" value="2" readonly >
											</div>
										</div>
										
									</div>
				
									<div class="row">
						
										<div class="col-md-6">
											<div class="form-group">
												<div class="form-group">
														<label for="employeeAilment">Ailment Type</label> 
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
												<label for="ailmentDescription">Ailment Description</label> 
												<input type="text"	class="form-control" id="ailmentDescription" name="ailmentDescription" placeholder="" maxlength="100" >
											</div>
										</div>
						
									</div>
							
							</div>
							
							<div class="well">
							
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="reportDescription">Report Description</label> 
												<input type="text" class="form-control" id="reportDescription" name="reportDescription" placeholder="Report Description" maxlength="100" >
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label" for="reportUpload" style="vertical-align: top;">Report Upload</label>
												
														<div class="fileinput fileinput-new" data-provides="fileinput">
														  
																  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
																    <img data-src="holder.js/100%x100%" src="dist/demoimages/images.jpg">
																  </div>
																  
																  <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
																  
																  <div>
																	    <span class="btn btn-default btn-file">
																	    			<span class="fileinput-new">Select image</span>
																	    			<span class="fileinput-exists">Change</span>
																					<input type="file"  id="avatar" name="file">
																		</span>
																		
																   		<a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
																   								   		
															  	  </div>

													       
													    </div>
		
											</div>
										</div>
									</div>
							
							</div>
				
							<div class="modal-footer">
							
								<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" value="ADMIN_USER_TR" >
								
								<!-- FILE UPLOAD -->
								<button type="button" class="btn btn-success full pull-right btn-space" id="upload" disabled="disabled">
									<i class="glyphicon glyphicon-floppy-disk"></i> Upload Reports 
								</button>
								
								<!-- SAVE -->
								<button type="button" class="btn btn-success full pull-right btn-space" onclick="addMedicalhistorydetails();"  id="save">
									<i class="glyphicon glyphicon-floppy-disk"></i> Save 
								</button>

								<!-- CLEAR -->
								<button type="button" class="btn btn-warning pull-left"	onclick="clearMedicalHisory()" id="reset">
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
				
