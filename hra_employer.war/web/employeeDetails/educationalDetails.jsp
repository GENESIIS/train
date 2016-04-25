<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#educationalQualificationdetails').DataTable();
	});
</script>

<div>
	<button type="button" class="btn btn-primary pull-side"
		data-toggle="modal" data-target="#addEducationaldetails">
		<i class="glyphicon glyphicon-plus"></i> Add New
	</button>
</div>

<br />

<div class="table-responsive">
	<table id="educationalQualificationdetails"
		class="table table-striped table-bordered table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Employee</th>
				<th>Qualification</th>
				<th>University/College/School</th>
				<th>Medium</th>
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
				<th>Qualification</th>
				<th>University/College/School</th>
				<th>Medium</th>
				<th>Started On</th>
				<th>Completed On</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td>Pabodha Narmadani</td>
				<td>Bachelors Degree</td>
				<td>SLIIT</td>
				<td>English</td>
				<td>2012-01-02</td>
				<td>2012-10-15</td>
				<td align="center"><button type="button" class="btn btn-info"
						data-toggle="modal" data-target="">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal" data-target="editEducationaldetails">
						<i class="glyphicon glyphicon-edit"></i>
					</button></td>
				<td align="center"><button type="button" class="btn btn-danger"
						data-toggle="modal" data-target="">
						<i class="glyphicon glyphicon-trash"></i>
					</button></td>
			</tr>
		</tbody>
	</table>
</div>


<!--Add Educational Modal -->
<div class="modal fade" id="addEducationaldetails"
	name="addEducationaldetails" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Educational & Professional
					Qualifications
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
					<label for="qualificationName">Qualification</label> <input
						type="text" class="form-control" id="qualificationName"
						name="qualificationName" placeholder="">
				</div>
				<div class="form-group">
					<label for="educatedPlace">University/College/School</label> <input
						type="text" class="form-control" id="educatedPlace"
						name="educatedPlace" placeholder="">
				</div>
				<div class="form-group">
					<label for="mediumStudied">Medium</label> <input type="text"
						class="form-control" id="mediumStudied" name="mediumStudied"
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

<!--Edit Educational Modal -->
<div class="modal fade" id="editEducationaldetails"
	name="editEducationaldetails" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Educational & Professional
					Qualifications
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
					<label for="editqualificationName">Qualification</label> <input
						type="text" class="form-control" id="editqualificationName"
						name="editqualificationName" placeholder="">
				</div>
				<div class="form-group">
					<label for="editeducatedPlace">University/College/School</label> <input
						type="text" class="form-control" id="editeducatedPlace"
						name="editeducatedPlace" placeholder="">
				</div>
				<div class="form-group">
					<label for="editmediumStudied">Medium</label> <input type="text"
						class="form-control" id="editmediumStudied" name="editmediumStudied"
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
							<label for="editcompleatedOn">Completed On</label> <input type="date"
								class="form-control" id="editcompleatedOn" name="editcompleatedOn"
								placeholder="">
						</div>
					</div>
				</div>


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
