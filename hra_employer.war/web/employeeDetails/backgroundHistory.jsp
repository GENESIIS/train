<script type="text/javascript">

	getAilment();
	
	
	//To load the Datatable
	$(document).ready(function() {

		$("#btn4").click(function() {

			$("#employeeId").val("001");
			$("#employer").val("employer name");
			$("#designation").val("designation");
			$("#ehComments").val("ehComments");
			$("#ehEmail").val("ehEmail@gmail.com");

			$("#ehReferencemodby").val("ADMIN_USER_TR");
			$("#ehEmpid").val("7");
		});

		
	});
	

	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	}
	
</script>


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
						<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="" maxlength="10" onblur="checkTextField(this);">
					</div>
				</div>
				
			
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
								<label for="employeeAilment">Ailment</label> <select
									class="form-control" id="employeeAilment" name="employeeAilment" >
									<option value="">--Select--</option>
									<option value="Permanent">Permanent</option>
									<option value="Contract">Contract</option>
									<option value="Trainee">Trainee</option>
								</select>
								
								
							</div>
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="designation">Description</label> 
						<input type="text"	class="form-control" id="designation" name="designation" placeholder="" maxlength="20" onblur="checkTextField(this);">
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="startedOn">Report Description</label> 
						<input type="date" class="form-control" id="startedOn" name="startedOn" placeholder="" onblur="checkTextField(this);">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="compleatedOn">Report Upload</label> 
						<input type="date" class="form-control" id="compleatedOn" name="compleatedOn" placeholder="" onblur="checkTextField(this);">
					</div>
				</div>
			</div>
			


			<div class="modal-footer">
				<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" value="ADMIN_USER_TR" >
				<input type="hidden" class="form-control" id="ehEmpid" name="ehEmpid" value="7">
				<button type="button" class="btn btn-success full pull-right"
					onclick="editEmployeeHistoryDetails();">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>

				<button type="button" class="btn btn-warning pull-left"
					onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" id="buttonCancelemployee"
					class="btn btn-danger pull-left" data-dismiss="modal" onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
				
<!-- 				<button type="button" class="btn btn-success full pull-right" id=btn4> -->
<!-- 					<i class="glyphicon glyphicon-floppy-disk"></i> Test -->
<!-- 				</button> -->

				
			</div>

		</div>

	</div>

</div>


