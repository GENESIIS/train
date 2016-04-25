<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#studyPrograms').DataTable();
	});
</script>

<div>
	<button type="button" class="btn btn-primary pull-side"
		data-toggle="modal" data-target="#addEmployeeDetailsForm">
		<i class="glyphicon glyphicon-plus"></i> Add New
	</button>
</div>

<br></br>
<div class="table-responsive">
	<table id="studyPrograms"
		class="table table-striped table-bordered table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Employee Number</th>
				<th>Employee Name</th>
				<th>Designation</th>
				<th>Contact Details</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Employee Number</th>
				<th>Employee Name</th>
				<th>Designation</th>
				<th>Contact Details</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td>EMP001</td>
				<td>Dammika Nawarathna</td>
				<td>AGM - HR</td>
				<td>0711111111<br> 0112222222<br> dammika@gmail.com
				</td>
				<td align="center"><button type="button" class="btn btn-info"
						data-toggle="modal" data-target="#viewEmployeeDetailsForm">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal"
						data-target="#editEmployeeDetailsForm">
						<i class="glyphicon glyphicon-edit"></i>
					</button></td>
				<td align="center"><button type="button" class="btn btn-danger"
						data-toggle="modal" data-target="#deleteEmployeeDetailsForm">
						<i class="glyphicon glyphicon-trash"></i>
					</button></td>
			</tr>
			<tr>
				<td>EMP002</td>
				<td>Chamara Withanachchi</td>
				<td>DGM - IT</td>
				<td>0712222222<br> 0113333333<br> chamaraw@gmail.com
				</td>
				<td align="center"><button type="button" class="btn btn-info"
						data-toggle="modal" data-target="#viewEmployeeDetailsForm">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal"
						data-target="#editEmployeeDetailsForm">
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


<!--Add Study details Modal -->
<div class="modal fade" id="addStudyprograms" name="addStudyprograms"
	role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Study Program Details
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
					<label for="institution">Institution</label> <input type="text"
						class="form-control" id="institution" name="institution"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="courseType">Type of Course</label> <input type="text"
						class="form-control" id="courseType" name="courseType"
						placeholder="">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="admissionDate">Admission Date</label> <input
								type="text" class="form-control" id="admissionDate"
								name="admissionDate" placeholder="">
						</div>
					</div>
				</div>
				<!-- 				<div class="row"> -->
				<!-- 					<div class="col-md-6"> -->
				<div class="form-group">
					<label for="duration">Duration (In months)</label> <input
						type="date" class="form-control" id="duration" name="duration"
						placeholder="">
				</div>
				<!-- 					</div> -->
				<!-- 					<div class="col-md-6"> -->
				<div class="form-group">
					<label for="studyTime">Study Time</label> <input type="date"
						class="form-control" id="studyTime" name="studyTime"
						placeholder="">
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

<!--edit Study details Modal -->
<div class="modal fade" id="editStudyprograms" name="editStudyprograms"
	role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Study Program Details
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
					<label for="editinstitution">Institution</label> <input type="text"
						class="form-control" id="editinstitution" name="editinstitution"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="editcourseType">Type of Course</label> <input type="text"
						class="form-control" id="editcourseType" name="editcourseType"
						placeholder="">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="editadmissionDate">Admission Date</label> <input
								type="text" class="form-control" id="editadmissionDate"
								name="editadmissionDate" placeholder="">
						</div>
					</div>
				</div>
				<!-- 				<div class="row"> -->
				<!-- 					<div class="col-md-6"> -->
				<div class="form-group">
					<label for="editduration">Duration (In months)</label> <input
						type="date" class="form-control" id="editduration" name="editduration"
						placeholder="">
				</div>
				<!-- 					</div> -->
				<!-- 					<div class="col-md-6"> -->
				<div class="form-group">
					<label for="editstudyTime">Study Time</label> <input type="date"
						class="form-control" id="editstudyTime" name="editstudyTime"
						placeholder="">
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