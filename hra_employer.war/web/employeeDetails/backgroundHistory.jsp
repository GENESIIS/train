

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.genesiis.hra.validation.AilmentEnum"%>

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
						<input id="input-6" name="input6[]" type="file" multiple class="file-loading" placeholder="Select Files">					
					</div>
				</div>
			</div>
			
			
<!-- 			<div class="modal-footer"> -->
			
<!-- 				<button type="button" class="btn btn-success full pull-right" id="btnAddd" onclick="Add();"> -->
<!-- 					<i class="glyphicon glyphicon-floppy-disk"></i> Add -->
<!-- 				</button> -->

<!-- 			</div> -->

<!-- 				<div class="modal-footer table-responsive"> -->
				
<!-- 					<table id="tblData" class="table table-striped table-bordered table-hover table-condensed" style="font-size:small;">			 -->
						
<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th id="t012">Employee Id</th> -->
<!-- 								<th id="t012">Employee Ailment</th> -->
<!-- 								<th id="t012">Ailment Description</th> -->
<!-- 								<th id="t012">Report Description</th> -->
<!-- 								<th id="t012">Report Uploaded</th> -->
<!-- 								<th id="t012">Created By</th> -->
<!-- 								<th id="tbledit" >Edit</th> -->
<!-- 								<th id="tbldelete">Delete</th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
						
<!-- 						<tbody> -->
							
<!-- 						</tbody> -->
						
						
<!-- 						<tfoot> -->
<!-- 						<tr> -->
<!-- 								<th id="t012">Employee Id</th> -->
<!-- 								<th id="t012">Employee Ailment</th> -->
<!-- 								<th id="t012">Ailment Description</th> -->
<!-- 								<th id="t012">Report Description</th> -->
<!-- 								<th id="t012">Report Uploaded</th> -->
<!-- 								<th id="t012">Created By</th> -->
<!-- 								<th id="tbledit">Edit</th> -->
<!-- 								<th id="tbldelete">Delete</th> -->
<!-- 							</tr> -->
<!-- 						</tfoot> -->
						
<!-- 					</table> -->
<!-- 			</div> -->


			<div class="modal-footer">
			
				<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" value="ADMIN_USER_TR" >
				
				<!-- SAVE -->
				<button type="button" class="btn btn-success full pull-right" onclick="addMedicalHistoryDetails();">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save 
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


