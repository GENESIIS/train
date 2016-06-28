<!-- 20160627 CM HRA-45 created addleaveTypes.jsp class -->

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Leave Types</h2>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addleaveTypesDetailsForm">
		<i class="glyphicon glyphicon-plus"></i> New Leave Type
	</button>
	<br></br>
		<div class="table-responsive">
		<table id="departmentDetails"
			class="table table-striped table-bordered table-responsive"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Leave Type Number</th>
					<th>Leave Type</th>
					<th>Duration (In month)</th>
					<th>Leaves Count</th>
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Leave Type Number</th>
					<th>Leave Type</th>
					<th>Duration (In month)</th>
					<th>Leaves Count</th>
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td>LT01</td>
					<td>Annual leave</td>
					<td>30</td>
					<td>1</td>
					<td align="center"><button type="button" class="btn btn-info"
							data-toggle="modal" data-target="#viewleaveTypesDetailsForm">
							<i class="glyphicon glyphicon-modal-window"></i>
						</button></td>
					<td align="center"><button type="button"
							class="btn btn-warning" data-toggle="modal"
							data-target="#editleaveTypesDetailsForm">
							<i class="glyphicon glyphicon-edit"></i>
						</button></td>
					<td align="center"><button type="button"
							class="btn btn-danger" data-toggle="modal"
							data-target="#deleteleaveTypesDetailsForm">
							<i class="glyphicon glyphicon-trash"></i>
						</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	
	
	<!--"Add leave types Details Form" Modal -->
	<div class="modal fade" id="addleaveTypesDetailsForm" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-calendar"></i> Add Leave Types Details
				</h3>
			</div>
			<div class="modal-body">
			

				<div class="form-group">
					<label for="departmentName">Leave Type</label> <input
						type="text" class="form-control" id="leavetypename"
						name="departmentName" placeholder="" value="">
				</div>
					<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="leaveTypename">Leave Duration (In month)</label> <input
								type="text" class="form-control" id="leavesduration"
								name="leavesduration" placeholder="" value=""
								size="5">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="leaveTypename">Leave Count</label> <input
								type="text" class="form-control" id="leavescount"
								name="leavescount" placeholder="" value=""
								size="5">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="leavepayments">Leave payment</label><br> <label for="leavePay"><input
						type="radio" class="" id="leavePay" name="leavePay"
						placeholder=""> With Pay </label> <label for="leavePay"> <input
						type="radio" class="" id="leaveNoPay" name="leavePay"
						placeholder="">No Pay
					</label>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right"
					onclick="addLeaveTypesDetails()">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-warning pull-left"
					onclick="">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal" onclick="">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>
	</div>
</div>