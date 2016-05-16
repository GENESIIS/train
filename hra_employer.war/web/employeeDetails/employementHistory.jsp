<script type="text/javascript">

	//To load the Datatable
	$(document).ready(function() {

		$('#employmentHistorydetails').DataTable();

		$("#btn3").click(function() {

			$("#employeeId").val("001");
			$("#employer").val("employer name");
			$("#designation").val("designation");
			$("#ehComments").val("ehComments");
			$("#ehEmail").val("ehEmail@gmail.com");
			
			$("#ehReferenceonename").val("Referenceonename 1");
			$("#ehReferenceonecomments").val("Referenceonecomments1");
			$("#ehReferenceonephone").val("Referenceonephone 1");
			$("#ehReferenceonemobile").val("Referenceonemobile1");
			$("#ehReferenceoneaddress").val("Referenceoneaddress1");
			$("#ehReferenceonedesignation").val("Referenceonedesignation1");

			$("#ehReferencetwoname").val("Referenceonename2");
			$("#ehReferencetwocomments").val("Referencetwocomments2");
			$("#ehReferencetwophone").val("Referencetwophone2");
			$("#ehReferencetwomobile").val("referenceTwocomments 22222");
			$("#ehReferencetwoaddress").val("referenceTwo 22222");
			$("#ehReferencetwodesignation").val("referenceTwocomments 22222");

			$("#ehReferencemodby").val("ADMIN_USER_TR");
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


<!--Add Employee History Modal -->	
<div>
	<div>
		<!-- Modal content-->
		<div class="modal-body">

			<div>
				<label><h3 class="modal-title">
						<i class="glyphicon glyphicon-check"></i>Employment History
					</h3></label>
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="employeeId">Employee ID</label> 
						<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="" maxlength="10">
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="employer">Employer Name</label> 
						<input type="text" class="form-control" id="employer" name="employer" placeholder="" maxlength="100">
					</div>
				</div>
			
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="designation">Designation</label> 
						<input type="text"	class="form-control" id="designation" name="designation" placeholder="" maxlength="20">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
								<label for="basis">Employment Basis (Contract/Intern/Permanent)</label> <select
									class="form-control" id="basis" name="basis">
									<option value="">--Select--</option>
									<option value="Permanent">Permanent</option>
									<option value="Contract">Contract</option>
									<option value="Trainee">Trainee</option>
								</select>
							</div>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="startedOn">Started On</label> 
						<input type="date" class="form-control" id="startedOn" name="startedOn" placeholder="">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="compleatedOn">Completed On</label> 
						<input type="date" class="form-control" id="compleatedOn" name="compleatedOn" placeholder="">
					</div>
				</div>
			</div>
			<!-- refreee 1-->

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonename">Reference Name</label> 
						<input
							type="text" class="form-control" id="ehReferenceonename" name="ehReferenceonename" placeholder="" maxlength="300">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonecomments">Reference Comments</label>
						<textarea type="text" class="form-control" 	id="ehReferenceonecomments" name="ehReferenceonecomments" placeholder="" maxlength="300"></textarea>
					</div>
				</div>

			</div>




			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonephone">Reference Phone</label>
						<input type="text" class="form-control" id="ehReferenceonephone" name="ehReferenceonephone" placeholder="" onkeypress="return isNumber(event)" maxlength="30">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonemobile">Reference Mobile</label>
						<input type="text" class="form-control"  id="ehReferenceonemobile" name="ehReferenceonemobile" placeholder="" onkeypress="return isNumber(event)" maxlength="30"></input>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehReferenceoneaddress">Reference Address</label>
						<input type="text" class="form-control" id="ehReferenceoneaddress" name="ehReferenceoneaddress" placeholder="" maxlength="500">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonedesignation">Reference Designation</label>
						<input type="text" class="form-control" id="ehReferenceonedesignation" name="ehReferenceonedesignation" placeholder="" maxlength="100"></input>
					</div>
				</div>
			</div>


				<!-- refreee 2-->

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwoname">Reference Name</label> 
						<input type="text" class="form-control" id="ehReferencetwoname" name="ehReferencetwoname" placeholder="" maxlength="300">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwocomments">Reference Comments</label>
						<textarea type="text" class="form-control" 	id="ehReferencetwocomments" name="ehReferencetwocomments" placeholder="" maxlength="300"></textarea>
					</div>
				</div>

			</div>
			
			
			

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwophone">Reference Phone</label>
						<input type="text" class="form-control" id="ehReferencetwophone" name="ehReferencetwophone" placeholder="" onkeypress="return isNumber(event)" maxlength="30">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwomobile">Reference Mobile</label>
						<input type="text" class="form-control" 	id="ehReferencetwomobile" name="ehReferencetwomobile" placeholder="" onkeypress="return isNumber(event)" maxlength="30"></input>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehReferencetwoaddress">Reference Address</label>
						<input type="text" class="form-control" id="ehReferencetwoaddress" name="ehReferencetwoaddress" placeholder="" maxlength="500">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwodesignation">Reference Designation</label>
						<input type="text" class="form-control" id="ehReferencetwodesignation" name="ehReferencetwodesignation" placeholder="" maxlength="100"></input>
					</div>
				</div>
				
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehEmail">E-mail Address</label> <input type="text" class="form-control" id="ehEmail" name="ehEmail" placeholder="" maxlength="100">
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehComments">Comments</label> <input type="text" class="form-control" id="ehComments" name="ehComments" placeholder="" maxlength="200">
					</div>
				</div>

			</div>


			<div class="modal-footer">
				<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" >
				<button type="button" class="btn btn-success full pull-right"
					onclick="addEmployeeHistoryDetails();">
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
				
				<button type="button" class="btn btn-success full pull-right" id=btn3>
					<i class="glyphicon glyphicon-floppy-disk"></i> Test
				</button>

				
			</div>


			<!-- 			<div> -->


<!-- 				<div class="row pad"> -->

<!-- 					<div class="col-xs-2 "> -->
<!-- 					<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" placeholder=""> -->
<!-- 						<button type="button" class="btn btn-danger full"> -->
<!-- 							<i class="glyphicon glyphicon-floppy-remove"></i> Cancel -->
<!-- 						</button> -->
<!-- 					</div> -->

<!-- 					<div class="col-xs-2 "> -->
<!-- 						<button type="button" class="btn btn-success full" onclick="addEmployeeHistoryDetails();"> -->
<!-- 							<i class="glyphicon glyphicon-floppy-disk"></i> Add New -->
<!-- 						</button> -->
<!-- 					</div> -->

<!-- 					<div class="col-xs-2 "> -->
<!-- 						<button type="button" class="btn btn-success full" id=btn3> -->
<!-- 							<i class="glyphicon glyphicon-floppy-disk"></i> Test -->
<!-- 						</button> -->
<!-- 						<button type="button" id="buttonCancelemployee" class="btn btn-danger pull-left" >  -->
<!-- 				 					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel  -->
<!-- 			 				</button> -->
<!-- 					</div> -->

<!-- 				</div> -->

<!-- 			</div> -->

		</div>

	</div>

</div>


<!--Add Educational Modal -->
<div class="modal fade" id="addEmploymenthistorydetails" name="addEducationaldetails" role="dialog">

</div>

<!--edit Educational Modal -->
<div class="modal fade" id="editEmploymenthistorydetails"
	name="addEducationaldetails" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Employment History
				</h3>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="editemployeeId">Employee</label> <input type="text"
						class="form-control" id="editemployeeId" name="editemployeeId"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="editemployer">Employer</label> <input type="text"
						class="form-control" id="editemployer" name="editemployer"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="editdesignation">Designation</label> <input type="text"
						class="form-control" id="editdesignation" name="editdesignation"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="basis">Basis (Contract/Intern/Permanent)</label> <input
						type="text" class="form-control" id="basis" name="basis"
						placeholder="">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="editstartedOn">Started On</label> <input type="date"
								class="form-control" id="editstartedOn" name="editstartedOn"
								placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="editcompleatedOn">Completed On</label> <input
								type="date" class="form-control" id="editcompleatedOn"
								name="editcompleatedOn" placeholder="">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="editreferenceOne">Reference 1</label> <input
								type="text" class="form-control" id="editreferenceOne"
								name="editreferenceOne" placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="editreferenceOnecomments">Comments</label>
							<textarea class="form-control" id="editreferenceOnecomments"
								name="editreferenceOnecomments" placeholder=""></textarea>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="editreferenceTwo">Reference 2</label> <input
								type="text" class="form-control" id="editreferenceTwo"
								name="editreferenceTwo" placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="editreferenceTwocomments">Comments</label>
							<textarea class="form-control" id="editreferenceTwocomments"
								name="editreferenceTwocomments" placeholder=""></textarea>
						</div>
					</div>
				</div>
				<div>
					<button type="button" id="buttonAddemployee">Save</button>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" id="buttonAddemployee"
					class="btn btn-success pull-side">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" id="buttonCancelemployee"
					class="btn btn-danger pull-left">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>

			</div>
		</div>

	</div>
</div>

