<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#employmentHistorydetails').DataTable();
	});
</script>


<div>
		<div> <h1>Employment History</h1> </div>
		<div> 
			<button type="button" class="btn btn-primary pull-side" data-toggle="modal" data-target="#addEmploymenthistorydetails"> 
				<i class="glyphicon glyphicon-plus"> Add New </i>
			</button> 
		</div>
		
		<!--<label> <h1>Employment History</h1> </label>-->
	
</div>

<br></br>
<div class="table-responsive">
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
				<td align="center"><button type="button" class="btn btn-info"
						data-toggle="modal" data-target="#">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
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
					<label for="employeeId">Employee</label> <input type="text"
						class="form-control" id="employeeId" name="employeeId"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="employer">Employer</label> <input type="text"
						class="form-control" id="employer" name="employer" placeholder="">
				</div>
				<div class="form-group">
					<label for="designation">Designation</label> <input type="text"
						class="form-control" id="designation" name="designation"
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
							<label for="startedOn">Started On</label> <input type="date"
								class="form-control" id="startedOn" name="startedOn"
								placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="compleatedOn">Completed On</label> <input type="date"
								class="form-control" id="compleatedOn" name="compleatedOn"
								placeholder="">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="referenceOne">Reference 1</label> <input type="date"
								class="form-control" id="referenceOne" name="referenceOne"
								placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="referenceOnecomments">Comments</label>
							<textarea type="date" class="form-control"
								id="referenceOnecomments" name="referenceOnecomments"
								placeholder=""></textarea>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="referenceTwo">Reference 2</label> <input type="date"
								class="form-control" id="referenceTwo" name="referenceTwo"
								placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="referenceTwocomments">Comments</label>
							<textarea type="date" class="form-control"
								id="referenceTwocomments" name="referenceTwocomments"
								placeholder=""></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side" onclick=""
					data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>

	</div>
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
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side" onclick=""
					data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>

	</div>
</div>