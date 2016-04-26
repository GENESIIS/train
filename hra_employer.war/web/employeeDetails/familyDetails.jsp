<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#familyDetails').DataTable();
	});
</script>

<div>
<label><h2>Family Details</h2> </label>
	
	<button type="button" class="btn btn-primary pull-side"
		data-toggle="modal" data-target="#addFamilydetails">
		<i class="glyphicon glyphicon-plus"></i> Add New
	</button>
</div>

<br></br>
<div class="table-responsive">
	<table id="familyDetails"
		class="table table-striped table-bordered table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Employee</th>
				<th>Relationship</th>
				<th>Name</th>
				<th>Date of Birth</th>
				<th>Occupation</th>
				<th>Working Place/School</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Employee</th>
				<th>Relationship</th>
				<th>Name</th>
				<th>Date of Birth</th>
				<th>Occupation</th>
				<th>Working Place/School</th>
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
						data-toggle="modal" data-target="#viewEmployeeDetailsForm">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal"
						data-target="#editFamilydetails">
						<i class="glyphicon glyphicon-edit"></i>
					</button></td>
				<td align="center"><button type="button" class="btn btn-danger"
						data-toggle="modal" data-target="#deleteEmployeeDetailsForm">
						<i class="glyphicon glyphicon-trash"></i>
					</button></td>
			</tr>
		</tbody>
	</table>
</div>

<!--Add Family Modal -->
<div class="modal fade" id="addFamilydetails" name="addFamilydetails"
	role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Family Details
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
					<label for="relationship">Relationship</label> <input type="text"
						class="form-control" id="relationship" name="relationship"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="relationName">Name</label> <input type="text"
						class="form-control" id="relationName" name="relationName"
						placeholder="">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="relationDateofbirth">Date of Birth</label> <input
								type="text" class="form-control" id="relationDateofbirth"
								name="relationDateofbirth" placeholder="">
						</div>
					</div>
				</div>
				<!-- 				<div class="row"> -->
				<!-- 					<div class="col-md-6"> -->
				<div class="form-group">
					<label for="occupation">Occupation</label> <input type="date"
						class="form-control" id="occupation" name="occupation"
						placeholder="">
				</div>
				<!-- 					</div> -->
				<!-- 					<div class="col-md-6"> -->
				<div class="form-group">
					<label for="occupationPlace">Working Place/School</label> <input
						type="date" class="form-control" id="occupationPlace"
						name="occupationPlace" placeholder="">
				</div>
				<!-- 					</div> -->
				<!-- 				</div> -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="updatedAlert()" data-dismiss="modal">
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


<!--edit Family Modal -->
<div class="modal fade" id="editFamilydetails" name="editFamilydetails"
	role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Family Details
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
					<label for="editrelationship">Relationship</label> <input
						type="text" class="form-control" id="editrelationship"
						name="editrelationship" placeholder="">
				</div>
				<div class="form-group">
					<label for="editrelationName">Name</label> <input type="text"
						class="form-control" id="editrelationName" name="editrelationName"
						placeholder="">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="editrelationDateofbirth">Date of Birth</label> <input
								type="date" class="form-control" id="editrelationDateofbirth"
								name="editrelationDateofbirth" placeholder="">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="editoccupation">Occupation</label> <input type="text"
						class="form-control" id="editoccupation" name="editoccupation"
						placeholder="">
				</div>

				<div class="form-group">
					<label for="editoccupationPlace">Working Place/School</label> <input
						type="text" class="form-control" id="editoccupationPlace"
						name="editoccupationPlace" placeholder="">
				</div>


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="updatedAlert()" data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-success pull-side"
					onclick="updatedAlert()" data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
			</div>
		</div>

	</div>
</div>