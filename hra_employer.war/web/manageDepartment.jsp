<!-- 20160411 PN HRA-3 created manageDepartment.jsp class -->
<!-- 20160411 PN HRA-3 created manageDepartment.jsp class -->

<!-- JavaScripts to help to load  -->
<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#departmentDetails').DataTable();
	});
</script>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Department Management</h2>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addDepartmentDetailsForm">
		<i class="glyphicon glyphicon-plus"></i> New Department
		<i class="glyphicon glyphicon-home"></i> Create Department
	</button>
	<br></br>
	<div class="table-responsive">
		<table id="departmentDetails"
			class="table table-striped table-bordered table-responsive"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Department Number</th>
					<th>Department Name</th>
					<th>Location</th>
					<th>Head Of the Department</th>
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Department Number</th>
					<th>Department Name</th>
					<th>Location</th>
					<th>Head Of the Department</th>
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td>DEPT01</td>
					<td>Human Resourses</td>
					<td>Head Office</td>
					<td>Mr. Dammika Nawarathna</td>
					<td align="center"><button type="button" class="btn btn-info"
							data-toggle="modal" data-target="#viewdepartmentDetailsForm">
							<i class="glyphicon glyphicon-modal-window"></i>
						</button></td>
					<td align="center"><button type="button"
							class="btn btn-warning" data-toggle="modal"
							data-target="#editdepartmentDetailsForm">
							<i class="glyphicon glyphicon-edit"></i>
						</button></td>
					<td align="center"><button type="button"
							class="btn btn-danger" data-toggle="modal"
							data-target="#deletedepartmentDetailsForm">
							<i class="glyphicon glyphicon-trash"></i>
						</button></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


<!--"Add Department Details Form" Modal -->
<div class="modal fade" id="addDepartmentDetailsForm" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-home"></i> Add Department Details
				</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="departmentNumber">Department Number</label> <input
								type="text" class="form-control" id="departmentNumber"
								name="departmentNumber" placeholder="" value="" maxlength="5" size="5">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="departmentName">Department Name</label> <input
						type="text" class="form-control" id="departmentName"
						name="departmentName" placeholder="" value="">
				</div>

				<div class="form-group">
					<label for="departmentLocation">Department Location</label> <input
						type="text" class="form-control" id="departmentLocation"
						name="departmentLocation" placeholder="" value="">
				</div>
				<div class="form-group">
					<label for="departmentHead">Department Head</label> <select
						class="form-control" id="departmentHead" name="departmentHead">
						<option>-Select-</option>						
					</select>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right"
					data-dismiss="modal" onclick="addDepartmentDetails()">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-warning pull-left"
					onclick="clearDepartmentform()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal" onclick="clearDepartmentform()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>
	</div>
</div>

<!--"Edit department Details Form" Modal -->
<div class="modal fade" id="editdepartmentDetailsForm" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-home"></i> Add Department Details
				</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="departmentNumberedit">Department Number</label> <input
								type="text" class="form-control" id="departmentNumberedit"
								name="departmentNumberedit" placeholder="" value="">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="departmentNameedit">Name</label> <input type="text"
						class="form-control" id="departmentNameedit"
						name="departmentNameedit" placeholder="" value="">
				</div>

				<div class="form-group">
					<label for="departmentLocationedit">Department Location</label> <input
						type="text" class="form-control" id="departmentLocationedit"
						name="departmentLocationedit" placeholder=""
						value="Lakmal Baalasooriya">
				</div>

				<!-- 				<div class="row"> -->
				<!-- 					<div class="col-md-6"> -->
				<div class="form-group">
					<label for="departmentHeadedit">Department Head</label> <select
						class="form-control" id="departmentHeadedit"
						name="departmentHeadedit">
						<option>-Select-</option>
					</select>
				</div>

				<!-- 					</div> -->
				<!-- 				</div> -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					data-dismiss="modal" onclick="addedDepartment()">Add
					Details</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!--"View department Details Form" Modal -->
<div class="modal fade" id="viewdepartmentDetailsForm" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-modal-window"></i> View department
					Details
				</h3>

			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger pull-side"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Delete department Details -->
<div class="modal fade bs-example-modal-sm"
	id="deletedepartmentDetailsForm" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-trash"></i> Delete department Details
				</h3>

			</div>
			<div class="modal-body">Are you sure to delete this department?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-left"
					onclick="deleteAlert()" data-dismiss="modal">Delete</button>
				<button type="button" class="btn btn-danger pull-side"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>