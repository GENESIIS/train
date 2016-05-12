<script type="text/javascript">
	
	$(function() {
		$("#startedOn").click(function() {
			$(this).datepicker().datepicker("show");
		});
	});
	
	
	//To load the Datatable
	$(document).ready(function() {

		$('#employmentHistorydetails').DataTable();

		$("#btn3").click(function() {

			$("#employeeId").val("001");
			$("#employer").val("employer name");
			$("#designation").val("designation");
			$("#basis").val("basis");

			$("#referenceOne").val("referenceOne 11111");
			$("#referenceOnecomments").val("referenceOnecomments 11111");

			$("#referenceTwo").val("referenceTwo 22222");
			$("#referenceTwocomments").val("referenceTwocomments 22222");

		});
	});
</script>


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
						<label for="employer">Employee ID</label> 
						<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="">
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="employer">Employer Name</label> 
						<input type="text" class="form-control" id="employer" name="employer" placeholder="">
					</div>
				</div>
			
			</div>
			
			<div class="row">
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="designation">Designation</label> 
						<input type="text" class="form-control" id="designation" name="designation" placeholder="">
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="basis">Basis (Contract/Intern/Permanent)</label> 
						<input type="text" class="form-control" id="basis" name="basis" placeholder="">
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
						<input type="text" class="form-control" id="ehReferenceonename" name="ehReferenceonename" placeholder="">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonecomments">Reference Comments</label>
						<textarea type="text" class="form-control" 	id="ehReferenceonecomments" name="ehReferenceonecomments" placeholder=""></textarea>
					</div>
				</div>

			</div>
			
			
			

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonephone">Reference Phone</label>
						<input type="text" class="form-control" id="ehReferenceonephone" name="ehReferenceonephone" placeholder="">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonemobile">Reference Mobile</label>
						<input type="text" class="form-control"  id="ehReferenceonemobile" name="ehReferenceonemobile" placeholder=""></input>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehReferenceoneaddress">Reference Address</label>
						<input type="text" class="form-control" id="ehReferenceoneaddress" name="ehReferenceoneaddress" placeholder="">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonedesignation">Reference Designation</label>
						<input type="text" class="form-control" id="ehReferenceonedesignation" name="ehReferenceonedesignation" placeholder=""></input>
					</div>
				</div>
			</div>


				<!-- refreee 2-->

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwoname">Reference Name</label> 
						<input type="text" class="form-control" id="ehReferencetwoname" name="ehReferencetwoname" placeholder="">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwocomments">Reference Comments</label>
						<textarea type="text" class="form-control" 	id="ehReferencetwocomments" name="ehReferencetwocomments" placeholder=""></textarea>
					</div>
				</div>

			</div>
			
			
			

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwophone">Reference Phone</label>
						<input type="text" class="form-control" id="ehReferencetwophone" name="ehReferencetwophone" placeholder="">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwomobile">Reference Mobile</label>
						<input type="text" class="form-control" 	id="ehReferencetwomobile" name="ehReferencetwomobile" placeholder=""></input>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehReferencetwoaddress">Reference Address</label>
						<input type="text" class="form-control" id="ehReferencetwoaddress" name="ehReferencetwoaddress" placeholder="">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwodesignation">Reference Designation</label>
						<input type="text" class="form-control" id="ehReferencetwodesignation" name="ehReferencetwodesignation" placeholder=""></input>
					</div>
				</div>
				
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehEmail">E-mail Address</label>
						<input type="text" class="form-control" id="ehEmail" name="ehEmail" placeholder="">
					</div>
				</div>

			</div>

	

	
	
			<div>

				<div class="row pad">

					<div class="col-xs-2 ">
						<button type="button" class="btn btn-danger full">
							<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
						</button>
					</div>

					<div class="col-xs-2 ">
						<button type="button" class="btn btn-success full"
							onclick="addEmployeeHistoryDetails();">
							<i class="glyphicon glyphicon-floppy-disk"></i> Add New
						</button>
					</div>

					<div class="col-xs-2 ">
						<button type="button" class="btn btn-success full" id=btn3>
							<i class="glyphicon glyphicon-floppy-disk"></i> Test
						</button>
					</div>


				</div>

			</div>

		</div>

	</div>



	<table id="employmentHistorydetails"
		class="table table-striped table-bordered table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Employee</th>
				<th>Employer</th>
				<th>Designation</th>
				<th>Basis</th>
				<th>Started On</th>
				<th>Completed On</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Employee</th>
				<th>Employer</th>
				<th>Designation</th>
				<th>Basis</th>
				<th>Started On</th>
				<th>Completed On</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td align="center">
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button>
				</td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal"
						data-target="#editEmploymenthistorydetails">
						<i class="glyphicon glyphicon-edit"></i>
					</button></td>
				<td align="center"><button type="button" class="btn btn-danger"
						data-toggle="modal" data-target="#">
						<i class="glyphicon glyphicon-trash"></i>
					</button></td>
			</tr>
		</tbody>
	</table>


</div>


<!--Add Educational Modal -->
<div class="modal fade" id="addEmploymenthistorydetails"
	name="addEducationaldetails" role="dialog"></div>

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
				<!-- 				<button type="button" id="buttonAddemployee" class="btn btn-success pull-side" > -->
				<!-- 					<i class="glyphicon glyphicon-floppy-disk"></i> Save -->
				<!-- 				</button> -->
				<!-- 				<button type="button" id="buttonCancelemployee" class="btn btn-danger pull-left" > -->
				<!-- 					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel -->
				<!-- 				</button> -->

			</div>
		</div>

	</div>
</div>

